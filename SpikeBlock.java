import greenfoot.*;

/**
 * Write a description of class SpikeBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpikeBlock extends NoCollisionBlock
{
    public SpikeBlock(){
        this(0);
    }
    
    public SpikeBlock(int blockType){
        
        super();

        setImage(LevelCreatorDisplayBlock.getBlock()[blockType]);
        
    }
    public void act() 
    {
        super.act();
        // Add your action code here.
    }    
}
