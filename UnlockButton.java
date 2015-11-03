import greenfoot.*;

/**
 * Write a description of class UnlockButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UnlockButton extends WeaponShop
{

    public int myFunction = 0;
    public boolean isSelected = false;

    public UnlockButton(int i){
        setImage("images/UnlockButton.png");
        myFunction = i;
    }
    
    public void updateImage(){
        if(Player.gold >= Weapon.getWeaponCost(myFunction, Player.getWeaponLevel(myFunction))){
            setImage("images/UnlockButton.png");
        }
        else{
            setImage("images/UnlockButtonGray.png");
        }
    }

    public void select(boolean sel){
        isSelected = sel;

        if(isSelected){

            if(Player.gold >= Weapon.getWeaponCost(myFunction, Player.getWeaponLevel(myFunction))){
                Player.gold -= Weapon.getWeaponCost(myFunction, Player.getWeaponLevel(myFunction));
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
                Player.updateAvailableWeapons(myFunction, true);
                Shop shop = (Shop) getWorld();
                shop.reloadCurrentCenter();
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
