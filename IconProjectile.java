import greenfoot.*;

/**
 * Write a description of class AntIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IconProjectile extends HUD implements weaponGUI
{
    /**
     * Act - do whatever the AntIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Actor a = getOneIntersectingObject(WeaponBG.class);
        Space SPACE = (Space) getWorld();
        if(SPACE.getWeapon() == 0)
        {
          a.setImage("SelectedWeapon.png");
        }
        else
        {
          a.setImage("HUD1.png");
        }
    }    
}
