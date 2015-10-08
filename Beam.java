import greenfoot.*;

/**
 * Write a description of class Beam here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Beam extends Weapon implements ProjectileObject
{
    /**
     * not completly finished
     * feel free to change immage
     * beam lenth is changed in Player.beam()
     * add colisions as nessary
     * 
     */
    public void act() 
    {
        super.act();
        scheduleRemoval();
        checkRemoval();//LAST
    }    
    
    public Beam(int angle, boolean isPlayer, double damage, double startX, double startY)
    {
        super(startX, startY, isPlayer, damage);
        setRotation(angle);
    }
    

}
