import greenfoot.*;

/**
 * Write a description of class PlayerShield here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerShield extends Object
{
    public PlayerShield(){
        
        setImage("shield0.png");
        getImage().setTransparency(60);
    }
    public void act() 
    {
        // Add your action code here.
        turn(10);
    }    
}
