import greenfoot.*;
import java.lang.Math;
/**
 * The player class is responsible for ship control and movement behavior.
 * Spawns stars and takes player input as well.
 * 
 * Written by Nathan Philliber
 */
public class Player extends Object implements DamageTaker
{

    //Coords to keep track of ship
    private double spaceX;
    private double spaceY;

    //Velocity of ship
    private double velX;
    private double velY;

    //Rate at which ship turns and accelerates
    private int turnSpeed = 5;
    private double flySpeed = 0.3;
    private double revSpeed = 0.15;

    //The maximum velocity the ship can have
    private double maxFlySpeed = 4.0;
    private double maxFlyBoostSpeed = 10.0;
    //How fast the ship deccelerates 
    //Lower the number the longer it takes to stop
    private double flyDec = .01;

    //How dense the stars should spawn. Higher number means more stars.
    //Number is arbitrary
    private int starDensity = 2;
    private int nebulaDensity = 100;

    private boolean dockPressed = false;

    //Health values of player
    private double health = 100.0;
    private double maxHealth = 100.0;

    //Damage bar for player
    private DamageBar damageBar;

    //Used for in class operations
    private boolean firstTime = true;

    private int spawnRate = 120;  

    private TutorialObjectManager tutObj;

    public Counter goldScore;

    private boolean projectileEnabled = true; //DO NOT DIRECTLY EDIT THESE
    private boolean missileEnabled = true;
    private boolean beamEnabled = true;
    private boolean mineEnabled = true;
    private boolean fireballEnabled = true;
    private boolean plasmaballEnabled = true;

    //Constructor, spawns player at 0,0
    public Player(){
        this(0,0);

    }

    //Constructor, spawns player at x,y coord
    public Player(double x, double y){
        setIsPlayer(true);

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
        super.act();

        if(!space.getIsPaused())
        {
            firstTime();
            fly();
            showDebug(true);

            scrollWeapon();

            spawnAsteroid();

            lookForGold();

            generateStars(starDensity);
            generateNebulas(nebulaDensity);
            damageBar.updateDamage(getHealth(), getMaxHealth());
            debugHealthHack(); //Allows to add health via '[']' DELETE THIS BEFORE PUBLISH
            //checkDead();
            weaponSystems();//john
            checkDock();

        }
    } 

    public void updateAvailableWeapons(boolean proj, boolean beam, boolean missile, boolean mine, boolean fire, boolean plasma){
        space.removeWeaponGUI();
        projectileEnabled = proj;
        missileEnabled = missile;
        beamEnabled = beam;
        mineEnabled = mine;
        fireballEnabled = fire;
        plasmaballEnabled = plasma;
        space.drawWeaponGUI(projectileEnabled, beamEnabled, missileEnabled, mineEnabled, fireballEnabled, plasmaballEnabled);

    }

    public void checkDock(){
        if(Greenfoot.isKeyDown("e")){
            if(touch(Planet.class) && dockPressed == false){
                dockPressed = true;
                dockMenu();

            }
        }
    }

    public void dockWorld(){
        //Planet planet = (Planet)getOneIntersectingObject(Planet.class);
        //planet.loadWorld();

        SpaceObject obj =(SpaceObject) getOneIntersectingObject(SpaceObject.class);
        if(obj != null){
            if(obj instanceof Planet){
                if(touch(obj)){ //Don't run this disgusting function unless neceessary
                    Planet planet = (Planet) obj;
                    //System.out.println(planet.world);
                    planet.loadWorld();

                }
            }
        }
    }

    public void resetDockMenu(){
        dockPressed = false;
    }

    public boolean getHit(double damage){
        addHealth(-damage);
        return true;
        //ADD DEATH AND RESPAWN
    }

    public boolean isAccelerating(){
        if(Greenfoot.isKeyDown("w")){
            return true;
        }
        return false;
    }

