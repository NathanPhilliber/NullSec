import greenfoot.*;

/**
 * Write a description of class TurnSpeedText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TurnSpeedText extends WeaponShop
{
    public TurnSpeedText(){
        setImage("images/TurnSpeedText.png");
    }
    public void act() 
    {
        if(Greenfoot.mousePressed(this)){
           
            shop.sideButton2.select(true);
        }
    }    
}
