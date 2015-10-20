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
        physics();
        sideScroll();
    }    
    private void physics()
    {
        gravity(gravity);
        airResist();
        collision();
        velocity();
    }
    
    
    private void sideScroll()
    {
        if (getX()>=getWorld().getWidth()-sideScrollDist && velX>0 || getX()<= sideScrollDist && velX<0)
        {
            w.setOffset(w.getOffset()+velX);
            setLocation(getX(),realY);
        }
        else
        {
            setLocation(realX-w.getOffset(),realY);
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
        Actor block = getOneObjectAtOffset(10,10,null);
        if (Greenfoot.isKeyDown("w") && block != null)
        {
            velY = -jumpSpeed;
        }
    }
    
    
    private void velRound()
    {
        if (velX<=.2)
        {
            velX=0;
        }
    }
    private void airResist()
    {
        velX -= airResist*velX;
        
        //velX -= airResist*velX*Math.abs(velX);
        //old
        //velX -= airResist*velX*Math.log(Math.abs(velX)+1);
        //velY -= airResist*velY*Math.log(Math.abs(velY)+1);
    }
    
    private void collision()
    {
        Actor block = getOneObjectAtOffset(15,15,null);
        if (block != null && velY > 0)
        {
            velY = 0;
        }
    }
    
    private void velocity()
    {
        realX += velX;
        realY += velY;
    }
    
    private void gravity(double grav)
    {
        velY += grav;
    }
    
    private void showDebug(boolean show)
    {
        if(show)
        {
            int x = getWorld().getWidth() - 75;
            
            //getWorld().showText("X: "+String.format("%.02f", (realX)), x, 25);
            //getWorld().showText("Y: "+String.format("%.02f", (realY)), x, 50); 
            
            // getWorld().showText("vX: "+String.format("%.02f", (velX)), x, 75);
            //getWorld().showText("vY: "+String.format("%.02f", (velY)), x, 100);
        }
    }
}
