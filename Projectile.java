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
        //firstTime();
        spaceMove(speed);
        checkRemoval();//LAST
    }    
    public Projectile(int angle, boolean isPlayer, double damage, double startX, double startY)
    {
        super(startX, startY, isPlayer, damage);
        if (isPlayer)
        {
            MouseInfo m = Greenfoot.getMouseInfo();
            if(m != null)
            {
                setRotation((int)Math.round(Math.atan2((m.getY()-270),(m.getX()-460))*360/(2*Math.PI))+angle);
            }
        }
        
        
        //angleChange = angle;
        //System.out.println("spawn");
    }
    
    //Constructor for entity shooting
    public Projectile(int angle, boolean isPlayer, double damage, double startX, double startY, double targetX, double targetY){
        this(angle, isPlayer, damage, startX, startY);
        //setTargetX(targetX);
        //setTargetY(targetY);
        setRotation((int)Math.round(Math.atan2((targetY-startY),(targetX-startX))*360/(2*Math.PI))+angle);
    }
    

    
    public void firstTime(){
        if(firstTime){
            firstTime = false;
            turnTowards((int)getTargetX(), (int)getTargetY());
            setRotation(getRotation()+angleChange);
        }
        
    }
}
