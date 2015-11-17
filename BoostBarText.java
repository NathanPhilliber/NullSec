import greenfoot.*;

/**
 * Write a description of class BoostBarText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoostBarText extends WeaponShop
{
    public BoostBarText(){
        setImage("images/BoostBarText.png");
    }
    public void act() 
    {
        if(Greenfoot.mousePressed(this)){
           
            shop.sideButton3.select(true);
        }
    }    
}
