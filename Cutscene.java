import greenfoot.*;

/**
 * Write a description of class Cutscene here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cutscene extends World
{
    World goToWorld;
    int time = 0;
    
    public Cutscene(World world)
    {    

        super(OptionsMenu.getWorldWidth(), OptionsMenu.getWorldHeight(), 1, false); 
        goToWorld = world;
    }
    
    public void act(){
        
        
        
    }
    
    public void end(){
        Greenfoot.setWorld(goToWorld);
    }
}
