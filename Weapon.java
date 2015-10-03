import greenfoot.*;

/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon extends Object
{
    
    private MouseInfo mouse;
    private int mouseX;
    private int mouseY;
    
    
    
    private double spaceX;
    private double spaceY;
    
    public Weapon(){
        
    }
    
    public Weapon(double x, double y){
        spaceX = x;
        spaceY = y;
    }
    
    public void act() 
    {
        mouse = Greenfoot.getMouseInfo();
        if(mouse!=null){
           mouseX = mouse.getX();
           mouseY = mouse.getY();
        }
    }  
    
    public void fire(){
        
        
        
    }
    
    public int getMouseX(){
        return mouseX;
    }
    
    public int getMouseY(){
        return mouseY;
    }
    
}
