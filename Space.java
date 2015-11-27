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
import java.util.ArrayList;
import java.util.Arrays;

public class Space extends World
{

    /*
     * This class is the base for the outer space exploration world. The tutorial and main map extends this
     * 
     * Written by Nathan, Trace
     */

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

    private boolean projectileEnabled = true; //DO NOT DIRECTLY EDIT THESE
    private boolean missileEnabled = true;
    private boolean beamEnabled = true;
    private boolean mineEnabled = true;
    private boolean fireballEnabled = true;
    private boolean plasmaballEnabled = true;

    public int sector;
    public int secx;
    public int secy;

    MapButton mapButton = new MapButton();
    MapBackButton mapBackButton = new MapBackButton();

    GotoShopButton gotoShopButton = new GotoShopButton();

    private double spawnX, spawnY;

    //Contructor, spawn world
    //Written by Nathan
    public Space() 
    {    
        this(0,0);
    }

    //Constructor with coords to return player to
    //Written by Nathan
    public Space(double spawnX, double spawnY){
        super(OptionsMenu.getWorldWidth(), OptionsMenu.getWorldHeight(), 1, false);
        this.spawnX = spawnX;
        this.spawnY = spawnY;
        prepare();
    }

    //Written by Trace
    public void scrollListener()
    {
        panel.addMouseWheelListener(scroll);
    }

    //Written by Trace
    protected void prepare()
    {
        isPaused=false;
        ship = new Ship(spawnX,spawnY);

        scrollListener();

        setPaintOrder(CutsceneObject.class,RespawnButton.class, RespawnMenu.class, RespawnMenuBG.class,
            MapBackButton.class, PlayerIcon.class, Map.class, MapButton.class, GotoShopButton.class, GoldText.class,
            Counter.class, BlackBG.class, TutorialObjectManager.class, DockMenu.class, OutsideMP.class, 
            PlayerShip.class, PlanetMP.class, PlanetCompletedMP.class,EnemyShip.class, InsideMP.class, CompletedLabel.class, IconProjectile.class, 
            IconFire.class, MissileIcon.class, IconPlasma.class, IconLaser.class, IconMine.class, 
            WeaponBG.class, BoostBarInside.class, BoostBarSegment.class, BoostBarOutside.class,
            Beam.class,  BeamHUD.class, PlanetLevelText.class, Number.class, Digit.class, Entity.class, DamageBar.class,
            Projectile.class, Missile.class, Cannon.class, Ship.class, PlasmaBall.class, Mine.class, 
            Fireball.class, Particle.class, Asteroid.class, Planet.class, BackgroundStar.class);

        PlayerShip playermp = new PlayerShip();
        addObject(playermp, getWidth()-120, getHeight()-135);

        InsideMP insidemp = new InsideMP();
        addObject(insidemp, getWidth()-120, getHeight()-135);

        OutsideMP outsidemp = new OutsideMP();
        addObject(outsidemp, getWidth()-120, getHeight()-135);

        addObject(new Cannon(),getWidth()/2,getHeight()/2);

        
        secx = (int) Math.ceil(((int) ship.getSpaceX()/10 + 460)/getWidth());
        secy = (int) Math.ceil(((int) ship.getSpaceY()/10 + 270)/getWidth());
    }

    //Written by Nathan and Trace
    public void drawWeaponGUI(boolean proj, boolean beam, boolean missile, boolean mine, boolean fire, boolean plasma){
        projectileEnabled = proj;
        missileEnabled = missile;
        beamEnabled = beam;
        mineEnabled = mine;
        fireballEnabled = fire;
        plasmaballEnabled = plasma;

        if(mine){
            WeaponBG weaponbg4 = new WeaponBG();  
            addObject(weaponbg4, 48, 300);

            IconMine iconmine = new IconMine();
            addObject(iconmine, 48, 299);

        }

        if(beam){
            WeaponBG weaponbg2 = new WeaponBG();  
            addObject(weaponbg2, 48, 140);

            IconLaser iconlaser = new IconLaser();
            addObject(iconlaser, 47, 138);

        }
        if(plasma){
            WeaponBG weaponbg6 = new WeaponBG();
            addObject(weaponbg6, 48, 460);

            IconPlasma iconplasma = new IconPlasma();
            addObject(iconplasma, 48, 73);
            iconplasma.setLocation(47, 80);
            removeObject(iconplasma);

            IconPlasma iconplasma2 = new IconPlasma();
            addObject(iconplasma2, 47, 459);

        }

        if(missile){
            WeaponBG weaponbg3 = new WeaponBG();        
            addObject(weaponbg3, 48, 220);

            MissileIcon missleicon = new MissileIcon();
            addObject(missleicon, 46, 53);
            MissileIcon missleicon2 = new MissileIcon();
            addObject(missleicon2, 44, 63);
            missleicon.setLocation(49, 50);
            missleicon2.setLocation(41, 64);
            missleicon2.setLocation(40, 211);
            missleicon.setLocation(52, 224);
        }

        if(fire){
            WeaponBG weaponbg5 = new WeaponBG();
            addObject(weaponbg5, 48, 380);

            IconFire iconfire = new IconFire();
            addObject(iconfire, 49, 364);
            iconfire.setLocation(47, 377);
            iconfire.setLocation(49, 376);
            iconfire.setLocation(49, 299);

            iconfire.setLocation(110, 355);
            removeObject(iconfire);
            IconFire iconfire2 = new IconFire();
            addObject(iconfire2, 49, 375);
            iconfire2.setLocation(45, 372);
            iconfire2.setLocation(47, 377);
        }
        if(proj){
            WeaponBG weaponbg = new WeaponBG();
            addObject(weaponbg, 48, 60);

            IconProjectile anticon = new IconProjectile();
            addObject(anticon, 38, 60);
            IconProjectile anticon2 = new IconProjectile();
            addObject(anticon2, 56, 60);
        }

    }

