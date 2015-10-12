import greenfoot.*;

/**
 * Write a description of class Planets here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Planets extends SpaceObject
{
    /**
     * Act - do whatever the Planets wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean firstPass = true;
     
    public void act() 
    {
        super.act();
        checkDock();
    }
    public void checkDock()
    {
        if(touch(Player.class))
        {
            if(firstPass && Greenfoot.isKeyDown("e"))
            {
             dockMenu();
             firstPass = false;
            }
        }
        else
        {
            firstPass = true;
            Space.setPause = false;
        }
    }
}
