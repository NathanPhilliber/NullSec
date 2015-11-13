import greenfoot.*;

/**
 * Write a description of class WireButtonOff here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WireButtonDown extends WireActivator
{
    private int delay = 150;
    
    public WireButtonDown(){
        this(0);
    }

    public WireButtonDown(int blockType){
        super();
    }
    public void act()
    {
        super.act();
        if(delay <= 0)
        {
            Actor butt = new WireButton();
            getWorld().addObject(butt, getX(), getY());

            getWorld().removeObject(this);
        }
        delay--;
    }
}
