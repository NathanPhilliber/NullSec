import greenfoot.*;
import java.util.List;

//Written by John and Nathan

public class Weapon extends SpaceObject
{
    protected boolean ownedByPlayer;
    private double damage;
    private MouseInfo mouse;
    private double targetX;
    private double targetY;

    protected boolean despawnOnTouch = true;

    
    public static final int PROJECTILE = 0;
    public static final int BEAM = 1;
    public static final int MISSILE = 2;
    public static final int MINE = 3;
    public static final int FIREBALL = 4;
    public static final int PLASMABALL = 5;
    
    //Written by Nathan
    public static final int[] PROJECTILE_COST = {0,50,60,70,80,90,100,110,120,130};
    public static final int[] BEAM_COST = {75,50,55,60,65,70,75,80,85,90,95,100};
    public static final int[] MISSILE_COST = {100,50,60,70,80,90,100};
    public static final int[] MINE_COST = {100,80,100,120,140,160,180,200};
    public static final int[] FIREBALL_COST = {100,100,100,100,100,100};
    public static final int[] PLASMA_COST = {120,100,130,160,190,220,250};
    
    //Written by Nathan
    public static int getWeaponCost(int weapon, int level){
        switch(weapon){
            case 0:
            return PROJECTILE_COST[level];
            
            case 1:
            return BEAM_COST[level];
            
            case 2:
            return MISSILE_COST[level];
            
            case 3:
            return MINE_COST[level];
            
            case 4:
            return FIREBALL_COST[level];
            
            case 5:
            return PLASMA_COST[level];
            
        }
        return -1;
    }

    public void act() 
    {
        super.act(); //Need to make so always spawn at ship
        checkCollision();
        setRemovalOffEdge(100);
    }  

    //Written by John
    public Weapon(int angle, boolean isPlayer, double startX, double startY, double damage){
        super(startX, startY);
        setRotation(angle);
        ownedByPlayer = isPlayer;
        this.damage = damage;
    }

    //Written by John
    public int angleTowards(double yourX,double yourY,double targetX, double targetY)
    {
        return (int)Math.round(Math.atan2((targetY-yourY),(targetX-yourX))*360/(2*Math.PI)); 
    }

    //Written by Nathan
    public boolean checkCollision(){

        List<Object> objs = getIntersectingObjects(Object.class);
        if(objs.isEmpty() == false){
            for( Object curObj : objs){
                if(ownedByPlayer){
                    if(curObj instanceof Entity){
                        if(touch(curObj)){ //Don't run this disgusting function unless neceessary
                            Entity ent = (Entity) curObj;
                            ent.getHit(damage);
                            if(despawnOnTouch){
                                scheduleRemoval();
                            }

                            return true;
                        }

                    }
                }
                else{

                    if(curObj instanceof Player){

                        if(touch(curObj)){ //Don't run this disgusting function unless neceessary
                            Player ent = (Player) curObj;
                            ent.getHit(damage);
                            if(despawnOnTouch){
                                scheduleRemoval();
                            }

                            return true;
                        }
                    }
                }

                if (curObj instanceof Asteroid){
                    if(touch(curObj)){ //Don't run this disgusting function unless neceessary
                        Asteroid ent = (Asteroid) curObj;
                        ent.getHit(damage);
                        if(despawnOnTouch){
                            scheduleRemoval();
                        }

                        return true;
                    }
                }

            }
            return false;

        }
        return true;
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

//Written by Nathan
interface ProjectileObject{
    //public boolean checkCollision();
}
