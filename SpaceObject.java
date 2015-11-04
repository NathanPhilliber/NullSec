import greenfoot.*;
import java.awt.Color;
import java.awt.Graphics.*;
import java.util.List;

/**
 * Every object in space that is not related to the player will be  subclass
 * of this class. This class mainly keeps track of movement.
 * 
 * Written by Nathan Philliber
 */
public class SpaceObject extends Object
{

    private double spaceX;
    private double spaceY;

    protected Space space;
    protected Ship ship;

    private boolean firstTime = true;
    //Default constructor, spawns object at 0,0
    public SpaceObject(){
        this(0.0,0.0);
    }

    //Constructor, spawns object at given x and y
    public SpaceObject(double spawnX, double spawnY){
        setSpaceX(spawnX);
        setSpaceY(spawnY);
        //Space SPACE = (Space) getWorld();
    }

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
                movePlayerDot();
            }
        }

    }   

    //Minimap Vars
    private double mpRatio = 10;
    private double mpRatioX = 5.5*mpRatio;
    private double mpRatioY = 3.23*mpRatio;
    private int mpRadius = 90;

    protected void miniMap(Actor object)
    {

        int x = (int)(800+(getSpaceX() - ship.getSpaceX()-540)/mpRatioX);
        int y = (int)(405+(getSpaceY() - ship.getSpaceY()-270)/mpRatioY);
        if (mpRadius>=Math.sqrt(Math.pow(x-800,2)+Math.pow(y-405,2)))
        {
            getWorld().addObject(object, x, y);
        }
    }

    public void movePlayerDot()
    {
        List<Actor> playDot = getWorld().getObjects(PlayerDot.class);
        if(!playDot.isEmpty())
        {
            Actor pDot = playDot.get(0);
            int x =(int) ship.getSpaceX()/100;
            int y = (int) ship.getSpaceX()/100;
            pDot.setLocation(x, y);
        }
    }

    //Moves the objects according to the ship's coords
    public void updatePosition(){

        setLocation(getSpaceX() - ship.getSpaceX(), getSpaceY() - ship.getSpaceY());
    }

    //Set object's X coord
    public void setSpaceX(double x){
        spaceX = x;
    }

    //Set object's Y coord
    public void setSpaceY(double y){
        spaceY = y;
    }

    //Return object's X coord as a double
    public double getSpaceX(){
        return spaceX;
    }

    //Return object's Y coord as a double
    public double getSpaceY(){
        return spaceY;
    }

    public void addSpaceX(double x){
        setSpaceX(getSpaceX()+x);
    }

    public void addSpaceY(double y){
        setSpaceY(getSpaceY()+y);
    }

    public void spaceMove(double speed){
        addSpaceX(speed*Math.cos(getRotation()*2*Math.PI/360));
        addSpaceY(speed*Math.sin(getRotation()*2*Math.PI/360));
    }

}
