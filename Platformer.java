import greenfoot.*;
public class Platformer extends World
{
    private double worldOffset=0;
    
    public double returnX, returnY;
    
    
    
    public Platformer()
    {    
        this(0,0);
        
    }
    
    public Platformer(double returnX, double returnY){
        super(OptionsMenu.getWorldWidth(), OptionsMenu.getWorldHeight(), 1, false); //ORIGINAL SIZE 920 540 ALWAYS CHANGE BACK TO THIS WHEN DONE
        
        setPaintOrder(WaterBlock.class, PlatformPlayer.class);
        
        this.returnX = returnX - getWidth()/2;
        this.returnY = returnY - getHeight()/2;
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
