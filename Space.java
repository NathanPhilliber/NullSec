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
    
    public void tutorial()
    {
        
        //EXAMPLE
        //CHANGE AS NEEDED
        showText("W to move forward", 600, 260);
        showText("A and D to turn", 600, 280);
        showText("C to shoot", 600, 300);
        showText("space to boost", 600, 320);
        showText("Q to swich weapon", 600, 340);
        showText("numbers to change LV", 600, 360);
        showText("shift to draw line", 600, 380);
        showText("PRESS ANY KEY TO CONTINUE", 600, 440);
    }
    
    public void act()
    {
        clearText();
    }
    
    public void clearText()
    {
        if (Greenfoot.getKey() != null)
        {
            for (int i=0; i<=600; i+=20)
            {
                showText("",600,i);
            }
        }
    }
    
    //Return ship object
    public Ship getShip(){
        return ship;
    }
    
    
    
}
