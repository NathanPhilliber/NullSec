import greenfoot.*;

/**
 * Write a description of class WeaponShop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WeaponShop extends Menu
{
    
    public static final int ENGINE = 0;
    public static final int WEAPONS = 1;
    public static final int SHIELD = 2;
    
    public Shop shop;
    
    public void act() 
    {
        // Add your action code here.
    } 
    
    public void addedToWorld(World world){
        
        shop = (Shop) getWorld();
    }
}
