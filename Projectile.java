import greenfoot.*;

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Weapon implements ProjectileObject
{
    /**
     * Works
     * feel free to change immage or move speed
     * shooting speed is changed in Player.shoot()
     * add colisions as nessary
     * 
     */
    
    private boolean ownedByPlayer;
    
    private double damage;
    
    public void act() 
    {
        //colision effect goes here
        //update Position method to move relitive to ship (if you want the ship to be able to catch up to projectiles)
        move(5);
        checkCollision();
        
        
        removeAtEdge(); //CALL LAST
        
    }    
    public Projectile(int angle, boolean isPlayer, double damage)
    {
        setRotation(angle);
        ownedByPlayer = isPlayer;
        this.damage = damage;
        //System.out.println("spawn");
    }
    
    public Projectile(int angle, double damage){
        this(angle, true, damage);
    }
    
    public boolean checkCollision(){
        
        
        if(ownedByPlayer){
            Entity obj = (Entity) getOneIntersectingObject(Entity.class);  
            if(obj != null){
                
                obj.getHit(damage);
                setLocation(getX()+3000,getY()); //Ghetto delete
            }
        }
        else{
            Player obj = (Player)getOneIntersectingObject(Player.class);  
            if(obj != null){
                obj.getHit(damage);
                setLocation(getX()+3000,getY()); //Ghetto delete
            }
        }
        
       
        
        return true;
    }
    
    public void removeSelf(){
        getWorld().removeObject(this);
    }
}
