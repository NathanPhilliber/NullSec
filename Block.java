import greenfoot.*;
import java.util.List;

public class Block extends NonPlayer
{  
    public void act() 
    {
        super.act();
    }    
    public Block()
    {
        this(0);
    }
    public Block(int blockType)
    {
        super();

        setImage(LevelCreatorDisplayBlock.getBlock()[blockType]);
    }  
}
