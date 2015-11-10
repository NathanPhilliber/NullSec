import greenfoot.*;

//Written by Trace

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
            space.getShip().resetDockMenu();
            space.setPause = false;
            space.removeObjects(space.getObjects(DockMenu.class));
        }
    }
}
