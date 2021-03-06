import greenfoot.*;

//Written by John

public class NonPlayer extends PlatformObject
{
    protected void addedToWorld(World world)
    {
        super.addedToWorld(world);
        setRealX(getX()+w.getXOffset());
        setRealY(getY()+w.getYOffset());
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
        protected void updatePos()
    {
        if(w == null){
           w=(Platformer)getWorld(); 
        }
        setLocation(getRealX()-w.getXOffset(),getRealY()-w.getYOffset());
    }
}
