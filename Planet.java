import greenfoot.*;
import java.awt.Color;
import java.util.List;

//Written by Nathan

public class Planet extends SpaceObject
{
    public World world;
    public PlanetLevelText label;
    private boolean labelInWorld = false;
    String worldNumber;
    public boolean isBeaten = false;
    
    //public static boolean firstPass = true;
    public Planet(double startX, double startY, World world, String image, String worldNumber){
        super(startX, startY);
        this.world = world;
        setImage(image);
        this.worldNumber = worldNumber;
        //System.out.println(world);
    }
    public void act() 
    {
        super.act();
        miniMap(new PlanetMP());
        
        
        tryDrawLabel();
        //checkDock();
    }
    
   
    
    public void loadWorld(){
        
        //add check for what world is beaten. Going to have to store it in player or some shit because this variable will
        //be overwritten when outerspace is reloaded every time. 
        //Add check to make sure you dont run off the player.levelsbeaten array.
        
        Player.levelsBeaten[Player.getNextIncompleteLevel(space.getSector(this))][space.getSector(this)] = true;
       
        Greenfoot.setWorld(world);
    }
    
    public void addedToWorld(World world){
        super.addedToWorld(world);
        label = new PlanetLevelText(worldNumber, 1);
    }
    
    public void tryDrawLabel(){
        MouseInfo mouse = Greenfoot.getMouseInfo();

        if (mouse != null) {

            if(label != null && labelInWorld){
                label.remove();
                labelInWorld = false;
            }
            List<Actor> objects = getWorld().getObjectsAt(mouse.getX(), mouse.getY(), Planet.class);
            for (Actor object : objects)
            {
                if (object == this)
                {
                    space.addObject(label, getX(), getY()-25);
                    labelInWorld = true;
                    
                    //space.showText("Planet 1", getX(), getY()-50);
                }
            }
        }
    }
    

}
