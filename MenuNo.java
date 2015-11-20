import greenfoot.*;
import java.util.List;
//Written by Trace
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
            GreenfootSound ding = new GreenfootSound("sounds/buttonSound.wav");
            ding.play();
            Ship ship = space.getShip();
            ship.resetDockMenu();
            removeDockMenu();
            space.setPause = false;
            //Planet.firstPass = true;
            
        }
    }    
}
