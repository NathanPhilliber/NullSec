import greenfoot.*;

/*
 * Written by Nathan
 * Graphics by Trace
 */

public class Shop extends World
{
    WeaponShopFG weaponShopFg = new WeaponShopFG();
    ShopButton weaponButton = new ShopButton(WeaponShop.ENGINE);
    ShopButton weaponButton2 = new ShopButton(WeaponShop.WEAPONS);
    
    Ship3D ship = new Ship3D();
    Button sideButton = new Button(0);
    Button sideButton2 = new Button(1);
    Button sideButton3 = new Button(2);
    Button sideButton4 = new Button(3);
    Button sideButton5 = new Button(4);
    Button sideButton6 = new Button(5);
    Button sideButton7 = new Button(6);

    UnlockButton unlock0 = new UnlockButton(0);
    UnlockButton unlock1 = new UnlockButton(1);
    UnlockButton unlock2 = new UnlockButton(2);
    UnlockButton unlock3 = new UnlockButton(3);
    UnlockButton unlock4 = new UnlockButton(4);
    UnlockButton unlock5 = new UnlockButton(5);

    LevelUpButton levelup0 = new LevelUpButton(0);
    LevelUpButton levelup1 = new LevelUpButton(1);
    LevelUpButton levelup2 = new LevelUpButton(2);
    LevelUpButton levelup3 = new LevelUpButton(3);
    LevelUpButton levelup4 = new LevelUpButton(4);
    LevelUpButton levelup5 = new LevelUpButton(5);

    LevelUpButton levelupengine0 = new LevelUpButton(0, 1);
    LevelUpButton levelupengine1 = new LevelUpButton(1, 1);
    LevelUpButton levelupengine2 = new LevelUpButton(2, 1);

    CostText costtext = new CostText();

    WeaponsText weaponsText = new WeaponsText();
    EngineText engineText = new EngineText();

    LaserDes laserdes = new LaserDes();
    BeamDes beamdes = new BeamDes();
    MissileDes missiledes = new MissileDes();
    MineDes minedes = new MineDes();
    FireballDes fireballdes = new FireballDes();
    PlasmaDes plasmades = new PlasmaDes();

    EngineText engineText2 = new EngineText();
    WeaponsText weaponText2 = new WeaponsText();

    SpeedText speedtext = new SpeedText();
    TurnSpeedText turnspeedtext = new TurnSpeedText();
    BoostBarText boostbartext = new BoostBarText();

    LaserText lasertext = new LaserText();
    BeamText beamtext = new BeamText();
    MissileText missiletext = new MissileText();
    MineText minetext = new MineText();
    FireballText fireballtext = new FireballText();
    PlasmaText plasmatext = new PlasmaText();

    SpeedDes speeddes = new SpeedDes();
    TurnSpeedDes turnspeeddes = new TurnSpeedDes();
    BoostBarDes boostbardes = new BoostBarDes();

    LaserText lasertext2 = new LaserText();
    BeamText beamtext2 = new BeamText();
    MissileText missiletext2 = new MissileText();
    MineText minetext2 = new MineText();
    FireballText fireballtext2 = new FireballText();
    PlasmaText plasmatext2 = new PlasmaText();

    EngineBars engineBars = new EngineBars();

    LevelText leveltext = new LevelText();
    Number levelNumber = new Number("0");
    Number costNumber = new Number("0", 1);
    Number goldNumber = new Number("0", 1);

    GoldText goldtext = new GoldText();
    ShopBackButton shopBackButton = new ShopBackButton();

    public int currentPanel = 0;
    public int currentButton = 0;

    private double returnX, returnY;

    public Shop(){
        this(0,0);
    }

    public Shop(double x, double y){
        super(OptionsMenu.getWorldWidth(), OptionsMenu.getWorldHeight(), 1, false); 
        returnX = x;
        returnY = y;
        prepare();
        GreenfootImage background = new GreenfootImage("Background.png");
        background.scale(OptionsMenu.getWorldWidth(),  OptionsMenu.getWorldHeight());
        setBackground(background);

    }

    public void act(){
        if(Greenfoot.isKeyDown("q")){
            exit();
        }
    }

    public void exit(){
        Greenfoot.setWorld(new OuterSpace(returnX, returnY));
    }

    public void assembleEngine(){
        addObject(engineText2, 99, 63);
        addObject(speedtext, 73, 111);
        addObject(turnspeedtext, 75, 142);
        addObject(boostbartext, 75, 176);
    }

    public void assembleWeapons(){
        addObject(weaponText2, 99, 63);
        addObject(lasertext, 74, 111);
        addObject(beamtext, 77, 143);
        addObject(missiletext, 74, 176);
        addObject(minetext, 73, 209);
        addObject(fireballtext, 78, 242);
        addObject(plasmatext, 76, 276);
    }

