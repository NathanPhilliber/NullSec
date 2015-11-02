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

    WeaponsText weaponsText = new WeaponsText();
    EngineText engineText = new EngineText();
    ShieldText shieldText = new ShieldText();

    EngineText engineText2 = new EngineText();
    WeaponsText weaponText2 = new WeaponsText();
    ShieldText shieldText2 = new ShieldText();

    LaserText lasertext = new LaserText();
    BeamText beamtext = new BeamText();
    MissileText missiletext = new MissileText();
    MineText minetext = new MineText();
    FireballText fireballtext = new FireballText();
    PlasmaText plasmatext = new PlasmaText();

    EngineBars engineBars = new EngineBars();

    public int currentPanel = 0;
    public int currentButton = 0;

    public void act(){
        if(Greenfoot.isKeyDown("q")){
            Greenfoot.setWorld(new OuterSpace());
        }
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

            switch(i){
                case 0:
                if(!Player.projectileEnabled){
                    addObject(unlock0, getWidth()/2+150, getHeight()/2+15);
                }
                break;
                case 1:
                if(!Player.beamEnabled){
                    addObject(unlock1, getWidth()/2+150, getHeight()/2+15);
                }
                break;
                case 2:
                if(!Player.missileEnabled){
                    addObject(unlock2, getWidth()/2+150, getHeight()/2+15);
                }
                break;
                case 3:
                if(!Player.mineEnabled){
                    addObject(unlock3, getWidth()/2+150, getHeight()/2+15);
                }
                break;
                case 4:
                if(!Player.fireballEnabled){
                    addObject(unlock4, getWidth()/2+150, getHeight()/2+15);
                }
                break;
                case 5:
                if(!Player.plasmaballEnabled){
                    addObject(unlock5, getWidth()/2+150, getHeight()/2+15);
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

    public Shop()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(OptionsMenu.getWorldWidth(), OptionsMenu.getWorldHeight(), 1, false); 

        prepare();
    }

    private void prepare()
    {

        addObject(weaponShopFg, 460, 272);

        addObject(weaponButton, 157, 475);

        addObject(weaponButton2, 462, 475);

        addObject(weaponButton3, 755, 475);

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
