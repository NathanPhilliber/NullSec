import greenfoot.*;

/**
 * Write a description of class Gold here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gold extends SpaceObject
{
    /**
     * Act - do whatever the Gold wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static int totalGold = 0;
    
    public int value;
    
    public Gold(double x, double y){
        super(x,y);
    }
    
    public void act() 
    {
        super.act();
    }   
    
    public void pickUp(){
       totalGold += value; 
       getWorld().removeObject(this);
    }
}