    //Written by Nathan
    public void removeWeaponGUI(){
        List objects = getObjects(HUD.class);

        for(int i = 0; i < objects.size(); i++){
            if(!(objects.get(i) instanceof weaponGUI)){
                objects.remove(i);
                i -= 1;
            }
        }
        removeObjects(objects);
    }

    private boolean pauseOnce = true;
    private int totalEscape = 0;

    //Written by Trace
    public void act()
    {
        boolean first = true;
        //System.out.println(totalEscape);
        if(Greenfoot.isKeyDown("escape") && totalEscape == 0 && !isPaused)
        {
            if(first)
            {
                setPause = true;
                MenuBG menubg = new MenuBG();
                addObject(menubg, getWidth()/2, getHeight()/2);
                menubg.getImage().scale(OptionsMenu.getWorldWidth(), OptionsMenu.getWorldHeight());

                first = false;
            }
        }
        else if (Greenfoot.isKeyDown("escape") && isPaused && totalEscape == 0)
        {
            setPause = false;
            first = true;
            List<DockMenu> dockMenu = getObjects(DockMenu.class);
            removeObjects(dockMenu);
        }
        if(Greenfoot.isKeyDown("escape") && pauseOnce)
        {
            pauseOnce = false;
            totalEscape += 1;
        }
        if(!Greenfoot.isKeyDown("escape") && !pauseOnce)
        {
            pauseOnce = true;
            totalEscape -= 1;
        }
        if(setPause == true)
        {
            isPaused = true;
        }
        if(setPause == false)
        {
            isPaused = false;
        }
        if(!isPaused)
        {
            getWeapon();
        }
        openMap(false);
    }

    //Written by Trace
    public boolean getIsPaused()
    {
        return isPaused;
    }

    //Return ship object
    //Written by Nathan
    public Ship getShip(){
        return ship;
    }

    //Written by Nathan
    public double getWeapon()
    {
        tempWep += scroll.getScroll();

        int numType = weaponType();

        if (numType != -1){
            tempWep = numType;
        }
        if(tempWep < 0)
        {
            tempWep = 0;
        }
        if(tempWep > 5)
        {
            tempWep = 5;
        }
        if(tempWep == 0 && projectileEnabled == false){
            tempWep++;
        }
        if(tempWep == 1 && beamEnabled == false){
            tempWep++;
        }
        if(tempWep == 2 && missileEnabled == false){
            tempWep++;
        }
        if(tempWep == 3 && mineEnabled == false){
            tempWep++;
        }
        if(tempWep == 4 && fireballEnabled == false){
            tempWep++;
        }
        if(tempWep == 5 && plasmaballEnabled == false){
            tempWep = 0;
        }
        return tempWep;
    } 

    //Written by John
    private int weaponType()
    {
        int weaponType = -1;
        if (Greenfoot.isKeyDown("1"))
        {
            weaponType = 0;
        }
        if (Greenfoot.isKeyDown("2"))
        {
            weaponType = 1;
        }
        if (Greenfoot.isKeyDown("3"))
        {
            weaponType = 2;
        }
        if (Greenfoot.isKeyDown("4"))
        {
            weaponType = 3;
        }
        if (Greenfoot.isKeyDown("5"))
        {
            weaponType = 4;
        }
        if (Greenfoot.isKeyDown("6"))
        {
            weaponType = 5;
        }

        return weaponType;
    }

    private boolean mapIsOpen;
    private boolean firstPass = true;
    private boolean pressOnce = true;
    private int totalClick = 0;

