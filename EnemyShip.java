import greenfoot.*;

/**
 * Write a description of class EnemyShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyShip extends Minimap
{
    public void act()
    {
       space.removeObject(this);
    }
}
