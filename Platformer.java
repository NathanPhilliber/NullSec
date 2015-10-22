import greenfoot.*;
public class Platformer extends World
{
    private double worldOffset=0;
    
    
    public static Level3 level = new Level3();
    
    
    public Platformer()
    {    
        super(920, 540, 1, false); //ORIGINAL SIZE 920 540 ALWAYS CHANGE BACK TO THIS WHEN DONE
        
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
