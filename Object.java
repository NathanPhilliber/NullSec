import greenfoot.*;
import java.util.List;
import java.util.ArrayList;

public class Object extends SmoothMover
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

    //Written by Nathan
    public void act() 
    {
        if(space == null){
            space = (Space) getWorld();
            ship = space.getShip();
        }
    } 

    //Written by John
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

    //Written by John
    public int getMouseAngle()//from center of world
    {
        MouseInfo m = Greenfoot.getMouseInfo();
        Space space=(Space)getWorld();
        if(m != null)
        {
            return (int)Math.round(Math.atan2((m.getY()-space.getHeight()/2),(m.getX()-space.getWidth()/2))*360/(2*Math.PI));
        }
        return 0;
    }

    //Written by John
    public void setRemovalOffEdge(int dist) 
    {
        if (isOffEdge(dist))
        {
            scheduleRemoval();
        }
    }

    //Written by John
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

    //Written by John
    public boolean isOffscreen(){
        if((getX() < 0 || getX() > space.getWidth()) || (getY() < 0 || getY() > space.getHeight())){
            return true;
        }
        return false;
    }

    //Written by John
    public void setRemovalAtEdge() 
    {
        if (isAtEdge())
        {
            scheduleRemoval();
        }
    }

    //Written by Nathan
    public void addExplosion(double x, double y, boolean playSound){

        for (int i = 0; i<13; i++)
        {
            space.addObject(new Particle(x, y, 8, 6, 10, 6, 20, 0,"images/exPart1.png"), 0, 0);
            space.addObject(new Particle(x, y, 20, 6, 17, 6, 20, 0,"images/exPart2.png"), 0, 0);
            space.addObject(new Particle(x, y, 10, 6, 7, 6, 10, 95, "images/spark1.png"), 0, 0);
            space.addObject(new Particle(x, y, 10, 6, 7, 6, 10, 95, "images/smoke1.png"), 0, 0);
        }
        if(playSound){
            GreenfootSound explodeSound = new GreenfootSound("sounds/explode1.mp3");
            explodeSound.play();
        }

    }

    //Written by Manny
    public void addRocketTrail(double x, double y){

        space.addObject(new Particle(x, y, 10, 6, 7, 6, 10, 95, "images/spark1.png"), 0, 0);
        space.addObject(new Particle(x, y, 10, 6, 7, 6, 10, 95, "images/smoke1.png"), 0, 0);
        //double startX, double startY, int straightness, double radius, int lifetime, double particleSpeed, int lifetimeRandom,int angle, String image)
    }

    //Written by Manny
    public void addFire(double x, double y){

        space.addObject(new Particle(x, y, 10, 6, 5, 3, 15, 50,"images/firesparks.png"), 0, 0);
    }

    //Written by Nathan
    public void addMineTicker(double x, double y){

        space.addObject(new Particle(x, y, 10, 6, 5, 3, 15, 95,"images/spark1.png"), 0, 0);
    }

    //Written by Nathan
    public void addCoinPickup(double x, double y){
        for(int i = 0; i < 30; i++){
            space.addObject(new Particle(x, y, 15, 6, 5, 5, 10, 0,"images/coinEffect.png"), 0, 0);
        }
    }

    //Written by Nathan
    public void addPlanetDock(double x, double y){
        for(int i = 0; i < 30; i++){
            space.addObject(new Particle(x, y, 6, 6, 10, 2, 20, 0,"images/smoke2.png"), 0, 0);
        }
    }

    //Written by Nathan
    public void addMissileTrail(double x, double y){
        Particle par = new Particle(x, y, 6, 6, 5, 2, 5, 0,"images/smoke2.png");
        par.getImage().setTransparency(100);
        space.addObject(par, 0, 0);

    }

    //Written by Nathan
    public void addExclamation(double x, double y, int imageWidth){
        space.addObject(new Particle(x,y-imageWidth,15, 0, 5, 10, 10,0,"images/Exclamation.png"),-10,-10);
        space.addObject(new Particle(x-imageWidth,y-imageWidth,15, 0, 5, 10, 10,0,"images/Exclamation.png"),-10,-10);
        space.addObject(new Particle(x+imageWidth,y-imageWidth,15, 0, 5, 10, 10,0,"images/Exclamation.png"),-10,-10);
        space.addObject(new Particle(x,y+imageWidth,15, 0, 20, 5, 10,0,"images/Exclamation.png"),-10,-10);
    }

    //Written by Nathan
    public void addShootingStar(double x, double y){
        for(int i = 0; i < 2; i++)
            space.addObject(new Particle(x, y, 15, 6, 10, 1, 1, 0,"images/coinEffect.png"), 0, 0);
        Particle par = new Particle(x, y, 6, 6, 5, 2, 5, 0,"images/smoke2.png");
        par.getImage().setTransparency(100);
        space.addObject(par, 0, 0);

    }

    //Written by Nathan
    public void addBoost(double x, double y){
        //for(int i = 0; i < 2; i++)
        //space.addObject(new Particle(x+Greenfoot.getRandomNumber(14)-7, y+Greenfoot.getRandomNumber(14)-7, 15, 6, 10, 1, 1, 0,"images/coinEffect.png"), 0, 0);
        Particle par = new Particle(x+Greenfoot.getRandomNumber(14)-7, y+Greenfoot.getRandomNumber(14)-7, 6, 6, 5, 2, 5, 0,"images/smoke2.png");
        par.getImage().setTransparency(100);
        space.addObject(par, 0, 0);
    }

    //Written by Nathan
    public void scheduleRemoval(){
        deleteMe = true;
    }

    //Written by Nathan
    public boolean checkRemoval(){
        if(deleteMe){
            space.removeObject(this);
            return true;
        }
        return false;
    }

    //Written by Nathan
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

    //Written by Trace
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

    //Written by Trace
    public void dockMenu()
    {

        space.setPause = true;
        MenuBG menubg = new MenuBG();
        space.addObject(menubg, space.getWidth()/2, space.getHeight()/2);
        menubg.getImage().scale(OptionsMenu.getWorldWidth(), OptionsMenu.getWorldHeight());
        space.addObject(new MenuMain(), space.getWidth()/2, space.getHeight()/2);
        space.addObject(new MenuYes(), space.getWidth()/2 - 100, space.getHeight()/2);
        space.addObject(new MenuNo(), space.getWidth()/2+100, space.getHeight()/2);

    }

    //Written by Trace
    public void removeDockMenu()
    {
        space = (Space) getWorld(); 
        space.setPause = false;
        List<DockMenu> dockMenu = space.getObjects(DockMenu.class);
        space.removeObjects(dockMenu);

    }

    //Written by John
    protected void projectile(int angle,int LV,double X,double Y, boolean isPlayer)
    {
        spawnProjectile(angle,X,Y, isPlayer);

        if (LV>=2)
        {
            spawnProjectile(angle+10,X,Y,isPlayer);

        }
        if (LV>=3)
        {
            spawnProjectile(angle-10,X,Y,isPlayer);
        }
        if (LV>=4)
        {
            spawnProjectile(angle+20,X,Y,isPlayer);
        }
        if (LV>=5)
        {
            spawnProjectile(angle-20,X,Y,isPlayer);
        }

    }

    //Written by John
    private void spawnProjectile(int angle,double X,double Y, boolean isPlayer)
    {
        space.addObject(new Projectile(angle, isPlayer, projectileDamage, X, Y), getX(), getY());
    }

    //Written by John
    protected void beam(int angle,int LV,double X,double Y,double charge, boolean isPlayer)
    {
        for (int i=0; i<=charge*(LV+2); i++)
        {
            space.addObject(new Beam(angle, isPlayer, beamDamage, X, Y), (int)Math.round(getX()+i*8*cos(angle)), (int)Math.round(getY()+i*8*sin(angle)));
        }
    }

    //Written by John
    protected void missile(int angle,int LV,double X,double Y,boolean isPlayer)
    {
        space.addObject(new Missile(angle, isPlayer, missileDamage, X, Y), getX(), getY());
    }

    //Written by John
    protected void mine(int angle,int LV,double X,double Y,boolean isPlayer)
    {
        space.addObject(new Mine(angle, isPlayer, X, Y, mineDamage, mineRange), getX(), getY());
    }

    //Written by John
    protected void fireball(int angle,int LV,double X,double Y,boolean isPlayer)
    {
        space.addObject(new Fireball(angle, isPlayer, fireballDamage, X, Y), getX(), getY());
    }

    //Written by John
    protected void plasmaBall(int angle,int LV,double X,double Y,boolean isPlayer)
    {
        if(isOffEdge(100) == false){
            GreenfootSound shootSound = new GreenfootSound("plasma.wav");
            shootSound.setVolume(80);
            shootSound.play();
        }
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

    //Written by John
    private void spawnPlasmaBall(int angle,double X,double Y,boolean isPlayer)
    {
        space.addObject(new PlasmaBall(angle, isPlayer, plasmaBallDamage, X, Y), getX(), getY());
    }

    //Written by John
    private boolean rMButton = false;
    public boolean rMButton()
    {

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

//Written by Nathan
interface DamageTaker{
    public boolean getHit(double damage); //Called when an object is hit by something
    //Return true if actually a hit
}
