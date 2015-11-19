import greenfoot.*;
import java.lang.Math;
import java.util.List;
/**
 * The player class is responsible for ship control and movement behavior.
 * Spawns stars and takes player input as well.
 * 
 * Written by Nathan, Trace, John
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

    public static final double planetDelay = 100;
    public static final double wrongPlanetDelay = 800;

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
    private static double health = 100.0;
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

    public static int[] SPEED_COST = {50,60,70,80,100,120,150,200,300,400,500,1000,2000,3000,5000,10000,100000};
    public static int[] TURN_SPEED_COST = {50,60,70,80,100,120,150,200,300,400,500,1000,2000,3000,5000,10000,100000};
    public static int[] BOOST_BAR_COST = {50,60,70,80,100,120,150,200,300,400,500,1000,2000,3000,5000,10000,100000};

    public static int speedLevel = 0;
    public static int turnSpeedLevel = 0;
    public static int boostBarLevel = 0;

    private int weaponTimer = 0;
    private int weaponToggle = 0;
    private int weaponLV = 0;
    private int weaponType = 0;

    private int hearthTimer = 0;
    private int blinkCD = 0;
    private int beamCharge = 0;
    private boolean beamCD = false;
    public boolean mouseAim = true;

    public boolean playerDisabled = false;

    public static int gold = 0;
    public static int goldPotential = 0;

    public static boolean respawnIsPressed;
    private boolean explosionTimer;

    public static boolean[][] levelsBeaten = new boolean[4][9]; //level , sector

    public static int workingSector = 0;

    public int currentSector = 0;
    public boolean inWrongSector = false;

    private int flash = 0;

    private boolean shrinkingShort;
    private boolean shrinkingLong;

    private int actDelay = 0;
    public static boolean aboutToPlayCompletedLevel = false;
    public static int getNextEngineCost(int i){
        switch(i){
            case 0:
            return SPEED_COST[speedLevel];

            case 1:
            return TURN_SPEED_COST[turnSpeedLevel];

            case 2:
            return BOOST_BAR_COST[boostBarLevel];

        }

        return -1;
    }

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

        maxFlySpeed += (maxFlySpeed*speedLevel)*.25;
        turnSpeed += (turnSpeed*turnSpeedLevel)*.25;

    }
    /******************************************************/
    /*********************  ACT  **************************/
    /******************************************************/
    //Called every tick
    //Allows ship to "move" (changes coords), displays debug info and spawns stars
    //Updates health

    public void actEvery100(){
        actDelay++;
        if(actDelay > 100){
            actDelay = 0;
            currentSector = space.getSector(this);
            if(!(health <= 0.0)	){
                addHealth(1.0);
            }
        }

    }

    public void act() 
    {
        super.act();

        if(!space.getIsPaused())
        {
            firstTime();
            if(!playerDisabled && !isDead){
                fly(); 
            }

            showDebug(false);
            scrollWeapon();
            spawnAsteroid();
            spawnShootingStar();
            lookForGold();

            actEvery100();

            destroyPlayerInWrongSector();

            generateStars(starDensity);
            generateNebulas(nebulaDensity); //Cant shoot in nebulas
            damageBar.updateDamage(getHealth(), getMaxHealth());
            debugHealthHack(); //Allows to add health via '[']' DELETE THIS BEFORE PUBLISH
            //checkDead(); //Add this back in later, make respawn
            weaponSystems();//john
            //keepEnemyOnScreen();

            if(Greenfoot.getRandomNumber(1300) == 0){
                spawnFleet(Greenfoot.getRandomNumber(6)+1, Entity.ANY_SHIP, 30);
            }

            updateGoldScore();
            checkDock();
            placeShield();
            checkDeath();
            respawn();
            flashWrongSector();
        }
    } 
    public static boolean justDied = true;
    private int explosionAmount = Greenfoot.getRandomNumber(10) + 5;
    private int deathDelay = 10;
    private boolean isDead;

    /*************************************************************************/
    /*********************  MOVEMENT AND COLLISION  **************************/
    /*************************************************************************/

    public void destroyPlayerInWrongSector(){
        inWrongSector = currentSector > workingSector;
        if(inWrongSector){
            if(Greenfoot.getRandomNumber(200) == 0){
                spawnFleet(Greenfoot.getRandomNumber(6)+1, Entity.ANY_SHIP, 75);
            }
        }
    }
    //Written by Nathan
    public void lockPlayer(boolean lock){
        playerDisabled = lock;

    }

    //Written by Nathan
    public boolean isMoving(){
        if(getVelX() != 0 || getVelY() != 0){

            return true;
        }
        return false;
    }

    //Written by Nathan
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
        List<Gold> objects = getObjectsInRange(250, Gold.class);

        for(Gold curObj : objects)
        {
            curObj.turnTowards(space.getWidth()/2, space.getHeight()/2);
            curObj.spaceMove(10);
        }
    }

    public boolean isInCorrectSector()
    {
        return space.getSector(this) == workingSector;
    }

    public void flashWrongSector()
    {
        if(!isInCorrectSector())
        {
            flashRed();
        }
        else
        {
            space.removeObjects(space.getObjects(WarningSector.class));
        }
    }

    public void flashRed()
    {
        WarningSector warning = new WarningSector();
        WarningBG respawnBG = new WarningBG();
        flash++;
        if(flash%40 == 0)
        {
            space.addObject(warning, space.getWidth()/2, space.getHeight()/2);
            space.addObject(respawnBG, space.getWidth()/2, space.getHeight()/2);
        }
    }

    //Written by Trace
    public void checkDock(){
        if(Greenfoot.isKeyDown("e")){
            if(touch(Planet.class) && dockPressed == false){
                dockPressed = true;
                dockMenu();

            }
        }
        delayLoadWorldHelper();
    }

    //Written by Nathan
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
                    if(!inWrongSector)
                    {
                        planetLoadDelay =  (int) planetDelay;
                        shrinkingLong = false;
                        shrinkingShort = true;
                    }
                    else
                    {
                        planetLoadDelay = (int) wrongPlanetDelay;
                        shrinkingLong = true;
                        shrinkingShort = false;
                    }

                }
            }
        }
    }

    private Planet currentPlanet;
    protected int planetLoadDelay = 0;
    private GreenfootImage shipImg = new GreenfootImage("images/RocketBoost.png");

    //Written by Nathan
    private void delayLoadWorldHelper(){

        if(planetLoadDelay > 1){
            planetLoadDelay--;

            addPlanetDock(getShipLocX(), getShipLocY());
            Actor cannon = getOneIntersectingObject(Cannon.class);
            if(shrinkingLong)
            {
                if(planetLoadDelay > 10)
                {
                    getImage().scale((int)((planetLoadDelay/wrongPlanetDelay)*95), (int) ((planetLoadDelay/wrongPlanetDelay)*40));
                    space.removeObject(cannon);
                }
            }
            if(shrinkingShort)
            {
                if(planetLoadDelay > 10)
                {
                    getImage().scale((int) ((planetLoadDelay*.01)*95),(int) ((planetLoadDelay*.01)*40));
                    space.removeObject(cannon);
                }
            }

        }
        else if(planetLoadDelay == 1){
            planetLoadDelay--;

            currentPlanet.loadWorld();
        }

    }

    //Written by Trace
    public void resetDockMenu(){
        dockPressed = false;
    }

    //Written by Nathan
    public boolean getHit(double damage){
        addHealth(-damage);
        return true;

    }

    //Written by Nathan
    public boolean isAccelerating(){
        if(Greenfoot.isKeyDown("w")){
            return true;
        }
        return false;
    }

    //Written by Trace
    private void boostChargeBar()
    {
        if(boostBarLevel > 0){
            for (int i=1; i <= boostCD/50; i++){
                space.addObject(new BoostBarSegment(),(space.getWidth()/2-77)+i*14,space.getHeight()-22);
            }
        }
    }
    //Checks for key presses and changes coords ("moves" ship)
    //Written by Nathan
    private void fly()
    {
        boostChargeBar();
        if(boostCD<500)
        {
            int change = boostBarLevel;
            boostCD += change;

            
        }
        //System.out.println(getShipLocX() + "  " + getShipLocY());
        //If spacebar or w is pressed
        if(isAccelerating()){
            int angle = getRotation();
            //Add to velocity based on what angle the ship is turned to
            addVelX((cos(angle)*getFlySpeed()));
            addVelY((sin(angle)*getFlySpeed()));
            //Check if ship is going too fast
            if((Greenfoot.isKeyDown("space")&&boostCD>0) && (boostBarLevel > 0))//BOOST
            {

                boostCD -= 2+boostBarLevel;
                if(Math.sqrt(Math.pow(getVelX(),2)+Math.pow(getVelY(),2))>=getMaxFlyBoostSpeed() && (boostBarLevel > 0))
                {

                    setVelX(getMaxFlyBoostSpeed()*cos(Math.atan2(getVelY(),getVelX())*180/Math.PI));
                    setVelY(getMaxFlyBoostSpeed()*sin(Math.atan2(getVelY(),getVelX())*180/Math.PI));
                    addRocketTrail(getShipLocX()-30*cosRot(),getShipLocY()-30*sinRot());
                    addBoost(getShipLocX(), getShipLocY());

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

    //Written by Nathan
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

    //Written by Nathan
    public double getSpeed(){
        return Math.sqrt(Math.pow(getVelX(),2)+Math.pow(getVelY(),2));
    }

    //Written by John
    private void blink()
    {
        blinkCD++;
        if (Greenfoot.isKeyDown("v") && blinkCD>=200){
            addSpaceX(250*cosRot());
            addSpaceY(250*sinRot());
            blinkCD=0;
        }
    }

    //Written by John
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
    //Look for ship types in entity
    //Difficulty is number 1-100, 100 is really hard.
    //Ships auto-agro at 25

    public void spawnFleet(int numberShips, int type, int difficulty){

        int x = 0;
        int y = 0;

        if(Greenfoot.getRandomNumber(2) == 1){ //up down
            if(Greenfoot.getRandomNumber(2) == 1){
                x = (int)getShipLocX() + Greenfoot.getRandomNumber(space.getWidth()*2) - space.getWidth();
                y = (int)getShipLocY() + space.getHeight() + Greenfoot.getRandomNumber(750) + 1500;
            }
            else{
                x = (int)getShipLocX() + Greenfoot.getRandomNumber(space.getWidth()*2) - space.getWidth();
                y = (int)getShipLocY() - space.getHeight() - Greenfoot.getRandomNumber(750) - 1500;
            }
        }
        else{ //left right
            if(Greenfoot.getRandomNumber(2) == 1){
                y = (int)getShipLocY() + Greenfoot.getRandomNumber(space.getHeight()*2) - space.getHeight();
                x = (int)getShipLocX() + space.getWidth() + Greenfoot.getRandomNumber(750) + 1500;
            }
            else{
                y = (int)getShipLocY() + Greenfoot.getRandomNumber(space.getHeight()*2) - space.getHeight();
                x = (int)getShipLocX() - space.getWidth() - Greenfoot.getRandomNumber(750) - 1500;
            }

            for(int i = 0; i < numberShips; i++){
                spawnSetupShip(type, difficulty, x, y);
            }
        }
    }

    private void spawnSetupShip(int type, int difficulty, int x, int y){
        Entity ship = null;
        switch(type){
            case Entity.ANY_SHIP:
            spawnSetupShip(Greenfoot.getRandomNumber(Entity.NUMBER_SHIP_TYPES)+1, difficulty, x, y);
            //System.out.println("Any Ship");
            break;

            case Entity.ALIEN_SHIP:
            ship = new AlienShip(x+Greenfoot.getRandomNumber(1000)-500, y+Greenfoot.getRandomNumber(1000)-500);
            //System.out.println("Alien");
            break;

            case Entity.BOMBER_SHIP:
            ship = new BomberShip(x+Greenfoot.getRandomNumber(1000)-500, y+Greenfoot.getRandomNumber(1000)-500);
            //System.out.println("Bomber");
            break;

            default:
            System.out.println("ERROR, NO ACCEPTABLE SHIP TYPE GIVEN TO SPAWN FLEET");
            break;
        }

        if(type != Entity.ANY_SHIP){
            if(difficulty >= 25){
                ship.desiredMode = Entity.ATTACK_MODE;
            }

            if(difficulty >= 50){

            }

            if(difficulty >= 75){
                ship.setMode(Entity.ATTACK_MODE);
            }

            space.addObject(ship, -20, -20);
        }

    }
    //Written by Nathan
    private void initialStarSpawn(int density){
        for(int i = 0; i < 7*density; i++){
            space.addObject(new BackgroundStar(
                    getShipLocX() + Greenfoot.getRandomNumber(space.getWidth()) - space.getWidth()/2,
                    getShipLocY() + Greenfoot.getRandomNumber(space.getHeight()) - space.getHeight()/2
                ),0,0);
        }
    }

    //Generates stars offscreen
    //Written by Nathan
    private void generateStars(int density){
        World world = space;

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

    //Written by Trace
    private void generateNebulas(int density){
        World world = space;

        //Doesn't spawn stars every call, higher density will increase odds
        //Don't spawn more than 120 stars
        if((Greenfoot.getRandomNumber(400)) < 10 && BackgroundStar.getNumStars() < 400){

            //Divide star spawns between up/down and right/left
            if(Greenfoot.getRandomNumber(2)==1){
                //If the ship is going fast enough left/right, spawn a star on one of those sides
                if(Math.abs(getVelX()) > 1.0){ 
                    world.addObject(new Nebula((getSpaceX() + world.getWidth()/2)+((world.getWidth()+10000)*getPosNeg()),
                            (getSpaceY() + world.getHeight()/2)+Greenfoot.getRandomNumber(world.getHeight())),4000*(int)getPosNeg(),-4000*(int)getPosNeg());
                }

            }   
            else{
                //If the ship is going fast enough up/down, spawn a star on one of those sides
                if(Math.abs(getVelY()) > 1.0){
                    world.addObject(new Nebula((getSpaceX() + world.getWidth()/2)+Greenfoot.getRandomNumber(world.getWidth()),
                            (getSpaceY() + world.getHeight()/2)+((world.getHeight()+10000)*getPosNeg())),4000*(int)getPosNeg(),4000*(int)getPosNeg());

                }
            }
        }

    }

    //Written by Nathan
    public void spawnShootingStar(){
        if(Greenfoot.getRandomNumber(shootingStarSpawnChance) == 0){

            space.addObject(new ShootingStar(ship.getShipLocX()+700*getPosNeg(),ship.getShipLocY()+700*getPosNeg(),Greenfoot.getRandomNumber(360)),-10,-10);

        }
    }

    //Written by Nathan
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

    //Written by Nathan
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

    //Written by Nathan
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

    //Written by Nathan
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

    //Written by Nathan
    public void reloadWeapons(){
        space.drawWeaponGUI(projectileEnabled, beamEnabled, missileEnabled, mineEnabled, fireballEnabled, plasmaballEnabled);
    }

    //Written by John
    private void shoot(int LV, int wep)
    {
        beamCharge();
        if (Greenfoot.isKeyDown("c") || rMButton())
        {
            if (mouseAim){
                weaponTimer(getMouseAngle(),LV,wep);
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

    //Written by John
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

    //Written by John
    private void beamChargeBar()
    {
        for (int i=1; i <= beamCharge/15; i++){
            space.addObject(new Beam(0, true, 0, 400, 520),418+i*4,520);
        }
    }

    //Written by John
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

    //Written by John
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

    //Written by Trace
    private void scrollWeapon(){
        weaponType = (int) space.getWeapon();
    }   

    //Written by John
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
    //Written by Trace
    public void checkDeath()
    {
        if(health <= 0)
        {
            if(justDied)
            {
                if(deathDelay <= 0)
                {
                    promptRespawn();
                    space.setPause = true;
                    justDied = false;
                    deathDelay = 10;
                }
                else
                {
                    deathDelay--;
                    deathAnimation();
                    isDead = true;
                }
                //System.out.println("died");
            }
        }
    }

    //Written by Trace
    public static void resetHealth()
    {
        health = MAX_HEALTH;
    }

    //Written by Trace
    public void respawn()
    {

        if(respawnIsPressed)
        {
            resetHealth();
            double myX, myY;
            myX =space.getSectorMiddleX(workingSector);
            myY =space.getSectorMiddleY(workingSector);
            setSpaceX(myX);
            setSpaceY(myY);
            respawnIsPressed = false;
            setLocation(getWorld().getWidth()/2, getWorld().getHeight()/2);
            List<Actor> c = getWorld().getObjects(Cannon.class);
            for(Actor a : c)
            {
                a.setLocation(getWorld().getWidth()/2, getWorld().getHeight()/2);
            }
            explosionTimer = false;
            isDead = false;

            List<Entity> entities = space.getObjects(Entity.class);
            for(Entity entity : entities){
                entity.setHealth(0.0);
            }

            Greenfoot.setWorld(new OuterSpace(myX, myY));
        }
    }

    //Written by Trace
    public void deathAnimation()
    {
        if(!explosionTimer)
        {
            explosionAmount = Greenfoot.getRandomNumber(10) + 5;
            explosionTimer = true;
        }
        //System.out.println(explosionAmount);
        if(explosionAmount > 0)
        {
            int midX = space.getWidth()/2;
            int midY = space.getHeight()/2;
            addExplosion(getSpaceX() + midX + Greenfoot.getRandomNumber(15), getSpaceY() + midY + Greenfoot.getRandomNumber(15), true);  
        }
        setLocation(1000, 1000);
        List<Actor> c = getWorld().getObjects(Cannon.class);
        for(Actor a : c)
        {
            a.setLocation(1000, 1000);
        }

        explosionAmount--;
    }

    //Written by Trace
    public void promptRespawn()
    {
        getWorld().addObject(new RespawnMenu(), getWorld().getWidth()/2, getWorld().getHeight()/2);
        getWorld().addObject(new RespawnButton(), getWorld().getWidth()/2, getWorld().getHeight()/2 + 50);
        RespawnMenuBG menubg = new RespawnMenuBG();
        space.addObject(menubg, space.getWidth()/2, space.getHeight()/2);
        menubg.getImage().scale(OptionsMenu.getWorldWidth(), OptionsMenu.getWorldHeight());
    }

    //Written by Nathan
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
        if(Greenfoot.isKeyDown("l")){
            gold+=100;
            updateGoldScore();
        }
        if(Greenfoot.isKeyDown("o")){
            System.out.println(health);
        }
    }

    //Written by Nathan
    public double getHealth(){
        return health;
    }

    public double getMaxHealth(){
        return maxHealth;
    }

    //Set the health, makes sure you're not setting health over the maximum or under 0
    //Written by Nathan
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
    //Written by Nathan
    public void setMaxHealth(double health){
        if(getHealth() > health){
            setHealth(health);
        }
        else{
            maxHealth = health;
        }

    }

    //Written by Nathan
    public void addHealth(double add){
        setHealth(getHealth()+add);

    }

    public DamageBar getDamageBar(){
        return damageBar;
    }

    /*******************************************************/
    /*********************  MISC  **************************/
    /*******************************************************/

    public static void printLevels(){

        for(int y = 0; y < levelsBeaten.length; y++){
            for(int x = 0; x < levelsBeaten[y].length; x++){
                System.out.print(levelsBeaten[y][x] + " ");
            }
            System.out.println("");
        }
    }

    public static boolean isSectorComplete(int sector){
        boolean com = true;
        for(int y = 0; y < levelsBeaten.length; y++){
            for(int x = 0; x < levelsBeaten[y].length; x++){
                if(x == sector){
                    if(levelsBeaten[y][x] == false){
                        com = false;
                    }
                }
            }

        }
        return com;
    }

    public static int getNextIncompleteLevel(int sector){

        for(int y = 0; y < levelsBeaten.length; y++){
            for(int x = 0; x < levelsBeaten[y].length; x++){
                if(x == sector){
                    if(levelsBeaten[y][x] == false){
                        return y;
                    }
                }
            }

        }
        return -1;
    }

    //Called during the first tick only
    //Some methods require the ship to alrady be spawned to work

    //Written by Nathan
    private void firstTime(){
        if(firstTime){

            if(boostBarLevel > 0){
                space.addObject(new BoostBarOutside(), space.getWidth()/2, space.getHeight()-32);
                space.addObject(new BoostBarInside(), space.getWidth()/2, space.getHeight()-32);
            }

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

    //Written by Nathan
    private void setUpGoldScore(){
        space.addObject(new GoldText(),space.getWidth()-158,22);
        space.addObject(goldNumber, space.getWidth()-65, 18);
    }

    //Written by Nathan
    private void updateGoldScore(){
        if(lastGoldCount != gold){
            goldNumber.remove();
            goldNumber = new Number(gold+"",2);
            space.addObject(goldNumber, space.getWidth()-65, 18);
        }
        lastGoldCount = gold;
    }

    //Private method used for star spawning, returns either 1.0 or -1.0
    //Written by Nathan
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
        return getSpaceX()+space.getWidth()/2;
    }

    public double getShipLocY(){
        return getSpaceY()+space.getHeight()/2;
    }

    private boolean qIsDown;

    //Written by Trace
    public void placeShield()
    {
        if(Greenfoot.isKeyDown("q") && qIsDown)
        {
            getWorld().addObject(new PlayerShield(),space.getWidth()/2, space.getHeight()/2);
        }
        else
        {
            List<PlayerShield> shield = getWorld().getObjects(PlayerShield.class);

            if(shield != null)
            {
                getWorld().removeObjects(shield);
            }
        }
        if(Greenfoot.isKeyDown("q"))
        {
            qIsDown = true;
        }
        if(!Greenfoot.isKeyDown("q"))
        {
            qIsDown = false;
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
