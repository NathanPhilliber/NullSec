import greenfoot.*;

/**
 * Background stars are mainly a visual to make it easier to see how the ship is moving.
 * They will despawn when they are far enough off screen
 * 
 * Written by Nathan Philliber
 */
public class BackgroundStar extends SpaceObject
{
    //Used for debug, keeps track of number of stars currently existing
    private static int numStars = 0;
    
    //Constructor, spawns star at x,y coord and adds to star count
    public BackgroundStar(double x, double y){
        super(x,y);
        addStarCount();
    }
    
    //Constructor, will spawn star at 0,0 and add to star count
    public BackgroundStar(){
        super();
        addStarCount();
    }
    
    //Called every tick, runs SpaceObject parent act method and checks how close it is to ship
    public void act() 
    {
        // Add your action code here.
        super.act();
        checkIfClosePlayer();
    } 
    
    //Returns number of stars currently loaded
    public static int getNumStars(){
        return numStars;
    }
    
    //Adds to star tracker
    private static void addStarCount(){
        numStars++;
    }
    
    //Removes one star from tracker
    private static void removeStarCount(){
        numStars--;
    }
    
    //Removes 1 from tracker and then deletes itself
    public void removeSelf(){
        removeStarCount();
        getWorld().removeObject(this);
    }
    
    //Checks how close star is to player ship via approximation by pythagorean theorem
    //If the star is far away (off screen) it will delete itself
    public void checkIfClosePlayer(){
        
        
        if(Math.sqrt((ship.getSpaceX()-getSpaceX())*(ship.getSpaceX()-getSpaceX())+
        (ship.getSpaceY()-getSpaceY())*(ship.getSpaceY()-getSpaceY()))>1000.0){
            removeSelf();
        }
    }
}
