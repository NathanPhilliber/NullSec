import greenfoot.*;
import java.util.List;

/**
 * Write a description of class LevelCreatorDisplayBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelCreatorDisplayBlock extends LevelCreatorObject
{
    /**
     * Act - do whatever the LevelCreatorDisplayBlock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static int block = 0;

    public static String[] blockName = {"brick.png", "BlueBrick.png","Lava.png","Lava2.png", "StandingRight.png",
        "Portal.png",
        "cancel.png"}; //MAKE CANCEL LAST

    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            block++;
            if(block >= blockName.length){
                block = 0;
            }
            setImage(blockName[block]);
            List<LevelCreatorBlockHover> objects = getWorld().getObjects(LevelCreatorBlockHover.class);
            objects.get(0).update(block);
        }

    }   
    
    
}
