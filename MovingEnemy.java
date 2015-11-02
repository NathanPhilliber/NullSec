import greenfoot.*;

/**
 * Write a description of class MovingEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MovingEnemy extends NonPlayer
{
    private double gravity = .5;
    private double airResist = .25;
    private double moveSpeed = 2;
    private double jumpSpeed = 16;
    private int sideScrollDist = 400;

    private Class blockType = Block.class;

    private boolean onBlock=false;
    private double realX;
    private double realY;
    private double velX;
    private double velY;
    private boolean isWalkingRight;
    private boolean isWalkingLeft;
    private boolean deleteMe = false;

    GifImage walkRight = new GifImage("Alien1.png");
    GifImage walkLeft = new GifImage("Alien1.png");
    GifImage standRight = new GifImage("Alien1.png");
    GifImage standLeft = new GifImage("Alien1.png");

    public MovingEnemy(){
        velX = 0;
        velY = 0;
        setImage(standRight.getCurrentImage());
    }

    public void act() 
    {
        super.act();
        gravity(gravity);
        airResist();
        //jump();
        //leftRight();
        velocity();
        updatePosition();
        checkIfOffEdge();
        checkDead();
    }  

    public void addedToWorld(World world)
    {
        
        realX=getX();
        realY=getY();
        
    }

    private void checkIfOffEdge(){
        if(getY() > 1500){
            kill();
        }
    }

    private void checkSpecialCollisions()
    {

        Actor l=getOneIntersectingObject(LavaBlock.class);
        if(l != null)
        {
            kill();
        }
    }

    public void kill(){
        deleteMe = true;
    }

    public void checkDead(){
        if(deleteMe){
            getWorld().removeObject(this);
        }
    }

    private void updatePosition()
    {
        //setLocation(realX-w.getOffset(),getExactY());
        int steps=40;
        //X check
        double stepX = (realX-w.getOffset()-getExactX())/steps;
        for (int i=0;i<=steps-1;i++)
        {
            double oldX=getExactX();
            setLocation(oldX+stepX,getExactY());
            Actor b=getOneIntersectingObject(blockType);
            if (b!=null)
            { 
                velX=0;
                //System.out.println(stepX);
                setLocation(oldX,getExactY());
                realX=oldX+w.getOffset();
                //System.out.println(realX);
                if (stepX==0)
                {
                    //Greenfoot.stop();//debug on >>>>>>>>>>>>>>>>>DEBUG<<<<<<<<<<<<<<<
                }
                i=steps;
            }

            b=getOneIntersectingObject(blockType);
            if(b!=null)
            {
                setLocation(getExactX(),getExactY()-1);
                realY-=1;

                //System.out.println(realY);

                if(isWalkingRight){
                    setLocation(getExactX() - 3, getExactY());
                }
                if(isWalkingLeft){
                    setLocation(getExactX() +3 , getExactY());
                }
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
