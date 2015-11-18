import greenfoot.*;

/**
 * Write a description of class WarningBG here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WarningBG extends RespawnMenu
{
    /**
     * Act - do whatever the WarningBG wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int delay = 10;
    
    public void act() 
    {
        delay--;
        if(delay  == 0)
        space.removeObject(this);
    }    
}
