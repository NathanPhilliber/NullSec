import greenfoot.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

/**
 * Write a description of class Wire here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wire extends NoCollisionBlock
{
    private int wireTypeInt = 0;
    private boolean firstTime = true;

    public Wire(){
        this(0);
    }

    public Wire(int blockType){
        super();
    }

    public void act() 
    {
        super.act();
        setCorrectImage();
        checkActivator();
    }

    public void checkActivator()
    {
        Actor actUp = getOneObjectAtOffset(0, -27, WireActivator.class);
        Actor actDown = getOneObjectAtOffset(0, 27, WireActivator.class);
        Actor actLeft = getOneObjectAtOffset(-27, 0, WireActivator.class);
        Actor actRight = getOneObjectAtOffset(27, 0, WireActivator.class);

        ArrayList<Actor> acts =  new ArrayList<Actor>();
        acts.add(actUp);
        acts.add(actDown);
        acts.add(actLeft);
        acts.add(actRight);

        if(acts != null)
        {
            for(Actor a: acts)
            {
                if(a instanceof WireButtonDown)
                {
                    activateWires();
                }
            }
        }
    }

    public void activateWires()
    {
        Actor wireUp = getOneObjectAtOffset(0, -27, Wire.class);
        Actor wireDown = getOneObjectAtOffset(0, 27, Wire.class);
        Actor wireLeft = getOneObjectAtOffset(-27, 0, Wire.class);
        Actor wireRight = getOneObjectAtOffset(27, 0, Wire.class);

        List<Actor> wires = getWorld().getObjects(Wire.class);
        for(Actor a : wires)
        {
            for(int y = 0; y < a.getImage().getHeight(); y++)
            {
                for(int x = 0; x < a.getImage().getWidth(); x++)
                {
                    if(a.getImage().getColorAt(x, y).getAlpha() == 255)
                    {
                        a.getImage().setColorAt(x, y, Color.RED);
                    }
                }
            }
        }
    }

    public int getWireType()
    {
        return wireTypeInt;
    }

    public void setCorrectImage()
    {
        Actor wireUp = getOneObjectAtOffset(0, -27, Wire.class);
        Actor wireDown = getOneObjectAtOffset(0, 27, Wire.class);
        Actor wireLeft = getOneObjectAtOffset(-27, 0, Wire.class);
        Actor wireRight = getOneObjectAtOffset(27, 0, Wire.class);
        if(firstTime)
        {
            firstTime = false;
            if(wireUp != null)
            {
                wireTypeInt += 1000;
            }
            if(wireRight != null)
            {
                wireTypeInt += 100;
            }
            if(wireDown != null)
            {
                wireTypeInt += 10;
            }
            if(wireLeft != null)
            {
                wireTypeInt += 1;
            }
            if(wireTypeInt == 1111)
            {
                setImage("Wire+.png");
            }
            if(wireTypeInt == 1101)
            {
                setImage("WireT.png");
            }
            if(wireTypeInt == 1110)
            {
                setImage("WireT.png");
                setRotation(90);
            }
            if(wireTypeInt == 111)
            {
                setImage("WireT.png");
                setRotation(180);
            }
            if(wireTypeInt == 1011)
            {
                setImage("WireT.png");
                setRotation(270);
            }
            if(wireTypeInt == 1001)
            {
                setImage("WireL.png");
            }
            if(wireTypeInt == 1100)
            {
                setImage("WireL.png");
                setRotation(90);
            }
            if(wireTypeInt == 110)
            {
                setImage("WireL.png");
                setRotation(180);
            }
            if(wireTypeInt == 11)
            {
                setImage("WireL.png");
                setRotation(270);
            }
            if(wireTypeInt == 101)
            {
                setImage("WireLine.png");
            }
            if(wireTypeInt == 1010)
            {
                setImage("WireLine.png");
                setRotation(90);
            }
            if(wireTypeInt == 10)
            {
                setImage("WireLine.png");
                setRotation(90);
            }
            if(wireTypeInt == 1)
            {
                setImage("WireLine.png");
            }
            if(wireTypeInt == 100)
            {
                setImage("WireLine.png");
            }
            if(wireTypeInt == 1000)
            {
                setImage("WireLine.png");
                setRotation(90);
            }
        }
    }
}
