import greenfoot.*;

/**
 * Write a description of class AsteroidMedium here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AsteroidMedium extends Asteroid
{
    /**
     * Act - do whatever the AsteroidMedium wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    protected double damage = 7.0;
    
    public AsteroidMedium(double x, double y, int rotation, double speed){
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
            
            rock1.play();
            int times = Greenfoot.getRandomNumber(4)+1;
            int numCoins = Greenfoot.getRandomNumber(3)+1;

            for(int i = 0; i < times; i++){
                space.addObject(new AsteroidSmall(getSpaceX(), getSpaceY(),Greenfoot.getRandomNumber(360), 3.0), 0,0);
            }
            
            for(int i = 0; i < numCoins; i++){
                space.addObject(new Gold(getSpaceX()+Greenfoot.getRandomNumber(20)-10, getSpaceY()+Greenfoot.getRandomNumber(20)-10, 1),-10,-10);
            }
            
            space.removeObject(this);
            return true;
        }
        return false;
    }
    
    public double getDamage(){
        return damage;
    }
}
