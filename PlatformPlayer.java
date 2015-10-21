import greenfoot.*;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlatformPlayer extends PlatformObject
{
    //constants
    private double gravity = .5;
    private double airResist = .25;
    private double moveSpeed = 2;
    private double jumpSpeed = 16;
    private int sideScrollDist = 200;
    
    //varibles
    private boolean onBlock=false;
    private double realX;
    private double realY;
    private double velX;
    private double velY;
    Platformer w;
    
    public PlatformPlayer()
    {
        this(100,50);
    }
    
    public PlatformPlayer(double X, double Y)
    {
        realX = X;
        realY = Y;
        velX = 0;
        velY = 0;
    }
    
    public void act() 
    {
        w=(Platformer)getWorld();
        showDebug(true);
        jump();
        leftRight();
        gravity(gravity);
        airResist();
        velocity();
        sideScroll();
        updatePosition();
    }    
    private void updatePosition()
    {
        double stepX = ((realX-w.getOffset())-getExactX())/10;
        double stepY = (realY-getExactY())/10;
        for (int i=0;i<=9;i++)
        {
            setLocation(getExactX()+stepX,getExactY()+stepY);
            if (touch(Block.class))
            {
                onBlock=true;
                velY=0;
                setLocation(getExactX(),getExactY()-stepY);
                i=10;
            }
            if(velY!=0)
            {
                onBlock=false;
            }
        }
    }
    
    private void sideScroll()
    {
        if (getX()>=getWorld().getWidth()-sideScrollDist && velX>0 || getX()<= sideScrollDist && velX<0)
        {
            w.setOffset(w.getOffset()+velX);
        }
    }
    
    private void leftRight()
    {
        if (Greenfoot.isKeyDown("d"))
        {
            velX += moveSpeed;
        }
        if (Greenfoot.isKeyDown("a"))
        {
            velX -= moveSpeed;
        }
    }
    
    private void jump()
    {
        if ((Greenfoot.isKeyDown("space")||Greenfoot.isKeyDown("w")) && onBlock)
        {
            onBlock=false;
            velY = -jumpSpeed;
        }
    }

    private void airResist()
    {
        velX -= airResist*velX;
        
        //old
        //velX -= airResist*velX*Math.abs(velX);
        //velX -= airResist*velX*Math.log(Math.abs(velX)+1);
        //velY -= airResist*velY*Math.log(Math.abs(velY)+1);
    }
    
    private void velocity()
    {
        realX += velX;
        realY += velY;
    }
    
    private void gravity(double grav)
    {
        if (!onBlock)
        {
            velY += grav;
        }
    }
    
    private void showDebug(boolean show)
    {
        if(show)
        {
            int x = getWorld().getWidth() - 75;
            
            getWorld().showText("X: "+String.format("%.02f", (realX)), x, 25);
            getWorld().showText("Y: "+String.format("%.02f", (realY)), x, 50); 
            
            getWorld().showText("vX: "+String.format("%.02f", (velX)), x, 75);
            getWorld().showText("vY: "+String.format("%.02f", (velY)), x, 100);
        }
    }
}
