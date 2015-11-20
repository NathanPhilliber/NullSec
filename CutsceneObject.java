import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class CutsceneObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CutsceneObject extends All
{
    public CutsceneObject(){
        this("images/transparent.png");
    }
    public CutsceneObject(String img){
        setImage(img);
    }

    public void act() 
    {
        // Add your action code here.

    }  

    public void fillScreen(Color color){
        GreenfootImage image = new  GreenfootImage(getWorld().getWidth(), getWorld().getHeight());
        image.setColor(color);
        image.fill();
        setImage(image);
    }
    
    
}
