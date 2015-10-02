import greenfoot.*;
import java.util.PriorityQueue;
/**
 * Subclass of other objects that will interact with the player directly.
 * 
 * Written by Nathan Philliber
 * 
 */
public class Entity extends SpaceObject
{
    //#####
    //TO DO: Make stack of actions for the ship to take
    
    private double aggression = 0.0;
    private double health = 0.0;
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
    
    private double targetX;
    private double targetY;
    
    private boolean reachedTarget;
    
    private DamageBar damageBar;
    
    private boolean firstTime = true;
    
    private PriorityQueue actionQueue = new PriorityQueue();
    //List of action codes:
    // moveTo
    // kill
    
    private boolean queueInUse = false;
    public Entity(){
        super();
    }
    
    public Entity(double x, double y){
        super(x,y);
    }
    
    
    public void act() 
    {
        super.act();
        makeMoves();
        firstTime();
        runQueue();
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
                
                translateCommand((String)actionQueue.poll());
                queueInUse(true);
                
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
    }
    
    //Switch queue to be in use or not
    private void queueInUse(boolean state){
        queueInUse = state;
    }
    
    //Called once during the first tick. Useful for certain objects that require
    //the entity to already be spawned.
    private void firstTime(){
        if(firstTime){
            Space space = (Space) getWorld();
            damageBar = new DamageBar(this, -30, getHealth(), getMaxHealth());
            space.addObject(damageBar, 0, 0);
            firstTime = false;
            
            
        }
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
    
    public double getTargetX(){
        return targetX;
    }
    
    public void setTargetX(double x){
        targetX = x;
    }
    
    public double getTargetY(){
        return targetY;
    }
    
    public void setTargetY(double y){
        targetY = y;
    }
    
    public void setReachedTarget(boolean state){
        reachedTarget = state;
    }
    
    public boolean reachedTarget(){
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
