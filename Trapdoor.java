import greenfoot.*;
import java.util.List;

public class Trapdoor extends Block
{

    public void act() 
    {
        super.act();
        activateMe();
    }    

    public Trapdoor()
    {
        this(0);
    }

    public Trapdoor(int blockType)
    {
        super(98);
    }
    
    public void activateMe()
    {
        List<Actor> leftWire = getObjectsAtOffset(-27, 0, WireOn.class);
        List<Actor> rightWire = getObjectsAtOffset(27, 0, WireOn.class);
        List<Actor> leftTrap = getObjectsAtOffset(-27, 0, OpenTrapdoor.class);
        List<Actor> rightTrap = getObjectsAtOffset(27, 0, OpenTrapdoor.class);
        if(!leftWire.isEmpty() || !rightWire.isEmpty() || !leftTrap.isEmpty() || !rightTrap.isEmpty())
        {
            OpenTrapdoor trap = new OpenTrapdoor();
            getWorld().addObject(trap, getX(), getY());
            getWorld().removeObject(this);
        }
    }
}