    public void setPanel(int i){
        removeCurrentText();
        currentPanel = i;
        setButton(0);

        if(currentPanel == WeaponShop.ENGINE){
            assembleEngine();
        }
        else if(currentPanel == WeaponShop.WEAPONS){
            assembleWeapons();

        }
    }

    public void setButton(int i){
        removeCurrentCenter();
        currentButton = i;
        setCurrentCenter(i);

    }

    public void reloadCurrentCenter(){
        removeCurrentCenter();
        setCurrentCenter(currentButton);
    }

    public void setCurrentCenter(int i){
        addObject(goldtext, getWidth()-538, 30);
        goldNumber = new Number(Player.gold + "",1);
        addObject(goldNumber,  getWidth()-440, 25);
        if(currentPanel == WeaponShop.ENGINE){

            try{

                levelupengine0.updateImage();
                levelupengine1.updateImage();
                levelupengine2.updateImage();

            } catch(ArrayIndexOutOfBoundsException e){

            }

            switch(i){
                case 0:

                addObject(ship, (int) (getWidth()*.45), (int) (getHeight()*.36));
                addObject(speeddes, (int)(getWidth()*.57), 210);

                addObject(costtext, (int) (getWidth()*.63),247);
                costNumber = new Number(Player.SPEED_COST[Player.speedLevel]+"", 1);
                addObject(costNumber, (int)(getWidth()*.66),240); 

                addObject(costNumber, (int) (getWidth()*.599),247); 

                addObject(levelupengine0, (int) (getWidth()*.83), 250);


                levelNumber = new Number(Player.speedLevel + "");
                addObject(levelNumber, getWidth()/2+150-50, getHeight()/2);
                addObject(leveltext, getWidth()/2+15-50, getHeight()/2);

                break;
                case 1:

                addObject(ship, (int) (getWidth()*.45), (int) (getHeight()*.36));
                addObject(turnspeeddes, (int)(getWidth()*.57), 210);

                addObject(costtext, (int) (getWidth()*.591),247);
                costNumber = new Number(Player.TURN_SPEED_COST[Player.turnSpeedLevel]+"", 1);
                addObject(costNumber, (int)(getWidth()*.66),240); 

                addObject(levelupengine1, (int) (getWidth()*.83), 250);

                levelNumber = new Number(Player.turnSpeedLevel + "");
                addObject(levelNumber, getWidth()/2+150-50, getHeight()/2);
                addObject(leveltext, getWidth()/2+15-50, getHeight()/2);

                break;
                case 2:

                addObject(ship, (int) (getWidth()*.45), (int) (getHeight()*.36));
                addObject(boostbardes, (int)(getWidth()*.70), 110);

                addObject(costtext, (int) (getWidth()*.591),247);
                costNumber = new Number(Player.BOOST_BAR_COST[Player.boostBarLevel]+"", 1);
                addObject(costNumber, (int)(getWidth()*.66),240); 

                addObject(levelupengine2, (int) (getWidth()*.83), 250);

                levelNumber = new Number(Player.boostBarLevel + "");
                addObject(levelNumber, getWidth()/2+150-50, getHeight()/2);
                addObject(leveltext, getWidth()/2+15-50, getHeight()/2);

                break;
                case 3:

                break;
                case 4:

                break;
                case 5:

                break;
                case 6:

                break;

            }
        }
        else if(currentPanel == WeaponShop.WEAPONS){

            try{
                unlock0.updateImage();
                unlock1.updateImage();
                unlock2.updateImage();
                unlock3.updateImage();
                unlock4.updateImage();
                unlock5.updateImage();

                levelup0.updateImage();
                levelup1.updateImage();
                levelup2.updateImage();
                levelup3.updateImage();
                levelup4.updateImage();
                levelup5.updateImage();
            } catch(ArrayIndexOutOfBoundsException e){

            }

            switch(i){
                case 0:
                addObject(lasertext2, (int)(getWidth()*.62), 80);
                addObject(laserdes, (int)(getWidth()*.62), 153);
                if(!Player.projectileEnabled){
                    addObject(unlock0, (int) (getWidth()*.85), getHeight()/2+15); 
                    addObject(costtext, (int)(getWidth()*.59) ,235);
                    costNumber = new Number(Weapon.PROJECTILE_COST[Player.projectileLevel]+"", 1);
                    addObject(costNumber, (int)(getWidth()*.66),230); 

                }
                else{
                    levelNumber = new Number(Player.projectileLevel + "");
                    addObject(levelNumber, (int)(getWidth()*.65), getHeight()/2);
                    addObject(leveltext, (int)(getWidth()*.50), getHeight()/2);

                    if(Weapon.PROJECTILE_COST.length > Player.projectileLevel){
                        addObject(levelup0, (int) (getWidth()*.85), getHeight()/2+15);
                        addObject(costtext, (int)(getWidth()*.59) ,235);
                        costNumber = new Number(Weapon.PROJECTILE_COST[Player.projectileLevel]+"", 1);
                        addObject(costNumber, (int)(getWidth()*.66),230); 
                    }

                }
                break;
                case 1:
                addObject(beamtext2,(int)(getWidth()*.62), 80);
                addObject(beamdes, (int)(getWidth()*.62), 157);

                if(!Player.beamEnabled){
                    addObject(unlock1, (int) (getWidth()*.85), getHeight()/2+15);
                    addObject(costtext, (int)(getWidth()*.59) ,235);
                    costNumber = new Number(Weapon.BEAM_COST[Player.beamLevel]+"", 1);
                    addObject(costNumber, (int)(getWidth()*.66),230); 
                }
                else{
                    levelNumber = new Number(Player.beamLevel + "");
                    addObject(levelNumber, (int)(getWidth()*.65), getHeight()/2);
                    addObject(leveltext, (int)(getWidth()*.50), getHeight()/2);
                    if(Weapon.BEAM_COST.length > Player.beamLevel){
                        addObject(levelup1,(int) (getWidth()*.85), getHeight()/2+15);
                        addObject(costtext, (int)(getWidth()*.59) ,235);
                        costNumber = new Number(Weapon.BEAM_COST[Player.beamLevel]+"", 1);
                        addObject(costNumber, (int)(getWidth()*.66),230); 
                    }

                }
                break;
                case 2:
                addObject(missiletext2, (int)(getWidth()*.62),80);
                addObject(missiledes, (int)(getWidth()*.62), 157);
                if(!Player.missileEnabled){
                    addObject(unlock2, (int) (getWidth()*.85), getHeight()/2+15);
                    addObject(costtext, (int)(getWidth()*.59) ,235);
                    costNumber = new Number(Weapon.MISSILE_COST[Player.missileLevel]+"", 1);
                    addObject(costNumber, (int)(getWidth()*.66),230); 
                }
                else{
                    levelNumber = new Number(Player.missileLevel + "");
                    addObject(levelNumber,(int)(getWidth()*.65), getHeight()/2);
                    addObject(leveltext, (int)(getWidth()*.50), getHeight()/2);

                    if(Weapon.MISSILE_COST.length > Player.missileLevel){
                        addObject(levelup2, (int) (getWidth()*.85), getHeight()/2+15);
                        addObject(costtext, (int)(getWidth()*.59) ,235);
                        costNumber = new Number(Weapon.MISSILE_COST[Player.missileLevel]+"", 1);
                        addObject(costNumber, (int)(getWidth()*.66),230); 
                    }

                }
                break;
                case 3:
                addObject(minetext2, (int)(getWidth()*.62), 80);
                addObject(minedes,(int)(getWidth()*.62), 157);
                if(!Player.mineEnabled){
                    addObject(unlock3, (int) (getWidth()*.85), getHeight()/2+15);
                    addObject(costtext, (int)(getWidth()*.59) ,235);
                    costNumber = new Number(Weapon.MINE_COST[Player.mineLevel]+"", 1);
                    addObject(costNumber, (int)(getWidth()*.66),230); 
                }
                else{
                    levelNumber = new Number(Player.mineLevel + "");
                    addObject(levelNumber, (int)(getWidth()*.65), getHeight()/2);
                    addObject(leveltext, (int)(getWidth()*.50), getHeight()/2);

                    if(Weapon.MINE_COST.length > Player.mineLevel){
                        addObject(levelup3, (int) (getWidth()*.85), getHeight()/2+15);
                        addObject(costtext, (int)(getWidth()*.59) ,235);
                        costNumber = new Number(Weapon.MINE_COST[Player.mineLevel]+"", 1);
                        addObject(costNumber, (int)(getWidth()*.66),230); 
                    }

                }
                break;
                case 4:
                addObject(fireballtext2, (int)(getWidth()*.62), 80);
                addObject(fireballdes, (int)(getWidth()*.62), 157);
                if(!Player.fireballEnabled){
                    addObject(unlock4, (int) (getWidth()*.85), getHeight()/2+15);
                    addObject(costtext, (int)(getWidth()*.59) ,235);
                    costNumber = new Number(Weapon.FIREBALL_COST[Player.fireballLevel]+"", 1);
                    addObject(costNumber, (int)(getWidth()*.66),230); 
                }
                else{
                    levelNumber = new Number(Player.fireballLevel + "");
                    addObject(levelNumber, (int)(getWidth()*.65), getHeight()/2);
                    addObject(leveltext, (int)(getWidth()*.50), getHeight()/2);

                    if(Weapon.FIREBALL_COST.length > Player.fireballLevel){
                        addObject(levelup4, (int) (getWidth()*.85), getHeight()/2+15);
                        addObject(costtext, (int)(getWidth()*.59) ,235);
                        costNumber = new Number(Weapon.FIREBALL_COST[Player.fireballLevel]+"", 1);
                        addObject(costNumber, (int)(getWidth()*.66),230); 
                    }

                }
                break;
                case 5:
                addObject(plasmatext2, (int)(getWidth()*.62), 80);
                addObject(plasmades, (int)(getWidth()*.62), 157);
                if(!Player.plasmaballEnabled){
                    addObject(unlock5, (int) (getWidth()*.85), getHeight()/2+15);
                    addObject(costtext, (int)(getWidth()*.59) ,235);
                    costNumber = new Number(Weapon.PLASMA_COST[Player.plasmaLevel]+"", 1);
                    addObject(costNumber, (int)(getWidth()*.66),230);  
                }
                else{
                    levelNumber = new Number(Player.plasmaLevel + "");
                    addObject(levelNumber, (int)(getWidth()*.65), getHeight()/2);
                    addObject(leveltext, (int)(getWidth()*.50), getHeight()/2);

                    if(Weapon.PLASMA_COST.length > Player.plasmaLevel){
                        addObject(levelup5, (int) (getWidth()*.85), getHeight()/2+15);
                        addObject(costtext, (int)(getWidth()*.59) ,235);
                        costNumber = new Number(Weapon.PLASMA_COST[Player.plasmaLevel]+"", 1);
                        addObject(costNumber, (int)(getWidth()*.66),230); 
                    }

                }
                break;

            }
        }
    }

