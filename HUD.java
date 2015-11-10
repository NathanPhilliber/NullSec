import greenfoot.*;

/**
 * Write a description of class HUD here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HUD extends Object
{


    public Space space;
    public void act() 
    {
        super.act();
        // Add your action code here.
    }  
    
    public void addedToWorld(World world){
        space = (Space) getWorld();
        
    }
}
interface weaponGUI{
    
}