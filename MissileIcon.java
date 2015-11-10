import greenfoot.*;

//Written by Trace

public class MissileIcon extends HUD implements weaponGUI
{

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
