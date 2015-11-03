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

    public LevelUpButton(int i){
        setImage("images/LevelUp.png");
        myFunction = i;
    } 
    
    public void select(boolean sel){
        isSelected = sel;

        if(isSelected){
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
