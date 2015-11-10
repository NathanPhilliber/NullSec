import greenfoot.*;
//Written by Nathan
public class Ship extends Player
{
    public Ship(){
        super();
    }

    public Ship(double x, double y){
        super(x,y);
    }

    public void act() 
    {
        super.act();

        if(isAccelerating()){
            setImage("RocketBoost.png");
        }
        else{
            setImage("RocketIdle.png");
        }
    }  
}
