import greenfoot.*;

/**
 * Write a description of class IconPlasma here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IconPlasma extends HUD implements weaponGUI
{
    /**
     * Act - do whatever the IconPlasma wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Actor a = getOneIntersectingObject(WeaponBG.class);
        Space SPACE = (Space) getWorld();
        if(SPACE.getWeapon() == 5)
        {
          a.setImage("SelectedWeapon.png");
        }
        else
        {
          a.setImage("HUD1.png");
        }
    }    
}