    private void removeCurrentCenter(){

        removeObject(speeddes);
        removeObject(turnspeeddes);
        removeObject(boostbardes);

        removeObject(ship);
        removeObject(engineBars);
        removeObject(unlock0);
        removeObject(unlock1);
        removeObject(unlock2);
        removeObject(unlock3);
        removeObject(unlock4);
        removeObject(unlock5);
        removeObject(lasertext2);
        removeObject(beamtext2);
        removeObject(missiletext2);
        removeObject(minetext2);
        removeObject(fireballtext2);
        removeObject(plasmatext2);

        removeObject(leveltext);
        removeObject(levelup0);
        removeObject(levelup1);
        removeObject(levelup2);
        removeObject(levelup3);
        removeObject(levelup4);
        removeObject(levelup5);

        removeObject(levelupengine0);
        removeObject(levelupengine1);
        removeObject(levelupengine2);

        removeObject(costtext);

        removeObject(laserdes);
        removeObject(beamdes);
        removeObject(missiledes);
        removeObject(minedes);
        removeObject(fireballdes);
        removeObject(plasmades);

        addObject(levelNumber, -100, -100); //add object because it must exist to remove it
        levelNumber.remove();

        addObject(costNumber, -100, -100); //add object because it must exist to remove it
        costNumber.remove();

        removeObject(goldtext);
        addObject(goldNumber, -100, -100); //add object because it must exist to remove it
        goldNumber.remove();
    }

