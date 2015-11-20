import greenfoot.*;

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends WeaponShop
{

    public boolean isSelected = false;
    public int myFunction = 0;

    public int selDistX;
    public int distX;

    public Button(int i){
        myFunction = i;

    }

    public void addedToWorld(World world){
        super.addedToWorld(world);
        selDistX = getX() + 35;
        distX = getX();
        
        
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
        

        isSelected = sel;

        if(isSelected){
            setLocation(selDistX, getY());
            shop.setButton(myFunction);
        }
        else{
            setLocation(distX, getY());
        }

    }
}
