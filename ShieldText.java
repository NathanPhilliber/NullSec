import greenfoot.*;

/**
 * Write a description of class ShieldText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShieldText extends WeaponShop
{
    /**
     * Act - do whatever the ShieldText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mousePressed(this)){
            shop.weaponButton3.select(true);
        }
    }    
}
