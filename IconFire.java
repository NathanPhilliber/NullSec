import greenfoot.*;

//Written by Trace
public class IconFire extends HUD implements weaponGUI
{
    /**
     * Act - do whatever the IconFire wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Actor a = getOneIntersectingObject(WeaponBG.class);
        
        if(space.getWeapon() == 4)
        {
          a.setImage("SelectedWeapon.png");
        }
        else
        {
          a.setImage("HUD1.png");
        }
    }    
}
