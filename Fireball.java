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
    
    /**
     * Act - do whatever the Fireball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        move(1);
        beam();
        removeAtEdge();
    }    
    
    public Fireball(int angle, boolean isPlayer, double damage)
    {
        super(isPlayer, damage);
        setRotation(angle);
    }
    
    private void beam()
    {
        beamAngle++;
        for (int i=0; i<=5; i++)
        {
            getWorld().addObject(new Beam(beamAngle, true, 3.0), (int)Math.round(getX()+i*8*Math.cos(beamAngle*2*Math.PI/360)), (int)Math.round(getY()+i*8*Math.sin(beamAngle*2*Math.PI/360)));
        }
        for (int i=0; i<=5; i++)
        {
            getWorld().addObject(new Beam(beamAngle+180, true, 3.0), (int)Math.round(getX()+i*8*Math.cos((beamAngle+180)*2*Math.PI/360)), (int)Math.round(getY()+i*8*Math.sin((beamAngle+180)*2*Math.PI/360)));
        }
    }
    

}
