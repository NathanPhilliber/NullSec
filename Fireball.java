import greenfoot.*;

//Written by John

public class Fireball extends Weapon implements ProjectileObject
{
    private int beamAngle = 0;
    private int level=1;
    private double speed = 1.0;
    private boolean isPlayer;


    public void act() 
    {
        super.act();
        spaceMove(speed);
        beam();
        addFire(getSpaceX(), getSpaceY());
        checkRemoval();//LAST
    }    
    
    public Fireball(int angle, boolean isPlayer, double damage, double startX, double startY)
    {
        super(angle, isPlayer, startX, startY, damage);
        despawnOnTouch = false;
        level=1;
        this.isPlayer = isPlayer;
    }
    
    private void beam()
    {
        beamAngle++;
        for (int i=0; i<=6*level; i++)
        {
            space.addObject(new Beam(beamAngle, isPlayer, 3.0, ship.getShipLocX(), ship.getShipLocY()), (int)Math.round(getX()+i*8*Math.cos(beamAngle*2*Math.PI/360)), (int)Math.round(getY()+i*8*Math.sin(beamAngle*2*Math.PI/360)));
        }
        for (int i=0; i<=6*level; i++)
        {
            space.addObject(new Beam(beamAngle+180, isPlayer, 3.0, ship.getShipLocX(), ship.getShipLocY()), (int)Math.round(getX()+i*8*Math.cos((beamAngle+180)*2*Math.PI/360)), (int)Math.round(getY()+i*8*Math.sin((beamAngle+180)*2*Math.PI/360)));
        }
    }
    

}
