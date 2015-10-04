import greenfoot.*;

/**
 * Write a description of class PlasmaBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlasmaBall extends Weapon implements ProjectileObject
{
    /**
     * Act - do whatever the PlasmaBall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(1);
        removeAtEdge();
    } 
    
    public PlasmaBall(int angle)
    {
        setRotation(angle);
    }
    
    public boolean checkCollision(){
        return true;
    }
}
