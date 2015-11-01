import greenfoot.*;

/**
 * Write a description of class MineText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MineText extends WeaponShop
{
    /**
     * Act - do whatever the MineText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mousePressed(this)){
            shop.sideButton4.select(true);
        }
    }    
}
