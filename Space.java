import greenfoot.*;

/**
 * Write a description of class Space here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space extends World
{

    private Ship ship;
    
    public Space()
    {    
        super(900, 450, 1, false); 

        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        ship = new Ship();
        addObject(ship, getWidth()/2, getHeight()/2);
    }
    
    public Ship getShip(){
        return ship;
    }
}
