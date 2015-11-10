import greenfoot.*;

//Written by Nathan

public class LevelCreatorBlockHover extends LevelCreatorObject
{

    public void act() 
    {

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
