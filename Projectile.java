import greenfoot.*;

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Weapon implements ProjectileObject
{
    /**
     * Works
     * feel free to change immage or move speed
     * shooting speed is changed in Player.shoot()
     * add colisions as nessary
     * 
     */
    public void act() 
    {
        //colision effect goes here
        //update Position method to move relitive to ship (if you want the ship to be able to catch up to projectiles)
        move(5);
        removeAtEdge();
    }    
    public Projectile(int angle)
    {
        setRotation(angle);
    }
}
