import greenfoot.*;

/**
 * Write a description of class Cannon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cannon extends Player
{
    /**
     * Act - do whatever the Cannon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setupCannon();
    }
    public void setupCannon()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        Actor a = getOneIntersectingObject(Ship.class);
        
        if(mouse != null)
        {
        turnTowards(mouse.getX(), mouse.getY());
        }
        setLocation(a.getX(), a.getY());
    }
}
