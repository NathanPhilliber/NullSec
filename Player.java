import greenfoot.*;
import java.lang.Math;
/**
 * The player class is responsible for ship control and movement behavior.
 * Spawns stars and takes player input as well.
 * 
 * Written by Nathan Philliber
 */
public class Player extends Object
{
    
    //Coords to keep track of ship
    private double spaceX;
    private double spaceY;
    
    //Velocity of ship
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
    
    //How dense the stars should spawn. Higher number means more stars.
    //Number is arbitrary
    private int starDensity = 2;
    
    //Health values of player
    private double health = 100.0;
    private double maxHealth = 100.0;
    
    //Damage bar for player
    private DamageBar damageBar;
    
    //Used for in class operations
    private boolean firstTime = true;
    
    //Constructor, spawns player at 0,0
    public Player(){
        this(0,0);
    }
    
    //Constructor, spawns player at x,y coord
    public Player(double x, double y){
        
        Space space = (Space) getWorld();
        
        setSpaceX(x);
        setSpaceY(y);
        
        setVelX(0.0);
        setVelY(0.0);
        
        
    }
    
    //Called every tick
    //Allows ship to "move" (changes coords), displays debug info and spawns stars
    //Updates health
    public void act() 
    {
       firstTime();
       fly();
       showDebug(true);
       generateStars(starDensity);
       damageBar.updateDamage(getHealth(), getMaxHealth());
    } 
    
    //Checks for key presses and changes coords ("moves" ship)
    public void fly(){
       
        //If spacebar or w is pressed
        if(Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("w")){
            int angle = getRotation();
            
            //Add to velocity based on what angle the ship is turned to
            setVelX((Math.cos(Math.toRadians(angle))*getFlySpeed()) + getVelX());
            setVelY((Math.sin(Math.toRadians(angle))*getFlySpeed()) + getVelY());
            
            //Check if ship is going too fast
            if(Math.abs(getVelX()) >= getMaxFlySpeed()){
                setVelX(getMaxFlySpeed()*Integer.signum((int)getVelX()));
            }
            if(Math.abs(getVelY()) >= getMaxFlySpeed()){
                setVelY(getMaxFlySpeed()*Integer.signum((int)getVelY()));
            }
        }
        
        //Fixes problem of velocity glitching out when close to 0
        if(Math.abs(getVelX()) <= .1){
            setVelX(0.0);
        }
        if(Math.abs(getVelY()) <= .1){
            setVelY(0.0);
        }
        
        //Decelerate the ship
        setVelX(getVelX() + (Math.signum(getVelX())*-1)*getFlyDec());
        setVelY(getVelY() + (Math.signum(getVelY())*-1)*getFlyDec());
        
        //If 'a' is pressed turn left
        if(Greenfoot.isKeyDown("a")){
            turn(-turnSpeed);
            
        }
        
        //If 'd' is pressed turn right
        if(Greenfoot.isKeyDown("d")){
            turn(turnSpeed);
        }
        
        //Add velocity to coordinates, thereby "moving" the ship
        addSpaceX(getVelX());
        addSpaceY(getVelY());
    }
    
    //Generates stars offscreen
    public void generateStars(int density){
        World world = getWorld();
        
        //Doesn't spawn stars every call, higher density will increase odds
        if((Greenfoot.getRandomNumber(100))/density < 10){
            
            //Divide star spawns between up/down and right/left
            if(getPosNeg()==1){
                
                //If the ship is going fast enough left/right, spawn a star on one of those sides
                if(Math.abs(getVelX()) > 1.0){
                    world.addObject(new BackgroundStar((getSpaceX() + world.getWidth()/2)+(world.getWidth()/2*getPosNeg()),
                    (getSpaceY() + world.getHeight()/2)+Greenfoot.getRandomNumber(world.getHeight())-world.getHeight()/2),0,0);
                }
            
            }   
            else{
                //If the ship is going fast enough up/down, spawn a star on one of those sides
                if(Math.abs(getVelY()) > 1.0){
                    world.addObject(new BackgroundStar((getSpaceX() + world.getWidth()/2)+Greenfoot.getRandomNumber(world.getWidth())-world.getWidth()/2,
                    (getSpaceY() + world.getHeight()/2)+(world.getHeight()/2*getPosNeg())),0,0);
                }
                
            }
        }
        
    }
    
    
    //Called during the first tick only
    //Some methods require the ship to alrady be spawned to work
    public void firstTime(){
        if(firstTime){
            Space space = (Space) getWorld();
            damageBar = new DamageBar(this, -30, getHealth(), getMaxHealth());
            space.addObject(damageBar, 0, 0);
            firstTime = false;
        }
    }
    
