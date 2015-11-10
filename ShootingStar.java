import greenfoot.*;

//Written by Nathan

public class ShootingStar extends SpaceObject
{
    public double speed = 14.0;

    public ShootingStar(double x, double y, int rotation){
        super(x,y);
        setRotation(rotation);
        setImage("ShootingStar.png");
    }

    public void act() 
    {
        super.act();
        spaceMove(speed);

        if(!isOffEdge(10)){
            addShootingStar(getSpaceX(), getSpaceY());
        }

        checkIfFar();
    }  

    public void checkIfFar(){
        if(isOffEdge(800)){
            scheduleRemoval();
        }
    }
}
