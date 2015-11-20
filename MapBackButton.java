import greenfoot.*;

/**
 * Write a description of class MapBackButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MapBackButton extends Menu
{
    public MapBackButton(){
        super();
        setImage("images/MapBack.png");
    }
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
