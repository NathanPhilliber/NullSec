import greenfoot.*;

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Weapon implements ProjectileObject
{
    /**
     * Works
     * feel free to change immage or move speed
     * shooting speed is changed in Player.shoot()
     * add colisions as nessary
     * 
     */
    
    private boolean firstTime = true;
    private int angleChange = 0;
    private double speed = 15.0;
    
    public void act() 
    {
        super.act();
        spaceMove(speed);
        checkRemoval();//LAST
    }    
    public Projectile(int angle, boolean isPlayer, double damage, double startX, double startY)
    {
        super(startX, startY, isPlayer, damage);
        setRotation(angle);
    }
    
    //Constructor for entity shooting
    public Projectile(int angleOffset, boolean isPlayer, double damage, double startX, double startY, double targetX, double targetY){
        this(angleOffset, isPlayer, damage, startX, startY);
        setRotation(angleTowards(startX,startY,targetX,targetY)+angleOffset);
    }
    
}
