import greenfoot.*;

/**
 * Write a description of class WeaponsText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WeaponsText extends WeaponShop
{
    /**
     * Act - do whatever the WeaponsText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

        if(Greenfoot.mousePressed(this)){
            shop.weaponButton2.select(true);
        }
    }    
}
