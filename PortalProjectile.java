import greenfoot.*;

//Written by Trace


public class PortalProjectile extends PortalWorld
{
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
