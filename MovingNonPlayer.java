import greenfoot.*;

//Written by John

public class MovingNonPlayer extends NonPlayer
{

    GifImage walkRight = new GifImage("WalkingAnimation.gif");
    GifImage walkLeft = new GifImage("WalkingAnimationLeft.gif");
    GifImage standRight = new GifImage("StandingRight.png");
    GifImage standLeft = new GifImage("StandingLeft.png");

    private boolean hitLeft = true;
    private boolean hitRight = false;
    private boolean walkBackAndForth = false;
    private boolean isWalker = false;
    private boolean canJump = false;

    public double walkSpeed = 1;
    public double jumpSpeed = 12;
    public void act() 
    {
        super.act();
        collision();
        moveBackAndForthHelper();
        updateImage();
    }    

    public MovingNonPlayer()
    {
        super();
    }

    protected void gravity(double y)
    {
        velY += gravity/5;
    } 

    protected void moveX(double x)
    {
        setVelX(x);
    }

    public void setJump(boolean d){
        canJump = d;
    }

    public void moveBackAndForth(boolean d){
        walkBackAndForth = d;
    }

    public void setHasGif(boolean d){
        isWalker = d;
    }

    public void updateImage(){
        if(isWalker){
            if(velX > 0){
                setImage(walkRight.getCurrentImage());
            }
            else if(velX < 0){
                setImage(walkLeft.getCurrentImage());
            }
            else{
                setImage(standRight.getCurrentImage());
            }
        }
    }

    private void moveBackAndForthHelper(){
        if(walkBackAndForth){
            if(hitLeft){

                setVelX(walkSpeed);
                
            }
            if(hitRight){
                setVelX(-walkSpeed);
            }
        }
    }

    public void move(double a)
    {
        setVelX(a*cosRot());
        setVelY(a*sinRot());
    }

    private void collision()
    {
        
        int steps=10;
        //x
        for (int i=0;i<=steps-1;i++)
        {
            setLocation(getExactX()+velX/steps,getExactY());
            addRealX(velX/steps);
            Actor b=getOneIntersectingObject(blockType);
            if (b!=null)
            {
                if(canJump){
                    setVelY(jumpSpeed);
                    
                }
                if(velX > 0){
                    hitRight = true;    
                    hitLeft = false;
                }
                if(velX < 0){
                    hitLeft = true;
                    hitRight = false;
                }

                setLocation(getExactX()-velY/steps,getExactY());
                addRealX(-velX/steps);
                i=steps;

            }
        }
        //y
        for (int i=0;i<=steps-1;i++)
        {
            setLocation(getExactX(),getExactY()+velY/steps);
            addRealY(velY/steps);
            Actor b=getOneIntersectingObject(blockType);
            if (b!=null)
            {
                setLocation(getExactX(),getExactY()-velY/steps);
                addRealY(-velY/steps);
                i=steps;
            }
        }
    }
}
