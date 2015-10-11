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
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new WorldOne());
        }
    }    
}
