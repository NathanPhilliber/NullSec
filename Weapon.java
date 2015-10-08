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
    private boolean ownedByPlayer;
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
        if(ownedByPlayer == true){
            updateMousePos();
        }
        setRemovalOffEdge(100);
    }  
    
    public int angleTowards(double X,double Y)
    {
        return (int)Math.round(Math.atan2((getTargetY()-getSpaceY()),(getTargetX()-getSpaceX()))*360/(2*Math.PI));
    }
    
    public Weapon(double startX, double startY, boolean isPlayer, double damage){
        super(startX, startY);
        ownedByPlayer = isPlayer;
        this.damage = damage;
    }
    
    
    
    public void updateMousePos(){
        mouse = Greenfoot.getMouseInfo();
        if(mouse != null){
            targetX = mouse.getX();
            targetY = mouse.getY();
        }
        
    }
    
    public boolean checkCollision(){
        
        
        if(ownedByPlayer){
            Entity obj = (Entity) getOneIntersectingObject(Entity.class);  
            if(obj != null && touch(obj)){
                
                obj.getHit(damage);
                scheduleRemoval();

                return true;
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
}

interface ProjectileObject{
    //public boolean checkCollision();
}
