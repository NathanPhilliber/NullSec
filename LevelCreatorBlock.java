import greenfoot.*;
import java.util.List;
//Written by Nathan 

public class LevelCreatorBlock extends LevelCreatorObject
{
    /**
     * Act - do whatever the LevelCreatorBlock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean isHover = true;

    public int myImage = 0;
    public boolean noCollision = false;
    public boolean deleteMe = false;

    private int cooldown = 0;

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
        if(cooldown == 20){
            cooldown = 0;
            List<LevelCreatorBlock> blocks = getIntersectingObjects(LevelCreatorBlock.class);
            for(LevelCreatorBlock block : blocks){
                if(block != null){
                    if(block.myImage == LevelCreatorDisplayBlock.blockName.length-1){
                        deleteMe = true;
                    }
                    //if((block.noCollision != noCollision) && (LevelCreatorDisplayBlock.exceptions.contains(block.myImage) || LevelCreatorDisplayBlock.exceptions.contains(myImage))){

                    //}
                    if(block.myImage == myImage){
                        deleteMe = true;
                    }
                    if(LevelCreatorDisplayBlock.exceptions.contains(myImage) || LevelCreatorDisplayBlock.exceptions.contains(block.myImage)){

                    }
                    else if((block.myImage == 94 && myImage == 93) || (block.myImage == 93 && myImage == 94)){

                    }
                    else{
                        deleteMe = true;
                    }
                }

                if(LevelCreatorDisplayBlock.blockName.length -1 == myImage){
                    deleteMe = true;
                }

            }
            removeMe();
            
        }
        
        cooldown++;
    }  

    public void removeMe(){
        if(deleteMe){
            getWorld().removeObject(this);
        }
    }

    public void addedToWorld(World world){
        List<LevelCreatorBlock> blocks = getIntersectingObjects(LevelCreatorBlock.class);
        for(LevelCreatorBlock block : blocks){
            if(block != null){
                if(noCollision){
                    if(LevelCreatorDisplayBlock.exceptions.contains(block.myImage)){
                        int x = block.getX();
                        int y = block.getY();
                        getWorld().removeObject(block);
                        getWorld().addObject(block,x,y);

                    }
                }
            }
        }
        
        if(myImage == LevelCreatorDisplayBlock.blockName.length-1){
                        deleteMe = true;
                    }
    }
}
