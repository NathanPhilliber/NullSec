import greenfoot.*;

/**
 * Write a description of class Slime here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SlimeBlock extends NoCollisionBlock
{
    public SlimeBlock(){
        this(88);
    }
    public SlimeBlock(int blockType){
        setImage(LevelCreatorDisplayBlock.getBlock()[blockType]);
    }
    public void act() 
    {
        super.act();
    }    
}
