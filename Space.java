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

public class Space extends World
{

    
    private Ship ship;

    boolean isDown = false;

    MouseInfo mouse;
    int mx,my;
    int prevx,prevy;
    int alpha = 255;
    int key = 9;
    double tempWep = 0; //static
    int mode = 0;
    boolean firstpass = true;
    ScrollingListener scroll = new ScrollingListener(); //static
    JPanel panel = WorldHandler.getInstance().getWorldCanvas();

    private boolean readPause = true;
    public boolean isPaused=false;
    public boolean setPause; //static 

    //Contructor, spawn world

    public Space()
    {    
        super(920, 540, 1, false); 
        prepare();
    }

    public void scrollListener()
    {
        panel.addMouseWheelListener(scroll);
    }

    private void prepare()
    {
        isPaused=false;
        ship = new Ship(0,0);
        addObject(ship, (int)getWidth()/2, (int)getHeight()/2);

        //addObject(new AlienShip(1000,1000), 1000,1000);
        addObject(new AlienShip(0,0), 0,0);

        scrollListener();
        // for (int i = 0; i<100; i++)
        // {
        //    addObject(new Particle(450, 270, 5, 5, 100, 10, 50), 0, 0);
        //}
        tutorial();

        setPaintOrder(DockMenu.class, OutsideMP.class, EnemyShip.class, PlayerShip.class, PlanetMP.class, InsideMP.class, IconProjectile.class, IconFire.class, AlienShip.class, MissleIcon.class, IconPlasma.class, IconLaser.class, IconMine.class, WeaponBG.class, DamageBar.class, Cannon.class, Beam.class,  BeamHUD.class, Projectile.class, Missile.class, Ship.class, PlasmaBall.class, Mine.class, Fireball.class, Particle.class, Planet.class, BackgroundStar.class);

        IconMine iconmine = new IconMine();
        addObject(iconmine, 52, 294);
        iconmine.setLocation(48, 301);
        IconLaser iconlaser = new IconLaser();
        addObject(iconlaser, 48, 226);
        IconPlasma iconplasma = new IconPlasma();
        addObject(iconplasma, 48, 73);
        iconplasma.setLocation(47, 80);
        iconlaser.setLocation(46, 150);
        iconmine.setLocation(47, 227);

        iconmine.setLocation(48, 227);
        IconFire iconfire = new IconFire();
        addObject(iconfire, 49, 364);
        iconfire.setLocation(47, 377);
        iconfire.setLocation(49, 376);
        iconmine.setLocation(49, 302);
        iconlaser.setLocation(45, 226);
        iconlaser.setLocation(46, 226);
        removeObject(iconplasma);
        iconlaser.setLocation(46, 151);
        iconmine.setLocation(48, 227);
        iconfire.setLocation(49, 299);
        IconPlasma iconplasma2 = new IconPlasma();
        addObject(iconplasma2, 40, 357);
        iconplasma2.setLocation(47, 376);
        iconplasma2.setLocation(48, 447);
        iconfire.setLocation(110, 355);
        removeObject(iconfire);
        IconFire iconfire2 = new IconFire();
        addObject(iconfire2, 49, 375);
        iconfire2.setLocation(45, 372);
        iconmine.setLocation(49, 301);
        iconlaser.setLocation(47, 151);
        iconplasma2.setLocation(47, 459);
        iconfire2.setLocation(47, 377);
        iconlaser.setLocation(47, 138);
        iconmine.setLocation(48, 299);

        PlayerShip playermp = new PlayerShip();
        addObject(playermp, 800, 405);

        WeaponBG weaponbg = new WeaponBG();
        addObject(weaponbg, 48, 60);

        WeaponBG weaponbg2 = new WeaponBG();  
        addObject(weaponbg2, 48, 140);

        WeaponBG weaponbg3 = new WeaponBG();        
        addObject(weaponbg3, 48, 220);

        WeaponBG weaponbg4 = new WeaponBG();  
        addObject(weaponbg4, 48, 300);

        WeaponBG weaponbg5 = new WeaponBG();
        addObject(weaponbg5, 48, 380);

        InsideMP insidemp = new InsideMP();
        addObject(insidemp, 800, 405);

        OutsideMP outsidemp = new OutsideMP();
        addObject(outsidemp, 800, 405);

        PlanetOne planetOne = new PlanetOne(1000,1000);
        addObject(planetOne,0, 0);

        PlanetOne planetOne2 = new PlanetOne(0,0);
        addObject(planetOne2,0, 0);

        WeaponBG weaponbg6 = new WeaponBG();
        addObject(weaponbg6, 48, 460);
        MissleIcon missleicon = new MissleIcon();
        addObject(missleicon, 46, 53);
        MissleIcon missleicon2 = new MissleIcon();
        addObject(missleicon2, 44, 63);
        missleicon.setLocation(49, 50);
        missleicon2.setLocation(41, 64);
        missleicon2.setLocation(40, 211);
        missleicon.setLocation(52, 224);
        iconlaser.setLocation(46, 139);
        IconProjectile anticon = new IconProjectile();
        addObject(anticon, 38, 60);
        IconProjectile anticon2 = new IconProjectile();
        addObject(anticon2, 56, 60);
        Cannon cannon = new Cannon();
        addObject(cannon, 443, 267);
        cannon.setLocation(438, 263);

        addObject(new BeamHUD(), 460, 512);
    }

    public void act()
    {

        
        //System.out.println(numberOfObjects());

        if(!readPause)
        {
            if(setPause == true || Greenfoot.isKeyDown("Escape"))
                readPause = true;
        }
        if(readPause)
        {
            if(Greenfoot.isKeyDown("Escape"))
            {
                if(isPaused) isPaused = false;
                else         isPaused = true;
                readPause = false;
            }
            if(setPause == true)
            {
                isPaused = true;
            }
            if(setPause == false)
            {
                isPaused = false;
            }
        }
        if(!isPaused)
        {
            clearText();
            getWeapon();
        }
    }

    public boolean getIsPaused()
    {
        return isPaused;
    }


    
    public void tutorial()
    {

        /**
         * EXAMPLE
         * CHANGE AS NEEDED
         */
        showText("W to move forward", 450, 260);
        showText("A and D to turn", 450, 280);
        showText("C to shoot", 450, 300);
        showText("space to boost", 450, 320);
        showText("Q to swich weapon", 450, 340);
        showText("numbers to change LV", 450, 360);
        showText("PRESS ANY KEY TO CONTINUE", 450, 440);
    }

    public void clearText()
    {
        if (Greenfoot.getKey() != null)
        {
            for (int i=0; i<=600; i+=20)
            {
                showText("",450,i);
            }
        }
    }

    //Return ship object
    public Ship getShip(){
        return ship;
    }

    public double getWeapon()
    {
        tempWep += scroll.getScroll();
        if(tempWep < 0)
        {
            tempWep = 0;
        }
        if(tempWep > 5)
        {
            tempWep = 5;
        }

        return tempWep;
    } 

}

//Classception
class ScrollingListener implements MouseWheelListener
{
    double amount = 0;

    public void mouseWheelMoved(MouseWheelEvent e){
        amount += e.getWheelRotation();  
        e.consume();
    }

    public double getScroll(){
        double t = amount;

        amount = 0;
        return t;
    }
}