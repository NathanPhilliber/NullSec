import greenfoot.*;

/**
 * Write a description of class WorldOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldOne extends World
{

    /**
     * Constructor for objects of class WorldOne.
     * 
     */
    public WorldOne()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(920, 540, 1, false);
        prepare();
    }
     private void prepare()
    {
        WorldOneFG worldOneFG = new WorldOneFG();
        addObject(worldOneFG, 460, 270);
    }
}
