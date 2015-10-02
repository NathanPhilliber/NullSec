import greenfoot.*;

/**
 * Write a description of class SpaceObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpaceObject extends Object
{
    
    private int spaceX;
    private int spaceY;
    
    public SpaceObject(){
        this(0,0);
    }
    
    public SpaceObject(int spawnX, int spawnY){
        setSpaceX(spawnX);
        setSpaceY(spawnY);
    }
    
    public void act() 
    {
        
    }   
    
    public void setSpaceX(int x){
        spaceX = x;
    }
    
    public void setSpaceY(int y){
        spaceY = y;
    }
    
    public int getSpaceX(){
        return spaceX;
    }
    
    public int getSpaceY(){
        return spaceY;
    }
}
