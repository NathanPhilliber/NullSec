import greenfoot.*;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Object
{
    
    private int spaceX;
    private int spaceY;
    
    public Player(){
        this(0,0);
    }
    
    public Player(int x, int y){
        setSpaceX(x);
        setSpaceY(y);
    }
    
    public void act() 
    {
       
    } 
    
    public int getSpaceX(){
        return spaceX;
    }
    
    public int getSpaceY(){
        return spaceY;
    }
    
    public void setSpaceX(int x){
        spaceX = x;
    }
    
    public void setSpaceY(int y){
        spaceY = y;
    }
}
