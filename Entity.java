import greenfoot.*;
import java.util.PriorityQueue;
/**
 * Subclass of other objects that will interact with the player directly.
 * 
 * Written by Nathan Philliber
 * 
 */
public class Entity extends SpaceObject implements DamageTaker
{
    //#####
    //TO DO: Make stack of actions for the ship to take
    
    private double aggression = 0.0;
    private double health = 100.0;
    private double maxHealth = 100.0;

    private double velX;
    private double velY;

    //Rate at which ship turns and accelerates
    private int turnSpeed = 3;
    private double flySpeed = 0.3;

    //The maximum velocity the ship can have
    private double maxFlySpeed = 3.0;

    //How fast the ship deccelerates 
    //Lower the number the longer it takes to stop
    private double flyDec = .01;

    //Where ship is to fly to
    private double targetX;
    private double targetY;

    private boolean reachedTarget;

    private DamageBar damageBar;

    private boolean firstTime = true;

    private PriorityQueue actionQueue = new PriorityQueue();
    //List of action codes:
    // moveTo
    // kill

    private double projectileDamage = 3.0;
    private double beamDamage = .2;
    private double missileDamage = 0.5;
    private double fireballDamage = 4.0;
    private double mineDamage = 15.0;
    private double plasmaBallDamage = 2.0;
    
    private int weaponDelay = 0;
    private int shootProgress = 0;
    private int cyclesBetweenShots = 0;
    private int currentWeapon = 0;

    private boolean queueInUse = false;

    private Space space;
    private Ship ship;
    public Entity(){
        super();
        setIsPlayer(false);//forWEAPONS
    }

    public Entity(double x, double y){
        super(x,y);
        setIsPlayer(false);//forWEAPONS
    }

    public void act() 
    {
        super.act();
        makeMoves();
        firstTime();
        damageBar.updateDamage(getHealth(), getMaxHealth());
        runQueue();
        checkDead();
        takeAShot();
        //System.out.println(actionQueue.size());
        //shoot(ship.getX(),ship.getY(), Weapon.MISSILE);
        
        
        if(isScheduledForRemoval()){
            addExplosion(getSpaceX(), getSpaceY());
        }
        checkRemoval();
    }    
    /***************************************************************************
     * *************************************************************************
     * TRIG IS NO HARD
     * TRIG IS NO HARD
     * TRIG IS NO HARD
     * *************************************************************************
     * *************************************************************************
     */
    public int getTargetAngle(double targetX,double targetY)
    {
        return (int)Math.round(Math.atan2((targetY-getSpaceY()),(targetX-getSpaceX()))*360/(2*Math.PI));
    }
    
    public void shootPlayer(int weapon, int cyclesBetweenShots, int numShots){
        
        shootProgress = numShots;
        this.cyclesBetweenShots = cyclesBetweenShots;
        currentWeapon = weapon;
        
        
        
    }
    
    private void takeAShot(){
        Space space = (Space) getWorld();
        Ship ship = space.getShip();
        
        weaponDelay++;
        if(shootProgress > 0){
            if(weaponDelay%cyclesBetweenShots == 0){
                shootProgress--;
                shoot(ship.getSpaceX()+460, ship.getSpaceY()+270, currentWeapon);
              
            }
        }
        else{
            queueInUse(false);
        }
        
    }
    
    
    
    
    public void shoot(double targetX, double targetY, int weapon){
        switch(weapon){
            case Weapon.PROJECTILE:
                projectile(getTargetAngle(targetX,targetY),0,getSpaceX(), getSpaceY());//in object WEAPON SYSTEMS
                break;
            case Weapon.BEAM:
                beam(getTargetAngle(targetX,targetY),1,getSpaceX(), getSpaceY());//in object WEAPON SYSTEMS
                break;
            case Weapon.MISSILE:
                missile(getTargetAngle(targetX,targetY),0,getSpaceX(), getSpaceY());//in object WEAPON SYSTEMS
                break;
            case Weapon.MINE:
                mine(getTargetAngle(targetX,targetY),1,getSpaceX(), getSpaceY());//in object WEAPON SYSTEMS
                break;
            case Weapon.FIREBALL:
                fireball(getTargetAngle(targetX,targetY),1,getSpaceX(), getSpaceY());//in object WEAPON SYSTEMS
                break;  
            case Weapon.PLASMABALL:
                plasmaBall(getTargetAngle(targetX,targetY),1,getSpaceX(), getSpaceY());//in object WEAPON SYSTEMS
                break;
        }
    }

