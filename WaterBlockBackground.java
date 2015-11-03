import greenfoot.*;

/**
 * Write a description of class WaterBlockBackground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaterBlockBackground extends NonPlayer
{
    /**
     * Act - do whatever the WaterBlockBackground wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public WaterBlockBackground(int p){

        super();
        if(p == 0)
        {
            setImage("WaterTop.png");
        }
        if(p == 1)
        {
            setImage("WaterMiddle.png");
        }
        if(p == 2)
        {
            setImage("WaterBottom.png");
        }

    }

    public void act() 
    {
        super.act();
        // Add your action code here.
    }    
}
