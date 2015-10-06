import greenfoot.*;

/**
 * Write a description of class PlasmaBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlasmaBall extends Weapon implements ProjectileObject
{
    private double straightX;
    private double straightY;
    private int step = 0;
    
    private double speed = 5.0;
    
    
    /**
     * Act - do whatever the PlasmaBall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        waveMove(1);
        spaceMove(speed);
        removeAtEdge();
    } 
    
    public PlasmaBall(int angle, boolean isPlayer, double damage, double startX, double startY)
    {
        super(startX, startY,isPlayer, damage);
        setRotation(angle);
        
    }
    

    private void waveMove(double distance)
    {
        //straightX = getExactX() + Math.cos(Math.toRadians(getRotation())) * distance;
        //straightY = getExactY() + Math.sin(Math.toRadians(getRotation())) * distance;
        
        
        double ang = getRotation()*2*Math.PI/360;
        double r = Math.sqrt((step)^2 + ((int)Math.round(100*step*Math.sin(step))^2)/10000);
        double theta = Math.atan(Math.sin(step));
        double x = r*Math.cos(theta+ang);
        double y = r*Math.sin(theta+ang);
        setLocation(getX()+x,getY()+y);
        step++;
    }
    

}
