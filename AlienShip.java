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

        projectileDamage = 1.0;
        missileDamage = 1.0;
    }

    public void act() 
    {

        super.act();
        firstTime();
        

    }   

    public void firstTime(){
        if(firstTime){
            
            firstTime = false;
        }
    }
}
