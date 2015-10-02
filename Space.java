import greenfoot.*;

public class Space extends World
{

    private Ship ship;
    
    //Contructor, spawn world
    public Space()
    {    
        super(900, 450, 1, false); 

        prepare();
    }

    //Add ship to world
    private void prepare()
    {
        ship = new Ship();
        addObject(ship, getWidth()/2, getHeight()/2);
        
    }
    
    //Return ship object
    public Ship getShip(){
        return ship;
    }
}
