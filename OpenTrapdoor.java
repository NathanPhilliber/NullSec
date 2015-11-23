import greenfoot.*;
import java.util.List;


public class OpenTrapdoor extends NoCollisionBlock
{
    /**
     * Act - do whatever the OpenTrapdoor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        updateImage();
    }    
    public void updateImage()
    {
        
        
        List<Actor> leftWire = getObjectsAtOffset(-27, 0, Wire.class);
        List<Actor> rightWire = getObjectsAtOffset(27, 0, Wire.class);
        List<Actor> leftTrap = getObjectsAtOffset(-27, 0, Trapdoor.class);
        List<Actor> rightTrap = getObjectsAtOffset(27, 0, Trapdoor.class);
        List<Actor> upWire = getObjectsAtOffset(0, -27, Wire.class);
        List<Actor> downWire = getObjectsAtOffset(0, 27, Wire.class);
        List<Actor> upTrap = getObjectsAtOffset(0, -27, Trapdoor.class);
        List<Actor> downTrap = getObjectsAtOffset(0, 27, Trapdoor.class);
        if(!leftWire.isEmpty() || !rightWire.isEmpty() || !leftTrap.isEmpty() || !rightTrap.isEmpty() || !upWire.isEmpty() || !downWire.isEmpty() || !upTrap.isEmpty() || !downTrap.isEmpty())
        {
            Trapdoor trap = new Trapdoor();
            getWorld().addObject(trap, getX(), getY());
            getWorld().removeObject(this);
        }
    }
}