    //Private method used for star spawning, returns either 1.0 or -1.0
    private double getPosNeg(){
        if(Greenfoot.getRandomNumber(2) ==0){
            return 1.0;
        }
        return -1.0;
    }
    
    //Check to see if the ship is moving in any direction
    public boolean isMoving(){
        if(getVelX() != 0 || getVelY() != 0){
            return true;
        }
        return false;
    }
    
    
    public double getSpaceX(){
        return spaceX;
    }
    
    public double getSpaceY(){
        return spaceY;
    }
    
    public void setSpaceX(double x){
        spaceX = x;
    }
    
    public void setSpaceY(double y){
        spaceY = y;
    }
    
    public void addSpaceX(double x){
        setSpaceX(getSpaceX()+x);
    }
    
    public void addSpaceY(double y){
        setSpaceY(getSpaceY()+y);
    }
    
    public void setVelX(double x){
        velX = x;
    }
    
    public void setVelY(double y){
        velY = y;
    }
    
    public double getVelX(){
        return velX;
    }
    
    public double getVelY(){
        return velY;
    }
    
    public int getTurnSpeed(){
        return turnSpeed;
    }
    
    public void setTurnSpeed(int speed){
        turnSpeed = speed;
    }
    
    public double getFlySpeed(){
        return flySpeed;
    }
    
    public void setFlySpeed(int speed){
        flySpeed = speed;
    }
    
    public double getMaxFlySpeed(){
        return maxFlySpeed;
    }
    
    public void setMaxFlySpeed(int speed){
        maxFlySpeed = speed;
    }
    
    public void setFlyDec(double dec){
        flyDec = dec;
    }
    
    public double getFlyDec(){
        return flyDec;
    }
    
    public double getShipLocX(){
        return getSpaceX()+getWorld().getWidth()/2;
    }
    
    public double getShipLocY(){
        return getSpaceY()+getWorld().getHeight()/2;
    }
    
    public double getHealth(){
        return health;
    }
    
    public double getMaxHealth(){
        return maxHealth;
    }
    
    //Set the health, makes sure you're not setting health over the maximum or under 0
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
    
    //Set maximum health, makes sure you're not setting it under current health
    public void setMaxHealth(double health){
        if(getHealth() > health){
            setHealth(health);
        }
        else{
            maxHealth = health;
        }
        
    }
    
    public void addHealth(double add){
        setHealth(getHealth()+add);
        
    }
    
    public DamageBar getDamageBar(){
        return damageBar;
    }
    
    
    
    //Display debug info such as x,y coords, velocities, star count, health
    public void showDebug(boolean show){
        if(show){
            getWorld().showText("X: "+String.format("%.02f", (getSpaceX())), 60, 25);
            getWorld().showText("Y: "+String.format("%.02f", (getSpaceY())), 60, 50); 
            
            getWorld().showText("vX: "+String.format("%.02f", (getVelX())), 60, 75);
            getWorld().showText("vY: "+String.format("%.02f", (getVelY())), 60, 100);        
            
            getWorld().showText("Stars: "+ BackgroundStar.getNumStars(), 60, 125); 
            
            getWorld().showText("Health: "+ getHealth(), 60, 150); 
        }
    }
}
