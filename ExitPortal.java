import greenfoot.*;

/**
 * Write a description of class ExitPortal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExitPortal extends NonPlayer
{
    /**
     * Act - do whatever the ExitPortal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
    }    
    public ExitPortal()
    {
        super();
    }
    
    protected void addedToWorld(World world)
    {
        setRealX(getX());
        setRealY(getY());
    }  
}
