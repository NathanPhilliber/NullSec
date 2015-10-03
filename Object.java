import greenfoot.*;

/**
 * Write a description of class Object here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Object extends SmoothMover
{
    
    private static int numObjects;
    
    public Object(){
        
    }
    
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
}
