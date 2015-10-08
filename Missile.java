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
    
    private double speed = 6.0;
    public void act() 
    {
        super.act();
        spaceMove(speed);
        seakTarget();//no work
        checkRemoval();//LAST
    }  
    
    public Missile(int angleOffset, boolean isPlayer, double damage, double startX, double startY)
    {
        super(startX, startY, isPlayer, damage);
        if (isPlayer)
        {
            MouseInfo m = Greenfoot.getMouseInfo();
            if(m != null)
            {
                setRotation(angleTowards(460,270,m.getX(),m.getY())+angleOffset);
            }
        }
    }
    
    public Missile(int angleOffset, boolean isPlayer, double damage, double startX, double startY, double targetX, double targetY){
        this(angleOffset, isPlayer, damage, startX, startY);
        setRotation(angleTowards(startX,startY,targetX,targetY)+angleOffset);
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
}
