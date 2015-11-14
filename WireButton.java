import greenfoot.*;

/**
 * Write a description of class WireButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WireButton extends WireActivator
{
    public WireButton(){
        this(0);
    }

    public WireButton(int blockType){
        super();
    }
    public void act()
    {
        super.act();
        pressDown();
    }
    public void pressDown()
    {
        Actor a = getOneIntersectingObject(PlatformPlayer.class);
       
        if(a != null)
        {
            Actor buttDown = new WireButtonDown();
            w.addObject(buttDown, getX(), getY());

            w.removeObject(this);
        }
    }
}
