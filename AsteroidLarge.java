import greenfoot.*;

/**
 * Write a description of class AsteroidLarge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AsteroidLarge extends Asteroid
{
    /**
     * Act - do whatever the AsteroidLarge wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public AsteroidLarge(double x, double y, int rotation, double speed){
        super(x,y,rotation,speed);
    }
    
    public void act() 
    {
        super.act();
        // Add your action code here.
    }   
    
    public boolean getHit(double damage){
        health -= damage;
        if(health <= 0){
            space.removeObject(this);
            
            int times = Greenfoot.getRandomNumber(4)+1;
            
            for(int i = 0; i < times; i++){
                space.addObject(new AsteroidMedium(getSpaceX(), getSpaceY(),Greenfoot.getRandomNumber(360), 3.0), 0,0);
            }
            return true;
        }
        return false;
    }
}