    public void checkDead(){
        if(getHealth() <= 0.0){
            damageBar.scheduleRemoval();
            scheduleRemoval();
        }
    }

    //This is the way to make an entity run an action.
    //Add an action as a string "METHODNAME/arg1/arg2/..."
    //The action will be added to a queue and will then be run
    public void addAction(String action){
        actionQueue.add(action);

    }

    //Needs to be run every tick. Checks to see if a command is already being run.
    //If no command is being run, the method operates the next command if there is one.
    private void runQueue(){
        if(queueInUse == false){
            //pop off next command
            if(actionQueue.isEmpty() == false){
                queueInUse(true);
                translateCommand((String)actionQueue.poll());
                

            }

        }
    }

    //Translates string command to real method. Update this as new actions are added
    private void translateCommand(String cmdS){
        String[] arg = cmdS.split("/");

        //moveTo method
        //"moveTo/targetX/targetY"
        if(arg[0].equalsIgnoreCase("moveTo")){
            moveTo(Double.parseDouble(arg[1]),Double.parseDouble(arg[2]));
        }
        else if(arg[0].equalsIgnoreCase("shootPlayer")){
            //shoot player code, what weapon and for how long
            shootPlayer(Integer.parseInt(arg[1]),Integer.parseInt(arg[2]), Integer.parseInt(arg[3]));
        }
    }

    //Switch queue to be in use or not
    private void queueInUse(boolean state){
        queueInUse = state;
    }

    public boolean hasMoreActions(){
        if(actionQueue.size() == 0){
            return false;
        }
        return true;
    }
    //Called once during the first tick. Useful for certain objects that require
    //the entity to already be spawned.
    private void firstTime(){
        if(firstTime){
            space = (Space) getWorld();
            ship = space.getShip();
            damageBar = new DamageBar(this, -30, getHealth(), getMaxHealth());
            space.addObject(damageBar, 0, 0);
            
            
            
            
            firstTime = false;

        }
    }

    public boolean getHit(double damage){
        addHealth(-damage);
        //System.out.println(getHealth());
        return true;
    }

    //Move to and x,y over time.
    private void moveTo(double x, double y){

        setReachedTarget(false);
        setTargetX(x);
        setTargetY(y);
    }

    //Make progress towards desired location
    private void makeMoves(){

        if(reachedTarget()==false){
            Space space = (Space) getWorld();
            Ship ship = space.getShip();

            turnTowards((int)(getTargetX()-ship.getSpaceX()), (int)(getTargetY()-ship.getSpaceY()));

            int angle = getRotation();

            addSpaceX(Math.cos(Math.toRadians(angle))*maxFlySpeed);
            addSpaceY(Math.sin(Math.toRadians(angle))*maxFlySpeed);

            if(checkClose()){
                setReachedTarget(true);
                queueInUse(false);
            }
        }

    }
    public void setAggression(double agro){
        aggression = agro;
    }

    public double getAggression(){
        return aggression;
    }

    public void addAggression(double agro){
        setAggression(getAggression() + agro);
    }

    public void setHealth(double health){
        if(health > getMaxHealth()){
            this.health = getMaxHealth();
        }
        else if(health < 0.0){
            this.health = 0.0;
        }
        else{
            this.health = health;
        }
    }

    public double getHealth(){
        return health;
    }

    public void setMaxHealth(double maxHealth){
        if(maxHealth < 0.0){
            return;
        }
        this.maxHealth = maxHealth;
        if(getHealth() > getMaxHealth()){
            setHealth(getMaxHealth());
        }
    }

    public double getMaxHealth(){
        return maxHealth;
    }

    public void addHealth(double hp){
        setHealth(getHealth()+hp);
    }

    private double getTargetX(){
        return targetX;
    }

    private void setTargetX(double x){
        targetX = x;
    }

    private double getTargetY(){
        return targetY;
    }

    private void setTargetY(double y){
        targetY = y;
    }

    private void setReachedTarget(boolean state){
        reachedTarget = state;
    }

    private boolean reachedTarget(){
        return reachedTarget;
    }

    //Check if the ship is close to its' desired target
    private boolean checkClose(){
        if(Math.abs(getTargetX()-getSpaceX()) < 3.0 && Math.abs(getTargetY()-getSpaceY()) < 3.0){
            return true;
        }
        return false;
    }

    
}
