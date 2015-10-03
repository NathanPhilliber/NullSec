import greenfoot.*;

/**
 * Write a description of class SimpleBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SimpleBullet extends Object
{
    /**
     * Act - do whatever the SimpleBullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int lifespan = 100;
    
    
    private double speed;
    
    private double targetX;
    private double targetY;
    
   private boolean firstTime = true;
    
    public SimpleBullet(){
        
    }
    
    public SimpleBullet(double tarX, double tarY, double speed){
        setTargetX(tarX);
        setTargetY(tarY);
        setSpeed(speed);
       
        
        
    }
    
    public void act() 
    {
        
        if(firstTime){
            firstTime = false;
            turnTowards((int)getTargetX(), (int)getTargetY());
        }
        move(getSpeed());
        removeLifespan();
        checkDead();
    }    
    
    public int getLifespan(){
        return lifespan;
    }
    
    public void setLifeSpan(int life){
        lifespan = life;
    }
    
    public void setTargetX(double x){
        targetX = x;
    }
    
    public void setTargetY(double y){
        targetY = y;
    }
    
    public double getTargetX(){
        return targetX;
    }
    
    public double getTargetY(){
        return targetY;
    }
    
    public double getSpeed(){
        return speed;
    }
    
    public void setSpeed(double speed){
        this.speed = speed;
    }
    
    public void removeSelf(){
        getWorld().removeObject(this);
    }
    
    public void removeLifespan(){
        lifespan--;
    }
    
    public void checkDead(){
        if(getLifespan()< 0){
            removeSelf();
        }
    }
}
