import greenfoot.*;

/**
 * Write a description of class GravityBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GravityBlock extends NoCollisionBlock
{
    public GravityBlock(){
        this(95);
    }
    public GravityBlock(int blockType){
        super();
        setImage(LevelCreatorDisplayBlock.getBlock()[blockType]);
    }
    public void act() 
    {
     super.act();   
    }    
}
