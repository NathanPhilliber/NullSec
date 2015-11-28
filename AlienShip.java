import greenfoot.*;

//Written by Nathan

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
        
        maxCoins = 40;
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
