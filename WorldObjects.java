import greenfoot.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Object here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldObjects extends SmoothMover
{

    private boolean deleteMe = false;
    protected Space space;
    protected Ship ship;

    //damages
    protected double projectileDamage = 5.0;
    protected double beamDamage = 1.0;
    protected double missileDamage = 13.0;
    protected double fireballDamage = 3.0;
    protected double mineDamage = 25.0;
    protected double plasmaBallDamage = 4.0;

    protected int mineRange = 250;

    public void act() 
    {
        if(space == null){
            space = (Space) getWorld();
            ship = space.getShip();
        }
    } 

    /**
     * 
     * 
     * john start
     * 
     */
    //from 0 to 360 to -180 to 180 
    public int angleRange(int angle)
    {
        if (angle<=180)
        {
            return angle;
        }
        else
        {
            return angle-360;
        }
    }

    public int mouseAngle()//from center of world
    {
        MouseInfo m = Greenfoot.getMouseInfo();
        if(m != null)
        {
            return (int)Math.round(Math.atan2((m.getY()-space.getHeight()/2),(m.getX()-space.getWidth()/2))*360/(2*Math.PI));
        }
        return 0;
    }

    public void setRemovalOffEdge(int dist) 
    {
        if (isOffEdge(dist))
        {
            scheduleRemoval();
        }
    }

    public boolean isOffEdge(int dist)
    {
        if (getX() <= -dist)
        {
            return true;
        }
        else if (getX() >= space.getWidth()+dist)
        {
            return true;
        }
        else if (getY() <= -dist)
        {
            return true;
        }
        else if (getY() >= space.getHeight()+dist)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    public boolean isOffscreen(){
        if((getX() < 0 || getX() > space.getWidth()) || (getY() < 0 || getY() > space.getHeight())){
            return true;
        }
        return false;
    }

    public void setRemovalAtEdge() 
    {
        if (isAtEdge())
        {
            scheduleRemoval();
        }
    }

    public boolean isAtEdge()
    {
        if (getX() <= 0)
        {
            return true;
        }
        else if (getX() >= space.getWidth()-1)
        {
            return true;
        }
        else if (getY() <= 0)
        {
            return true;
        }
        else if (getY() >= space.getHeight()-1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //john end

    public void addExplosion(double x, double y){

        for (int i = 0; i<13; i++)
        {
            space.addObject(new Particle(x, y, 8, 6, 10, 6, 20, 0,"images/exPart1.png"), 0, 0);
            space.addObject(new Particle(x, y, 20, 6, 17, 6, 20, 0,"images/exPart2.png"), 0, 0);
            space.addObject(new Particle(x, y, 10, 6, 7, 6, 10, 95, "images/spark1.png"), 0, 0);
            space.addObject(new Particle(x, y, 10, 6, 7, 6, 10, 95, "images/smoke1.png"), 0, 0);
        }
        GreenfootSound explodeSound = new GreenfootSound("sounds/explode1.mp3");
        explodeSound.play();
    }

    public void addRocketTrail(double x, double y){

        space.addObject(new Particle(x, y, 10, 6, 7, 6, 10, 95, "images/spark1.png"), 0, 0);
        space.addObject(new Particle(x, y, 10, 6, 7, 6, 10, 95, "images/smoke1.png"), 0, 0);
        //double startX, double startY, int straightness, double radius, int lifetime, double particleSpeed, int lifetimeRandom,int angle, String image)
    }

    public void addFire(double x, double y){

        space.addObject(new Particle(x, y, 10, 6, 5, 3, 15, 50,"images/firesparks.png"), 0, 0);
    }

    public void addMineTicker(double x, double y){

        space.addObject(new Particle(x, y, 10, 6, 5, 3, 15, 95,"images/spark1.png"), 0, 0);
    }

    public void addCoinPickup(double x, double y){
        for(int i = 0; i < 30; i++){
            space.addObject(new Particle(x, y, 15, 6, 5, 5, 10, 0,"images/coinEffect.png"), 0, 0);
        }
    }

    public void addPlanetDock(double x, double y){
        for(int i = 0; i < 30; i++){
            space.addObject(new Particle(x, y, 6, 6, 10, 2, 20, 0,"images/smoke2.png"), 0, 0);
        }
    }

    public void addMissileTrail(double x, double y){
        Particle par = new Particle(x, y, 6, 6, 5, 2, 5, 0,"images/smoke2.png");
        par.getImage().setTransparency(100);
        space.addObject(par, 0, 0);

    }

    public void addShootingStar(double x, double y){
        for(int i = 0; i < 2; i++)
            space.addObject(new Particle(x, y, 15, 6, 10, 1, 1, 0,"images/coinEffect.png"), 0, 0);
        Particle par = new Particle(x, y, 6, 6, 5, 2, 5, 0,"images/smoke2.png");
        par.getImage().setTransparency(100);
        space.addObject(par, 0, 0);

    }

    public void scheduleRemoval(){
        deleteMe = true;
    }

    public static GreenfootImage scale(GreenfootImage gi_Image,int i_width,int i_height)
    {
        java.awt.Image image_=gi_Image.getAwtImage().getScaledInstance(i_width,i_height,java.awt.Image.SCALE_SMOOTH);

        gi_Image=new GreenfootImage(i_width,i_height);
        gi_Image.getAwtImage().createGraphics().drawImage(image_,0,0,null);
        return gi_Image;
    }

    public void checkRemoval(){
        if(deleteMe){
            space.removeObject(this);
        }
    }

    public boolean isScheduledForRemoval(){
        return deleteMe;
    }

    /** This method is a pixel perfect collision detection. Returns a List of all Actors, that are touched by this object */
    public List getTouchedObjects(Class clss)
    {
        List<Actor> list =
            getWorld().getObjects(clss),
        list2 = new ArrayList();
        for(Actor A : list)
            if(intersects(A)&&touch(A))
                list2.add(A);
        return list2;
    }

    /** This method is a pixel perfect collision detection. Return, if it intersects an actor of the given class */
    public boolean touch(Class clss)
    {
        List<Actor> list =
            getWorld().getObjects(clss),
        list2 = new ArrayList();
        for(Actor A : list)
            if(intersects(A)&&touch(A))
                return true;
        return false;
    }

    /** This method is a pixel perfect collision detection. It returns a touched actor of the given class, if there's one touched. */
    public Actor getOneTouchedObject(Class clss)
    {
        List<Actor> list =
            getWorld().getObjects(clss),
        list2 = new ArrayList();
        for(Actor A : list)
            if(intersects(A)&&touch(A))
                return A;
        return null;
    }

    /** This method is a pixel perfect collision detection. Returns true, if the object touchs the given Actor */
    public boolean touch(Actor a_big)
    {
        Actor a_small;
        if(getImage().getWidth()*getImage().getHeight()>a_big.getImage().getHeight()*a_big.getImage().getWidth())
        {
            a_small=a_big;
            a_big=this;
        }
        else
            a_small=this;

        int i_hypot=(int)Math.hypot(a_small.getImage().getWidth(),a_small.getImage().getHeight());

        GreenfootImage i=new GreenfootImage(i_hypot,i_hypot);
        i.drawImage(a_small.getImage(),i_hypot/2-a_small.getImage().getWidth()/2,i_hypot/2-a_small.getImage().getHeight()/2);
        i.rotate(a_small.getRotation());
        int w=i_hypot;

        GreenfootImage Ai = a_big.getImage(),
        i2=new GreenfootImage(i_hypot=(int)Math.hypot(Ai.getWidth(),Ai.getHeight()),i_hypot);
        i2.drawImage(Ai,i2.getWidth()/2-Ai.getWidth()/2,i2.getHeight()/2-Ai.getHeight()/2);
        i2.rotate(a_big.getRotation());
        Ai=i2;

        int
        x_Offset=a_big.getX()-a_small.getX()-(Ai.getWidth()/2-w/2),
        y_Offset=a_big.getY()-a_small.getY()-(Ai.getHeight()/2-w/2);

        boolean b = true;
        for(int yi =Math.max(0,y_Offset); yi<w && yi<i_hypot+y_Offset && b; yi++)
            for(int xi =Math.max(0,x_Offset); xi<w && xi<i_hypot+x_Offset && b; xi++)
                if(Ai.getColorAt(xi-x_Offset,yi-y_Offset).getAlpha()>0 && i.getColorAt(xi,yi).getAlpha()>0)
                    b=false;
        return !b;
    }

    public void pause(boolean isPaused)
    {

        List<Actor> actors = space.getObjects(null);

        if(isPaused == true)
        {
            for(Actor a: actors)
            {
                a.setLocation(a.getX(), a.getY());
            }
        }
    }

    public void dockMenu()
    {

        space.setPause = true;
        space.addObject(new MenuBG(), space.getWidth()/2, space.getHeight()/2);
        space.addObject(new MenuMain(), space.getWidth()/2, space.getHeight()/2);
        space.addObject(new MenuYes(), space.getWidth()/2 - 100, space.getHeight()/2);
        space.addObject(new MenuNo(), space.getWidth()/2+100, space.getHeight()/2);

    }

    public void removeDockMenu()
    {
        space = (Space) getWorld(); 
        space.setPause = false;
        List<DockMenu> dockMenu = space.getObjects(DockMenu.class);
        space.removeObjects(dockMenu);

    }

    /*****************************************************************************
     *****************************************************************************
     * WEAPON SYSTEMS
     *     for
     * PLAYER AND NPC
     * 
     * 
     * 
     *****************************************************************************
     *****************************************************************************
     */

    protected void projectile(int angle,int LV,double X,double Y, boolean isPlayer)
    {
        spawnProjectile(angle,X,Y, isPlayer);
        if (LV>=1)
        {
            spawnProjectile(angle+10,X,Y,isPlayer);
            spawnProjectile(angle-10,X,Y,isPlayer);
        }
        if (LV>=2)
        {
            spawnProjectile(angle+20,X,Y,isPlayer);
            spawnProjectile(angle-20,X,Y,isPlayer);
        }
        if (LV>=3)
        {
            spawnProjectile(angle+30,X,Y,isPlayer);
            spawnProjectile(angle-30,X,Y,isPlayer);
        }
    }

    private void spawnProjectile(int angle,double X,double Y, boolean isPlayer)
    {
        space.addObject(new Projectile(angle, isPlayer, projectileDamage, X, Y), getX(), getY());
    }

    protected void beam(int angle,int LV,double X,double Y,double charge, boolean isPlayer)
    {
        for (int i=0; i<=charge*(LV+2); i++)
        {
            space.addObject(new Beam(angle, isPlayer, beamDamage, X, Y), (int)Math.round(getX()+i*8*Math.cos(angle*2*Math.PI/360)), (int)Math.round(getY()+i*8*Math.sin(angle*2*Math.PI/360)));
        }
    }

    protected void missile(int angle,int LV,double X,double Y,boolean isPlayer)
    {
        space.addObject(new Missile(angle, isPlayer, missileDamage, X, Y), getX(), getY());
    }

    protected void mine(int angle,int LV,double X,double Y,boolean isPlayer)
    {
        space.addObject(new Mine(angle, isPlayer, X, Y, mineDamage, mineRange), getX(), getY());
    }

    protected void fireball(int angle,int LV,double X,double Y,boolean isPlayer)
    {
        space.addObject(new Fireball(angle, isPlayer, fireballDamage, X, Y), getX(), getY());
    }

    protected void plasmaBall(int angle,int LV,double X,double Y,boolean isPlayer)
    {
        spawnPlasmaBall(getRotation(),X,Y,isPlayer);
        if (LV>=1)
        {
            spawnPlasmaBall(getRotation()+10,X,Y, isPlayer);
            spawnPlasmaBall(getRotation()-10,X,Y,isPlayer);
        }
        if (LV>=2)
        {
            spawnPlasmaBall(getRotation()+20,X,Y,isPlayer);
            spawnPlasmaBall(getRotation()-20,X,Y,isPlayer);
        }
        if (LV>=3)
        {
            spawnPlasmaBall(getRotation()+30,X,Y,isPlayer);
            spawnPlasmaBall(getRotation()-30,X,Y,isPlayer);
        }
    }

    private void spawnPlasmaBall(int angle,double X,double Y,boolean isPlayer)
    {
        space.addObject(new PlasmaBall(angle, isPlayer, plasmaBallDamage, X, Y), getX(), getY());
    }

    private boolean rMButton = false;
    public boolean rMButton()
    {
        MouseInfo mi = Greenfoot.getMouseInfo();
        if (Greenfoot.mousePressed(null))
        {
            rMButton = true;
        }
        if (Greenfoot.mouseClicked(null)) 
        {
            rMButton = false;
        }
        return rMButton;
    }
}

interface DamageTaker{
    public boolean getHit(double damage); //Called when an object is hit by something
    //Return true if actually a hit
}