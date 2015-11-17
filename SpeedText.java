import greenfoot.*;

/**
 * Write a description of class SpeedText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpeedText extends WeaponShop
{
    /**
     * Act - do whatever the SpeedText wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public SpeedText(){
        setImage("images/SpeedText.png");
    }
    public void act() 
    {
        if(Greenfoot.mousePressed(this)){
           
            shop.sideButton.select(true);
        }
    }    
}
