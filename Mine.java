import greenfoot.*;

/**
 * Write a description of class Mine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mine extends Weapon implements ProjectileObject
{

    /**
     * currently broken
     * Not fully implamented
     * feel free to change immage
     * add colisions as nessary
     * 
     */
    int timer=0;
    
    public void act() 
    {
        super.act();
        updatePosition();
        time();
        checkRemoval();//LAST
    }    
    
    public Mine(int angle,boolean isPlayer,double x, double y, double damage){
        super(angle, isPlayer, x, y, damage);
    }
    
    /*
    public void collision()
    {
        if (checkCollision())
        {
            //explode();
        }
    }
    */
    private void time()
    {
        if (timer >= 100)
        {
            explode();
        }
        timer++;
    }
    
    public void explode()
    {
        
        //remove objects
        addExplosion(getSpaceX(), getSpaceY());
        getWorld().removeObject(this);
    }
    

}
