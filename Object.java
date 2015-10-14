import greenfoot.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Object here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Object extends SmoothMover
{
    
    private boolean deleteMe = false;

    
    public void act() 
    {
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
            return (int)Math.round(Math.atan2((m.getY()-getWorld().getHeight()/2),(m.getX()-getWorld().getWidth()/2))*360/(2*Math.PI));
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
        else if (getX() >= getWorld().getWidth()+dist)
        {
            return true;
        }
        else if (getY() <= -dist)
        {
            return true;
        }
        else if (getY() >= getWorld().getHeight()+dist)
        {
            return true;
        }
        else
        {
            return false;
        }
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
        else if (getX() >= getWorld().getWidth()-1)
        {
            return true;
        }
        else if (getY() <= 0)
        {
            return true;
        }
        else if (getY() >= getWorld().getHeight()-1)
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
        World world = getWorld();
        for (int i = 0; i<13; i++)
        {
            world.addObject(new Particle(x, y, 8, 6, 10, 6, 20, 0,"images/exPart1.png"), 0, 0);
            world.addObject(new Particle(x, y, 20, 6, 17, 6, 20, 0,"images/exPart2.png"), 0, 0);
            world.addObject(new Particle(x, y, 10, 6, 7, 6, 10, 95, "images/spark1.png"), 0, 0);
            world.addObject(new Particle(x, y, 10, 6, 7, 6, 10, 95, "images/smoke1.png"), 0, 0);
        }
    }
    
    public void addRocketTrail(double x, double y){
        World world = getWorld();
        
        world.addObject(new Particle(x, y, 10, 6, 7, 6, 10, 95, "images/spark1.png"), 0, 0);
        world.addObject(new Particle(x, y, 10, 6, 7, 6, 10, 95, "images/smoke1.png"), 0, 0);
        //double startX, double startY, int straightness, double radius, int lifetime, double particleSpeed, int lifetimeRandom,int angle, String image)
    }
    
    public void addFire(double x, double y){
        World world = getWorld();
        world.addObject(new Particle(x, y, 10, 6, 5, 3, 15, 50,"images/firesparks.png"), 0, 0);
    }
    
    public void addMineTicker(double x, double y){
        World world = getWorld();
        world.addObject(new Particle(x, y, 10, 6, 5, 3, 15, 95,"images/spark1.png"), 0, 0);
    }
    
    public void scheduleRemoval(){
        deleteMe = true;
    }
    public void checkRemoval(){
        if(deleteMe){
            getWorld().removeObject(this);
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
        
        List<Actor> actors = getWorld().getObjects(null);
        
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
        World world = getWorld();
        
        Space.setPause = true;
        
        world.addObject(new MenuBG(), world.getWidth()/2, world.getHeight()/2);
        world.addObject(new MenuMain(), world.getWidth()/2, world.getHeight()/2);
        world.addObject(new MenuYes(), world.getWidth()/2 - 100, world.getHeight()/2);
        world.addObject(new MenuNo(), world.getWidth()/2+100, world.getHeight()/2);

    }
    public void removeDockMenu()
    {
            List<DockMenu> dockMenu = getWorld().getObjects(DockMenu.class);
            getWorld().removeObjects(dockMenu);
            Space.setPause = false;
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
    
    
    //damages
    private double projectileDamage = 3.0;
    private double beamDamage = .5;
    private double missileDamage = 10.0;
    private double fireballDamage = 4.0;
    private double mineDamage = 25.0;
    private double plasmaBallDamage = 2.0;
    
    private int mineRange = 250;
    
    private boolean isPlayer;
    protected void setIsPlayer(boolean P)
    {
        isPlayer = P;
    }
    protected boolean getIsPlayer()
    {
        return isPlayer;
    }
    
    protected void projectile(int angle,int LV,double X,double Y)
    {
        spawnProjectile(angle,X,Y);
        if (LV>=1)
        {
            spawnProjectile(angle+10,X,Y);
            spawnProjectile(angle-10,X,Y);
        }
        if (LV>=2)
        {
            spawnProjectile(angle+20,X,Y);
            spawnProjectile(angle-20,X,Y);
        }
        if (LV>=3)
        {
            spawnProjectile(angle+30,X,Y);
            spawnProjectile(angle-30,X,Y);
        }
    }
    private void spawnProjectile(int angle,double X,double Y)
    {
        getWorld().addObject(new Projectile(angle, getIsPlayer(), projectileDamage, X, Y), getX(), getY());
    }
    
    
    protected void beam(int angle,int LV,double X,double Y)
    {
        for (int i=0; i<=10*(LV+1); i++)
            {
                getWorld().addObject(new Beam(angle, getIsPlayer(), beamDamage, X, Y), (int)Math.round(getX()+i*8*Math.cos(angle*2*Math.PI/360)), (int)Math.round(getY()+i*8*Math.sin(angle*2*Math.PI/360)));
            }
    }
    
    
    protected void missile(int angle,int LV,double X,double Y)
    {
            getWorld().addObject(new Missile(angle, getIsPlayer(), missileDamage, X, Y), getX(), getY());
    }
    
    
    protected void mine(int angle,int LV,double X,double Y)
    {
        getWorld().addObject(new Mine(angle, true, X, Y, mineDamage, mineRange), getX(), getY());
    }
    
    
    protected void fireball(int angle,int LV,double X,double Y)
    {
            getWorld().addObject(new Fireball(angle, true, fireballDamage, X, Y), getX(), getY());
    }
    
    
    protected void plasmaBall(int angle,int LV,double X,double Y)
    {
        spawnPlasmaBall(getRotation(),X,Y);
        if (LV>=1)
        {
            spawnPlasmaBall(getRotation()+10,X,Y);
            spawnPlasmaBall(getRotation()-10,X,Y);
        }
        if (LV>=2)
        {
            spawnPlasmaBall(getRotation()+20,X,Y);
            spawnPlasmaBall(getRotation()-20,X,Y);
        }
        if (LV>=3)
        {
            spawnPlasmaBall(getRotation()+30,X,Y);
            spawnPlasmaBall(getRotation()-30,X,Y);
        }
    }
    private void spawnPlasmaBall(int angle,double X,double Y)
    {
        getWorld().addObject(new PlasmaBall(angle, true, plasmaBallDamage, X, Y), getX(), getY());
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
