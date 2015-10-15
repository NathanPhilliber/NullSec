import greenfoot.*;

/**
 * Write a description of class Planets here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Planet extends SpaceObject
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
        if(Greenfoot.isKeyDown("e") && firstPass)
        {
            if(touch(Player.class))
            {

                dockMenu();
                firstPass = false;
            }
            else
            {
                firstPass = true;
                Space.setPause = false;
            }
        }

    }


}
