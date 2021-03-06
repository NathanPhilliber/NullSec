import greenfoot.*;

//Written by Nathan

public class LevelCreatorPallet extends LevelCreatorObject
{

    public int width = 25;
    public int length = 13; //height of pallet
    public int spaceBetween = 3;

    public static int numPallets = 0;
    public static boolean open = false;

    public LevelCreatorPallet(){
        numPallets++;
        open = true;
    }

    public void act() 
    {

    }  

    public void addedToWorld(World w){
        World world = getWorld();

        if(numPallets > 0){
            numPallets--;

            world.removeObjects(world.getObjects(LevelCreatorPalletBlock.class));
            world.removeObject(this);
        }

        int row = 0;
        int column = 0;

        int mouseX = 0;

        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null){
            mouseX = mouse.getX();
        }

        for(int i = 0; i < LevelCreatorDisplayBlock.blockName.length; i++){

            if(i == 4){
                world.addObject(new LevelCreatorPalletBlock(i), mouseX+25+row*(27+spaceBetween), 85+17+column*(27+spaceBetween));
            } 
            else if(i == 5){
                world.addObject(new LevelCreatorPalletBlock(i), mouseX-10+row*(27+spaceBetween), 85+5+column*(27+spaceBetween));
            }
            else if(i == 99){
                world.addObject(new LevelCreatorPalletBlock(i), mouseX-220+row*(27+spaceBetween), 85+5+column*(27+spaceBetween));
            }
            else{
                world.addObject(new LevelCreatorPalletBlock(i), mouseX+25+row*(27+spaceBetween), 85+column*(27+spaceBetween));
            }
            column++;
            if(column > length){
                row++;
                column = 0;
            }
        }

    }
}
