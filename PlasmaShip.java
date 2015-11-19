import greenfoot.*;

/**
 * Write a description of class PlasmaShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlasmaShip extends Entity
{
    public PlasmaShip(){
        this(0,0);
    }

    public PlasmaShip(double x, double y){
        super(x,y);

        mineDamage = mineDamage / 2;
        maxFlySpeed *= .7;
        MAX_FLY_SPEED *= .7;
        missileDamage = missileDamage /2;
        fireballDamage /= 2;

        desiredMode = ATTACK_MODE;

        setMaxHealth(200);
        setHealth(200);

        catchUpDis = 12000;

    }

    public void act() 
    {
        super.act();
    }    

    public void attackMode(){
        catchUp();

        if(hasMoreActions() == false){

            if(Greenfoot.getRandomNumber(2)==0){
                addAction("shootPlayer/5/2/10");
                addAction("wait/10");
                addAction("shootPlayer/5/2/10");
                addAction("wait/10");
                addAction("shootPlayer/5/2/10");
            }
            else{
                addAction("moveTo/"+ (int)(ship.getShipLocX()) + "/" + (int)(ship.getShipLocY()));
            }


        }
    }
}
