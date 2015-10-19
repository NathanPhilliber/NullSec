import greenfoot.*;

/**
 * Write a description of class Asteroids here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Asteroid extends SpaceObject implements DamageTaker
{

    private double speed;
    protected double health = 5.0;
    
    
    public Asteroid(double x, double y, int rotation, double speed){
        super(x,y);
        this.speed = speed;
        turn(rotation);
    }
    
    public void act() 
    {
       super.act();
       spaceMove(speed);
       checkCollision();
       checkIfFar();
       
       
       checkRemoval();
    }
    
    public void checkIfFar(){
        if(isOffEdge(800)){
            scheduleRemoval();
        }
    }
    
    public boolean getHit(double damage){
        return true;
    }
    
    public boolean checkCollision(){
        Player obj = (Player)getOneIntersectingObject(Player.class);  
            if(obj != null && touch(obj)){
                obj.getHit(getDamage());
                scheduleRemoval();

                return true;
            }
            return false;
    }
    
    public double getDamage(){
        return 0.0;
    }
}
