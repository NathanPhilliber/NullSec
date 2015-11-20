import greenfoot.*;

/**
 * Write a description of class GotoShopButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GotoShopButton extends Menu
{
    public GotoShopButton(){
        super();
        setImage("images/GotoShop.png");
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
    
    public void select(boolean sel){
        GreenfootSound ding = new GreenfootSound("sounds/buttonSound.wav");
            ding.play();
        if(sel){
            Space space = (Space) getWorld();
            Ship ship = space.getShip();
            Greenfoot.setWorld(new Shop(ship.getSpaceX(), ship.getSpaceY()));
        }
    }  
}
