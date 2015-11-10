import greenfoot.*;
import java.util.List;

//Written by Nathan

public class Gold extends SpaceObject
{
    /**
     * Act - do whatever the Gold wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static int totalGold = 0;

    public int value;

    public Gold(double x, double y, int value){
        super(x,y);
        this.value = value;
    }

    public void act() 
    {
        super.act();
    }   

    public void pickUp(){
        addCoinPickup(getSpaceX(), getSpaceY());
        totalGold += value; 
        getWorld().removeObject(this);
    }

    
}
