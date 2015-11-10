import greenfoot.*;

//Written by John and Nathan

public class Platformer extends World
{
    private double worldOffset=0;
    public double returnX, returnY;
    
    //Written by Nathan
    public Platformer()
    {    
        this(0,0);
    }
    
    //Written by Nathan
    public Platformer(double returnX, double returnY){
        super(OptionsMenu.getWorldWidth(), OptionsMenu.getWorldHeight(), 1, false); //ORIGINAL SIZE 920 540 ALWAYS CHANGE BACK TO THIS WHEN DONE
        
        setPaintOrder(Coin.class, ElevatorBlock.class,WaterBlock.class, PlatformPlayer.class, WaterBlockBackground.class);
        
        this.returnX = returnX - getWidth()/2;
        this.returnY = returnY - getHeight()/2;
    }
    
    
    //Written by John
    public double getOffset()
    {
        return worldOffset;
    }
    //Written by John
    public void setOffset(double Of)
    {
        worldOffset=Of;
    }
    //Written by John
    public void addOffset(double Of)
    {
        worldOffset+=Of;
    }
}
