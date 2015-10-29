import greenfoot.*;

/**
 * Write a description of class ClimbBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
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

    protected void addedToWorld(World world)
    {
        setRealX(getX());
        setRealY(getY());
    }   
}
