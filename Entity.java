import greenfoot.*;
import java.util.LinkedList;
import java.util.List;
/**
 * Subclass of other objects that will interact with the player directly.
 * 
 * Written by Nathan Philliber
 * 
 */
public class Entity extends SpaceObject implements DamageTaker
{

    /**********************************************************
     * 
     * CLASS VARIABLES
     * 
     *********************************************************/

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
    private boolean isShooting;

    private DamageBar damageBar;

    private boolean firstTime = true;

    private LinkedList actionQueue = new LinkedList();

    private int weaponDelay = 0;
    private int shootProgress = 0;
    private int cyclesBetweenShots = 0;
    private int currentWeapon = 0;

    private boolean queueInUse = false;
    //Minimap Vars
    private double mpRatio = 10;
    private double mpRatioX = 5.5*mpRatio;
    private double mpRatioY = 3.23*mpRatio;

    protected int spawnX;
    protected int spawnY;

    // End Minimap vars

    public static final int EXPLORE_MODE = 0;
    public static final int GUARD_MODE = 1;
    public static final int ATTACK_MODE = 2;
    public static final int WAITFORPLAYER_MODE = 3;

    protected int maxExploreLength = 1000;

    private int currentMode = -1;

    private int currentWait = 0;

    private boolean modeChanged = false;

    private int ticksToDie = 1000; //MAX TICK CYCLES BEFORE DEATH
    private int ticksAwayFromPlayer = ticksToDie;

    private int circleTargetX = 0;
    private int circleTargetY = 0;;
    private boolean currentlyCircling = false;
    private int circleCycle = 0;

    private boolean currentlyWaiting = false;

    private int circleTargetRadius = 250;
    
    protected int desiredMode = EXPLORE_MODE;
    
    /**********************************************************
     * 
     * CONSTRUCTORS
     * 
     *********************************************************/
     
    public Entity(){
        super();

        setIsPlayer(false);//forWEAPONS

        spawnX = getX();
        spawnY = getY();
        setTargetX(getX());
        setTargetY(getY());
    }

    public Entity(double x, double y){
        super(x,y);
        setIsPlayer(false);//forWEAPONS
        setTargetX(x);
        setTargetY(y);
        spawnX =(int) x;
        spawnY =(int) y;
        
        setMode(WAITFORPLAYER_MODE); //delete this
    }

    /**********************************************************
     * 
     * ACT METHOD
     * 
     *********************************************************/

    public void act() 
    {
        //Space SPACE = (Space) getWorld();
        if(space == null){
            space = (Space) getWorld();
            ship = space.getShip();
        }
        else if(!space.getIsPaused())
        {
            super.act();

            firstTime();

            damageBar.updateDamage(getHealth(), getMaxHealth());

            runQueue();

            checkDead();

            modeActions();
            decayIfFar();

            miniMap(new EnemyShip());

            

            if(isScheduledForRemoval()){
                addExplosion(getSpaceX(), getSpaceY());
            }
            checkRemoval();
        }
    }

    /**********************************************************
     * 
     * MODE / AI OPERATIONS
     * 
     *********************************************************/

    public void modeActions(){

        if(modeChanged){
            clearActions();
            modeChanged = false;

        }
        
        if(getMode() == EXPLORE_MODE && ship.getHealth() - getHealth() >= 5){
            setMode(ATTACK_MODE);
        }

        switch(getMode()){
            case EXPLORE_MODE: /***************** EXPLORE MODE */

            if(hasMoreActions() == false){
                addAction("wait/" + Greenfoot.getRandomNumber(200));
                addAction("MoveTo/" + (Greenfoot.getRandomNumber(maxExploreLength)-(maxExploreLength/2)+spawnX) + "/" + (Greenfoot.getRandomNumber(maxExploreLength)-(maxExploreLength/2)+spawnY));    
            }

            break;
            
            case GUARD_MODE: /***************** GUARD MODE */
            if(hasMoreActions() == false){
                addAction("circleTarget/"+ spawnX + "/" + spawnY +"/300");
                
            }
            break;
            
            case ATTACK_MODE: /***************** ATTACK MODE */
            if(hasMoreActions() == false){
                addAction("shootPlayer/0/10/7");
                addAction("circleTarget/"+ (int)ship.getShipLocX() + "/" + (int)ship.getShipLocY() +"/" + Greenfoot.getRandomNumber(300)+"/80");
                
                
                
            }
            break;
            
            case WAITFORPLAYER_MODE:
            if(hasMoreActions() == false){
                addAction("wait/300");
                resetTicks();
                if(isOffscreen() == false){
                    setMode(desiredMode);
                }
                
            }
            break;
            
            default: /***************** DEFAULT */
            System.out.println("NO MODE SPECIFIED");
            break;

        }
    }

    public void setMode(int mode){
        currentMode = mode;
        modeChanged = true;
    }

    public int getMode(){
        return currentMode;
    }

    /**********************************************************
     * 
     * QUEUE MANAGEMENT
     * 
     *********************************************************/

    public void clearActions(){
        actionQueue.clear();
    }

    public void addAction(String action){
        actionQueue.add(action);
    }

