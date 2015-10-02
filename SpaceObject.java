import greenfoot.*;

/**
 * Write a description of class SpaceObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpaceObject extends Object
{
    
    private double spaceX;
    private double spaceY;
    
    public SpaceObject(){
        this(0.0,0.0);
    }
    
    public SpaceObject(double spawnX, double spawnY){
        setSpaceX(spawnX);
        setSpaceY(spawnY);
    }
    
    public void act() 
    {
        updatePosition();
    }   
    
    public void updatePosition(){
        Space space = (Space) getWorld();
        Ship ship = space.getShip();
        
        setLocation(getSpaceX() - ship.getSpaceX(), getSpaceY() - ship.getSpaceY());
    }
    
    public void setSpaceX(double x){
        spaceX = x;
    }
    
    public void setSpaceY(double y){
        spaceY = y;
    }
    
    public double getSpaceX(){
        return spaceX;
    }
    
    public double getSpaceY(){
        return spaceY;
    }
}
