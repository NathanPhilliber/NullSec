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
    
    public void act() 
    {
        checkCollision();
    }  
    
    public Weapon(boolean isPlayer, double damage){
        ownedByPlayer = isPlayer;
        this.damage = damage;
    }
    
    public Weapon(double x, double y,boolean isPlayer, double damage){
        super(x,y);
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
}

interface ProjectileObject{
    //public boolean checkCollision();
}
