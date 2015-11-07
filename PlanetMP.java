import greenfoot.*;

/**
 * Write a description of class PlanetsMP here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlanetMP extends Minimap
{
    /**
     * Act - do whatever the PlanetsMP wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        space.removeObject(this);
    }    
}
