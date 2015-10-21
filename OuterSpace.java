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
    public OuterSpace()
    {    
        super();
        prepareObjects();
    }

    private void prepareObjects()
    {
        super.prepare();
        addObject(getShip(), (int)getWidth()/2, (int)getHeight()/2);

        //addObject(new AlienShip(1000,1000), 1000,1000);

        /********  ADD YOUR SPACE OBJECT STUFF HERE  *******/
        addObject(new AlienShip(0,0), 0,0);

        PlanetOne planetOne = new PlanetOne(0,0, new WorldOne());
        addObject(planetOne,0, 0);

        PlanetOne planetOne2 = new PlanetOne(0,0, new WorldOne());
        addObject(planetOne2,0, 0);

        PlanetTwo planetTwo = new PlanetTwo(500, 1000, new WorldOne());
        addObject(planetTwo,0, 0);

        ShopPlanet shopPlanet = new ShopPlanet(0,2000, new Shop());
        addObject(shopPlanet, 0, 0); 

    }

    public void act()
    {
        super.act();
    }

}

    