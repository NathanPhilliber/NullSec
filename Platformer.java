import greenfoot.*;
public class Platformer extends World
{
    private double worldOffset=0;
    public Platformer()
    {    
        super(920, 540, 1, false); //ORIGINAL SIZE 920 540 ALWAYS CHANGE BACK TO THIS WHEN DONE
        prepare();
    }
    private void prepare()
    {
        addObject(new PlatformPlayer(),100,50);
        for (int i = -10; i <= 35; i++)
        {
            addObject(new Block(), 26*i+13, 525);
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
