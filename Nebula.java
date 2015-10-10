import greenfoot.*;

/**
 * Write a description of class Nebula here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nebula extends SpaceObject
{
    /**
     * Act - do whatever the Nebula wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       super.act();

    }
    //Used for debug, keeps track of number of nebulas currently existing
    private static int numNebula = 0;
    
    //Constructor, spawns nebula at x,y coord and adds to nebula count
    public Nebula(double x, double y){
        super(x,y);
        addNebulaCount();
    }
    
    //Constructor, will spawn nebula at 0,0 and add to nebula count
    public Nebula(){
        super();
        addNebulaCount();
    }
    
    //Called every tick, runs SpaceObject parent act method and checks how close it is to ship
    //Returns number of nebulas currently loaded
    public static int getNumNebula(){
        return numNebula;
    }
    
    //Adds to nebula tracker
    private static void addNebulaCount(){
        numNebula++;
    }
    
    //Removes one nebula from tracker
    private static void removeNebulaCount(){
        numNebula--;
    }
    
    //Removes 1 from tracker and then deletes itself
    public void removeSelf(){
        removeNebulaCount();
        getWorld().removeObject(this);
    }
    
    //Checks how close nebula is to player ship via approximation by pythagorean theorem
    //If the nebula is far away (off screen) it will delete itself
    public void checkIfClosePlayer(){
        Space space = (Space) getWorld();
        Ship ship = space.getShip();
        if(getObjectsInRange(10000, Player.class) == null){
            removeSelf();
        }

    }
}
