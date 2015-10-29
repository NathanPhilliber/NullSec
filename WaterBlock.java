import greenfoot.*;

/**
 * Write a description of class WaterBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WaterBlock extends NonPlayer
{
    /**
     * Act - do whatever the WaterBlock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        super.act();
    }   
    
    public WaterBlock(){
        this(0);
    }
    
    public WaterBlock(int p)
    {
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
        
        getImage().setTransparency(150);
    }
    
    
    protected void addedToWorld(World world)
    {
        setRealX(getX());
        setRealY(getY());
    }  
}
