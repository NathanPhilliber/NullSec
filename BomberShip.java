import greenfoot.*;

//Written by Nathan

public class BomberShip extends Entity
{
    public BomberShip(){
        this(0,0);
    }
    
    public BomberShip(double x, double y){
        super(x,y);
        
        mineDamage = mineDamage / 2;
        maxFlySpeed *= 2;
        missileDamage = missileDamage /2;
        MAX_FLY_SPEED *= 2;
        desiredMode = ATTACK_MODE;
        
        setMaxHealth(50);
        
        maxCoins = 65;
        
    }
    public void act() 
    {
        super.act();
    }   
    
    public void attackMode(){
        catchUp();
        
        if(hasMoreActions() == false){

            if(Greenfoot.getRandomNumber(4) != 0){
                addAction("shootPlayer/3/1/1");
            }
            else{
                addAction("shootPlayer/2/10/4"); //type/delay/number
            }
            
            addAction("circleTarget/"+ (int)ship.getShipLocX() + "/" + (int)ship.getShipLocY() +"/" + Greenfoot.getRandomNumber(150)+"/40");

        }
    }
    
    
}
