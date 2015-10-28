import greenfoot.*;

/**
 * Write a description of class PortalProjectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PortalProjectile extends PortalWorld
{
    /**
     * Act - do whatever the PortalProjectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move(20);  
    }
    public PortalProjectile(int c)
    {
        if(c == 1)
        {
            setImage("bulletOrange.png");
        }
        if(c == 2)
        {
            setImage("bulletBlue.png");
        }
    }
    public void placePortalH()
    {
            PortalOrange portal = new PortalOrange();
            getWorld().addObject(portal,getX(),getY()); 
            portal.setRotation(90);
    }
    public void placePortalV()
    {
            PortalOrange portal = new PortalOrange();
            getWorld().addObject(portal,getX(),getY()); 
    }
    public void checkForHit()
    {  
            placePortalV();
            getWorld().removeObject(this);
    }
}
