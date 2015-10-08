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
            System.out.println(hasMoreActions());
            addAction("moveTo/"+(Greenfoot.getRandomNumber(500)-250)+"/"+(Greenfoot.getRandomNumber(500)-250));
            addAction("shootPlayer/0/10/5");
            addAction("moveTo/0/0");
            System.out.println("HEY2");
        }
        
    }    
}
