import greenfoot.*;
public class ClimbBlock extends NonPlayer
{
    public ClimbBlock()
    {
        this(0);
    }

    public ClimbBlock(int blockType)
    {
        super();

        setImage(LevelCreatorDisplayBlock.getBlock()[blockType]);
    }  
}
