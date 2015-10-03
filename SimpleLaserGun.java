import greenfoot.*;

/**
 * Write a description of class SimpleLaserGun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SimpleLaserGun extends Weapon
{
    /**
     * Act - do whatever the SimpleLaserGun wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public SimpleLaserGun(){
        super();
    }
    
    public SimpleLaserGun(double x, double y){
        super(x,y);
    }
    
    public void act() 
    {
        super.act();
    }    
    
    public void fire(){
        
        
        getWorld().addObject(new SimpleBullet(getMouseX(), getMouseY(), 8.0), getX(),getY());
    }
}
