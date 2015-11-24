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

    GreenfootSound calmMusic = new GreenfootSound("sounds/Devoid_Presence.mp3");
    GreenfootSound activeMusic = new GreenfootSound("sounds/Infected_Euphoria.mp3");
    private boolean firstPass = true;
    private boolean fadeInFirst = true;
    private int delayIn;
    private boolean fadeOutFirst = true;
    private int delayOut;
    //Written by Nathan
    public OuterSpace()
    {    
        this(0,0);
        calmMusic.playLoop();
    }

    //Written by Nathan
    public OuterSpace(double spawnX, double spawnY){
        super(spawnX, spawnY);
        prepareObjects();
    }

    //Written by Trace
    private void prepareObjects()
    {

        super.prepare();
        addObject(mapButton, getWidth()-260,18);
        addObject(gotoShopButton, getWidth()-328, 18);

        addObject(getShip(), (int)getWidth()/2, (int)getHeight()/2);
        //addObject(new AlienShip(1000,1000), 1000,1000);
        /********  ADD YOUR SPACE OBJECT STUFF HERE  *******/
        //addObject(new AlienShip(0,0), 0,0);
        
        //amanda

        Planet planet0 = new Planet(-1200,-1480, new Level14(-1200,-1480), "images/Planet1.png", "1", 0);
        addObject(planet0, 3000, 0);

        Planet planet1 = new Planet(2800,-1400, new Level14(2800,-1400), "images/Planet2.png", "2", 1);
        addObject(planet1,3000, 0);

        Planet planet2 = new Planet(1860, 180, new Level14(1860,180), "images/Planet3.png", "3", 2);
        addObject(planet2,3000, 0);

        Planet planet3 = new Planet(-2000, 130,  new Level14(-2000,130), "images/Planet4.png", "4", 3);
        addObject(planet3,3000, 0);

        //Planet planet4 = new Planet(-110, 1300,  new Level14(-110,1300), "images/Planet5.png", "4");
        //addObject(planet4,3000, 0);

        //Sector 1  done

        Planet planet5 = new Planet(7220, 880,  new Level15(7220,880), "images/Planet6.png", "5", 0);
        addObject(planet5,3000, 0);

        Planet planet6 = new Planet(8220, 383,  new Level22(8220,383), "images/Planet7.png", "6", 1);
        addObject(planet6,3000, 0);

        Planet planet7 = new Planet(10240, -730,  new Level93(10240,-730), "images/Planet8.png", "7", 2);
        addObject(planet7,3000, 0);

        Planet planet8 = new Planet(11220, 1000,  new Level91(11220,1000), "images/Planet9.png", "8", 3);
        addObject(planet8,3000, 0);

        //Sector 2  done
        Planet planet9 = new Planet(20160, 630,  new Level2(20160,630), "images/Planet10.png", "9", 0);
        addObject(planet9,3000, 0);

        Planet planet10 = new Planet(18150, 590,  new Level4(18150,590), "images/Planet11.png", "10", 1);
        addObject(planet10,3000, 0);

        Planet planet11 = new Planet(19200, 2280,  new Level1(19200,2280), "images/Planet12.png", "12", 2);
        addObject(planet11,3000, 0);

        Planet planet12 = new Planet(17185, 1150,  new Level0(17185,1150), "images/Planet13.png", "13", 3);
        addObject(planet12,3000, 0);
        //Planet shopPlanet = new Planet(0,2000, new Shop(), "images/PlanetShop.png");
        //addObject(shopPlanet, 3000, 0); 
        
        
        //Sector 3  done
        Planet planet13 = new Planet(-828, 4146,  new Level30(-828,4146), "images/Planet14.png", "14", 0);
        addObject(planet13,3000, 0);
        //purple

        Planet planet14 = new Planet(-1643, 5733,  new Level31(-1643,5733), "images/Planet16.png", "15", 1);
        addObject(planet14,3000, 0);
        //green planet

        Planet planet15 = new Planet(0, 5621,  new Level32(0,5621), "images/Planet15.png", "16", 2);
        addObject(planet15,3000, 0);
        //white planet

        Planet planet16 = new Planet(2143, 5782,  new Level33(2143,5782), "images/Planet9.png", "17", 3);
        addObject(planet16,3000, 0);
        //brown planet
        
        //Sector 4 done
         
         Planet planet17 = new Planet(6959, 4213,  new Level40(6959,4213), "images/Planet35.png", "18", 0);
        addObject(planet17,3000, 0);
        //blue
        

        Planet planet18 = new Planet(7704, 5698,  new Level41(7704,5698), "images/Planet37.png", "19", 1);
        addObject(planet18,3000, 0);
        //purple
        
        Planet planet19 = new Planet(8745, 5259,  new Level60(8745,5259), "images/Planet18.png", "20", 2);
        addObject(planet19,3000, 0);
        //rainbow

        Planet planet20 = new Planet(10192, 6102,  new Level61(10192,6102), "images/Planet36.png", "21", 3);
        addObject(planet20,3000, 0);
        //green
        
        
       
       //Sector 5  done 
        Planet planet21 = new Planet(15946, 6644,  new Level13(15946,6644), "images/Planet21re.png", "22", 0);
        addObject(planet21,3000, 0);
        //purple
        

        Planet planet22 = new Planet(16882, 6206,  new Level37(16882,6206), "images/planet19.png", "23", 1);
        addObject(planet22,3000, 0);
        //blue

        Planet planet23 = new Planet(18745, 6045,  new Level92(18745,6045), "images/Planet20.png", "24", 2);
        addObject(planet23,3000, 0);
        //white 
        Planet planet24 = new Planet(18745, 3927,  new Level94(18745,3927), "images/Planet22.png", "25", 3);
        addObject(planet24,3000, 0);
        //green/white
        
       
       //*****************************************************************
        
        //Sector 6   done 
        Planet planet25 = new Planet(-2138, 11144,  new Level15(-2138,11144), "images/Planet25.png", "26", 0);
        addObject(planet25,3000, 0);
        //black planet
        

        Planet planet26 = new Planet(716, 11624,  new Level15(716,11624), "images/Planet26.png", "27", 1);
        addObject(planet26,3000, 0);
        //brown planet

        Planet planet27 = new Planet(-226, 10002,  new Level7(-226,10002), "images/Planet23.png", "28", 2);
        addObject(planet27,3000, 0);
        //blue planet

        Planet planet28 = new Planet(2536, 9563,  new Level7(2536,9536), "images/Planet24.png", "29", 3);
        addObject(planet28,3000, 0);
        //green
        
         //************************************************************************
         
        //Sector 7  done
        Planet planet29 = new Planet(9310, 11979,  new Level14(9310,11979), "images/Planet28.png", "30", 0);
        addObject(planet29,3000, 0);
        //red 
        

        Planet planet30 = new Planet(10371, 10235,  new Level24(10371,10235), "images/Planet30.png", "31", 1);
        addObject(planet30,3000, 0);
        //orange

        Planet planet31 = new Planet(8432, 10083,  new Level25(8432,10083), "images/Planet29.png", "32", 2);
        addObject(planet31,3000, 0);
        //blue
        
        
        Planet planet32 = new Planet(6634, 10167,  new Level26(6634,10167), "images/Planet27.png", "33", 3);
        addObject(planet32,3000, 0);
        //peach
        
        // ******************************************************************************//
        //Sector 8  done
        Planet planet33 = new Planet(19562, 10304,  new Level5(20160,630), "images/Planet33.png", "34", 0);
        addObject(planet33,3000, 0);
        //pink
        

        Planet planet34 = new Planet(16887, 10999,  new Level15(18150,590), "images/Planet34.png", "35", 1);
        addObject(planet34,3000, 0);
        //blue with circles

        Planet planet35 = new Planet(15920, 9333,  new Level7(19200,2280), "images/Planet31.png", "36", 2);
        addObject(planet35,3000, 0);
        //green and blue

        Planet planet36 = new Planet(14893, 10957,  new Level7(17185,1150), "images/Planet32.png", "37", 3);
        addObject(planet36,3000, 0);
        //brown
       
      //amanda

    }

    public void act()
    {
        super.act();
        //playAmbientMusic();
    }

    public void playAmbientMusic()
    {
        boolean toggleMusic = false;
        List<Actor> aliens = getObjects(Entity.class);
        if(aliens.size() > 3)
        {
            toggleMusic = true;
            if(toggleMusic)
            {
                fadeIn(activeMusic);
                fadeOut(calmMusic);
            }
        }
        else if(aliens.size() <= 1)
        {
            toggleMusic = true;
            if(toggleMusic)
            {
                fadeIn(calmMusic);
                fadeOut(activeMusic);
            }
        }
    }

    public void fadeOut(GreenfootSound music)
    {
        if(fadeOutFirst)
        {
            delayOut = 100;
            fadeOutFirst = false;
        }
        if(delayOut == 0)
        {
            music.stop();
        }
        if(delayOut > 0)
        {
            music.setVolume(delayOut);
            delayOut--;
        }
    }

    public void fadeIn(GreenfootSound music)
    {
        if(fadeInFirst)
        {
            delayIn = 0;
            fadeInFirst = false;
        }
        if(delayIn == 0)
        {
            music.playLoop();
        }
        if(delayIn < 100)
        {
            music.setVolume(delayIn);
            delayIn++;
        }
        System.out.println(delayIn);
    }

}
