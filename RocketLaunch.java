import greenfoot.*;

/**
 * Write a description of class RocketLaunch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RocketLaunch extends NonPlayer
{
    /**
     * Act - do whatever the RocketLaunch wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GifImage rocketLaunch = new GifImage("RocketLaunch.gif");
    private int delay = 38;
    
    public void act() 
    {
        super.act();
        delay--;
        if(delay > 0)
        {
            setImage(rocketLaunch.getCurrentImage());
        }
        else
        {
            getImage().setTransparency(0);
        }
    }    
}
