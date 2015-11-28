import greenfoot.*;

/**
 * Write a description of class CargoShip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CargoShip extends Entity
{
    public CargoShip(){
        this(0,0);
    }

    public CargoShip(double x, double y){
        super(x,y);
        desiredMode = EXPLORE_MODE;
        maxFlySpeed *= 1.5;
        MAX_FLY_SPEED *= 1.5;

        maxCoins = 100;
    }

    public void act() 
    {
        super.act();
    }    

    public void attackMode(){

        if(hasMoreActions() == false){
            if(Greenfoot.getRandomNumber(5) != 0){
                addAction("moveTo/"+(getSpaceX()+(getSpaceX()-ship.getShipLocX()))+"/"+(getSpaceY()+(getSpaceY()-ship.getShipLocY())));
            }
            else{
                addAction("shootPlayer/0/10/2");
            }


        }
    }
}
