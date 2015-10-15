import greenfoot.*;
import java.awt.Color;
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
    //public static boolean firstPass = true;
    public Planet(double startX, double startY){
        super(startX, startY);
    }
    public void act() 
    {
        super.act();
        miniMap(new PlanetMP());
        //checkDock();
    }
    
    /*
    public void checkDock()
    {
        if(Greenfoot.isKeyDown("e"))
        {
            if(touch(Player.class)  && firstPass)
            {
                dockMenu();
                firstPass = false;
            }
        }
    }
    */
}
