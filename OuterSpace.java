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

    //World worldOne = new WorldOne();
    //World shop = new Shop();
    //Contructor, spawn world

    private Level3 level3 = new Level3(0,0);
    
    

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
        
        Planet planetOne = new Planet(1000,-1000, new Level3(1000,-1000), "images/Planet1.png");
        addObject(planetOne,3000, 0);

        
        
        Planet planetOne2 = new Planet(2500,400, new Level3(2500,400), "images/Planet2.png");
        addObject(planetOne2,3000, 0);

        Planet planetTwo = new Planet(500, 1000, new Level3(500,1000), "images/Planet3.png");
        addObject(planetTwo,3000, 0);

        /*
        Planet planet3 = new Planet(-500, -1000,  level3, "images/Planet4.png");
        addObject(planet3,3000, 0);

        Planet planet4 = new Planet(1000, -2400,  level3, "images/Planet5.png");
        addObject(planet4,3000, 0);

        //Planet shopPlanet = new Planet(0,2000, new Shop(), "images/PlanetShop.png");
        //addObject(shopPlanet, 3000, 0); 
        */
        
    }

    public void act()
    {
        super.act();
    }

}

    