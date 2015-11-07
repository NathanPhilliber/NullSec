import greenfoot.*;

/**
 * Write a description of class MenuYes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuYes extends DockMenu
{
    /**
     * Act - do whatever the MenuYes wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    //public World newWorld = new Shop();

    public void act() 
    {
        checkClicked();
    }

    public void checkClicked()
    {
        if(Greenfoot.mouseClicked(this))
        {
           
            
            space.getShip().dockWorld();
            space.setPause = false;
            space.removeObjects(space.getObjects(DockMenu.class));
        }
    }
}
