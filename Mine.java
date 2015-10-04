import greenfoot.*;

/**
 * Write a description of class Mine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mine extends Weapon implements ProjectileObject
{

    /**
     * currently broken
     * Not fully implamented
     * feel free to change immage
     * add colisions as nessary
     * 
     */
    int timer=0;
    
    public void act() 
    {
        //colision effect goes here
        updatePosition();
        time();
        collision();
    }    
    
    public Mine(double x, double y){
        super(x,y);
    }
    
    public void collision()
    {
        if (checkCollision())
        {
            //explode();
        }
    }
    
    private void time()
    {
        if (timer >= 100)
        {
            explode();
        }
        timer++;
    }
    
    public void explode()
    {
        
        //remove objects
        getWorld().removeObject(this);
    }
    
    public boolean checkCollision(){
        return true;
    }
}
