import greenfoot.*;
public class Level3 extends Platformer
{
    public Level3()
    {
        prepare();
    }
    
    private double worldOffset=0;
    private void prepare()
    {
        addObject(new PlatformPlayer(),300,50);
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
