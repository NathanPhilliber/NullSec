import greenfoot.*;

/**
 * Write a description of class Shop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shop extends World
{

    /**
     * Constructor for objects of class ShopBackground.
     * 
     */
    public Shop()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(920, 540, 1, false); 

        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        WeaponShopFG weaponshopfg = new WeaponShopFG();
        addObject(weaponshopfg, 461, 272);
        weaponshopfg.setLocation(460, 272);

        ShopButton weaponbutton = new ShopButton();
        addObject(weaponbutton, 157, 475);

        ShopButton weaponbutton2 = new ShopButton();
        addObject(weaponbutton2, 462, 475);

        ShopButton weaponbutton3 = new ShopButton();
        addObject(weaponbutton3, 755, 475);
        Ship3D ship = new Ship3D();
        addObject(ship, 493, 202);
        ship.setLocation(390, 201);
        ship.setLocation(445, 203);
        Button sidebutton = new Button();
        addObject(sidebutton, 137, 151);
        sidebutton.setLocation(97, 59);
        Button sidebutton2 = new Button();
        addObject(sidebutton2, 65, 96);
        sidebutton2.setLocation(67, 93);
        Button sidebutton3 = new Button();
        addObject(sidebutton3, 62, 133);
        sidebutton3.setLocation(67, 127);
        Button sidebutton4 = new Button();
        addObject(sidebutton4, 71, 178);
        sidebutton4.setLocation(67, 306);
        sidebutton2.setLocation(67, 240);
        sidebutton.setLocation(67, 207);
        Button sidebutton5 = new Button();
        addObject(sidebutton5, 38, 148);
        sidebutton5.setLocation(67, 174);
        Button sidebutton6 = new Button();
        addObject(sidebutton6, 85, 137);
        sidebutton6.setLocation(67, 141);
        Button sidebutton7 = new Button();
        addObject(sidebutton7, 67, 113);
        sidebutton7.setLocation(67, 108);
        sidebutton6.setLocation(67, 273);
        sidebutton3.setLocation(67, 141);
        sidebutton7.setLocation(89, 108);
        WeaponsText weaponstext = new WeaponsText();
        addObject(weaponstext, 84, 48);
        weaponstext.setLocation(427, 502);
        EngineText enginetext = new EngineText();
        addObject(enginetext, 129, 486);
        enginetext.setLocation(121, 503);
        ShieldText shieldtext = new ShieldText();
        addObject(shieldtext, 714, 500);
        shieldtext.setLocation(722, 501);
        enginetext.setLocation(120, 501);
        enginetext.setLocation(121, 501);
        shieldtext.setLocation(721, 503);
        EngineText enginetext2 = new EngineText();
        addObject(enginetext2, 99, 63);
        enginetext2.setLocation(90, 64);
        EngineBars enginebars = new EngineBars();
        addObject(enginebars, 660, 183);
        enginebars.setLocation(663, 175);
        enginebars.setLocation(728, 292);
        enginebars.setLocation(732, 280);

    }
}
