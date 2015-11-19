import greenfoot.*;

/**
 * Write a description of class FireShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FireShip extends Entity
{
    public FireShip(){
        this(0,0);
    }

    public FireShip(double x, double y){
        super(x,y);

        mineDamage = mineDamage / 2;
        maxFlySpeed *= 4;
        MAX_FLY_SPEED *= 3;
        missileDamage = missileDamage /2;
        fireballDamage /= 8;

        desiredMode = ATTACK_MODE;

        setMaxHealth(40);

        catchUpDis = 12000;
        
        maxCoins = 30;

    }

    public void act() 
    {
        super.act();
    }    

    public void attackMode(){
        catchUp();

        if(hasMoreActions() == false){
            if(Greenfoot.getRandomNumber(2)==0){
                addAction("moveTo/"+ (int)(ship.getShipLocX()-400) + "/" + (int)(ship.getShipLocY()-400));
                addAction("moveTo/"+ (int)(ship.getShipLocX()) + "/" + (int)(ship.getShipLocY()));
                addAction("shootPlayer/4/1/1");
                addAction("moveTo/"+ (int)(ship.getShipLocX()+400) + "/" + (int)(ship.getShipLocY()+400));
                addAction("moveTo/"+ (int)(ship.getShipLocX()) + "/" + (int)(ship.getShipLocY()));
                addAction("shootPlayer/4/1/1");
            }
            else{
                addAction("moveTo/"+ (int)(ship.getShipLocX()+400) + "/" + (int)(ship.getShipLocY()-400));
                addAction("moveTo/"+ (int)(ship.getShipLocX()) + "/" + (int)(ship.getShipLocY()));
                addAction("shootPlayer/4/1/1");
                addAction("moveTo/"+ (int)(ship.getShipLocX()+400) + "/" + (int)(ship.getShipLocY()-400));
                addAction("moveTo/"+ (int)(ship.getShipLocX()) + "/" + (int)(ship.getShipLocY()));
                addAction("shootPlayer/4/1/1");
            }

        }
    }
}
