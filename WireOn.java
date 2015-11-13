import greenfoot.*;

/**
 * Write a description of class WireOn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WireOn extends WireActivator
{
    private int wireTypeInt = 0;
    private boolean firstTime = true;
    /**
     * Act - do whatever the WireOn wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setCorrectImage();
    }

    public void setCorrectImage()
    {
        Actor wireUp = getOneObjectAtOffset(0, -27, WireOn.class);
        Actor wireDown = getOneObjectAtOffset(0, 27, WireOn.class);
        Actor wireLeft = getOneObjectAtOffset(-27, 0, WireOn.class);
        Actor wireRight = getOneObjectAtOffset(27, 0, WireOn.class);
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
                setImage("Wire+On.png");
            }
            if(wireTypeInt == 1101)
            {
                setImage("WireTOn.png");
            }
            if(wireTypeInt == 1110)
            {
                setImage("WireTOn.png");
                setRotation(90);
            }
            if(wireTypeInt == 111)
            {
                setImage("WireTOn.png");
                setRotation(180);
            }
            if(wireTypeInt == 1011)
            {
                setImage("WireTOn.png");
                setRotation(270);
            }
            if(wireTypeInt == 1001)
            {
                setImage("WireLOn.png");
            }
            if(wireTypeInt == 1100)
            {
                setImage("WireLOn.png");
                setRotation(90);
            }
            if(wireTypeInt == 110)
            {
                setImage("WireLOn.png");
                setRotation(180);
            }
            if(wireTypeInt == 11)
            {
                setImage("WireLOn.png");
                setRotation(270);
            }
            if(wireTypeInt == 101)
            {
                setImage("WireLineOn.png");
            }
            if(wireTypeInt == 1010)
            {
                setImage("WireLineOn.png");
                setRotation(90);
            }
            if(wireTypeInt == 10)
            {
                setImage("WireLineOn.png");
                setRotation(90);
            }
            if(wireTypeInt == 1)
            {
                setImage("WireLineOn.png");
            }
            if(wireTypeInt == 100)
            {
                setImage("WireLineOn.png");
            }
            if(wireTypeInt == 1000)
            {
                setImage("WireLineOn.png");
                setRotation(90);
            }
        }
    }
}
