import greenfoot.*;
import java.awt.Color;
import java.util.List;
/**
 * Write a description of class Planets here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Planet extends SpaceObject
{
    /**
     * Act - do whatever the Planets wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public World world;
    public PlanetLevelText label;
    private boolean labelInWorld = false;
    String worldNumber;
    
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
