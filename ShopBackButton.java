import greenfoot.*;

/**
 * Write a description of class ShopBackButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShopBackButton extends Menu
{
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
    
    public void select(boolean sel){
        if(sel){
            Shop shop = (Shop) getWorld();
            shop.exit();
        }
    }   
}
