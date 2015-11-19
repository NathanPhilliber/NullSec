import greenfoot.*;
import java.util.List;

//Written by Nathan

public class Mine extends Weapon implements ProjectileObject
{

    private int timer=0;
    public int MAX_TIME = 100;
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
        if (timer >= MAX_TIME)
        {
            explode();
        }
        if(!isOffEdge(100)){
            if((MAX_TIME-timer <= MAX_TIME/2) && timer%5 == 0){
                GreenfootSound beep6 = new GreenfootSound("sounds/beep6.mp3");
                beep6.setVolume(25);
                beep6.play();
            }
            else if((MAX_TIME-timer > MAX_TIME/2) && timer%10 == 0){
                GreenfootSound beep7 = new GreenfootSound("sounds/beep7.mp3");
                beep7.setVolume(25);
                beep7.play();
            }
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

        addExplosion(getSpaceX(), getSpaceY(), !isOffscreen());
        scheduleRemoval();
    }

    public boolean checkCollision(){
        return false;
    }

}
