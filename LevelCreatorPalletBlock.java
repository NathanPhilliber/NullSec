import greenfoot.*;
import java.util.List;

/**
 * Write a description of class LevelCreatorPalletBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelCreatorPalletBlock extends LevelCreatorObject
{
    public int myImage = 0;

    public LevelCreatorPalletBlock(){
        setImage("brick.png");
    }

    public LevelCreatorPalletBlock(int blockType)
    {
        myImage = blockType;
        setImage(LevelCreatorDisplayBlock.blockName[blockType]);
    }

    public void act() 
    {
        //System.out.println(LevelCreatorPallet.numPallets);
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            List<LevelCreatorDisplayBlock> objects = getWorld().getObjects(LevelCreatorDisplayBlock.class);
            objects.get(0).block = myImage;
            objects.get(0).updateBlock();
            LevelCreator w = (LevelCreator) getWorld();
            w.update();
            LevelCreatorPallet.open = false;
            
            w.removeObjects(w.getObjects(LevelCreatorPalletBlock.class));
        }    
    }
}
