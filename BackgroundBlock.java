import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class BackgroundBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackgroundBlock extends NonPlayer
{
    public void act() 
    {
        super.act();
    }    

    public BackgroundBlock()
    {
        this(0);
    }

    public BackgroundBlock(int blockType)
    {
        super();
  
        setImage(LevelCreatorDisplayBlock.getBlock()[blockType]);
        //getImage().setTransparency(200);
        getImage().setColor(new Color(0,0,0,120));
        getImage().fill();
        
    }  

    protected void addedToWorld(World world)
    {
        setRealX(getX());
        setRealY(getY());
    }   
}
