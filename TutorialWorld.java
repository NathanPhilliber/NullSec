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

public class TutorialWorld extends Space
{

    //Contructor, spawn world
    public TutorialWorld()
    {    
        super();
        prepareObjects();
    }


    private void prepareObjects()
    {
        super.prepare();
        addObject(getShip(), (int)getWidth()/2, (int)getHeight()/2);

        addObject(new Gold(0,0,1),0,0);

    }
    public void act()
    {
        super.act();
    }
    
    public void clearCoins(){
        removeObjects(getObjects(Gold.class));
    }

}

    