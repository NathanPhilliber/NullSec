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
        MAX_FLY_SPEED *= 4;
        missileDamage = missileDamage /2;

        desiredMode = ATTACK_MODE;

        setMaxHealth(40);

    }

    public void act() 
    {
        super.act();
    }    

    public void attackMode(){
        catchUp();

        if(hasMoreActions() == false){
            addAction("moveTo/"+ (int)(ship.getShipLocX()-800) + "/" + (int)(ship.getShipLocY()-800));
            addAction("moveTo/"+ (int)(ship.getShipLocX()) + "/" + (int)(ship.getShipLocY()));
            addAction("shootPlayer/5/1/1");
            addAction("moveTo/"+ (int)(ship.getShipLocX()+800) + "/" + (int)(ship.getShipLocY()+800));
            addAction("moveTo/"+ (int)(ship.getShipLocX()) + "/" + (int)(ship.getShipLocY()));
            addAction("shootPlayer/5/1/1");
        }
    }
}
