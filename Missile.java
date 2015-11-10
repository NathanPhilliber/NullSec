import greenfoot.*;
import java.util.List;

//Written by Trace

public class Missile extends Weapon implements ProjectileObject
{


    private int turn;
    private int time;
    private boolean firstTime = true;

    private double speed = 6.0;
    
    Class targetClass = ownedByPlayer ? AlienShip.class : Ship.class;
    
    private GreenfootSound shootSound = new GreenfootSound("sounds/missileLaunch.mp3");
    public void act() 
    {
        super.act();
        spaceMove(speed);
        addMissileTrail(getSpaceX(), getSpaceY());
        seakTarget();
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
        List<Actor> nearActors = getObjectsInRange(150, targetClass);  
        Actor nearestActor = null;  
        double nearestDistance = 150;  
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
           // System.out.println(currAngle);
        }
    }

    private void turnRandom()
    {
        setRotation(getRotation()+(Greenfoot.getRandomNumber(5)-2));
    }
}
