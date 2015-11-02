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
    
    public void select(boolean sel){
        isSelected = sel;
        
        Player.updateAvailableWeapons(myFunction, true);
        
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
