import greenfoot.*;

/**
 * Write a description of class IconMine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IconMine extends HUD
{
    /**
     * Act - do whatever the IconMine wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Actor a = getOneIntersectingObject(WeaponBG.class);
        if(Space.getWeapon() == 3)
        {
          a.setImage("SelectedWeapon.png");
        }
        else
        {
          a.setImage("HUD1.png");
        }
    }    
}
