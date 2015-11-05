import greenfoot.*;
public class MovingNonPlayer extends NonPlayer
{
    public void act() 
    {
        collision();
        super.act();
    }    
    public MovingNonPlayer()
    {
        super();
    }

    
    public void addedToWorld(World world){
        setRealX(getX());
        setRealY(getY());
    }
    
    protected void gravity(double y)
    {
       velY=y*10;
    } 
    protected void moveX(double x)
    {
        setVelX(x);
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
