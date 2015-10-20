import greenfoot.*;
public class NonPlayer extends PlatformObject
{
    private double realX;
    private double realY;
    private boolean firstTime=true;
    
    Platformer w;
    public NonPlayer()
    {
        this(0,0);
    }
    
    public NonPlayer(double x,double y)
    {
        setRealX(x);
        setRealY(y);
    }
    
    public void act() 
    {
        w=(Platformer)getWorld();
        updatePos();
    }   
    
    public void updatePos()
    {
        setLocation(realX-w.getOffset(),realY);
    }
    
    public void setRealX(double x)
    {
        realX=x;
    }
    public void setRealY(double y)
    {
        realY=y;
    }
    public double getRealX()
    {
        return realX;
    }
    public double getRealY()
    {
        return realY;
    }
}
