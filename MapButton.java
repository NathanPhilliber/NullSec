import greenfoot.*;

/**
 * Write a description of class MapButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MapButton extends Menu
{
    /**
     * Act - do whatever the MapButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mousePressed(null)){
            if(Greenfoot.mousePressed(this)){
                select(true);
            }
            else{
                select(false);
            }
        }
    }   
    
    public void select(boolean sel){
        GreenfootSound ding = new GreenfootSound("sounds/buttonSound.wav");
            ding.play();
        if(sel){
            Space space = (Space) getWorld();
            space.openMap(true);
        }
    }
}
