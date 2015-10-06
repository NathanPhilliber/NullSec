import greenfoot.*;

/**
 * Write a description of class Missle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Missile extends Weapon implements ProjectileObject
{
    /**
     * Not fully implamented
     * feel free to change immage
     * add colisions as nessary
     * will eventualy seak targets 
     * 
     */
    
    private int turn;
    private int time;
    private boolean firstTime = true;
    
    private double speed = 10.0;
    public void act() 
    {
        super.act();
        //colision effect goes here
        firstTime();
        spaceMove(speed);
        seakTarget();
        removeAtEdge();
    }  
    
    public Missile(int angle, boolean isPlayer, double damage, double startX, double startY)
    {
        super(startX, startY, isPlayer, damage);
        //setRotation(angle);
        
    }
    
    private void seakTarget()
    {
        //seaking stuff here
        
        //if (no target in range)
        //{
            turnRandom();
        //}
    }
    
    private void turnRandom()
    {
        setRotation(getRotation()+(Greenfoot.getRandomNumber(5)-2));
    }
    
    public void firstTime(){
        if(firstTime){
            firstTime = false;
            turnTowards((int)getTargetX(), (int)getTargetY());
        }
        
    }
}
