import greenfoot.*;

/**
 * Write a description of class MissleIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MissleIcon extends HUD implements weaponGUI
{
    /**
     * Act - do whatever the MissleIcon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Actor a = getOneIntersectingObject(WeaponBG.class);
        
        if(space.getWeapon() == 2)
        {
          a.setImage("SelectedWeapon.png");
        }
        else
        {
          a.setImage("HUD1.png");
        }
    }    
}
