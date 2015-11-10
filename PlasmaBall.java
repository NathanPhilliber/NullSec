import greenfoot.*;

//Written by John

public class PlasmaBall extends Weapon implements ProjectileObject
{
    private double straightX;
    private double straightY;
    private int step = 0;
    
    private double speed = 7.0;
    
    

    public void act() 
    {
        super.act();
        waveMove(1);
        spaceMove(speed);
        checkRemoval();//LAST
    } 
    
    public PlasmaBall(int angle, boolean isPlayer, double damage, double startX, double startY)
    {
        super(angle, isPlayer, startX, startY, damage);
    }
    

    private void waveMove(double distance)
    {
               
        double ang = getRotation()*2*Math.PI/360;
        double r = Math.sqrt((step)^2 + ((int)Math.round(100*step*Math.sin(step))^2)/10000);
        double theta = Math.atan(Math.sin(step));
        double x = r*Math.cos(theta+ang);
        double y = r*Math.sin(theta+ang);
        setLocation(getX()+x,getY()+y);
        step++;
    }
    

}
