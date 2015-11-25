import greenfoot.*;

/**
 * Write a description of class PlasmaTrail here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlasmaTrail extends SpaceObject
{
    private int delay = 50;
    public void act() 
    {
        super.act();
        fade();
    }
    public void fade()
    {
        delay--;
        getImage().setTransparency(delay*5);
        if(delay <= 0)
        {
            getWorld().removeObject(this);
        }
    }
}
