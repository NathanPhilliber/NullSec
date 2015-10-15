import greenfoot.*;
import java.util.List;
/**
 * Write a description of class MenuNo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuNo extends DockMenu
{
    /**
     * Act - do whatever the MenuNo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            Space space = (Space) getWorld();
            Ship ship = space.getShip();
            ship.resetDockMenu();
            removeDockMenu();
            space.setPause = false;
            //Planet.firstPass = true;
            
        }
    }    
}
