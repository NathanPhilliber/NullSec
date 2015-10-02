import greenfoot.*;

/**
 * Write a description of class Entity here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    }    
    
    public void moveTo(double x, double y){
        setReachedTarget(false);
        setTargetX(x);
        setTargetY(y);
    }
    
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
    
    private boolean checkClose(){
        System.out.println((getTargetX()-getSpaceX())+ " " + (getTargetY()-getSpaceY()));
        if(Math.abs(getTargetX()-getSpaceX()) < 3.0 && Math.abs(getTargetY()-getSpaceY()) < 3.0){
            return true;
        }
        return false;
    }
}
