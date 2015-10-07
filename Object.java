import greenfoot.*;

/**
 * Write a description of class Object here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Object extends SmoothMover
{
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    /**
     * removeAtEdge()
     * ALWAYS PUT AT THE END OF A ACT METHOD
     * ALLLLLLLLLLLLLLLLLLLLLLLLLLLLLWAYYYYYYYYYYYYYYSSSSSSSSSSSS
     * john start
     * 
     */
    public void removeAtEdge() 
    {
        if (isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }
    
    public boolean isAtEdge()
    {
        if (getX() <= 0)
        {
            return true;
        }
        else if (getX() >= getWorld().getWidth()-1)
        {
            return true;
        }
        else if (getY() <= 0)
        {
            return true;
        }
        else if (getY() >= getWorld().getHeight()-1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //john end
    
    public void addExplosion(double x, double y){
        World world = getWorld();
        for (int i = 0; i<13; i++)
        {
            world.addObject(new Particle(x, y, 8, 6, 10, 6, 20,"images/fire1.png"), 0, 0);
            world.addObject(new Particle(x, y, 20, 6, 17, 6, 20,"images/ant.png"), 0, 0);
        }
    }
}

interface DamageTaker{
    public boolean getHit(double damage); //Called when an object is hit by something
    //Return true if actually a hit
}
