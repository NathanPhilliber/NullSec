import greenfoot.*;
public class Cannon extends Player
{
    public void act() 
    { 
       Space theWorld = (Space) getWorld();
       if(!theWorld.isPaused)
       {
           setupCannon();
       }
    }
    public void setupCannon()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        Actor a = getOneIntersectingObject(Ship.class);
        
        if(mouse != null)
        {
            turnTowards(mouse.getX(), mouse.getY());
        }
        setLocation(a.getX(), a.getY());
    }
    public Cannon()
    {
        
    }
}
