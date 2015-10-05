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
    public void act() 
    {
        super.act();
        //colision effect goes here
        //update Position method to move relitive to ship (if you want the ship to be able to catch up to projectiles)
        firstTime();
        move(8);
        
        
        
        removeAtEdge(); //CALL LAST
        
    }    
    public Projectile(int angle, boolean isPlayer, double damage)
    {
        super(isPlayer, damage);
        //setRotation(angle);
        angleChange = angle;
        //System.out.println("spawn");
    }
    
    public Projectile(int angle, double damage){
        this(angle, true, damage);
    }
    
    public void firstTime(){
        if(firstTime){
            firstTime = false;
            turnTowards((int)getTargetX(), (int)getTargetY());
            setRotation(getRotation()+angleChange);
        }
        
    }
}
