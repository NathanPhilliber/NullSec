import greenfoot.*;

/**
 * Write a description of class FireballText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FireballText extends WeaponShop
{
    /**
     * Act - do whatever the FireballText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mousePressed(this)){
            shop.sideButton5.select(true);
        }
    }    
}
