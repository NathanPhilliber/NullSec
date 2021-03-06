import greenfoot.*;
import java.util.List;
import java.io.*;
import java.awt.Color;

/*
 * 
 * Written by Nathan
 * 
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
        super(7000, 2000, 1, false); //7000,540

        LevelCreatorDisplayBlock.printNames();

        setPaintOrder(LevelCreatorPalletBlock.class, LevelCreatorGrid.class, LevelCreatorDisplayBlock.class, LevelCreatorBlockHover.class);
        prepare();
        showText("Press e/left mouse to place. Press r/right mouse to place no collision block\nPress enter to export. Press i to import. Press f to open menu"+
            "\nHold shift to place 3x3", 500,35);
    }

    public LevelCreatorBlockHover block = new LevelCreatorBlockHover(LevelCreatorDisplayBlock.block);
    public LevelCreatorGrid grid = new LevelCreatorGrid();

    public void act(){
        //System.out.println(LevelCreatorPallet.numPallets);
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if(mouse != null){

            block.setLocation(27*Math.round(mouse.getX()/27)+13, 27*Math.round(mouse.getY()/27)+13);
            grid.setLocation(27*Math.round(mouse.getX()/27)+13, 27*Math.round(mouse.getY()/27)+13);
        }
        if(Greenfoot.isKeyDown("e") || (Greenfoot.mousePressed(null) && mouse.getButton() == 1 && LevelCreatorPallet.open == false)){

            addObject(new LevelCreatorBlock(LevelCreatorDisplayBlock.block), 27*Math.round(mouse.getX()/27)+13, 27*Math.round(mouse.getY()/27)+13);
            block.update(LevelCreatorDisplayBlock.block);
            //block = new LevelCreatorBlock(LevelCreatorDisplayBlock.block);

            addObject(block,0,0);

            if(Greenfoot.isKeyDown("shift")){
                addObject(new LevelCreatorBlock(LevelCreatorDisplayBlock.block), 27*Math.round(mouse.getX()/27)+13-27, 27*Math.round(mouse.getY()/27)+13-27);
                addObject(new LevelCreatorBlock(LevelCreatorDisplayBlock.block), 27*Math.round(mouse.getX()/27)+13, 27*Math.round(mouse.getY()/27)+13-27);
                addObject(new LevelCreatorBlock(LevelCreatorDisplayBlock.block), 27*Math.round(mouse.getX()/27)+13+27, 27*Math.round(mouse.getY()/27)+13-27);

                addObject(new LevelCreatorBlock(LevelCreatorDisplayBlock.block), 27*Math.round(mouse.getX()/27)+13-27, 27*Math.round(mouse.getY()/27)+13+27);
                addObject(new LevelCreatorBlock(LevelCreatorDisplayBlock.block), 27*Math.round(mouse.getX()/27)+13, 27*Math.round(mouse.getY()/27)+13+27);
                addObject(new LevelCreatorBlock(LevelCreatorDisplayBlock.block), 27*Math.round(mouse.getX()/27)+13+27, 27*Math.round(mouse.getY()/27)+13+27);

                addObject(new LevelCreatorBlock(LevelCreatorDisplayBlock.block), 27*Math.round(mouse.getX()/27)+13-27, 27*Math.round(mouse.getY()/27)+13);

                addObject(new LevelCreatorBlock(LevelCreatorDisplayBlock.block), 27*Math.round(mouse.getX()/27)+13+27, 27*Math.round(mouse.getY()/27)+13);
            }
            //System.out.println("Number of Objects In Level: " + (numberOfObjects()-2));   
        }
        if(Greenfoot.isKeyDown("r") || (Greenfoot.mousePressed(null) && mouse.getButton() == 3 && LevelCreatorPallet.open == false)){
            if(LevelCreatorDisplayBlock.exceptions.contains(LevelCreatorDisplayBlock.block)){

            }
            else{

                LevelCreatorBlock myBlock = new LevelCreatorBlock(LevelCreatorDisplayBlock.block);
                myBlock.getImage().setColor(new Color(0,0,0,120));
                myBlock.getImage().fill();
                myBlock.noCollision = true; 
                addObject(myBlock, 27*Math.round(mouse.getX()/27)+13, 27*Math.round(mouse.getY()/27)+13);
                block.update(LevelCreatorDisplayBlock.block);
                addObject(block,0,0);

                if(Greenfoot.isKeyDown("shift")){
                    myBlock = new LevelCreatorBlock(LevelCreatorDisplayBlock.block);
                    myBlock.getImage().setColor(new Color(0,0,0,120));
                    myBlock.getImage().fill();
                    myBlock.noCollision = true; 
                    addObject(myBlock, 27*Math.round(mouse.getX()/27)+13-27, 27*Math.round(mouse.getY()/27)+13-27);

                    myBlock = new LevelCreatorBlock(LevelCreatorDisplayBlock.block);
                    myBlock.getImage().setColor(new Color(0,0,0,120));
                    myBlock.getImage().fill();
                    myBlock.noCollision = true; 
                    addObject(myBlock, 27*Math.round(mouse.getX()/27)+13+27, 27*Math.round(mouse.getY()/27)+13-27);

                    myBlock = new LevelCreatorBlock(LevelCreatorDisplayBlock.block);
                    myBlock.getImage().setColor(new Color(0,0,0,120));
                    myBlock.getImage().fill();
                    myBlock.noCollision = true; 
                    addObject(myBlock, 27*Math.round(mouse.getX()/27)+13, 27*Math.round(mouse.getY()/27)+13-27);

                    myBlock = new LevelCreatorBlock(LevelCreatorDisplayBlock.block);
                    myBlock.getImage().setColor(new Color(0,0,0,120));
                    myBlock.getImage().fill();
                    myBlock.noCollision = true; 
                    addObject(myBlock, 27*Math.round(mouse.getX()/27)+13-27, 27*Math.round(mouse.getY()/27)+13+27);

                    myBlock = new LevelCreatorBlock(LevelCreatorDisplayBlock.block);
                    myBlock.getImage().setColor(new Color(0,0,0,120));
                    myBlock.getImage().fill();
                    myBlock.noCollision = true; 
                    addObject(myBlock, 27*Math.round(mouse.getX()/27)+13+27, 27*Math.round(mouse.getY()/27)+13+27);

                    myBlock = new LevelCreatorBlock(LevelCreatorDisplayBlock.block);
                    myBlock.getImage().setColor(new Color(0,0,0,120));
                    myBlock.getImage().fill();
                    myBlock.noCollision = true; 
                    addObject(myBlock, 27*Math.round(mouse.getX()/27)+13, 27*Math.round(mouse.getY()/27)+13+27);

                    myBlock = new LevelCreatorBlock(LevelCreatorDisplayBlock.block);
                    myBlock.getImage().setColor(new Color(0,0,0,120));
                    myBlock.getImage().fill();
                    myBlock.noCollision = true; 
                    addObject(myBlock, 27*Math.round(mouse.getX()/27)+13-27, 27*Math.round(mouse.getY()/27)+13);

                    myBlock = new LevelCreatorBlock(LevelCreatorDisplayBlock.block);
                    myBlock.getImage().setColor(new Color(0,0,0,120));
                    myBlock.getImage().fill();
                    myBlock.noCollision = true; 
                    addObject(myBlock, 27*Math.round(mouse.getX()/27)+13+27, 27*Math.round(mouse.getY()/27)+13);

                }
            }
        }
        if(Greenfoot.isKeyDown("f")){
            LevelCreatorPallet pallet = new LevelCreatorPallet();
            addObject(pallet,0,0);
        }

        if(Greenfoot.isKeyDown("enter")){
            export();
            Greenfoot.stop();
        }
        if(Greenfoot.isKeyDown("u")){
            writeLevel();
            Greenfoot.stop();
        }
        if(Greenfoot.isKeyDown("i")){
            loadGenerated();
            Greenfoot.stop();
        }
    }

    public void update(){
        block.update(LevelCreatorDisplayBlock.block);
    }

    public void writeLevel(){
        export();
        try{
            BufferedReader br = new BufferedReader(new FileReader("_GeneratedLevel.txt"));

            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("_Level.txt"), "utf-8"));
            writer.write("import greenfoot.*;\n");
            writer.write("\n//Level generated by Level Creator\n//Level designed by: \n\n\n");
            writer.write("public class Level$ extends Platformer{\n");
            writer.write("public Level$(){\n");
            writer.write("this(0,0);\n");
            writer.write("}\n");
            writer.write("public Level$(double x, double y){\n");
            writer.write("\tsuper(x,y);\n\n\n");


            String line = br.readLine();

            while(line != null){
                writer.write(line+"\n");
                line = br.readLine(); //last
            }
            writer.write("}\n}\n");

        }catch (FileNotFoundException e){
            System.out.println(e);
        } catch(IOException e){
            System.out.println(e);
        }
        
        try{
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    Writer writer = null;
    private void export(){
        List<Actor> objects = getObjects(null);

        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("_GeneratedLevel.txt"), "utf-8"));
            writer.write("//Level Generated\n\n");
            writer.write("int offsetX = 0;\nint offsetY = (getHeight()-540)/2;\n\n");
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
                    else if(thisBlock.myImage == 24 || thisBlock.myImage == 25 ||thisBlock.myImage == 61){
                        writer.write("addObject(new ClimbBlock(" + (thisBlock.myImage)+"),"+ object.getX()+"+offsetX,"+object.getY()+"+offsetY);\n");
                    }
                    else if(thisBlock.myImage == 75){
                        writer.write("addObject(new FallingBlock(" + (thisBlock.myImage)+"),"+ object.getX()+"+offsetX,"+object.getY()+"+offsetY);\n");
                    }
                    else if(thisBlock.myImage == 84){
                        writer.write("addObject(new SpikeBlock(" + (thisBlock.myImage)+"),"+ object.getX()+"+offsetX,"+object.getY()+"+offsetY);\n");
                    }
                    else if(thisBlock.myImage == 85){
                        writer.write("addObject(new BulletLauncher(" + (thisBlock.myImage)+",0),"+ object.getX()+"+offsetX,"+object.getY()+"+offsetY);\n");
                    }
                    else if(thisBlock.myImage == 86){
                        writer.write("addObject(new BulletLauncher(" + (thisBlock.myImage)+",180),"+ object.getX()+"+offsetX,"+object.getY()+"+offsetY);\n");
                    }
                    else if(thisBlock.myImage == 87){
                        writer.write("addObject(new ElevatorBlock(" + (thisBlock.myImage)+"),"+ object.getX()+"+offsetX,"+object.getY()+"+offsetY);\n");
                    }
                    else if(thisBlock.myImage == 88){
                        writer.write("addObject(new SlimeBlock(" + (thisBlock.myImage)+"),"+ object.getX()+"+offsetX,"+object.getY()+"+offsetY);\n");
                    }
                    else if(thisBlock.myImage == 89){
                        writer.write("addObject(new MeltingBlock(" + (thisBlock.myImage)+"),"+ object.getX()+"+offsetX,"+object.getY()+"+offsetY);\n");
                    }
                    else if(thisBlock.myImage == 90){
                        writer.write("addObject(new Coin(" + (thisBlock.myImage)+"),"+ object.getX()+"+offsetX,"+object.getY()+"+offsetY);\n");
                    }
                    else if(thisBlock.myImage == 91){
                        writer.write("addObject(new TraceHead(" + (thisBlock.myImage)+"),"+ object.getX()+"+offsetX,"+object.getY()+"+offsetY);\n");
                    }
                    else if(thisBlock.myImage == 93){
                        writer.write("addObject(new Track(" + (thisBlock.myImage)+"),"+ object.getX()+"+offsetX,"+object.getY()+"+offsetY);\n");
                    }
                    else if(thisBlock.myImage == 94){
                        writer.write("addObject(new Cart(" + (thisBlock.myImage)+"),"+ object.getX()+"+offsetX,"+object.getY()+"+offsetY);\n");
                    }
                    else if(thisBlock.myImage == 95){
                        writer.write("addObject(new GravityBlock(" + (thisBlock.myImage)+"),"+ object.getX()+"+offsetX,"+object.getY()+"+offsetY);\n");
                    }
                    else if(thisBlock.myImage == 96){
                        writer.write("addObject(new Wire(" + (thisBlock.myImage)+"),"+ object.getX()+"+offsetX,"+object.getY()+"+offsetY);\n");
                    }
                    else if(thisBlock.myImage == 97){
                        writer.write("addObject(new WireButton(" + (thisBlock.myImage)+"),"+ object.getX()+"+offsetX,"+object.getY()+"+offsetY);\n");
                    }
                    else if(thisBlock.myImage == 98){
                        writer.write("addObject(new Trapdoor(" + (thisBlock.myImage)+"),"+ object.getX()+"+offsetX,"+object.getY()+"+offsetY);\n");
                    }
                    else if(thisBlock.myImage == 99){
                        writer.write("addObject(new Alien(),"+ object.getX()+"+offsetX,"+object.getY()+"+offsetY);\n");
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
        grid.getImage().setTransparency(150);
        addObject(grid,0,0);
        addObject(block,0,0);

        LevelCreatorDisplayBlock.printNames();

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
                    //String[] parts = line.split(" ");
                    //String numS = parts[3].replace(";","");
                    //offsetX = Integer.parseInt(numS);
                }
                if(line.contains("int offsetY")){
                    //String[] parts = line.split(" ");
                    //String numS = parts[3].replace(";","");
                    //offsetY = Integer.parseInt(numS);
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

                if(line.contains("new ClimbBlock")){
                    String[] parts = line.split(",");
                    String x = parts[1].replace("+offsetX","");
                    String y = parts[2].replace("+offsetY);","");

                    System.out.println(parts[0]);
                    String[] parts2 = parts[0].split("\\(");
                    String type = parts2[2].replace(")","");

                    addObject(new LevelCreatorBlock(Integer.parseInt(type)), Integer.parseInt(x)+offsetX, Integer.parseInt(y)+offsetY);
                }
                if(line.contains("new GravityBlock")){
                    String[] parts = line.split(",");
                    String x = parts[1].replace("+offsetX","");
                    String y = parts[2].replace("+offsetY);","");

                    System.out.println(parts[0]);
                    String[] parts2 = parts[0].split("\\(");
                    String type = parts2[2].replace(")","");

                    addObject(new LevelCreatorBlock(Integer.parseInt(type)), Integer.parseInt(x)+offsetX, Integer.parseInt(y)+offsetY);
                }

                if(line.contains("new ElevatorBlock")){
                    String[] parts = line.split(",");
                    String x = parts[1].replace("+offsetX","");
                    String y = parts[2].replace("+offsetY);","");

                    System.out.println(parts[0]);
                    String[] parts2 = parts[0].split("\\(");
                    String type = parts2[2].replace(")","");

                    addObject(new LevelCreatorBlock(Integer.parseInt(type)), Integer.parseInt(x)+offsetX, Integer.parseInt(y)+offsetY);
                }

                if(line.contains("new SlimeBlock")){
                    String[] parts = line.split(",");
                    String x = parts[1].replace("+offsetX","");
                    String y = parts[2].replace("+offsetY);","");

                    System.out.println(parts[0]);
                    String[] parts2 = parts[0].split("\\(");
                    String type = parts2[2].replace(")","");

                    addObject(new LevelCreatorBlock(Integer.parseInt(type)), Integer.parseInt(x)+offsetX, Integer.parseInt(y)+offsetY);
                }
                
                if(line.contains("new Wire")){
                    String[] parts = line.split(",");
                    String x = parts[1].replace("+offsetX","");
                    String y = parts[2].replace("+offsetY);","");

                    System.out.println(parts[0]);
                    String[] parts2 = parts[0].split("\\(");
                    String type = parts2[2].replace(")","");

                    addObject(new LevelCreatorBlock(Integer.parseInt(type)), Integer.parseInt(x)+offsetX, Integer.parseInt(y)+offsetY);
                }
                
                if(line.contains("new Trapdoor")){
                    String[] parts = line.split(",");
                    String x = parts[1].replace("+offsetX","");
                    String y = parts[2].replace("+offsetY);","");

                    System.out.println(parts[0]);
                    String[] parts2 = parts[0].split("\\(");
                    String type = parts2[2].replace(")","");

                    addObject(new LevelCreatorBlock(Integer.parseInt(type)), Integer.parseInt(x)+offsetX, Integer.parseInt(y)+offsetY);
                }
                
                if(line.contains("new WireButton")){
                    String[] parts = line.split(",");
                    String x = parts[1].replace("+offsetX","");
                    String y = parts[2].replace("+offsetY);","");

                    System.out.println(parts[0]);
                    String[] parts2 = parts[0].split("\\(");
                    String type = parts2[2].replace(")","");

                    addObject(new LevelCreatorBlock(Integer.parseInt(type)), Integer.parseInt(x)+offsetX, Integer.parseInt(y)+offsetY);
                }

                if(line.contains("new FallingBlock")){
                    String[] parts = line.split(",");
                    String x = parts[1].replace("+offsetX","");
                    String y = parts[2].replace("+offsetY);","");

                    System.out.println(parts[0]);
                    String[] parts2 = parts[0].split("\\(");
                    String type = parts2[2].replace(")","");

                    addObject(new LevelCreatorBlock(Integer.parseInt(type)), Integer.parseInt(x)+offsetX, Integer.parseInt(y)+offsetY);
                }

                if(line.contains("new SpikeBlock")){
                    String[] parts = line.split(",");
                    String x = parts[1].replace("+offsetX","");
                    String y = parts[2].replace("+offsetY);","");

                    System.out.println(parts[0]);
                    String[] parts2 = parts[0].split("\\(");
                    String type = parts2[2].replace(")","");

                    addObject(new LevelCreatorBlock(Integer.parseInt(type)), Integer.parseInt(x)+offsetX, Integer.parseInt(y)+offsetY);
                }

                if(line.contains("new MeltingBlock")){
                    String[] parts = line.split(",");
                    String x = parts[1].replace("+offsetX","");
                    String y = parts[2].replace("+offsetY);","");

                    System.out.println(parts[0]);
                    String[] parts2 = parts[0].split("\\(");
                    String type = parts2[2].replace(")","");

                    addObject(new LevelCreatorBlock(Integer.parseInt(type)), Integer.parseInt(x)+offsetX, Integer.parseInt(y)+offsetY);
                }

                if(line.contains("new Track")){
                    String[] parts = line.split(",");
                    String x = parts[1].replace("+offsetX","");
                    String y = parts[2].replace("+offsetY);","");

                    System.out.println(parts[0]);
                    String[] parts2 = parts[0].split("\\(");
                    String type = parts2[2].replace(")","");

                    addObject(new LevelCreatorBlock(Integer.parseInt(type)), Integer.parseInt(x)+offsetX, Integer.parseInt(y)+offsetY);
                }
                if(line.contains("new Alien")){
                    String[] parts = line.split(",");
                    String x = parts[1].replace("+offsetX","");
                    String y = parts[2].replace("+offsetY);","");

                    System.out.println(parts[0]);
                    String[] parts2 = parts[0].split("\\(");
                    String type = parts2[2].replace(")","");

                    addObject(new LevelCreatorBlock(99), Integer.parseInt(x)+offsetX, Integer.parseInt(y)+offsetY);
                }

                if(line.contains("new Cart")){
                    String[] parts = line.split(",");
                    String x = parts[1].replace("+offsetX","");
                    String y = parts[2].replace("+offsetY);","");

                    System.out.println(parts[0]);
                    String[] parts2 = parts[0].split("\\(");
                    String type = parts2[2].replace(")","");

                    addObject(new LevelCreatorBlock(Integer.parseInt(type)), Integer.parseInt(x)+offsetX, Integer.parseInt(y)+offsetY);
                }

                if(line.contains("new Coin")){
                    String[] parts = line.split(",");
                    String x = parts[1].replace("+offsetX","");
                    String y = parts[2].replace("+offsetY);","");

                    System.out.println(parts[0]);
                    String[] parts2 = parts[0].split("\\(");
                    String type = parts2[2].replace(")","");

                    addObject(new LevelCreatorBlock(Integer.parseInt(type)), Integer.parseInt(x)+offsetX, Integer.parseInt(y)+offsetY);
                }

                if(line.contains("new TraceHead")){
                    String[] parts = line.split(",");
                    String x = parts[1].replace("+offsetX","");
                    String y = parts[2].replace("+offsetY);","");

                    System.out.println(parts[0]);
                    String[] parts2 = parts[0].split("\\(");
                    String type = parts2[2].replace(")","");

                    addObject(new LevelCreatorBlock(Integer.parseInt(type)), Integer.parseInt(x)+offsetX, Integer.parseInt(y)+offsetY);
                }

                if(line.contains("new BulletLauncher")){
                    if(line.contains("85,0)")){
                        String[] parts = line.split(",");
                        String x = parts[2].replace("+offsetX","");
                        String y = parts[3].replace("+offsetY);","");

                        System.out.println(parts[0]);
                        String[] parts2 = parts[0].split("\\(");
                        String type = parts2[2].replace(")","");

                        addObject(new LevelCreatorBlock(85), Integer.parseInt(x)+offsetX, Integer.parseInt(y)+offsetY); 
                    }
                    if(line.contains("86,180")){
                        String[] parts = line.split(",");
                        String x = parts[2].replace("+offsetX","");
                        String y = parts[3].replace("+offsetY);","");

                        System.out.println(parts[0]);
                        String[] parts2 = parts[0].split("\\(");
                        String type = parts2[2].replace(")","");

                        addObject(new LevelCreatorBlock(86), Integer.parseInt(x)+offsetX, Integer.parseInt(y)+offsetY); 
                    }

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

