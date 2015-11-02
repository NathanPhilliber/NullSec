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

    private int delay = 0;

    public static String[] blockName = {"brick.png", "BlueBrick.png","Lava.png","Lava2.png", "StandingRight.png",
            "Portal.png", "MoonBrick.png", "MoonBrickTop.png", "GooTop.png", "GooBottom.png", "WaterTop.png",  "WaterMiddle.png","WaterBottom.png",
            "Dirt.png", "Grass.png", "SingleStone.png", "StoneSquare.png", "GreyStone1.png", "GreyStone2.png",
            "SandTop.png", "SandMiddle.png", "CrackedPurple.png", "Xcrate.png", "SlashCrate.png",
            "AlienVines.png", "Vines.png", "BlueBasicBlock.png", "BlueExtrudedBlock.png", "BlueGlassBlock.png",
            "BlueMetal.png", "BluePlates.png", "BlueStone.png", "BlueStonesTop.png", "BlueStones.png", "BoltedMetal.png",
            "BrownBlock.png", "BrownBlockBottom.png", "BrownWall.png", "CautionBlock.png", "CheckerBoard.png",
            "ColorfulBlocks.png", "CoolColorBlocks.png", "CrackedPurple.png", "CrackedStone.png", "DarkBricks.png",
            "EmeraldBlock.png", "ExtrudedBlock.png", "GlassBlockClear.png", "GreenBasicBlock.png", "GreenExtrudedBlock.png",
            "GreenGlassBlock.png", "GreenishYellowBlocks.png", "GreenSlash.png", "GreyStone1.png", "GreyStone2.png",
            "HellBricks.png", "IceBlock.png", "LeavesBlock.png", "Log.png", "MetalBeams.png",
            "MetalBlock.png", "MetalLadder.png", "OrangePlates.png", "PinkBricks.png", "PinkPurpleBlocks.png",
            "PinkStones.png", "PurpleBlock.png", "RedGlassBlock.png", "SnowBlock.png", "StoneBricks.png",
            "WeirdBlueBlock.png", "YellowBlock.png", "YellowPlates.png", "YellowStones.png", "SnowBlock.png",
            "FallCrate.png", "RoughStoneBricks.png", "WoodenBricksOrRoof.png", "BlueSlash.png", "RedSlash.png",
            "YellorangeMetal.png", "SkinnyLog.png", "WoodenRoofLeft.png", "WoodenRoofRight.png",
            "cancel.png"}; //MAKE CANCEL LAST

    public static String[] backgroundImages = {"PlanetOneBG.png", "BackgroundLevel4.png", "BackgroundImage3.png", "SpaceshipBackground1.png"};
    public boolean upIsDown;
    public boolean downIsDown;
    public static int bgImage = 0;

    public void act() 
    {
        MouseInfo m = Greenfoot.getMouseInfo();
        delay++;
        cycleBackground();

        if(m != null){

            setLocation(m.getX(), getY()-200);

            if((Greenfoot.isKeyDown("w")&& delay > 15)){
                delay = 0;
                block++;
                if(block >= blockName.length){
                    block = 0;
                }
                setImage(blockName[block]);
                List<LevelCreatorBlockHover> objects = getWorld().getObjects(LevelCreatorBlockHover.class);
                objects.get(0).update(block);
            }

            if((Greenfoot.isKeyDown("q") && delay > 15)){
                delay = 0;
                block--;
                if(block < 0){
                    block = blockName.length -1;
                }
                setImage(blockName[block]);
                List<LevelCreatorBlockHover> objects = getWorld().getObjects(LevelCreatorBlockHover.class);
                objects.get(0).update(block);
            }

            if(Greenfoot.mousePressed(null) && m.getButton() == 2 && delay > 15)
            {
                block = blockName.length - 1;
                delay = 0;
                setImage(blockName[block]);
                List<LevelCreatorBlockHover> objects = getWorld().getObjects(LevelCreatorBlockHover.class);
                objects.get(0).update(block);
            }
        }
    }  

    public void updateBlock(){
        setImage(blockName[block]);
        
    }

    public void cycleBackground()
    {
        if(Greenfoot.isKeyDown("UP") && !upIsDown)
        {
            bgImage++;

            if(bgImage >= backgroundImages.length){
                bgImage = 0;
            }

            getWorld().setBackground(backgroundImages[bgImage]);

            upIsDown = true;
        }
        if(!Greenfoot.isKeyDown("UP")&& upIsDown)
        {
            upIsDown = false;
        }

        if(Greenfoot.isKeyDown("DOWN")&& !downIsDown)
        {
            downIsDown = true;
            bgImage--;

            if(bgImage < 0){
                bgImage = backgroundImages.length - 1;
            }

            getWorld().setBackground(backgroundImages[bgImage]);
        }
        if(!Greenfoot.isKeyDown("DOWN")&&  downIsDown)
        {
            downIsDown = false;
        }
    }

    public static String getBG()
    {
        return backgroundImages[bgImage];
    }

    public static String[] getBlock()
    {
        return blockName;
    }

    public static void printNames(){
        int i = 0;
        for(String name : blockName){

            System.out.print(i + " " + name);
            i++;
        }
    }
}
