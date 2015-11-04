import greenfoot.*;

/**
 * Write a description of class PlanetLevelText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlanetLevelText extends Menu
{
    
    public String name;
    public Number number;
    
    public PlanetLevelText(String name, int i){
        setImage("WorldLevelText.png");
        this.name = name;
        number = new Number(name, i);
    }
    public void act() 
    {
        // Add your action code here.
    }  
    
    public void addedToWorld(World world){
        getWorld().addObject(number, getX()+68, getY()-9);
    }
    
    public void remove(){
        number.remove();
        getWorld().removeObject(this);
    }
}
