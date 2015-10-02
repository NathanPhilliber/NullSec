import greenfoot.*;
import java.lang.Math;
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
    
    private int turnSpeed = 3;
    private double flySpeed = 3.0;
    
    private double maxFlySpeed = 5.0;
    
    private double flyDec = .01;
    
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
       showDebug(true);
    } 
    
    public void fly(){
        
        if(Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("w")){
            int angle = getRotation();
            
            setVelX((Math.cos(Math.toRadians(angle))*getFlySpeed()) + getVelX());
            setVelY((Math.sin(Math.toRadians(angle))*getFlySpeed()) + getVelY());
            
            if(Math.abs(getVelX()) >= getMaxFlySpeed()){
                setVelX(getMaxFlySpeed()*Integer.signum((int)getVelX()));
            }
            if(Math.abs(getVelY()) >= getMaxFlySpeed()){
                setVelY(getMaxFlySpeed()*Integer.signum((int)getVelY()));
            }
        }
        
            
        setVelX(getVelX() + (Math.signum(getVelX())*-1)*getFlyDec());
            
            
        setVelY(getVelY() + (Math.signum(getVelY())*-1)*getFlyDec());
            
            
            
        
        
        if(Greenfoot.isKeyDown("a")){
            turn(-turnSpeed);
            
        }
        if(Greenfoot.isKeyDown("d")){
            turn(turnSpeed);
        }
        
        addSpaceX(getVelX());
        addSpaceY(getVelY());
    }
    
    public boolean isMoving(){
        if(getVelX() != 0 || getVelY() != 0){
            return true;
        }
        return false;
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
    
    public void addSpaceX(double x){
        setSpaceX(getSpaceX()+x);
    }
    
    public void addSpaceY(double y){
        setSpaceY(getSpaceY()+y);
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
    
    public int getTurnSpeed(){
        return turnSpeed;
    }
    
    public void setTurnSpeed(int speed){
        turnSpeed = speed;
    }
    
    public double getFlySpeed(){
        return flySpeed;
    }
    
    public void setFlySpeed(int speed){
        flySpeed = speed;
    }
    
    public double getMaxFlySpeed(){
        return maxFlySpeed;
    }
    
    public void setMaxFlySpeed(int speed){
        maxFlySpeed = speed;
    }
    
    public void setFlyDec(double dec){
        flyDec = dec;
    }
    
    public double getFlyDec(){
        return flyDec;
    }
    
    public void showDebug(boolean show){
        if(show){
            getWorld().showText("vX: "+String.format("%.02f", (getVelX())), 40, 25);
            getWorld().showText("vY: "+String.format("%.02f", (getVelY())), 40, 50);          
        }
    }
}
