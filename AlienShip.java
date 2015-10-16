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
        
        projectileDamage = .1;
        missileDamage = 1.0;
    }
    
    public void act() 
    {
        
        super.act();
        firstTime();
        if(hasMoreActions() == false){
           
            //addAction("moveTo/"+(Greenfoot.getRandomNumber(1000)-500)+"/"+(Greenfoot.getRandomNumber(1000)-500));
            //addAction("shootPlayer/0/10/10");
            //addAction("shootPlayer/2/10/5");
            //addAction("circleTarget");
        }
        
    }   
    
    public void firstTime(){
        if(firstTime){
           
            firstTime = false;
        }
    }
}
