import greenfoot.*;

/**
 * Write a description of class WarningSector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WarningSector extends RespawnMenu
{
    /**
     * Act - do whatever the WarningSector wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int delay = 30;
    
    public void act() 
    {
        delay--;
        if(delay  == 0)
        space.removeObject(this);
    }    
}
