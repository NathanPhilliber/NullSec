import greenfoot.*;

/**
 * Write a description of class Shop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shop extends World
{
    WeaponShopFG weaponShopFg = new WeaponShopFG();
    ShopButton weaponButton = new ShopButton(WeaponShop.ENGINE);
    ShopButton weaponButton2 = new ShopButton(WeaponShop.WEAPONS);
    ShopButton weaponButton3 = new ShopButton(WeaponShop.SHIELD);
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

    CostText costtext = new CostText();

    WeaponsText weaponsText = new WeaponsText();
    EngineText engineText = new EngineText();
    ShieldText shieldText = new ShieldText();

    LaserDes laserdes = new LaserDes();
    BeamDes beamdes = new BeamDes();
    MissileDes missiledes = new MissileDes();
    MineDes minedes = new MineDes();
    FireballDes fireballdes = new FireballDes();
    PlasmaDes plasmades = new PlasmaDes();

    EngineText engineText2 = new EngineText();
    WeaponsText weaponText2 = new WeaponsText();
    ShieldText shieldText2 = new ShieldText();

    LaserText lasertext = new LaserText();
    BeamText beamtext = new BeamText();
    MissileText missiletext = new MissileText();
    MineText minetext = new MineText();
    FireballText fireballtext = new FireballText();
    PlasmaText plasmatext = new PlasmaText();

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

    public void assembleShield(){
        addObject(shieldText2, 99, 63);
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
        else if(currentPanel == WeaponShop.SHIELD){
            assembleShield();
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
        if(currentPanel == WeaponShop.ENGINE){
            switch(i){
                case 0:
                addObject(engineBars, 732, 280);
                addObject(ship, 445, 203);

                break;
                case 1:

                break;
                case 2:

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

            addObject(goldtext, 382, 30);
            goldNumber = new Number(Player.gold + "",1);
            addObject(goldNumber, 480, 25);

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
                addObject(lasertext2, getWidth()/2+150, 70);
                addObject(laserdes, 599, 153);
                if(!Player.projectileEnabled){
                    addObject(unlock0, getWidth()/2+150, getHeight()/2+15); 
                    addObject(costtext, 544,247);
                    costNumber = new Number(Weapon.PROJECTILE_COST[Player.projectileLevel]+"", 1);
                    addObject(costNumber, 610,240); 

                }
                else{
                    levelNumber = new Number(Player.projectileLevel + "");
                    addObject(levelNumber, getWidth()/2+150-50, 270);
                    addObject(leveltext, getWidth()/2+15-50, 270);

                    if(Weapon.PROJECTILE_COST.length > Player.projectileLevel){
                        addObject(levelup0, getWidth()/2+320, getHeight()/2+15);
                        addObject(costtext, 712,245);
                        costNumber = new Number(Weapon.PROJECTILE_COST[Player.projectileLevel]+"", 1);
                        addObject(costNumber, 775,240); 
                    }

                }
                break;
                case 1:
                addObject(beamtext2, getWidth()/2+150, 70);
                addObject(beamdes, 607, 157);

                if(!Player.beamEnabled){
                    addObject(unlock1, getWidth()/2+150, getHeight()/2+15);
                    addObject(costtext, 544,247);
                    costNumber = new Number(Weapon.BEAM_COST[Player.beamLevel]+"", 1);
                    addObject(costNumber, 610,240); 
                }
                else{
                    levelNumber = new Number(Player.beamLevel + "");
                    addObject(levelNumber, getWidth()/2+150-50, 270);
                    addObject(leveltext, getWidth()/2+15-50, 270);
                    if(Weapon.BEAM_COST.length > Player.beamLevel){
                        addObject(levelup1, getWidth()/2+320, getHeight()/2+15);
                        addObject(costtext, 712,245);
                        costNumber = new Number(Weapon.BEAM_COST[Player.beamLevel]+"", 1);
                        addObject(costNumber, 775,240); 
                    }

                }
                break;
                case 2:
                addObject(missiletext2, getWidth()/2+150, 70);
                addObject(missiledes, 607, 157);
                if(!Player.missileEnabled){
                    addObject(unlock2, getWidth()/2+150, getHeight()/2+15);
                    addObject(costtext, 544,247);
                    costNumber = new Number(Weapon.MISSILE_COST[Player.missileLevel]+"", 1);
                    addObject(costNumber, 610,240); 
                }
                else{
                    levelNumber = new Number(Player.missileLevel + "");
                    addObject(levelNumber, getWidth()/2+150-50, 270);
                    addObject(leveltext, getWidth()/2+15-50, 270);

                    if(Weapon.MISSILE_COST.length > Player.missileLevel){
                        addObject(levelup2, getWidth()/2+320, getHeight()/2+15);
                        addObject(costtext, 712,245);
                        costNumber = new Number(Weapon.MISSILE_COST[Player.missileLevel]+"", 1);
                        addObject(costNumber, 775,240); 
                    }

                }
                break;
                case 3:
                addObject(minetext2, getWidth()/2+150, 70);
                addObject(minedes, 607, 157);
                if(!Player.mineEnabled){
                    addObject(unlock3, getWidth()/2+150, getHeight()/2+15);
                    addObject(costtext, 544,247);
                    costNumber = new Number(Weapon.MINE_COST[Player.mineLevel]+"", 1);
                    addObject(costNumber, 610,240); 
                }
                else{
                    levelNumber = new Number(Player.mineLevel + "");
                    addObject(levelNumber, getWidth()/2+150-50, 270);
                    addObject(leveltext, getWidth()/2+15-50, 270);

                    if(Weapon.MINE_COST.length > Player.mineLevel){
                        addObject(levelup3, getWidth()/2+320, getHeight()/2+15);
                        addObject(costtext, 712,245);
                        costNumber = new Number(Weapon.MINE_COST[Player.mineLevel]+"", 1);
                        addObject(costNumber, 775,240); 
                    }

                }
                break;
                case 4:
                addObject(fireballtext2, getWidth()/2+150, 70);
                addObject(fireballdes, 607, 157);
                if(!Player.fireballEnabled){
                    addObject(unlock4, getWidth()/2+150, getHeight()/2+15);
                    addObject(costtext, 544,247);
                    costNumber = new Number(Weapon.FIREBALL_COST[Player.fireballLevel]+"", 1);
                    addObject(costNumber, 610,240); 
                }
                else{
                    levelNumber = new Number(Player.fireballLevel + "");
                    addObject(levelNumber, getWidth()/2+150-50, 270);
                    addObject(leveltext, getWidth()/2+15-50, 270);

                    if(Weapon.FIREBALL_COST.length > Player.fireballLevel){
                        addObject(levelup4, getWidth()/2+320, getHeight()/2+15);
                        addObject(costtext, 712,245);
                        costNumber = new Number(Weapon.FIREBALL_COST[Player.fireballLevel]+"", 1);
                        addObject(costNumber, 775,240); 
                    }

                }
                break;
                case 5:
                addObject(plasmatext2, getWidth()/2+150, 70);
                addObject(plasmades, 607, 157);
                if(!Player.plasmaballEnabled){
                    addObject(unlock5, getWidth()/2+150, getHeight()/2+15);
                    addObject(costtext, 544,247);
                    costNumber = new Number(Weapon.PLASMA_COST[Player.plasmaLevel]+"", 1);
                    addObject(costNumber, 610,240); 
                }
                else{
                    levelNumber = new Number(Player.plasmaLevel + "");
                    addObject(levelNumber, getWidth()/2+150-50, 270);
                    addObject(leveltext, getWidth()/2+15-50, 270);

                    if(Weapon.PLASMA_COST.length > Player.plasmaLevel){
                        addObject(levelup5, getWidth()/2+320, getHeight()/2+15);
                        addObject(costtext, 712,245);
                        costNumber = new Number(Weapon.PLASMA_COST[Player.plasmaLevel]+"", 1);
                        addObject(costNumber, 775,240); 
                    }

                }
                break;

            }
        }
        else if(currentPanel == WeaponShop.SHIELD){

            switch(i){
                case 0:

                break;
                case 1:

                break;
                case 2:

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
    }

    private void removeCurrentCenter(){

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
        else if(currentPanel == WeaponShop.SHIELD){
            removeObject(shieldText2);
        }
    }

    

    private void prepare()
    {
        addObject(levelNumber, -100, -100);

        addObject(weaponShopFg, 460, 272);

        addObject(weaponButton, 157, 475);

        addObject(weaponButton2, 462, 475);

        addObject(weaponButton3, 755, 475);
        addObject(shopBackButton,851,22);

        addObject(sideButton4, 67, 207);
        addObject(sideButton5, 67, 240);
        addObject(sideButton2, 67, 141);
        addObject(sideButton7, 67, 306);
        addObject(sideButton3, 67, 174);
        addObject(sideButton6, 67, 273);
        addObject(sideButton, 67, 108);
        addObject(weaponsText, 427, 502);
        addObject(engineText, 121, 501);
        addObject(shieldText, 721, 503);
        setPanel(0);

    }
}
