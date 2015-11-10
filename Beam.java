import greenfoot.*;

//Written by John

public class Beam extends Weapon implements ProjectileObject
{

    public void act() 
    {
        super.act();
        scheduleRemoval();
        checkRemoval();//LAST
    }    
    
    public Beam(int angle, boolean isPlayer, double damage, double startX, double startY)
    {
        super(angle, isPlayer, startX, startY, damage);
    }
    

}
