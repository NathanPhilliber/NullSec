import greenfoot.*;

//Written by John

public class PlatformObject extends Object
{
    protected double realX;
    protected double realY;
    protected double velX;
    protected double velY;
    protected double gravity=.5;
    protected boolean firstTime=true;
    protected Platformer w;
    static final Class blockType = Block.class;
    protected void addedToWorld(World world)
    {
        w=(Platformer)world;
    }
    public void act()
    {
        
    }
    protected void setRealX(double x)
    {
        realX=x;
    }
    protected void setRealY(double y)
    {
        realY=y;
    }
    protected double getRealX()
    {
        return realX;
    }
    protected double getRealY()
    {
        return realY;
    }
    protected void addRealX(double x)
    {
        realX+=x;
    }
    protected void addRealY(double y)
    {
        realY+=y;
    }
    protected void setVelX(double x)
    {
        velX=x;
    }
    protected void setVelY(double y)
    {
        velY=y;
    }
    protected double getVelX()
    {
        return velX;
    }
    protected double getVelY()
    {
        return velY;
    }
    protected void addVelX(double x)
    {
        velX+=x;
    }
    protected void addVelY(double y)
    {
        velY+=y;
    }
}


