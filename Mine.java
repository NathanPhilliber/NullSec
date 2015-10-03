import greenfoot.*;

/**
 * Write a description of class Mine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mine extends Weapon implements ProjectileObject
{
    /**
     * currently broken
     * Not fully implamented
     * feel free to change immage
     * add colisions as nessary
     * 
     */
    public void act() 
    {
        //colision effect goes here
        //Update Position (so it gets moved with everything else)
        getWorld().removeObject(this);
    }    
    
    public Mine(int x,int y)
    {
        //X = x;
        //Y = y;
    }
}
