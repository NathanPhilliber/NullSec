import greenfoot.*;

/**
 * Write a description of class TutorialObjectManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TutorialObjectManager extends SpaceObject
{
    /**
     * Act - do whatever the TutorialObjectManager wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    private int currentTick = 0;
    
    
    
    public void act() 
    {
        currentTick++;
        
        if(currentTick == 100){
            setImage("images/TutorialSlide1.png");
            setLocation(450,150);
        }
    }    
}