    //Checks for key presses and changes coords ("moves" ship)
    private void fly(){

        //System.out.println(getShipLocX() + "  " + getShipLocY());
        //If spacebar or w is pressed
        if(isAccelerating()){
            int angle = getRotation();
            //addRocketTrail(getShipLocX()-30*Math.cos(getRotation()*2*Math.PI/360), getShipLocY()-30*Math.sin(getRotation()*2*Math.PI/360));
            //Add to velocity based on what angle the ship is turned to
            addVelX((Math.cos(Math.toRadians(angle))*getFlySpeed()));
            addVelY((Math.sin(Math.toRadians(angle))*getFlySpeed()));

            //Check if ship is going too fast
            if(Greenfoot.isKeyDown("space")){ //Boost
                if(Math.abs(getVelX()) >= getMaxFlyBoostSpeed()){
                    setVelX(getMaxFlyBoostSpeed()*Integer.signum((int)getVelX()));

                    addRocketTrail(getShipLocX()-30*Math.cos(getRotation()*2*Math.PI/360), getShipLocY()-30*Math.sin(getRotation()*2*Math.PI/360));
                }
                if(Math.abs(getVelY()) >= getMaxFlyBoostSpeed()){
                    setVelY(getMaxFlyBoostSpeed()*Integer.signum((int)getVelY()));
                    addRocketTrail(getShipLocX()-30*Math.cos(getRotation()*2*Math.PI/360), getShipLocY()-30*Math.sin(getRotation()*2*Math.PI/360));
                }
            }
            else{
                if(Math.abs(getVelX()) >= getMaxFlySpeed()){
                    //Set velocity to maximum velocity in correct direction
                    setVelX(getMaxFlySpeed()*Integer.signum((int)getVelX()));

                    addRocketTrail(getShipLocX()-30*Math.cos(getRotation()*2*Math.PI/360), getShipLocY()-30*Math.sin(getRotation()*2*Math.PI/360));
                }
                if(Math.abs(getVelY()) >= getMaxFlySpeed()){
                    setVelY(getMaxFlySpeed()*Integer.signum((int)getVelY()));
                    addRocketTrail(getShipLocX()-30*Math.cos(getRotation()*2*Math.PI/360), getShipLocY()-30*Math.sin(getRotation()*2*Math.PI/360));
                }
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

        reverseThruster();//john

        //Add velocity to coordinates, thereby "moving" the ship
        addSpaceX(getVelX());
        addSpaceY(getVelY());
    }

    private void reverseThruster()//john
    {
        if (Greenfoot.isKeyDown("s"))
        {
            int angle = getRotation();
            addVelX(-(Math.cos(Math.toRadians(angle))*revSpeed));
            addVelY(-(Math.sin(Math.toRadians(angle))*revSpeed));

            if(Math.abs(getVelX()) >= getMaxFlySpeed()){
                //Set velocity to maximum velocity in correct direction
                setVelX(getMaxFlySpeed()*Integer.signum((int)getVelX()));
                addRocketTrail(getShipLocX()-30*Math.cos(getRotation()*2*Math.PI/360), getShipLocY()-30*Math.sin(getRotation()*2*Math.PI/360));
            }
            if(Math.abs(getVelY()) >= getMaxFlySpeed()){
                setVelY(getMaxFlySpeed()*Integer.signum((int)getVelY()));
                addRocketTrail(getShipLocX()-30*Math.cos(getRotation()*2*Math.PI/360), getShipLocY()-30*Math.sin(getRotation()*2*Math.PI/360));
            }
        }

    }

    private void debugHealthHack(){
        if(Greenfoot.isKeyDown("[")){
            addHealth(-.5);
        }
        if(Greenfoot.isKeyDown("]")){
            addHealth(.5);
        }
    }

    //Generates stars offscreen
    private void generateStars(int density){
        World world = getWorld();

        //Doesn't spawn stars every call, higher density will increase odds
        //Don't spawn more than 120 stars
        if((Greenfoot.getRandomNumber(100))/density < 10 && BackgroundStar.getNumStars() < 120){

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

    private void generateNebulas(int density){
        World world = getWorld();

        //Doesn't spawn stars every call, higher density will increase odds
        //Don't spawn more than 120 stars
        if((Greenfoot.getRandomNumber(400)) < 10 && BackgroundStar.getNumStars() < 400){

            //Divide star spawns between up/down and right/left
            if(Greenfoot.getRandomNumber(2)==1){
                //If the ship is going fast enough left/right, spawn a star on one of those sides
                if(Math.abs(getVelX()) > 1.0){ 
                    world.addObject(new Nebula((getSpaceX() + world.getWidth()/2)+((world.getWidth()+2000)*getPosNeg()),
                            (getSpaceY() + world.getHeight()/2)+Greenfoot.getRandomNumber(world.getHeight())),1000*(int)getPosNeg(),-1000*(int)getPosNeg());
                }

            }   
            else{
                //If the ship is going fast enough up/down, spawn a star on one of those sides
                if(Math.abs(getVelY()) > 1.0){
                    world.addObject(new Nebula((getSpaceX() + world.getWidth()/2)+Greenfoot.getRandomNumber(world.getWidth()),
                            (getSpaceY() + world.getHeight()/2)+((world.getHeight()+2000)*getPosNeg())),1000*(int)getPosNeg(),1000*(int)getPosNeg());

                }
            }
        }

    }
    //Called during the first tick only
    //Some methods require the ship to alrady be spawned to work
    private void firstTime(){
        if(firstTime){
            Space SPACE=(Space)getWorld();
            damageBar = new DamageBar(this, -30, getHealth(), getMaxHealth());
            SPACE.addObject(damageBar, 0, 0);

            
            updateAvailableWeapons(true, true, true, true, true, true);
            
            if(getWorld() instanceof TutorialWorld){
                tutObj = new TutorialObjectManager();
                SPACE.addObject(tutObj,-10,-10);
                updateAvailableWeapons(true, true, false, true, false, false);
            }
            else{
                //thisIsATutorial = false;
            }

            goldScore = new Counter("Space Doubloons: ");
            getWorld().addObject(goldScore, SPACE.getWidth()-119, SPACE.getHeight()-22);
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

    public void lookForGold(){
        //COLLISION AND CALL PICKUP
        SpaceObject obj =(SpaceObject) getOneIntersectingObject(SpaceObject.class);
        if(obj != null){
            if(obj instanceof Gold){
                if(touch(obj)){ //Don't run this disgusting function unless neceessary
                    Gold ent = (Gold) obj;
                    ent.pickUp();
                    goldScore.setValue(Gold.totalGold);

                }
            }
        }

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

    public void addVelX(double x){
        setVelX(getVelX()+x);
    }

    public void addVelY(double y){
        setVelY(getVelY()+y);
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

    public double getMaxFlyBoostSpeed(){
        return maxFlyBoostSpeed;
    }

    public void setMaxFlyBoostSpeed(int speed){
        maxFlyBoostSpeed = speed;
    }

    public void setFlyDec(double dec){
        flyDec = dec;
    }

    public double getFlyDec(){
        return flyDec;
    }

    public double getRevSpeed(){
        return revSpeed;
    }

    public void setRevSpeed(int speed){
        revSpeed = speed;
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

    public void checkDead(){
        if(getHealth() <= 0.0){
            addExplosion(getShipLocX(), getShipLocY());
        }
    }

    /*
    public void addAsteroid()
    {
    if(spawnRate == 0)
    {
    int size = Greenfoot.getRandomNumber(3);

    int areay = getWorld().getHeight();
    int areax = getWorld().getWidth();
    int topBot = Greenfoot.getRandomNumber(1);
    int x = (Greenfoot.getRandomNumber(3)+2 % 2 == 0) ? -50 : areax + 50;
    int y = Greenfoot.getRandomNumber(areay);

    if(size == 0)
    {
    Asteroid1 asteroidS = new Asteroid1();
    getWorld().addObject(asteroidS, x, y);
    }
    if(size == 1)
    {
    Asteroid2 asteroidM = new Asteroid2();
    getWorld().addObject(asteroidM, x, y);
    }
    if(size == 2)
    {
    Asteroid3 asteroidB = new Asteroid3();
    getWorld().addObject(asteroidB, x, y);
    }
    spawnRate = 100;

    }
    else
    {
    spawnRate--;
    }  
    }
     */

    private int asteroidSpawnChance = 90;

    public void spawnAsteroid(){
        if(Greenfoot.getRandomNumber(asteroidSpawnChance) == 0){
            switch(Greenfoot.getRandomNumber(3)){
                case 0:
                space.addObject(new AsteroidLarge(ship.getShipLocX()+700*getPosNeg(),ship.getShipLocY()+700*getPosNeg(),Greenfoot.getRandomNumber(360),4.0),-10,-10);
                break;
                case 1:
                space.addObject(new AsteroidMedium(ship.getShipLocX()+700*getPosNeg(),ship.getShipLocY()+700*getPosNeg(),Greenfoot.getRandomNumber(360),4.0),-10,-10);            
                break;
                case 2:
                space.addObject(new AsteroidSmall(ship.getShipLocX()+700*getPosNeg(),ship.getShipLocY()+700*getPosNeg(),Greenfoot.getRandomNumber(360),4.0),-10,-10);            
                break;
            }
        }

    }

    private long tick = 0;
    private long time = System.currentTimeMillis();
    //Display debug info such as x,y coords, velocities, star count, health
    private void showDebug(boolean show){
        if(show)
        {
            tick++;
            long curTime = System.currentTimeMillis();
            Space SPACE = (Space) getWorld();
            int x = SPACE.getWidth() - 75;

            SPACE.showText("X: "+String.format("%.02f", (getSpaceX())), x, 25);
            SPACE.showText("Y: "+String.format("%.02f", (getSpaceY())), x, 50); 

            SPACE.showText("vX: "+String.format("%.02f", (getVelX())), x, 75);
            SPACE.showText("vY: "+String.format("%.02f", (getVelY())), x, 100);        

            SPACE.showText("Stars: "+ BackgroundStar.getNumStars(), x, 125); 

            SPACE.showText("Health: "+ getHealth(), x, 150);
            SPACE.showText("Weapon: "+ SPACE.getWeapon(), x, 175);

            SPACE.showText("Tick: "+ tick*1000/(curTime - time), x, 200);
        }
    }   

    public double getSpeed(){
        return Math.sqrt(Math.pow(getVelX(),2)+Math.pow(getVelY(),2));
    }

    private void scrollWeapon()
    {
        Space SPACE = (Space) getWorld();
        weaponType = (int) SPACE.getWeapon();
    }   
    /* sooooo broken
    public static double getWeapon()
    {
    int tempWep=0;
    tempWep += scroll.getScroll();
    if(tempWep < 0)
    {
    tempWep = 0;
    }
    if(tempWep > 5)
    {
    tempWep = 5;
    }

    return tempWep;
    } 
     */
    /**********************************************************************************************************
     **********************************************************************************************************
     **********************************************************************************************************
     **********************************************************************************************************
     * WEAPON SYSTEMS
     * by john
     * 10/8/15
     * 
     *
     * //add sheilds
     **********************************************************************************************************
     **********************************************************************************************************
     **********************************************************************************************************
     **********************************************************************************************************
     */

    //john start

    private int weaponTimer = 0;
    private int weaponToggle = 0;
    private int weaponLV = 0;
    private int weaponType = 0;

    private int hearthTimer = 0;
    private int blinkCD = 0;
    private int beamCharge = 0;
    private boolean beamCD = false;
    public boolean mouseAim = true;

    public void weaponSystems()
    {
        shoot(weaponLV, weaponType);
        toggleWeaponLV();
        weaponType();
        hearth();
        blink();
    }

    private void blink()
    {
        blinkCD++;
        if (Greenfoot.isKeyDown("v") && blinkCD>=200)
        {
            addSpaceX(250*Math.cos(getRotation()*2*Math.PI/360));
            addSpaceY(250*Math.sin(getRotation()*2*Math.PI/360));
            blinkCD=0;
        }
    }

    private void hearth()
    {
        if (Greenfoot.isKeyDown("b"))
        {
            hearthTimer++;
            if (hearthTimer >= 100)
            {
                setSpaceX(0);
                setSpaceY(0);
                setVelX(0);
                setVelY(0);
            }
        }
        else
        {
            hearthTimer = 0;
        }
    }

    private void shoot(int LV, int wep)
    {
        beamCharge();
        if (Greenfoot.isKeyDown("c") || rMButton())
        {
            
         
            
            
            if (mouseAim)
            {
                weaponTimer(mouseAngle(),LV,wep);
            }
            else
            {
                weaponTimer(getRotation(),LV,wep);
            }
        }
        else
        {
            weaponTimer = 0;
        }
    }

    private void beamCharge()
    {
        bramChargeBar();
        if (beamCharge<300)
        {
            beamCharge++;
        }
        if (beamCharge<=5)
        {
            beamCD = true;
        }
        if (beamCharge>=100)
        {
            beamCD = false;
        }
    }

    private void bramChargeBar()
    {
        for (int i=1; i <= beamCharge/15; i++)
        {
            getWorld().addObject(new Beam(0, true, 0, 400, 520),418+i*4,520);
        }
    }

    private void weaponTimer(int angle,int LV,int wep)
    {
        weaponTimer++;
        if (wep==0)
        {
            if (weaponTimer%10 == 1)
            {
                projectile(angle,LV,getShipLocX(),getShipLocY());
            }
        }            
        if (wep==1&&!beamCD)
        {
            beam(angle,LV,getShipLocX(),getShipLocY());//in object WEAPON SYSTEMS
            beamCharge--;
            beamCharge--;
            beamCharge--;
        }
        if (wep==2)
        {
            if (weaponTimer%35 == 1)
            {
                missile(angle,LV,getShipLocX(),getShipLocY());//in object WEAPON SYSTEMS
            }
        }
        if (wep==3)
        {
            if (weaponTimer%30 == 1)
            {
                mine(angle,LV,spaceX+getX(),spaceY+getY());//in object WEAPON SYSTEMS
            }
        }
        if (wep==4)
        {
            if (weaponTimer%70 == 1)
            {
                fireball(angle,LV,getShipLocX(),getShipLocY());//in object WEAPON SYSTEMS
            }
        }
        if (wep==5)
        {
            if (weaponTimer%30 <= 4)
            {
                plasmaBall(angle,LV,getShipLocX(),getShipLocY());
            }
        }
        if (wep==6)
        {
            //stuff wave
        }
    }

    private void toggleWeaponLV()
    {
        if (Greenfoot.isKeyDown("="))
        {
            if (weaponToggle==0)
            {
                if (weaponLV == 6)
                {
                    weaponLV = 0;
                }
                else
                {
                    weaponLV++;
                }
                weaponToggle++;
            }
        }
        else if (Greenfoot.isKeyDown("-"))
        {
            if (weaponToggle==0)
            {
                if (weaponLV == 0)
                {
                    weaponLV = 6;
                }
                else
                {
                    weaponLV--;
                }
                weaponToggle++;
            }
        }
        else
        {
            weaponToggle = 0;
        }
    }

    private void weaponType()
    {
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
    }
    //john end

}
