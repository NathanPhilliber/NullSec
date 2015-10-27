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
        "Portal.png", "MoonBrick.png", "MoonBrickTop.png", "GooTop.png", "GooBottom.png", "WaterTop.png",  "WaterMiddle.png","WaterBottom.png",
        "Dirt.png", "Grass.png", "SingleStone.png", "StoneSquare.png", "GreyStone1.png", "GreyStone2.png",
        "SandTop.png", "SandMiddle.png",
        "cancel.png"}; //MAKE CANCEL LAST

    public void act() 
    {
        MouseInfo m = Greenfoot.getMouseInfo();
        if(Greenfoot.mouseClicked(this) && m.getButton() == 1){
            block++;
            if(block >= blockName.length){
                block = 0;
            }
            setImage(blockName[block]);
            List<LevelCreatorBlockHover> objects = getWorld().getObjects(LevelCreatorBlockHover.class);
            objects.get(0).update(block);
        }
        
        if(Greenfoot.mouseClicked(this) && m.getButton() == 3){
            block--;
            if(block < 0){
                block = blockName.length -1;
            }
            setImage(blockName[block]);
            List<LevelCreatorBlockHover> objects = getWorld().getObjects(LevelCreatorBlockHover.class);
            objects.get(0).update(block);
        }
    }   
    
    
}
