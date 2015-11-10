import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.core.WorldHandler;  
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.*;
import java.util.List;

public class OuterSpace extends Space
{
    
    
    
    public OuterSpace()
    {    
        this(0,0);
    }
    
    public OuterSpace(double spawnX, double spawnY){
        super(spawnX, spawnY);
        prepareObjects();
    }

    private void prepareObjects()
    {
        super.prepare();
        addObject(getShip(), (int)getWidth()/2, (int)getHeight()/2);

        //addObject(new AlienShip(1000,1000), 1000,1000);

        /********  ADD YOUR SPACE OBJECT STUFF HERE  *******/
        //addObject(new AlienShip(0,0), 0,0);
        
        Planet planet0 = new Planet(-1200,-1480, new Level14(1000,-1000), "images/Planet1.png", "0");
        addObject(planet0, 3000, 0);

        Planet planet1 = new Planet(2800,-1400, new Level14(2500,400), "images/Planet2.png", "1");
        addObject(planet1,3000, 0);

        Planet planet2 = new Planet(1860, 180, new Level14(500,1000), "images/Planet3.png", "2");
        addObject(planet2,3000, 0);

        Planet planet3 = new Planet(-2000, 130,  new Level14(500,1000), "images/Planet4.png", "3");
        addObject(planet3,3000, 0);

        Planet planet4 = new Planet(-110, 1300,  new Level14(500,1000), "images/Planet5.png", "4");
        addObject(planet4,3000, 0);
        
        //Sector 1
        
        Planet planet5 = new Planet(7220, 880,  new Level3(500,1000), "images/Planet6.png", "5");
        addObject(planet5,3000, 0);
        
        Planet planet6 = new Planet(8220, 383,  new Level3(500,1000), "images/Planet7.png", "6");
        addObject(planet6,3000, 0);
        
        Planet planet7 = new Planet(10240, -730,  new Level3(500,1000), "images/Planet8.png", "7");
        addObject(planet7,3000, 0);
        
        
        //Sector 2
        Planet planet8 = new Planet(11220, 1000,  new Level15(500,1000), "images/Planet9.png", "8");
        addObject(planet8,3000, 0);

        Planet planet9 = new Planet(20160, 630,  new Level15(500,1000), "images/Planet10.png", "11");
        addObject(planet9,3000, 0);
        
        Planet planet10 = new Planet(18150, 590,  new Level15(500,1000), "images/Planet11.png", "10");
        addObject(planet10,3000, 0);
        
        Planet planet11 = new Planet(19200, 2280,  new Level7(500,1000), "images/Planet12.png", "12");
        addObject(planet11,3000, 0);
        
        Planet planet12 = new Planet(17185, 1150,  new Level7(500,1000), "images/Planet13.png", "9");
        addObject(planet12,3000, 0);
        //Planet shopPlanet = new Planet(0,2000, new Shop(), "images/PlanetShop.png");
        //addObject(shopPlanet, 3000, 0); 
        
    }

    public void act()
    {
        super.act();
    }

}
