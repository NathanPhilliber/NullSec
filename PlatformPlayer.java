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
    private int sideScrollDist = 400;
    private Class blockType = Block.class;

    //varibles
    private boolean onBlock=false;
    private double realX;
    private double realY;
    private double velX;
    private double velY;
    private boolean isWalkingRight;
    private boolean isWalkingLeft;
    Platformer w;

    GifImage walkRight = new GifImage("WalkingAnimation.gif");
    GifImage walkLeft = new GifImage("WalkingAnimationLeft.gif");
    GifImage standRight = new GifImage("StandingRight.png");
    GifImage standLeft = new GifImage("StandingLeft.png");

    public PlatformPlayer()
    {
        this(100,50);
        setImage(standRight.getCurrentImage());
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
        Actor b=getOneIntersectingObject(Block.class);
        if(b!=null)
        {
            System.out.println(b);
        }
        
        if(w == null){
            w=(Platformer)getWorld();
        }
        
        pausePlayerHelper();
        
        if(playerPaused == false){
            showDebug(true);
            jump();
            leftRight();
            gravity(gravity);
            airResist();
            velocity();
            sideScroll();
            updatePosition();
            restartWorld();
            checkSpecialCollisions();
            
        }

    }

    private void checkSpecialCollisions()
    {
        Actor c=getOneIntersectingObject(ExitPortal.class);
        if(c != null)
        {
            Greenfoot.setWorld(new OuterSpace());
        }

        Actor d=getOneIntersectingObject(LavaBlock.class);
        if(d != null)
        {
            pauseCycles = 50;
            setLocation(getX(), getY() -1000);
            deleteMe = true;
        }
    }

    private int pauseCycles = 0;
    private boolean playerPaused = false;
    private boolean deleteMe = false;
    
    private void restartWorld(){
        if(deleteMe){
            
            //Greenfoot.setWorld(getWorld());
            
            World world = getWorld();
            if(world instanceof Level3){
                Greenfoot.setWorld(new Level3());
            }
            else{
                System.out.println("ADD WORLD TO PLATFORMPLAYER");
            }
        }
    }
    private void pausePlayerHelper(){
        pauseCycles--;
        if(pauseCycles > 0){
            playerPaused = true;
        }
        else{
            playerPaused = false;
        }
    }

    private void updatePosition()
    {
        //setLocation(realX-w.getOffset(),getExactY());
        int steps=2;
        //X check
        double stepX = (realX-w.getOffset()-getExactX())/steps;
        for (int i=0;i<=steps-1;i++)
        {
            setLocation(getExactX()+stepX,getExactY());
            Actor b=getOneIntersectingObject(blockType);
            if (b!=null)
            {
                velX=0;
                setLocation(getExactX()-stepX,getExactY());
                realX -= stepX*(steps-i);
                i=steps;
            }
        }

        //Y check
        double stepY = (realY-getExactY())/steps;
        for (int i=0;i<=steps-1;i++)
        {
            setLocation(getExactX(),getExactY()+stepY);
            Actor b=getOneIntersectingObject(blockType);
            if (b!=null)
            {
                if (stepY>=0)
                {
                    onBlock=true;
                }
                velY=0;
                setLocation(getExactX(),getExactY()-stepY);
                realY-=stepY*(steps-i);
                i=steps;
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
            //w.setOffset(w.getOffset()+velX);
            w.setOffset(realX-getExactX());
        }
    }

    private void leftRight()
    {
        Actor b=getOneIntersectingObject(blockType);
        if (Greenfoot.isKeyDown("d")&&b==null)
        {
            velX += moveSpeed;
            setImage(walkRight.getCurrentImage());
        }

        if (Greenfoot.isKeyDown("a")&&b==null)
        {
            velX -= moveSpeed;
            setImage(walkLeft.getCurrentImage());
        }

        if (Greenfoot.isKeyDown("d")&&!isWalkingRight)
        {
            isWalkingRight = true;
        }

        if(!Greenfoot.isKeyDown("d")&&isWalkingRight)
        {
            setImage(standRight.getCurrentImage());
            isWalkingRight = false;
        }

        if (Greenfoot.isKeyDown("a")&&!isWalkingLeft)
        {
            isWalkingLeft = true;
        }

        if(!Greenfoot.isKeyDown("a")&&isWalkingLeft)
        {
            setImage(standLeft.getCurrentImage());
            isWalkingLeft = false;
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
        velY += grav;
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
