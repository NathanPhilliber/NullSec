import greenfoot.*;

//Written by Nathan

public class ClimbBlock extends NoCollisionBlock
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
