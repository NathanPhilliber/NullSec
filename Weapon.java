import greenfoot.*;

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
    public void act() 
    {
        checkCollision();
        updateMousePos();
    }  
    
    public Weapon(boolean isPlayer, double damage){
        ownedByPlayer = isPlayer;
        this.damage = damage;
    }
    
    public Weapon(double x, double y,boolean isPlayer, double damage){
        super(x,y);
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
            if(obj != null){
                
                obj.getHit(damage);
                setLocation(getX()+3000,getY()); //Ghetto delete

                return true;
            }
        }
        else{
            Player obj = (Player)getOneIntersectingObject(Player.class);  
            if(obj != null){
                obj.getHit(damage);
                setLocation(getX()+3000,getY()); //Ghetto delete

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
}

interface ProjectileObject{
    //public boolean checkCollision();
}
