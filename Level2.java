import greenfoot.*;

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends Platformer
{
    public Level2()
    {
        this(0,0);
    }
    public Level2(double returnX, double returnY)
    {
        super(returnX, returnY);
        prepare();
    }
    
    private double worldOffset = 0;
    private void prepare()
    {
        addObject(new PlatformPlayer(),540,50);

        addObject(new ExitPortal(),4580, 412);

        for (int i = 0; i <= 75; i++)
        {
            addObject(new Block(), 27*i, 500);
        }

        for (int i = 0; i <= 75; i++)
        {
            addObject(new LavaBlock(1), 27*i+2052, 500);
        }

        for (int i = 0; i <= 36; i++)
        {
            addObject(new Block(), 27*i+189, 473);
        }

        for (int i = 0; i <= 15; i++)
        {
            addObject(new Block(), 27*i+1350, 473);
        }

        for (int i = 0; i <= 22; i++)
        {
            addObject(new Block(), 27*i+351, 446);
        }

        for (int i = 0; i <= 8; i++)
        {
            addObject(new Block(), 27*i+1404, 446);
        }

        for (int i = 0; i <= 6; i++)
        {
            addObject(new Block(), 27*i+405, 419);
        }

        for (int i = 0; i <= 6; i++)
        {
            addObject(new Block(), 27*i+2322, 419);
        }

        for (int i = 0; i <= 3; i++)
        {
            addObject(new Block(), 27*i+2727, 392);
        }

        for (int i = 0; i <= 0; i++)
        {
            addObject(new Block(), 27*i+3132, 392);
        }

        for (int i = 0; i <= 6; i++)
        {
            addObject(new Block(), 27*i+3456, 446);
        }

        for (int i = 0; i <= 50; i++)
        {
            addObject(new Block(), 27*i+4077, 500);
        }

        for (int i = 0; i <= 12; i++)
        {
            addObject(new Block(), 27*i+4050, 473);
        }

        for (int i = 0; i <= 6; i++)
        {
            addObject(new Block(), 27*i+3996, 446);
        }

        for (int i = 0; i <= 75; i++)
        {
            addObject(new Block(), 27*i, 527);
        }

        for (int i = 0; i <= 75; i++)
        {
            addObject(new LavaBlock(2), 27*i+2052, 527);
        }

        for (int i = 0; i <= 75; i++)
        {
            addObject(new Block(), 27*i+4050, 527);
        }
        
        Ball ball = new Ball();
        addObject(ball, 185, 126);
        Ball ball2 = new Ball();
        addObject(ball2, 181, 274);
        Ball ball3 = new Ball();
        addObject(ball3, 848, 346);
        Ball ball4 = new Ball();
        addObject(ball4, 333, 159);
        Ball ball5 = new Ball();
        addObject(ball5, 537, 255);
    }
    
    public double getOffset()
    {
        return worldOffset;
    }
    public void setOffset(double Of)
    {
        worldOffset=Of;
    }
}
