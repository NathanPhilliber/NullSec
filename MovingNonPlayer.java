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
    private boolean onBlock = true;

    public double walkSpeed = 1;
    public double jumpSpeed = 4;
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
            if(hitRight&&onBlock){
                //setVelX(-walkSpeed);
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
            addRealX(velX/steps);
            setLocation(getRealX()-w.getXOffset(),getExactY());
            Actor b=getOneIntersectingObject(blockType);
            if (b!=null)
            {
                if(velX > 0){
                    hitRight = true;    
                    hitLeft = false;
                    if(onBlock)
                    {
                        setVelY(-jumpSpeed);
                    }
                }
                if(velX < 0){
                    hitLeft = true;
                    hitRight = false;
                }
                addRealX(-velX/steps);
                setLocation(getRealX()-w.getXOffset(),getExactY());
                i=steps;
            }
        }
        //y
        for (int i=0;i<=steps-1;i++)
        {
            addRealY(velY/steps);
            setLocation(getExactX(),getRealY()-w.getYOffset());
            Actor b=getOneIntersectingObject(blockType);
            if (b!=null)
            {
                if(getVelY()>0)
                {
                    onBlock=true;
                }
                addRealY(-velY/steps);
                setLocation(getExactX(),getRealY()-w.getYOffset());
                i=steps;
                setVelY(0);
            }
        }
        if(getVelY()!=0)
        {
            onBlock=false;
        }
    }
}
