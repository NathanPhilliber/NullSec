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
        ship = new Ship(0, 0);
        addObject(ship, getWidth()/2, getHeight()/2);
        
        addObject(new AlienShip(0,0), 10,10);
        //addObject(new Planet(0,0),0,0);
        
        tutorial();
    }
    
    
    public void act()
    {
        clearText();
    }
    
    public void tutorial()
    {
        
        /**
         * EXAMPLE
         * CHANGE AS NEEDED
         */
        showText("W to move forward", 450, 260);
        showText("A and D to turn", 450, 280);
        showText("C to shoot", 450, 300);
        showText("space to boost (someone should add)", 450, 320);
        showText("Q to swich weapon", 450, 340);
        showText("numbers to change LV", 450, 360);
        showText("PRESS ANY KEY TO CONTINUE", 450, 440);
    }
    
    public void clearText()
    {
        if (Greenfoot.getKey() != null)
        {
            for (int i=0; i<=600; i+=20)
            {
                showText("",450,i);
            }
        }
    }
    
    //Return ship object
    public Ship getShip(){
        return ship;
    }
    
    
    
}
