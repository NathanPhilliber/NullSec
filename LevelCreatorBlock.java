import greenfoot.*;

/**
 * Write a description of class LevelCreatorBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelCreatorBlock extends LevelCreatorObject
{
    /**
     * Act - do whatever the LevelCreatorBlock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean isHover = true;

    public int myImage = 0;
    public boolean noCollision = false;

    public LevelCreatorBlock(){
        setImage("brick.png");
    }

    public LevelCreatorBlock(int blockType)
    {
        myImage = blockType;
        setImage(LevelCreatorDisplayBlock.blockName[blockType]);
    }

    public void act() 
    {
        LevelCreatorBlock block = (LevelCreatorBlock) getOneIntersectingObject(LevelCreatorBlock.class);
        //System.out.println(LevelCreatorDisplayBlock.exceptions.contains(myImage));
        if(block != null){
            if((block.noCollision != noCollision) && (LevelCreatorDisplayBlock.exceptions.contains(block.myImage) || LevelCreatorDisplayBlock.exceptions.contains(myImage))){
                
            }
            else{
                getWorld().removeObject(this);
            }
        }

        if(LevelCreatorDisplayBlock.blockName.length -1 == myImage){
            getWorld().removeObject(this);
        }
    }  

    public void addedToWorld(){

    }
}
