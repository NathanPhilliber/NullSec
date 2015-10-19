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
       checkIfFar();
    }
    
    public void checkIfFar(){
        if(isOffEdge(800)){
            space.removeObject(this);
        }
    }
    
    public boolean getHit(double damage){
        return true;
    }
    
    
}
