import greenfoot.*;
import java.util.PriorityQueue;
import java.util.List;
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

    private int weaponDelay = 0;
    private int shootProgress = 0;
    private int cyclesBetweenShots = 0;
    private int currentWeapon = 0;

    private boolean queueInUse = false;
    //Minimap Vars
    private double mpRatio = 10;
    private double mpRatioX = 5.5*mpRatio;
    private double mpRatioY = 3.23*mpRatio;

    private int spawnX;
    private int spawnY;

    // End Minimap vars
    private Space space;
    private Ship ship;

    //player location
    private double playerX;
    private double playerY;

    public Entity(){
        super();
        space = (Space) getWorld();
        ship = space.getShip();
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
        
    }

    public void act() 
    {
        Space SPACE = (Space) getWorld();
        if(!SPACE.getIsPaused())
        {
            super.act();

            firstTime();
            damageBar.updateDamage(getHealth(), getMaxHealth());
            runQueue();

            makeMoves();
            checkDead();
            takeAShot();

            /*****************************************************************************************************
             * ***************************************************************************************************
             * ***************************************************************************************************
             * ***************************************************************************************************
             * GOOD MINIMAP
             * ***************************************************************************************************
             * ***************************************************************************************************
             * ***************************************************************************************************
             * ***************************************************************************************************/
            miniMap(new EnemyShip());

            updateMinimap();
            //System.out.println(actionQueue.size());

            //prob in wrong spot >>>>>>>>>>>>>FIX<<<<<<<<<<<<<
            //circleTarget();//prob in wrong spot

            //System.out.println("Queue in use: " + queueInUse);

            //updatePlayerLocation();

            if(isScheduledForRemoval()){
                addExplosion(getSpaceX(), getSpaceY());
            }
            checkRemoval();
        }
    }

    private void updatePlayerLocation() //What the shit is this? use getShipLoc
    {
        playerX = ship.getSpaceX()+getWorld().getWidth()/2;
        playerY = ship.getSpaceY()+getWorld().getHeight()/2;;
    }

    public void circleTarget()
    {
        spaceMove(4);
        int angleDif = angleRange(getRotation())-getTargetAngle(playerX,playerY);
        if (180 < angleDif)
        {
            angleDif -= 360;
        }
        else if (-180 > angleDif)
        {
            angleDif += 360;
        }
        if (checkRange(250))
        {
            //if (5 <= angleDif)
            //{
            setRotation(getRotation()+angleDif/80);
            /*}
            else if (-5 >= angleDif)
            {
            setRotation(getRotation()-angleDif/80);
            }*/
        }
        else
        {
            //if (5 <= angleDif)
            //{
            setRotation(getRotation()-angleDif/80);
            /*}
            else if (-5 >= angleDif)
            {
            setRotation(getRotation()+angleDif/80);
            }*/
        } 
    }

    private boolean checkRange(double r)
    {
        return r >= (Math.sqrt(Math.pow(playerX-getSpaceX(),2)+Math.pow(playerY-getSpaceY(),2)));
    }

    public void setupMinimap()
    {

        double minimapX = (getX()/mpRatioX) + 800-(167/mpRatio)/2 + spawnX/mpRatioX;
        double minimapY = (getY()/mpRatioY) + 405-(167/mpRatio)/2 + spawnY/mpRatioY;

        EnemyShip enemyShip = new EnemyShip();
        getWorld().addObject(enemyShip, (int) minimapX, (int) minimapY);

    }

    public void updateMinimap()
    {
        double minimapX = (getX()/mpRatioX) + 800-(167/mpRatio)/2 + spawnX/mpRatioX;
        double minimapY = (getY()/mpRatioY) + 405-(167/mpRatio)/2 + spawnY/mpRatioY;

        List<Actor> actors = getWorld().getObjects(EnemyShip.class); 
        for (Actor a : actors)
        {
            a.setLocation((int) minimapX, (int) minimapY);
        }
    }

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

        if(shootProgress > 0){
            weaponDelay++;
            if(weaponDelay%cyclesBetweenShots == 0){
                shootProgress--;
                shoot(playerX, playerY, currentWeapon);

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
        System.out.println(cmdS);
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
    /**STOP USING FIRST TIME
     * USE THE CONSTRUCTOR
     *  ^^^^
     * CANT USE CONSTRUCTOR FOR CERTAIN THINGS 
     * 
     */

    private void firstTime(){
        if(firstTime){
            space = (Space) getWorld();
            ship = space.getShip();
            damageBar = new DamageBar(this, -50, getHealth(), getMaxHealth());
            space.addObject(damageBar, 0, 0);
            //setupMinimap();

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
        //
        if(reachedTarget()==false){

            //System.out.println("Reached Target: " + reachedTarget());
            Space space = (Space) getWorld();
            Ship ship = space.getShip();

            turnTowards((int)(getTargetX()-ship.getSpaceX()), (int)(getTargetY()-ship.getSpaceY()));

            int angle = getRotation();

            addSpaceX(Math.cos(Math.toRadians(angle))*maxFlySpeed);
            addSpaceY(Math.sin(Math.toRadians(angle))*maxFlySpeed);

            if(checkClose()){
                setReachedTarget(true);
                queueInUse(false);
                //System.out.println("DONE");
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
