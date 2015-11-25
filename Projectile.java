import greenfoot.*;

//Written by John

public class Projectile extends Weapon implements ProjectileObject
{

    private boolean firstTime = true;
    private int angleChange = 0;
    private double speed = 15.0;

    private GreenfootSound shootSound = new GreenfootSound("sounds/shot.mp3");

    public void act() 
    {
        super.act();
        if(firstTime){
            firstTime = false;
            if(isOffEdge(50) == false){
                shootSound.setVolume(50);
                shootSound.play();
            }
        }
        spaceMove(speed);
        checkRemoval();//LAST
    }    

    public Projectile(int angle, boolean isPlayer, double damage, double startX, double startY)
    {
        super(angle, isPlayer, startX, startY, damage);
        //shootSound.play();
    } 

    
}
