import greenfoot.*;

/**
 * Write a description of class ShopButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShopButton extends WeaponShop
{
    public boolean isSelected = false;
    public int myFunction = 0;

    public ShopButton(int fun){
        myFunction = fun;
        setImage("images/ButtonShop.png");
    }

    public void select(boolean sel){
        isSelected = sel;
        if(isSelected){
            setImage("images/ButtonShopHover.png");
            shop.setPanel(myFunction);
            
        }
        else{
            setImage("images/ButtonShop.png");
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