    private void removeCurrentText(){
        if(currentPanel == WeaponShop.ENGINE){
            removeObject(engineText2);
            removeObject(speedtext);
            removeObject(turnspeedtext);
            removeObject(boostbartext);
        }
        else if(currentPanel == WeaponShop.WEAPONS){
            removeObject(weaponText2);
            removeObject(lasertext);
            removeObject(beamtext);
            removeObject(missiletext);
            removeObject(minetext);
            removeObject(fireballtext);
            removeObject(plasmatext);
        }
    }

    private void prepare()
    {
        addObject(levelNumber, -100, -100);

        weaponShopFg.getImage().scale(getWidth(), getHeight());
        addObject(weaponShopFg, getWidth()/2, getHeight()/2);

        addObject(weaponButton, (int) Math.round(getWidth()*0.25), getHeight()-65);

        addObject(weaponButton2, (int) Math.round(getWidth()*0.75), getHeight()-65);

        addObject(shopBackButton,getWidth()-69,22);

        addObject(sideButton4, 67, 207);
        addObject(sideButton5, 67, 240);
        addObject(sideButton2, 67, 141);
        addObject(sideButton7, 67, 306);
        addObject(sideButton3, 67, 174);
        addObject(sideButton6, 67, 273);
        addObject(sideButton, 67, 108);

        addObject(weaponsText, (int)(getWidth()*0.75), getHeight()-40);
        addObject(engineText, (int)(getWidth()*0.25), getHeight()-40);
        setPanel(0);

    }
}
