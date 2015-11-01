import greenfoot.*;

/**
 * Write a description of class BeamText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BeamText extends WeaponShop
{
    /**
     * Act - do whatever the BeamText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mousePressed(this)){
            shop.sideButton2.select(true);
        }
    }    
}
