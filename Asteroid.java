import greenfoot.*;

//Written by Nathan

public class Asteroid extends SpaceObject implements DamageTaker
{

    private double speed;
    protected double health = 5.0;
    private boolean noCollision = false;

    protected GreenfootSound rock1 = new GreenfootSound("sounds/rocks1.wav");

    public Asteroid(double x, double y, int rotation, double speed){
        super(x,y);
        this.speed = speed;
        turn(rotation);
    }

    public Asteroid(double x, double y, int rotation, double speed, boolean noCollide){
        this(x,y,rotation,speed);
        noCollision = noCollide;

    }

    public void act() 
    {
        super.act();
        spaceMove(speed);
        checkCollision();
        checkIfFar();

        checkRemoval();
    }

    public void checkIfFar(){
        if(isOffEdge(800)){
            scheduleRemoval();
        }
    }

    public boolean getHit(double damage){
        return true;
    }

    public boolean checkCollision(){
        if(noCollision == false){
            Player obj = (Player)getOneIntersectingObject(Player.class);  
            if(obj != null && touch(obj)){
                obj.getHit(getDamage());

                if(this instanceof AsteroidLarge){
                    for(int i = 0; i < 5; i++){
                        space.addObject(new AsteroidSmall(getSpaceX(), getSpaceY(),Greenfoot.getRandomNumber(360), 3.0, true), 0,0);
                    }
                }
                 if(this instanceof AsteroidMedium){
                    for(int i = 0; i < 3; i++){
                        space.addObject(new AsteroidSmall(getSpaceX(), getSpaceY(),Greenfoot.getRandomNumber(360), 3.0, true), 0,0);
                    }
                }

                scheduleRemoval();

                return true;
            }
            return false;
        }
        return false;
    }

    public double getDamage(){
        return 0.0;
    }
}
