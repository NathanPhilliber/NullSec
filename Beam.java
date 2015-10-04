import greenfoot.*;

/**
 * Write a description of class Beam here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Beam extends Weapon implements ProjectileObject
{
    /**
     * not completly finished
     * feel free to change immage
     * beam lenth is changed in Player.beam()
     * add colisions as nessary
     * 
     */
    public void act() 
    {
        //colision effect goes here
        getWorld().removeObject(this);
    }    
    
    public Beam(int angle)
    {
        setRotation(angle);
    }
    
    public boolean checkCollision(){
        return true;
    }
}
