import greenfoot.*;

/**
 * Write a description of class AlienShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AlienShip extends Entity
{
   
    public AlienShip(){
        super();
    }
    
    public AlienShip(double x, double y){
        super(x,y);
        
        
        
    }
    
    public void act() 
    {
        
        super.act();
        
        if(hasMoreActions() == false){
            addAction("moveTo/"+(Greenfoot.getRandomNumber(1000)-500)+"/"+(Greenfoot.getRandomNumber(1000)-500));
        }
        
    }    
}
