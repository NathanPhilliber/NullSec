import greenfoot.*;
import java.awt.Color;

//Written by Nathan

public class BackgroundBlock extends NoCollisionBlock
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
}
