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
    protected double damage = 13.0;

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
            
            int times = Greenfoot.getRandomNumber(4)+1;
            int numCoins = Greenfoot.getRandomNumber(5)+1;
            
            for(int i = 0; i < times; i++){
                space.addObject(new AsteroidMedium(getSpaceX(), getSpaceY(),Greenfoot.getRandomNumber(360), 3.0), 0,0);
            }
            
            for(int i = 0; i < numCoins; i++){
                space.addObject(new Gold(getSpaceX()+Greenfoot.getRandomNumber(20)-10, getSpaceY()+Greenfoot.getRandomNumber(20)-10, 1),-10,-10);
            }
            
            try{
                space.removeObject(this);
            } catch(NullPointerException e){
                System.out.println(e);
            }
            return true;
        }
        return false;
    }

    public double getDamage(){
        return damage;
    }
}
