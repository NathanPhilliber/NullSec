import greenfoot.*;

/**
 * Write a description of class LevelUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelUpButton extends WeaponShop
{
    public int myFunction = 0;
    public boolean isSelected = false;

    public int type = 0;

    public static final int ENGINE = 1;
    public static final int WEAPON = 0;
    public static final int SHIELD = 2;

    public LevelUpButton(int i, int type){
        this(i);
        this.type = type;
    }

    public LevelUpButton(int i){
        setImage("images/LevelUp.png");
        myFunction = i;

    } 

    public void updateImage(){
        if(type == WEAPON){
            if(Player.gold >= Weapon.getWeaponCost(myFunction, Player.getWeaponLevel(myFunction))){
                setImage("images/LevelUp.png");
            }
            else{
                setImage("images/LevelUpGray.png");
            }
        }
        else if(type == ENGINE){
            if(Player.gold >= Player.getNextEngineCost(myFunction)){
                setImage("images/LevelUp.png");
            }
            else{
                setImage("images/LevelUpGray.png");
            }
        }
    }

    public void select(boolean sel){
        
        isSelected = sel;

        if(isSelected){
            if(type == WEAPON){
                if(Player.gold >= Weapon.getWeaponCost(myFunction, Player.getWeaponLevel(myFunction))){
                    Player.gold -= Weapon.getWeaponCost(myFunction, Player.getWeaponLevel(myFunction));
                    Player.updateAvailableWeapons(myFunction, true);

                    switch(myFunction){
                        case 0:
                        Player.projectileLevel++;
                        break;
                        case 1:
                        Player.beamLevel++;
                        break;
                        case 2:
                        Player.missileLevel++;
                        break;
                        case 3:
                        Player.mineLevel++;
                        break;
                        case 4:
                        Player.fireballLevel++;
                        break;
                        case 5:
                        Player.plasmaLevel++;
                        break;

                    }

                    Shop shop = (Shop) getWorld();
                    shop.reloadCurrentCenter();
                }
            }
            else if(type == ENGINE){
                try{
                    
                    if(Player.gold >= Player.getNextEngineCost(myFunction)){
                        Player.gold -= Player.getNextEngineCost(myFunction);

                        switch(myFunction){
                            case 0:
                            Player.speedLevel++;
                            break;

                            case 1:
                            Player.turnSpeedLevel++;
                            break;

                            case 2:
                            Player.boostBarLevel++;
                            break;
                        }

                        Shop shop = (Shop) getWorld();
                        shop.reloadCurrentCenter();
                    }
                } catch(ArrayIndexOutOfBoundsException e){
                    
                }
            }
        }
    }

    public void act() 
    {
        if(Greenfoot.mousePressed(null)){
            if(Greenfoot.mousePressed(this)){
                select(true);
            }
            else{
                select(false);
            }
        }

    } 
}
