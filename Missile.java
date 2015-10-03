import greenfoot.*;

/**
 * Write a description of class Missle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Missile extends Weapon
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
    
    public void act() 
    {
        //colision effect goes here
        move(3);
        seakTarget();
        removeAtEdge();
    }  
    
    public Missile(int angle)
    {
        setRotation(angle);
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
