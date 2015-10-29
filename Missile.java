import greenfoot.*;
import java.util.List;
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

    private GreenfootSound shootSound = new GreenfootSound("sounds/missileLaunch.mp3");
    public void act() 
    {
        super.act();
        spaceMove(speed);

        if(ownedByPlayer){

            seakTarget();//no work
        }
        checkRemoval();//LAST
    }  

    public Missile(int angle, boolean isPlayer, double damage, double startX, double startY)
    {
        super(angle, isPlayer, startX, startY, damage);
        shootSound.play();

    }

    public void addedToWorld(){
        if(ownedByPlayer){

            speed += space.getShip().getSpeed();
            
        }
    }

    public double getDistance(Actor actor) {
        return Math.hypot(actor.getX() - getX(), actor.getY() - getY());
    }

    public Actor getNearestActor()                   
    {
        List<Actor> nearActors = getObjectsInRange(120, AlienShip.class);  
        Actor nearestActor = null;  
        double nearestDistance = 120;  
        double distance;   
        for (int i = 0; i < nearActors.size(); i++)  
        {  
            distance = getDistance(nearActors.get(i));  
            if (distance < nearestDistance)  
            {  
                nearestActor = nearActors.get(i);  
                nearestDistance = distance;  
            }  
        }  
        return nearestActor;
    }

    private void seakTarget()
    {
        if(getNearestActor() != null)
        {
            int currAngle = 90 - (int) Math.toDegrees(Math.atan2(((double) getNearestActor().getX() - this.getX()), ((double) getNearestActor().getY() - this.getY())));
            int newRotation = (int) currAngle + (int) Math.ceil( -currAngle / 360 ) * 360;
            setRotation(newRotation);
            System.out.println(currAngle);
        }
    }

    private void turnRandom()
    {
        setRotation(getRotation()+(Greenfoot.getRandomNumber(5)-2));
    }
}
