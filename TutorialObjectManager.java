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
    
    private Space space;
    private Ship ship;
    
    private AlienShip alien1;
    private AlienShip alien2;
    
    
    
    protected void addedToWorld(World world){
        space = (Space) world;
        ship = space.getShip();
        
        
    }
    
    public void act() 
    {
        
        currentTick++;
        
        if(currentTick == 100){
            setImage("images/TutorialSlide1.png");
            setLocation(450,110);
        }
        else if(currentTick == 700){
            setLocation(1000,1000);
        }
        
        else if(currentTick == 800){
            setImage("images/TutorialSlide2.png");
            setLocation(450,110);
        }
        else if(currentTick == 1400){
            setLocation(1000,1000);
        }
        
        else if(currentTick == 1500){
            setImage("images/TutorialSlide3.png");
            setLocation(450,110);
        }
        else if(currentTick == 2100){
            setLocation(1000,1000);
        }
        
        else if(currentTick == 2200){
            setImage("images/TutorialSlide4.png");
            setLocation(450,110);
        }
        else if(currentTick == 2800){
            setLocation(1000,1000);
        }
        
        else if(currentTick == 2900){
            alien1 = new AlienShip(ship.getShipLocX()+100, ship.getShipLocY()+100);
            alien2 = new AlienShip(ship.getShipLocX()-100, ship.getShipLocY()-100);
            space.addObject(alien1, -10,-10);
            space.addObject(alien2, -10, -10);
        }
    }    
}
