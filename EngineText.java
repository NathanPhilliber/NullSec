import greenfoot.*;

/**
 * Write a description of class EngineText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EngineText extends WeaponShop
{
    /**
     * Act - do whatever the EngineText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

        if(Greenfoot.mousePressed(this)){
            shop.weaponButton.select(true);
            
        }

    }    
}
