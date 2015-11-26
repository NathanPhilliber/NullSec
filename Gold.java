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
    
    private int killGold = 1500;
    private GifImage coinAnimation = new GifImage("coinAnimation.gif");
    private boolean deleteMe = false;

    public Gold(double x, double y, int value){
        super(x,y);
        this.value = value;
        setImage(coinAnimation.getCurrentImage());
    }

    public void act() 
    {
        super.act();
        killGold--;
        if(killGold < 0){
            deleteMe = true;
        }
        //setImage(coinAnimation.getCurrentImage());
        deleteMe();
    }   

    public void pickUp(){
        addCoinPickup(getSpaceX(), getSpaceY());
        totalGold += value; 
        deleteMe = true;
    }
    
    public void deleteMe(){
        if(deleteMe){
            space.removeObject(this);
        }
    }

    
}
