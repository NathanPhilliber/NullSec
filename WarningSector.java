import greenfoot.*;

/**
 * Write a description of class WarningSector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WarningSector extends RespawnMenu
{
     private int delay = 10;
    
    public void act() 
    {
        delay--;
        if(delay  == 0)
        space.removeObject(this);
    }      
}
