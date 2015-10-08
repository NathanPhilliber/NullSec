import greenfoot.*;

/**
 * Write a description of class Fireball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fireball extends Weapon implements ProjectileObject
{
    private int beamAngle = 0;
    
    private double speed = 1.0;
    
    /**
     * Act - do whatever the Fireball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        spaceMove(speed);
        beam();
        checkRemoval();//LAST
    }    
    
    public Fireball(int angleOffset, boolean isPlayer, double damage, double startX, double startY)
    {
        super(startX, startY, isPlayer, damage);
        if (isPlayer)
        {
            MouseInfo m = Greenfoot.getMouseInfo();
            if(m != null)
            {
                setRotation(angleTowards(460,270,m.getX(),m.getY())+angleOffset);
            }
        }
    }
    
    private void beam()
    {
        Space space = (Space) getWorld();
        Ship ship = space.getShip();
        
        
        
        beamAngle++;
        for (int i=0; i<=5; i++)
        {
            getWorld().addObject(new Beam(beamAngle, true, 3.0, ship.getShipLocX(), ship.getShipLocY()), (int)Math.round(getX()+i*8*Math.cos(beamAngle*2*Math.PI/360)), (int)Math.round(getY()+i*8*Math.sin(beamAngle*2*Math.PI/360)));
        }
        for (int i=0; i<=5; i++)
        {
            getWorld().addObject(new Beam(beamAngle+180, true, 3.0, ship.getShipLocX(), ship.getShipLocY()), (int)Math.round(getX()+i*8*Math.cos((beamAngle+180)*2*Math.PI/360)), (int)Math.round(getY()+i*8*Math.sin((beamAngle+180)*2*Math.PI/360)));
        }
    }
    

}
