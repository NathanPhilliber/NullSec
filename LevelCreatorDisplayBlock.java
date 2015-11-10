import greenfoot.*;
import java.util.List;
import java.util.ArrayList;

//Written by Nathan and Trace

public class LevelCreatorDisplayBlock extends LevelCreatorObject
{

    public static int block = 0;

    private int delay = 0;

    /************** DONT MESS WITH THE ORDER, ADD SHIT TO THE END******************/

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
            "YellorangeMetal.png", "SkinnyLog.png", "WoodenRoofLeft.png", "WoodenRoofRight.png","spikes.png",
            "BulletLauncherRight.png","BulletLauncherLeft.png","Elevator.png","BounceBlock.png","melt.png",
            "coin.png",
            "cancel.png"}; //MAKE CANCEL LAST

    public static String[] backgroundImages = {"PlanetOneBG.png", "BackgroundLevel4.png", "BackgroundImage3.png", "SpaceshipBackground1.png","MetalBackground.png"};
    public boolean upIsDown;
    public boolean downIsDown;
    public static int bgImage = 0;

    //Written by Nathan
    public static ArrayList<Integer> exceptions = new ArrayList<Integer>();
    public LevelCreatorDisplayBlock(){
        exceptions.add(4);
        exceptions.add(5);
        exceptions.add(90);
        exceptions.add(87);
        exceptions.add(88);
        exceptions.add(84);
        exceptions.add(82);
        exceptions.add(83);
        exceptions.add(75);
        exceptions.add(24);
        exceptions.add(25);
        exceptions.add(61);

    }
    
    //Written by Nathan and Trace
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

    //Written by Nathan
    public void updateBlock(){
        setImage(blockName[block]);

    }

    //Written by Trace
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

    //Written by Trace
    public static String getBG()
    {
        return backgroundImages[bgImage];
    }

    //Written by Nathan
    public static String[] getBlock()
    {
        return blockName;
    }

    //Written by Nathan
    public static void printNames(){
        int i = 0;
        for(String name : blockName){

            System.out.print(i + " " + name);
            i++;
        }
    }
}
