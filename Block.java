import greenfoot.*;
public class Block extends NonPlayer
{
    public void act() 
    {
        super.act();
    }    
    public Block()
    {
        super();
    }
    
    protected void addedToWorld(World world)
    {
        setRealX(getX());
        setRealY(getY());
    }
}
