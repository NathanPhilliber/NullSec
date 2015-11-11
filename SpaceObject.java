import greenfoot.*;
import java.awt.Color;
import java.awt.Graphics.*;
import java.util.List;

/**
 * Every object in space that is not related to the player will be  subclass
 * of this class. This class mainly keeps track of movement.
 * 
 * Written by Nathan, John, Trace
 */
public class SpaceObject extends Object
{

    private double spaceX;
    private double spaceY;

    protected Space space;
    protected Ship ship;

    private boolean firstTime = true;

    //Written by Nathan
    //Default constructor, spawns object at 0,0
    public SpaceObject(){
        this(0.0,0.0);
    }

    //Written by Nathan
    //Constructor, spawns object at given x and y
    public SpaceObject(double spawnX, double spawnY){
        setSpaceX(spawnX);
        setSpaceY(spawnY);
        //Space SPACE = (Space) getWorld();
    }

    //Written by Nathan
    //Called every tick, updates object position relative to ship coords
    public void act(){
        super.act();
        if(space == null){
            space = (Space) getWorld();
            ship = space.getShip();
        }
        else{
            if(!space.isPaused)
            {
                updatePosition();
            }
        }

    }   

    //Written by Trace
    //Minimap Vars
    private double mpRatio = 10;
    private double mpRatioX = 5.5*mpRatio;
    private double mpRatioY = 3.23*mpRatio;
    private int mpRadius = 90;
    
    //Written by John
    protected void miniMap(Actor object)
    {

        int x = (int)((space.getWidth()-120)+(getSpaceX() - ship.getSpaceX()-(space.getWidth()-380))/mpRatioX);
        int y = (int)((space.getHeight()-135)+(getSpaceY() - ship.getSpaceY()-(space.getHeight()/2))/mpRatioY);
        if (mpRadius>=Math.sqrt(Math.pow(x-(space.getWidth()-120),2)+Math.pow(y-(space.getHeight()-135),2)))
        {
            getWorld().addObject(object, x, y);
        }
    }

    //Moves the objects according to the ship's coords
    //Written by Nathan
    public void updatePosition(){

        setLocation(getSpaceX() - ship.getSpaceX(), getSpaceY() - ship.getSpaceY());
    }

    //Set object's X coord
    //Written by Nathan
    public void setSpaceX(double x){
        spaceX = x;
    }

    //Set object's Y coord
    //Written by Nathan
    public void setSpaceY(double y){
        spaceY = y;
    }

    //Return object's X coord as a double
    //Written by Nathan
    public double getSpaceX(){
        return spaceX;
    }

    //Return object's Y coord as a double
    //Written by Nathan
    public double getSpaceY(){
        return spaceY;
    }

    //Written by Nathan
    public void addSpaceX(double x){
        setSpaceX(getSpaceX()+x);
    }

    //Written by Nathan
    public void addSpaceY(double y){
        setSpaceY(getSpaceY()+y);
    }
    
    //Written by John
    public void spaceMove(double speed){
        addSpaceX(speed*cosRot());
        addSpaceY(speed*sinRot());
    }

}
