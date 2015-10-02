import greenfoot.*;

/**
 * Write a description of class AlienShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AlienShip extends Entity
{
    /**
     * Act - do whatever the AlienShip wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public AlienShip(){
        super();
    }
    
    public AlienShip(double x, double y){
        super(x,y);
        //moveTo(450,225);
    }
    
    public void act() 
    {
        // Add your action code here.
        super.act();
        
        Space space = (Space) getWorld();
        Ship ship = space.getShip();
        moveTo(ship.getShipLocX(),ship.getShipLocY());
        //System.out.println(getSpaceX() + " " + getSpaceY());
        
    }    
}
