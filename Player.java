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
    
    public static final int TURN_SPEED = 2;
    public static final double FLY_SPEED = .3;
    public static final double REV_SPEED = .15;

    //Rate at which ship turns and accelerates
    private int turnSpeed = TURN_SPEED;
    private double flySpeed = FLY_SPEED;
    private double revSpeed = REV_SPEED;
    
    private int boostCD=0;

    //The maximum velocity the ship can have
    public static final double MAX_FLY_SPEED = 4.0;
    public static final double MAX_FLY_BOOST_SPEED = 10.0;
    private double maxFlySpeed = MAX_FLY_SPEED;
    private double maxFlyBoostSpeed = MAX_FLY_BOOST_SPEED;
    //How fast the ship deccelerates 
    //Lower the number the longer it takes to stop
    public static final double FLY_DEC = .08;
    private double flyDec = FLY_DEC;

    //How dense the stars should spawn. Higher number means more stars.
    //Number is arbitrary
    private int starDensity = 2;
    private int nebulaDensity = 100;

    private boolean dockPressed = false;

    //Health values of player
    public static final double MAX_HEALTH = 100.0;
    private double health = 100.0;
    private double maxHealth = MAX_HEALTH;

    //Damage bar for player
    private DamageBar damageBar;

    //Used for in class operations
    private boolean firstTime = true;

    private int spawnRate = 120;  

    private TutorialObjectManager tutObj;

    //public Counter goldScore;

    private int asteroidSpawnChance = 90; //Lower the more common
    private int shootingStarSpawnChance = 60;

    public static boolean projectileEnabled = true; //DO NOT DIRECTLY EDIT THESE
    public static boolean missileEnabled = false;
    public static boolean beamEnabled = false;
    public static boolean mineEnabled = false;
    public static boolean fireballEnabled = false;
    public static boolean plasmaballEnabled = false;

    public static int projectileLevel = 1;
    public static int missileLevel = 0;
    public static int beamLevel = 0;
    public static int mineLevel = 0;
    public static int fireballLevel = 0;
    public static int plasmaLevel = 0;

    private int weaponTimer = 0;
    private int weaponToggle = 0;
    private int weaponLV = 0;
    private int weaponType = 0;

    private int hearthTimer = 0;
    private int blinkCD = 0;
    private int beamCharge = 0;
    private boolean beamCD = false;
    public boolean mouseAim = true;

    private boolean playerDisabled = false;

    public static int gold = 3000;

    /*************************************************************/
    /*********************  DEMO STUFF  **************************/
    /*************************************************************/

    private int numEnemiesKilled = 0;
    private AlienShip alien;

    private boolean alienCurAlive = false;

    public void keepEnemyOnScreen(){
        if(getWorld() instanceof OuterSpace){
            if(alienCurAlive == false){
                alien = new AlienShip(getShipLocX()+Greenfoot.getRandomNumber(500)-250, getShipLocY()+Greenfoot.getRandomNumber(500)-250);
                space.addObject(alien,0,0);
                alienCurAlive = true;
            }
            else{
                if(alien.isAlive == false){
                    numEnemiesKilled++;
                    alienCurAlive = false;

                    
                }
            }   
        }

    }

    /******* DELETE LATER********/

    /***************************************************************/
    /*********************  CONSTRUCTORS  **************************/
    /***************************************************************/

    //Constructor, spawns player at 0,0
    public Player(){
        this(0,0);
    }

    //Constructor, spawns player at x,y coord
    public Player(double x, double y){

        setSpaceX(x);
        setSpaceY(y);

        setVelX(0.0);
        setVelY(0.0);

    }

    /******************************************************/
    /*********************  ACT  **************************/
    /******************************************************/
    //Called every tick
    //Allows ship to "move" (changes coords), displays debug info and spawns stars
    //Updates health
    public void act() 
    {
        super.act();

        if(!space.getIsPaused())
        {
            firstTime();
            if(playerDisabled == false){
                fly(); 
            }

            showDebug(true);
            scrollWeapon();
            spawnAsteroid();
            spawnShootingStar();
            lookForGold();

            generateStars(starDensity);
            generateNebulas(nebulaDensity); //Cant shoot in nebulas
            damageBar.updateDamage(getHealth(), getMaxHealth());
            debugHealthHack(); //Allows to add health via '[']' DELETE THIS BEFORE PUBLISH
            //checkDead(); //Add this back in later, make respawn
            weaponSystems();//john
            keepEnemyOnScreen();
            updateGoldScore();
            checkDock();
        }
    } 

    /*************************************************************************/
    /*********************  MOVEMENT AND COLLISION  **************************/
    /*************************************************************************/

    public void lockPlayer(boolean lock){
        playerDisabled = lock;

    }

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
                Gold ent = (Gold) obj;
                gold += ent.value;
                ent.pickUp();
                //goldScore.setValue(gold);
            }

        }
    }

    public void checkDock(){
        if(Greenfoot.isKeyDown("e")){
            if(touch(Planet.class) && dockPressed == false){
                dockPressed = true;
                dockMenu();

            }
        }
        delayLoadWorldHelper();
    }

    public void dockWorld(){
        //Planet planet = (Planet)getOneIntersectingObject(Planet.class);
        //planet.loadWorld();

        SpaceObject obj =(SpaceObject) getOneIntersectingObject(SpaceObject.class);
        if(obj != null){
            if(obj instanceof Planet){
                if(touch(obj)){ //Don't run this disgusting function unless neceessary
                    Planet planet = (Planet) obj;
                    lockPlayer(true);
                    currentPlanet = planet;
                    planetLoadDelay = 100;

                }
            }
        }
    }

    private Planet currentPlanet;
    protected int planetLoadDelay = 0;
    private GreenfootImage shipImg = new GreenfootImage("images/RocketBoost.png");

    private void delayLoadWorldHelper(){
        if(planetLoadDelay > 1){
            planetLoadDelay--;

            addPlanetDock(getShipLocX(), getShipLocY());

        }
        else if(planetLoadDelay == 1){
            planetLoadDelay--;

            currentPlanet.loadWorld();
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
    private void boostChargeBar()
    {
        for (int i=1; i <= boostCD/25; i++){
            getWorld().addObject(new Beam(0, true, 0, 400, 520),418+i*4,520);
        }
    }
    //Checks for key presses and changes coords ("moves" ship)
    private void fly()
    {
        boostChargeBar();
        if(boostCD<500)
        {
            boostCD++;
        }
        //System.out.println(getShipLocX() + "  " + getShipLocY());
        //If spacebar or w is pressed
        if(isAccelerating()){
            int angle = getRotation();
            //Add to velocity based on what angle the ship is turned to
            addVelX((cos(angle)*getFlySpeed()));
            addVelY((sin(angle)*getFlySpeed()));
            //Check if ship is going too fast
            if(Greenfoot.isKeyDown("space")&&boostCD>0)//BOOST
            {
                boostCD-=2;
                if(Math.sqrt(Math.pow(getVelX(),2)+Math.pow(getVelY(),2))>=getMaxFlyBoostSpeed())
                {
                    setVelX(getMaxFlyBoostSpeed()*cos(Math.atan2(getVelY(),getVelX())*180/Math.PI));
                    setVelY(getMaxFlyBoostSpeed()*sin(Math.atan2(getVelY(),getVelX())*180/Math.PI));
                    addRocketTrail(getShipLocX()-30*cosRot(),getShipLocY()-30*sinRot());
                }
            }
            else
            {
                /**>>>>>>>>>USE THE TRIG<<<<<<<<<<<<<<<**//*
                if(Math.abs(getVelX()) >= getMaxFlySpeed()){
                    //Set velocity to maximum velocity in correct direction
                    setVelX(getMaxFlySpeed()*Integer.signum((int)getVelX()));
                    addRocketTrail(getShipLocX()-30*cosRot(),getShipLocY()-30*sinRot());
                }
                if(Math.abs(getVelY()) >= getMaxFlySpeed()){
                    setVelY(getMaxFlySpeed()*Integer.signum((int)getVelY()));
                    addRocketTrail(getShipLocX()-30*cosRot(),getShipLocY()-30*sinRot());
                }*/
                if(Math.sqrt(Math.pow(getVelX(),2)+Math.pow(getVelY(),2))>=getMaxFlySpeed())
                {
                    setVelX(getMaxFlySpeed()*cos(Math.atan2(getVelY(),getVelX())*180/Math.PI));
                    setVelY(getMaxFlySpeed()*sin(Math.atan2(getVelY(),getVelX())*180/Math.PI));
                    addRocketTrail(getShipLocX()-30*cosRot(),getShipLocY()-30*sinRot());
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

    private void reverseThruster(){
        if (Greenfoot.isKeyDown("s"))
        {
            int angle = getRotation();
            addVelX(-(cos(angle)*revSpeed));
            addVelY(-(sin(angle)*revSpeed));

            if(Math.abs(getVelX()) >= getMaxFlySpeed()){
                //Set velocity to maximum velocity in correct direction
                setVelX(getMaxFlySpeed()*Integer.signum((int)getVelX()));
                addRocketTrail(getShipLocX()-30*cosRot(),getShipLocY()-30*sinRot());
            }
            if(Math.abs(getVelY()) >= getMaxFlySpeed()){
                setVelY(getMaxFlySpeed()*Integer.signum((int)getVelY()));
                addRocketTrail(getShipLocX()-30*cosRot(),getShipLocY()-30*sinRot());
            }
        }

    }

    public double getSpeed(){
        return Math.sqrt(Math.pow(getVelX(),2)+Math.pow(getVelY(),2));
    }

    private void blink()
    {
        blinkCD++;
        if (Greenfoot.isKeyDown("v") && blinkCD>=200){
            addSpaceX(250*cosRot());
            addSpaceY(250*sinRot());
            blinkCD=0;
        }
    }

    private void hearth(){
        if (Greenfoot.isKeyDown("b")){
            hearthTimer++;
            if (hearthTimer >= 100){
                setSpaceX(0);
                setSpaceY(0);
                setVelX(0);
                setVelY(0);
            }
        }
        else{
            hearthTimer = 0;
        }
    }

    /********************************************************************/
    /*********************  OBJECT GENERATION  **************************/
    /********************************************************************/

    private void initialStarSpawn(int density){
        for(int i = 0; i < 7*density; i++){
            space.addObject(new BackgroundStar(
                    getShipLocX() + Greenfoot.getRandomNumber(space.getWidth()) - space.getWidth()/2,
                    getShipLocY() + Greenfoot.getRandomNumber(space.getHeight()) - space.getHeight()/2
                ),0,0);
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

    public void spawnShootingStar(){
        if(Greenfoot.getRandomNumber(shootingStarSpawnChance) == 0){

            space.addObject(new ShootingStar(ship.getShipLocX()+700*getPosNeg(),ship.getShipLocY()+700*getPosNeg(),Greenfoot.getRandomNumber(360)),-10,-10);

        }
    }

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

    /******************************************************************/
    /*********************  WEAPONS SYSTEMS  **************************/
    /******************************************************************/

    public static int getWeaponLevel(int weapon){
        switch(weapon){
            case 0:
            return projectileLevel;
            
            case 1:
            return beamLevel;
            
            case 2:
            return missileLevel;
           
            case 3:
            return mineLevel;
            
            case 4:
            return fireballLevel;
            
            case 5:
            return plasmaLevel;
            
        }
        return -1;
    }

    public void updateAvailableWeapons(boolean proj, boolean beam, boolean missile, boolean mine, boolean fire, boolean plasma)
    {
        space.removeWeaponGUI();
        projectileEnabled = proj;
        missileEnabled = missile;
        beamEnabled = beam;
        mineEnabled = mine;
        fireballEnabled = fire;
        plasmaballEnabled = plasma;

        reloadWeapons();

    }

    public static void updateAvailableWeapons(int i, boolean weapon){

        switch(i){
            case 0:
            projectileEnabled = weapon;
            break;
            case 1:
            beamEnabled = weapon;
            break;
            case 2:
            missileEnabled = weapon;
            break;
            case 3:
            mineEnabled = weapon;
            break;
            case 4:
            fireballEnabled = weapon;
            break;
            case 5:
            plasmaballEnabled = weapon;
            break;

        }

    }
    public void reloadWeapons(){
        space.drawWeaponGUI(projectileEnabled, beamEnabled, missileEnabled, mineEnabled, fireballEnabled, plasmaballEnabled);
    }

    private void shoot(int LV, int wep)
    {
        beamCharge();
        if (Greenfoot.isKeyDown("c") || rMButton())
        {
            if (mouseAim){
                weaponTimer(mouseAngle(),LV,wep);
            }
            else{
                weaponTimer(getRotation(),LV,wep);
            }
        }
        else if(weaponTimer>=10000)
        {
            weaponTimer = 0;
        }
    }

    private void beamCharge()
    {
        //beamChargeBar();
        if (beamCharge<300){
            beamCharge++;
        }
        if (beamCharge<=5){
            beamCD = true;
        }
        if (beamCharge>=100){
            beamCD = false;
        }
    }

    private void beamChargeBar()
    {
        for (int i=1; i <= beamCharge/15; i++){
            getWorld().addObject(new Beam(0, true, 0, 400, 520),418+i*4,520);
        }
    }

    private void weaponTimer(int angle,int LV,int wep)
    {
        weaponTimer++;
        if (wep==0){
            if (weaponTimer%10 == 1){
                projectile(angle,LV,getShipLocX(),getShipLocY(), true);
            }
        }            
        if (wep==1&&!beamCD){
            beam(angle,LV,getShipLocX(),getShipLocY(),beamCharge/30, true);//in object WEAPON SYSTEMS
            beamCharge--;
            beamCharge--;
            beamCharge--;
        }
        if (wep==2){
            if (weaponTimer%35 == 1){
                missile(angle,LV,getShipLocX(),getShipLocY(), true);//in object WEAPON SYSTEMS
            }
        }
        if (wep==3){
            if (weaponTimer%30 == 1){
                mine(angle,LV,spaceX+getX(),spaceY+getY(), true);//in object WEAPON SYSTEMS
            }
        }
        if (wep==4){
            if (weaponTimer%70 == 1){
                fireball(angle,LV,getShipLocX(),getShipLocY(), true);//in object WEAPON SYSTEMS
            }
        }
        if (wep==5){
            if (weaponTimer%30 <= 4){
                plasmaBall(angle,LV,getShipLocX(),getShipLocY(), true);
            }
        }
    }

    private void toggleWeaponLV(){
        if (Greenfoot.isKeyDown("=")){
            if (weaponToggle==0)
            {
                if (weaponLV == 5)
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
                    weaponLV = 5;
                }
                else{
                    weaponLV--;
                }
                weaponToggle++;
            }
        }
        else{
            weaponToggle = 0;
        }
    }

    private void scrollWeapon(){
        weaponType = (int) space.getWeapon();
    }   

    public void weaponSystems(){
        //System.out.println(Player.getWeaponLevel(weaponType));
        shoot(Player.getWeaponLevel(weaponType), weaponType);
        //toggleWeaponLV(); //disable key to change
        //weaponType();
        hearth();
        blink();
    }

    /****************************************************************/
    /*********************  HEALTH SYSTEM  **************************/
    /****************************************************************/
    private void debugHealthHack(){
        if(Greenfoot.isKeyDown("[")){
            addHealth(-.5);
        }
        if(Greenfoot.isKeyDown("]")){
            addHealth(.5);
        }
        if(Greenfoot.isKeyDown("\\")){
            updateAvailableWeapons(true,true,true,true,true,true);
        }
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
    /*******************************************************/
    /*********************  MISC  **************************/
    /*******************************************************/
    //Called during the first tick only
    //Some methods require the ship to alrady be spawned to work
    private void firstTime(){
        if(firstTime){

            initialStarSpawn(starDensity);
            damageBar = new DamageBar(this, -30, getHealth(), getMaxHealth());
            space.addObject(damageBar, 0, 0);

            //
            reloadWeapons();

            if(getWorld() instanceof TutorialWorld){
                tutObj = new TutorialObjectManager();
                space.addObject(tutObj,-10,-10);
                updateAvailableWeapons(true, false, false, false, false, false);
            }
            else{
                //thisIsATutorial = false;
            }

            //goldScore = new Counter("Space Doubloons: ");
            //getWorld().addObject(goldScore, space.getWidth()-119, space.getHeight()-22);
            setUpGoldScore();
            firstTime = false;
        }
    }
    
    private Number goldNumber = new Number(gold+"",2);
    private double lastGoldCount = gold;
    
    private void setUpGoldScore(){
        space.addObject(new GoldText(),762,22);
        space.addObject(goldNumber, 855, 18);
    }
    
    private void updateGoldScore(){
        if(lastGoldCount != gold){
            goldNumber.remove();
            goldNumber = new Number(gold+"",2);
            space.addObject(goldNumber, 855, 18);
        }
        lastGoldCount = gold;
    }

    //Private method used for star spawning, returns either 1.0 or -1.0
    private double getPosNeg(){
        if(Greenfoot.getRandomNumber(2) ==0){
            return 1.0;
        }
        return -1.0;
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

    private long tick = 0;
    private long time = System.currentTimeMillis();
    //Display debug info such as x,y coords, velocities, star count, health
    private void showDebug(boolean show){
        if(show)
        {
            tick++;
            long curTime = System.currentTimeMillis();

            int x = space.getWidth() - 75;

            space.showText("X: "+String.format("%.02f", (getSpaceX())), x, 25);
            space.showText("Y: "+String.format("%.02f", (getSpaceY())), x, 50); 

            space.showText("vX: "+String.format("%.02f", (getVelX())), x, 75);
            space.showText("vY: "+String.format("%.02f", (getVelY())), x, 100);        

            space.showText("Stars: "+ BackgroundStar.getNumStars(), x, 125); 

            space.showText("Health: "+ getHealth(), x, 150);
            space.showText("Weapon: "+ space.getWeapon(), x, 175);

            space.showText("Tick: "+ tick*1000/(curTime - time), x, 200);
        }
    }   

}
