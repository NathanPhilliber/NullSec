import greenfoot.*;
import java.util.List;
import java.io.*;
import java.awt.Color;

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
        super(7000, 540, 1); 
        setPaintOrder(LevelCreatorDisplayBlock.class, LevelCreatorBlockHover.class);
        prepare();
        showText("Press 'e' to place block. Click top left or press q/w to toggle block. \nPress r to place no collision background block. Press enter to generate file", 500,25);
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
        if(Greenfoot.isKeyDown("r")){
            LevelCreatorBlock myBlock = new LevelCreatorBlock(LevelCreatorDisplayBlock.block);
            myBlock.getImage().setColor(new Color(0,0,0,120));
            myBlock.getImage().fill();
            myBlock.noCollision = true; 
            addObject(myBlock, 27*Math.round(mouse.getX()/27), 27*Math.round(mouse.getY()/27));
            block.update(LevelCreatorDisplayBlock.block);
            addObject(block,0,0);
        }
        

        if(Greenfoot.isKeyDown("enter")){
            export();
            Greenfoot.stop();
        }
        if(Greenfoot.isKeyDown("i")){
            loadGenerated();
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
            writer.write("setBackground(\"" + LevelCreatorDisplayBlock.getBG().toString() + "\");\n");
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
                    else if(thisBlock.myImage == 5){
                        writer.write("addObject(new ExitPortal(),"+ object.getX()+"+offsetX,"+object.getY()+"+offsetY);\n");
                    }
                    else if(thisBlock.noCollision){
                        writer.write("addObject(new BackgroundBlock(" + thisBlock.myImage+"),"+ object.getX()+"+offsetX,"+object.getY()+"+offsetY);\n");
                    }
                    else if(thisBlock.myImage == 10 || thisBlock.myImage == 11 ||thisBlock.myImage == 12){
                        writer.write("addObject(new WaterBlock(" + (thisBlock.myImage-10)+"),"+ object.getX()+"+offsetX,"+object.getY()+"+offsetY);\n");
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
    public void loadGenerated(){
        removeObjects(getObjects(null));
        prepare();
        int offsetX = 0;
        int offsetY = 0;

        try{
            BufferedReader br = new BufferedReader(new FileReader("_import.txt"));

            String line = br.readLine();

            while(line != null){
                
                if(line.contains("        ")){
                    line = line.replace("        ","");
                }
                
                if(line.contains("int offsetX")){
                    String[] parts = line.split(" ");
                    String numS = parts[3].replace(";","");
                    offsetX = Integer.parseInt(numS);
                }
                if(line.contains("int offsetY")){
                    String[] parts = line.split(" ");
                    String numS = parts[3].replace(";","");
                    offsetY = Integer.parseInt(numS);
                }

                if(line.contains("PlatformPlayer")){
                    String[] parts = line.split(",");
                    String x = parts[1].replace("+offsetX","");
                    String y = parts[2].replace("+offsetY);","");
                    addObject(new LevelCreatorBlock(4), Integer.parseInt(x)+offsetX, Integer.parseInt(y)+offsetY);
                }

                
                if(line.contains("setBackground")){
                    String[] parts = line.split("\"");
                    
                    setBackground(parts[1]);
                }
                
                
                if(line.contains("ExitPortal")){
                    String[] parts = line.split(",");
                    String x = parts[1].replace("+offsetX","");
                    String y = parts[2].replace("+offsetY);","");
                    addObject(new LevelCreatorBlock(5), Integer.parseInt(x)+offsetX, Integer.parseInt(y)+offsetY);
                }

                if(line.contains("new Block")){
                    String[] parts = line.split(",");
                    String x = parts[1].replace("+offsetX","");
                    String y = parts[2].replace("+offsetY);","");

                    System.out.println(parts[0]);
                    String[] parts2 = parts[0].split("\\(");
                    String type = parts2[2].replace(")","");

                    addObject(new LevelCreatorBlock(Integer.parseInt(type)), Integer.parseInt(x)+offsetX, Integer.parseInt(y)+offsetY);
                }
                
                if(line.contains("new LavaBlock")){
                    String[] parts = line.split(",");
                    String x = parts[1].replace("+offsetX","");
                    String y = parts[2].replace("+offsetY);","");

                    System.out.println(parts[0]);
                    String[] parts2 = parts[0].split("\\(");
                    String type = parts2[2].replace(")","");

                    addObject(new LevelCreatorBlock(Integer.parseInt(type)+1), Integer.parseInt(x)+offsetX, Integer.parseInt(y)+offsetY);
                }
                
                if(line.contains("new WaterBlock")){
                    String[] parts = line.split(",");
                    String x = parts[1].replace("+offsetX","");
                    String y = parts[2].replace("+offsetY);","");

                    System.out.println(parts[0]);
                    String[] parts2 = parts[0].split("\\(");
                    String type = parts2[2].replace(")","");

                    addObject(new LevelCreatorBlock(Integer.parseInt(type)+10), Integer.parseInt(x)+offsetX, Integer.parseInt(y)+offsetY);
                }

                if(line.contains("new BackgroundBlock")){
                    String[] parts = line.split(",");
                    String x = parts[1].replace("+offsetX","");
                    String y = parts[2].replace("+offsetY);","");

                    System.out.println(parts[0]);
                    String[] parts2 = parts[0].split("\\(");
                    String type = parts2[2].replace(")","");

                    LevelCreatorBlock myBlock = new LevelCreatorBlock(Integer.parseInt(type));
                    myBlock.getImage().setColor(new Color(0,0,0,120));
                    myBlock.getImage().fill();
                    myBlock.noCollision = true; 

                    addObject(myBlock, Integer.parseInt(x)+offsetX, Integer.parseInt(y)+offsetY);
                }

                line = br.readLine();
            }

        }catch (FileNotFoundException e){
            System.out.println(e);
        } catch(IOException e){
            System.out.println(e);
        }
    }
}

