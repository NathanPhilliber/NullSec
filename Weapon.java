import greenfoot.*;
import java.util.List;
/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon extends SpaceObject
{
    protected boolean ownedByPlayer;
    private double damage;
    private MouseInfo mouse;
    private double targetX;
    private double targetY;

    public static final int PROJECTILE = 0;
    public static final int BEAM = 1;
    public static final int MISSILE = 2;
    public static final int MINE = 3;
    public static final int FIREBALL = 4;
    public static final int PLASMABALL = 5;

    public void act() 
    {
        super.act(); //Need to make so always spawn at ship
        checkCollision();
        setRemovalOffEdge(100);
    }  

    public Weapon(int angle, boolean isPlayer, double startX, double startY, double damage){
        super(startX, startY);
        setRotation(angle);
        ownedByPlayer = isPlayer;
        this.damage = damage;
    }

    public int angleTowards(double yourX,double yourY,double targetX, double targetY)
    {
        return (int)Math.round(Math.atan2((targetY-yourY),(targetX-yourX))*360/(2*Math.PI)); 
    }

    public boolean checkCollision(){
        if(ownedByPlayer){
            SpaceObject obj =(SpaceObject) getOneIntersectingObject(SpaceObject.class);
            if(obj != null){
                if(obj instanceof Entity){
                    if(touch(obj)){ //Don't run this disgusting function unless neceessary
                        Entity ent = (Entity) obj;
                        ent.getHit(damage);
                        scheduleRemoval();

                        return true;
                    }

                }
                else if (obj instanceof Asteroid){
                    if(touch(obj)){ //Don't run this disgusting function unless neceessary
                        Asteroid ent = (Asteroid) obj;
                        ent.getHit(damage);
                        scheduleRemoval();

                        return true;
                    }
                }
            }

        }
        else{
            Player obj = (Player)getOneIntersectingObject(Player.class);  
            if(obj != null && touch(obj)){
                obj.getHit(damage);
                scheduleRemoval();

                return true;
            }
        }

        return false;
    }

    public void removeSelf(){
        getWorld().removeObject(this);
    }

    public double getTargetX(){
        return targetX;
    }

    public double getTargetY(){
        return targetY;
    }

    public void setTargetX(double tarX){
        targetX = tarX;
    }

    public void setTargetY(double tarY){
        targetY = tarY;
    }

    public double getDamage(){
        return damage;
    }
}

interface ProjectileObject{
    //public boolean checkCollision();
}
