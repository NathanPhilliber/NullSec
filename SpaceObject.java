import greenfoot.*;

/**
 * Every object in space that is not related to the player will be  subclass
 * of this class. This class mainly keeps track of movement.
 * 
 * Written by Nathan Philliber
 */
public class SpaceObject extends Object
{
    
    private double spaceX;
    private double spaceY;
    
    //Default constructor, spawns object at 0,0
    public SpaceObject(){
        this(0.0,0.0);
    }
    
    //Constructor, spawns object at given x and y
    public SpaceObject(double spawnX, double spawnY){
        setSpaceX(spawnX);
        setSpaceY(spawnY);
    }
    
    //Called every tick, updates object position relative to ship coords
    public void act() 
    {
        updatePosition();
    }   
    
    //Moves the objects according to the ship's coords
    public void updatePosition(){
        Space space = (Space) getWorld();
        Ship ship = space.getShip();
        
        setLocation(getSpaceX() - ship.getSpaceX(), getSpaceY() - ship.getSpaceY());
    }
    
    //Set object's X coord
    public void setSpaceX(double x){
        spaceX = x;
    }
    
    //Set object's Y coord
    public void setSpaceY(double y){
        spaceY = y;
    }
    
    //Return object's X coord as a double
    public double getSpaceX(){
        return spaceX;
    }
    
    //Return object's Y coord as a double
    public double getSpaceY(){
        return spaceY;
    }
}