    //Written by Trace
    public static int getIndexOf( int toSearch, int[] tab ){
        int i = 0;
        try{
            while(!(tab[i] == toSearch) )
            {  i++; }

            return i;
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            return -1;
        }
    }
    //Written by Trace
    public void openMap(boolean override)
    {
        if((Greenfoot.isKeyDown("t") && !mapIsOpen && totalClick == 0) || (override && !mapIsOpen))
        {
            if(firstPass)
            {
                GreenfootSound launch = new GreenfootSound("sounds/radar.mp3");
                launch.setVolume(25);
                launch.play();

                Map map = new Map(getSector(ship));

                //System.out.println(secPos);
                int x = (int) (ship.getSpaceX()/10) +  920/2;
                int y = (int) (ship.getSpaceY()/10) +540/2;
                int newx = (int) (ship.getSpaceX()/10) +  920/2;
                int newy = (int) (ship.getSpaceY()/10) + 540/2;

                if(x > getWidth())
                {
                    newx = x - 920*secx;
                }
                if(y > getHeight())
                {
                    newy = y - 540*secy;
                }
                if(x < 0)
                {
                    newx = x + 920*secx;
                }
                if(y < 0)
                {
                    newy = y + 540*secy;
                }
                addObject(map, getWidth()/2, getHeight()/2);
                BlackBG bg = new BlackBG();
                addObject(bg, getWidth()/2, getHeight()/2);
                bg.getImage().scale(OptionsMenu.getWorldWidth(), OptionsMenu.getWorldHeight());
                addObject(new PlayerIcon(), newx, newy);
                addObject(mapBackButton, 471, 18);
                mapIsOpen = true;
                setPause = true;
                firstPass = false;
            }
        }
        else if((Greenfoot.isKeyDown("t") && mapIsOpen && totalClick == 0) || (mapIsOpen && override))
        {
            List<MapItems> m = getObjects(MapItems.class);
            removeObjects(m);
            removeObject(mapBackButton);
            mapIsOpen = false;
            firstPass = true;
            setPause = false;
        }
        if(Greenfoot.isKeyDown("t") && pressOnce)
        {
            pressOnce = false;
            totalClick += 1;
        }
        if(!Greenfoot.isKeyDown("t") && !pressOnce)
        {
            pressOnce = true;
            totalClick -= 1;
        }
    }
    //Written by Trace
    public int getSectorMiddleX(int sector)
    {
        int sectorX = 0;

        if(sector == 0 || sector == 3 || sector == 6) { sectorX = 0; }
        if(sector == 1 || sector == 4 || sector == 7) { sectorX = 1; }
        if(sector == 2 || sector == 5 || sector == 8) { sectorX = 2; }

        return (sectorX)*(getWidth()*10);
    }

    //Written by Trace
    public int getSectorMiddleY(int sector)
    {
        int sectorY = 0;

        if(sector == 0 || sector == 1 || sector == 2) { sectorY = 0; }
        if(sector == 3 || sector == 4 || sector == 5) { sectorY = 1; }
        if(sector == 6 || sector == 7 || sector == 8) { sectorY = 2; }

        return (sectorY)*(getHeight()*10);
    }

    public int getSector(SpaceObject ship)
    {
        int x = (int) (ship.getSpaceX()/10) + 920/2;
        int y = (int) (ship.getSpaceY()/10) + 540/2;

        //int[] secArray = {0, 1, 2, 10, 11, 12, 20, 21, 22};
        int[] secArray = {0, 10, 20, 1, 11, 21, 2, 12, 22};
        secx = (x>0) ? (int) Math.floor(x/920) : -1;
        secy = (y>0) ? (int) Math.floor(y/540) : -1;

        String a = secx + "" + secy;
        String b = "-1";
        String secPos =  (secx<0 || secy<0) ? b : a;
        int secPosInt = Integer.parseInt(secPos);

        int sectorFake = (getIndexOf(secPosInt, secArray));
        sector = sectorFake;
        return sector;
    }

    public int getSector(Player ship)
    {
        int x = (int) (ship.getSpaceX()/10) +  920/2;
        int y = (int) (ship.getSpaceY()/10) + 540/2;

        //int[] secArray = {0, 1, 2, 10, 11, 12, 20, 21, 22};

        int[] secArray = {0, 10, 20, 1, 11, 21, 2, 12, 22};

        secx = (x>0) ? (int) Math.floor(x/920) : -1;
        secy = (y>0) ? (int) Math.floor(y/540) : -1;

        String a = secx + "" + secy;
        String b = "-1";
        String secPos =  (secx<0 || secy<0) ? b : a;
        int secPosInt = Integer.parseInt(secPos);

        int sectorFake = (getIndexOf(secPosInt, secArray));
        sector = sectorFake;
        return sector;
    }
}

//Classception
//Written by Trace
class ScrollingListener implements MouseWheelListener
{
    double aftAmount = 0;
    double initAmount = 0;

    public void mouseWheelMoved(MouseWheelEvent e){
        initAmount += e.getWheelRotation();                 
        e.consume();
    }

    public double getScroll(){
        double t = Math.round(initAmount/2);

        initAmount = 0;
        return t;
    }
}