    //Needs to be run every tick. Checks to see if a command is already being run.
    //If no command is being run, the method operates the next command if there is one.
    private void runQueue(){

        //Run all helper functions
        makeMoves();
        takeAShot();
        waitHelper();
        circleTargetHelper(circleTargetX, circleTargetY);

        if(queueInUse == false){
            //pop off next command
            if(actionQueue.isEmpty() == false && queueInUse == false){

                //System.out.println("QueueUse: " + queueInUse + ", Empty: " + actionQueue.isEmpty());
                queueInUse(true);
                translateCommand((String)actionQueue.poll());
                //System.out.println("QueueUse: " + queueInUse + ", Empty: " + actionQueue.isEmpty());

            }
        }
    }

    //Translates string command to real method. Update this as new actions are added
    private void translateCommand(String cmdS){

        String[] arg = cmdS.split("/");

        if(arg[0].equalsIgnoreCase("moveTo")){
            moveTo(Double.parseDouble(arg[1]),Double.parseDouble(arg[2]));
        }
        else if(arg[0].equalsIgnoreCase("shootPlayer")){

            shootPlayer(Integer.parseInt(arg[1]),Integer.parseInt(arg[2]), Integer.parseInt(arg[3]));
        }
        else if(arg[0].equalsIgnoreCase("wait")){

            wait(Integer.parseInt(arg[1]));
        }
        else if(arg[0].equalsIgnoreCase("circleTarget")){

            circleTarget(Integer.parseInt(arg[1]),Integer.parseInt(arg[2]),Integer.parseInt(arg[3]));
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

    /**********************************************************
     * 
     * COMMANDS TO BE ADDED TO QUEUE
     * 
     *********************************************************/

    public void circleTarget(int x, int y, int numOfCycles, int radius){
        currentlyCircling = true;
        circleTargetX = x;
        circleTargetY = y;
        circleCycle = numOfCycles;
        circleTargetRadius = radius;
    }
    
    public void circleTarget(int x, int y, int numOfCycles){
        circleTarget(x,y,numOfCycles,250);
    }

    public void circleTargetHelper(int x, int y)
    {
        if(currentlyCircling){

            circleCycle--;

            if(circleCycle <= 0){
                currentlyCircling = false;
                queueInUse(false);
            }

            spaceMove(maxFlySpeed);
            int angleDif = angleRange(getRotation())-getTargetAngle(x,y);

            if (180 < angleDif){
                angleDif -= 360;
            }
            else if (-180 > angleDif){
                angleDif += 360;
            }

            if (checkRange(circleTargetRadius)){
                setRotation(getRotation()+angleDif/80);
            }
            else{
                setRotation(getRotation()-angleDif/80);
            } 
        }

    }

    public int getTargetAngle(double targetX,double targetY)
    {
        return (int)Math.round(Math.atan2((targetY-getSpaceY()),(targetX-getSpaceX()))*360/(2*Math.PI));
    }

    public void wait(int actCycles){
        currentWait = actCycles;
        currentlyWaiting = true;
    }

    private void waitHelper(){
        if(currentlyWaiting){
            if(currentWait <= 0){
                queueInUse(false);
                currentlyWaiting = false;
            }
            else{
                currentWait--;
            }
        }

    }

    public void shootPlayer(int weapon, int cyclesBetweenShots, int numShots){

        shootProgress = numShots;
        this.cyclesBetweenShots = cyclesBetweenShots;
        currentWeapon = weapon;
        isShooting = true;
    }

    private void takeAShot(){

        if(shootProgress > 0 && isShooting){
            weaponDelay++;

            if(weaponDelay%cyclesBetweenShots == 0){
                shootProgress--;
                shoot(ship.getShipLocX(), ship.getShipLocY(), currentWeapon);
            }
        }
        else if(shootProgress == 0){
            queueInUse(false);
            weaponDelay = 0;
            shootProgress = -1;
            isShooting = false;
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

    private void moveTo(double x, double y){
        setReachedTarget(false);
        setTargetX(x);
        setTargetY(y);
    }

    //Make progress towards desired location
    private void makeMoves(){
        if(reachedTarget()==false){

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

    /**********************************************************
     * 
     * MINIMAP
     * 
     *********************************************************/

    private boolean checkRange(double r)
    {
        return r >= (Math.sqrt(Math.pow(ship.getShipLocX()-getSpaceX(),2)+Math.pow(ship.getShipLocY()-getSpaceY(),2)));
    }

    

    /**********************************************************
     * 
     * HEALTH RELATED
     * 
     *********************************************************/

    public boolean getHit(double damage){
        addHealth(-damage);
        //System.out.println(getHealth());
        return true;
    }

    public void checkDead(){
        if(getHealth() <= 0.0){
            damageBar.scheduleRemoval();
            scheduleRemoval();
        }
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

    /**********************************************************
     * 
     * MISC
     * 
     *********************************************************/
    private void decayIfFar(){
        if(isOffscreen()){
            ticksAwayFromPlayer--;
            if(ticksAwayFromPlayer < 0){
                setHealth(0.0);
            }
        }
        else{
            resetTicks();
        }

    }
    
    private void resetTicks(){
        ticksAwayFromPlayer = ticksToDie;
    }

    private void firstTime(){
        if(firstTime){
            this.space = (Space) getWorld();
            this.ship = space.getShip();
            damageBar = new DamageBar(this, -50, getHealth(), getMaxHealth());
            space.addObject(damageBar, 0, 0);
            //setupMinimap();

            firstTime = false;
        }
    }

    //Move to and x,y over time.
    public void setAggression(double agro){
        aggression = agro;
    }

    public double getAggression(){
        return aggression;
    }

    public void addAggression(double agro){
        setAggression(getAggression() + agro);
    }

}
