import greenfoot.*;

/**
 * Write a description of class MissileText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MissileText extends WeaponShop
{
    /**
     * Act - do whatever the MissileText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mousePressed(this)){
            shop.sideButton3.select(true);
        }
    }    
}
