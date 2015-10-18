import greenfoot.*;

/**
 * Write a description of class Asteroids here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Asteroid extends SpaceObject
{

    private double speed;
    
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
        if(isOffEdge(600)){
            space.removeObject(this);
        }
    }
    
    
}
