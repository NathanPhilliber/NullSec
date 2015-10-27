import greenfoot.*;
import java.util.List;
import java.io.*;

/**
 * Write a description of class LevelCreator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelCreator extends World
{

    /**
     * Constructor for objects of class LevelCreator.
     * 
     */
    public LevelCreator()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(2000, 540, 1); 
        setPaintOrder(LevelCreatorDisplayBlock.class, LevelCreatorBlockHover.class);
        prepare();
        showText("Press 'e' to place block. Click top left to toggle block. Press enter to generate file", 485,25);
    }

    public LevelCreatorBlockHover block = new LevelCreatorBlockHover(LevelCreatorDisplayBlock.block);

    public void act(){

        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null){

            block.setLocation(27*Math.round(mouse.getX()/27), 27*Math.round(mouse.getY()/27));
        }
        if(Greenfoot.isKeyDown("e")){
            addObject(new LevelCreatorBlock(LevelCreatorDisplayBlock.block), 27*Math.round(mouse.getX()/27), 27*Math.round(mouse.getY()/27));
            block.update(LevelCreatorDisplayBlock.block);
            //block = new LevelCreatorBlock(LevelCreatorDisplayBlock.block);

            addObject(block,0,0);
            //System.out.println("Number of Objects In Level: " + (numberOfObjects()-2));	
        }

        if(Greenfoot.isKeyDown("enter")){
            export();
            Greenfoot.stop();
        }
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    Writer writer = null;
    private void export(){
        List<Actor> objects = getObjects(null);

        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("_GeneratedLevel.txt"), "utf-8"));
            writer.write("//Level Generated\n\n");
            writer.write("int offsetX = 0;\nint offsetY = 0;\n\n");
        } catch (IOException ex) {
            System.out.println(ex);
        }

        for(Actor object : objects){
            if(object instanceof LevelCreatorBlock){
                try{
                    LevelCreatorBlock thisBlock = (LevelCreatorBlock) object;
                    if(thisBlock.myImage == 2 || thisBlock.myImage == 3){
                        writer.write("addObject(new LavaBlock(" + (thisBlock.myImage-1)+"),"+ object.getX()+"+offsetX,"+object.getY()+"+offsetY);\n");
                    }
                    else if(thisBlock.myImage == 4){
                        writer.write("addObject(new PlatformPlayer(),"+ object.getX()+"+offsetX,"+object.getY()+"+offsetY);\n");
                    }
                    else{
                        writer.write("addObject(new Block(" + thisBlock.myImage+"),"+ object.getX()+"+offsetX,"+object.getY()+"+offsetY);\n");
                    }
                    
                }catch(IOException e){
                    System.out.println(e);
                }

            }
        }
        try{
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private void prepare()
    {
        LevelCreatorDisplayBlock levelcreatordisplayblock = new LevelCreatorDisplayBlock();
        addObject(levelcreatordisplayblock, 30, 28);
        addObject(block,0,0);

    }
}
