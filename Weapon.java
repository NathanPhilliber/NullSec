import greenfoot.*;

/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon extends SpaceObject
{
    
    public void act() 
    {
        // Add your action code here.
    }  
    
        public Weapon(){
        
    }
    
        public Weapon(double x, double y){
        super(x,y);
    }
}

interface ProjectileObject{
    public boolean checkCollision();
}
