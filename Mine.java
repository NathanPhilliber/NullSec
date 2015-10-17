import greenfoot.*;
import java.util.List;
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
    private int timer=0;
    private int range;
    private boolean isPlayer;

    public void act() 
    {
        super.act();
        addMineTicker(getSpaceX(), getSpaceY());
        updatePosition();
        time();

        checkRemoval();//LAST
    }    

    public Mine(int angle,boolean isPlayer,double x, double y, double damage, int range){
        super(angle, isPlayer, x, y, damage);
        this.range = range;
        this.isPlayer = isPlayer;
    }

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
        if(isPlayer){
            List<Entity> objects = getObjectsInRange(range, Entity.class);

            for (Entity object : objects) {

                object.getHit(getDamage());
            }
        }
        else{
            List<Player> objects = getObjectsInRange(range, Player.class);

            for (Player object : objects) {

                object.getHit(getDamage());
            }
        }

        addExplosion(getSpaceX(), getSpaceY());
        scheduleRemoval();
    }

}
