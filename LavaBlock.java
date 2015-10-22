import greenfoot.*;

/**
 * Write a description of class LavaBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LavaBlock extends NonPlayer
{
    /**
     * Act - do whatever the LavaBlock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }    
    public LavaBlock(int p)
    {
        super();
        if(p == 1)
        {
            setImage("Lava.png");
        }
        if(p == 2)
        {
            setImage("Lava2.png");
        }
    }
    
    protected void addedToWorld(World world)
    {
        setRealX(getX());
        setRealY(getY());
    }    
}
