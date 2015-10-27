import greenfoot.*;

/**
 * Write a description of class LevelCreatorBlockHover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelCreatorBlockHover extends LevelCreatorObject
{
    /**
     * Act - do whatever the LevelCreatorBlockHover wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    } 
    
    public LevelCreatorBlockHover(){
        setImage("brick.png");
    }

    public LevelCreatorBlockHover(int blockType)
    {
        setImage(LevelCreatorDisplayBlock.blockName[blockType]);
    }
    
    public void update(int blockType){
        setImage(LevelCreatorDisplayBlock.blockName[blockType]);
    }
}
