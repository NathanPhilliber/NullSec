import greenfoot.*;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Object
{
    
    private double spaceX;
    private double spaceY;
    
    private double velX;
    private double velY;
    
    private double turnSpeed = 3.0;
    
    public Player(){
        this(0,0);
    }
    
    public Player(double x, double y){
        setSpaceX(x);
        setSpaceY(y);
        
        setVelX(0.0);
        setVelY(0.0);
    }
    
    public void act() 
    {
       fly();
    } 
    
    public void fly(){
        if(Greenfoot.isKeyDown("a")){
            turn(-(int)turnSpeed);
            move(1.2);
        }
        if(Greenfoot.isKeyDown("d")){
            turn((int)turnSpeed);
        }
    }
    
    public double getSpaceX(){
        return spaceX;
    }
    
    public double getSpaceY(){
        return spaceY;
    }
    
    public void setSpaceX(double x){
        spaceX = x;
    }
    
    public void setSpaceY(double y){
        spaceY = y;
    }
    
    public void setVelX(double x){
        velX = x;
    }
    
    public void setVelY(double y){
        velY = y;
    }
    
    public double getVelX(){
        return velX;
    }
    
    public double getVelY(){
        return velY;
    }
}
