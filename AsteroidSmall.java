import greenfoot.*;

/**
 * Write a description of class AsteroidSmall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AsteroidSmall extends Asteroid
{
    /**
     * Act - do whatever the AsteroidSmall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    protected double damage = 3.0;
    public AsteroidSmall(double x, double y, int rotation, double speed){
        super(x,y,rotation,speed);
    }
    
    public void act() 
    {
        super.act();
        // Add your action code here.
    }    
    
    public boolean getHit(double damage){
        space.removeObject(this);
        return true;
    }
    
    public double getDamage(){
        return damage;
    }
}