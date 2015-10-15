import greenfoot.*;

/**
 * Write a description of class AlienShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AlienShip extends Entity
{
   private boolean firstTime = true;
    public AlienShip(){
        super();
    }
    
    public AlienShip(double x, double y){
        super(x,y);
        
        
        
    }
    
    public void act() 
    {
        
        super.act();
        firstTime();
        if(hasMoreActions() == false){
           
            //addAction("moveTo/"+(Greenfoot.getRandomNumber(500)-250)+"/"+(Greenfoot.getRandomNumber(500)-250));
            
            //addAction("circleTarget");
        }
        
    }   
    
    public void firstTime(){
        if(firstTime){
            addAction("moveTo/500/500");
            addAction("shootPlayer/0/10/5");
            addAction("shootPlayer/2/10/5");
            firstTime = false;
        }
    }
}
