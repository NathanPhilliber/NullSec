import greenfoot.*;
public class NonPlayer extends PlatformObject
{
    protected void addedToWorld(World world)
    {
        super.addedToWorld(getWorld());
        setRealX(getX());
        setRealY(getY());
    }
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
        updatePos();
    }   
}
