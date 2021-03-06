import greenfoot.*;

//Written by John and Nathan

public class Platformer extends World
{
    private double worldXOffset=0;
    private double worldYOffset=0;
    public double returnX, returnY;

    //Written by Nathan
    public Platformer()
    {    
        this(0,0);
    }

    //Written by Nathan
    public Platformer(double returnX, double returnY){
        super(OptionsMenu.getWorldWidth(), OptionsMenu.getWorldHeight(), 1, false); //ORIGINAL SIZE 920 540 ALWAYS CHANGE BACK TO THIS WHEN DONE

        setPaintOrder(GoldText.class, Number.class, Digit.class, BlackBox.class, SpikeBlock.class, Coin.class, Cart.class, ElevatorBlock.class,WaterBlock.class, PlatformPlayer.class, WaterBlockBackground.class);

        this.returnX = returnX - getWidth()/2;
        this.returnY = returnY - getHeight()/2;
        if(getHeight() > 540)
        {
            BlackBox bb = new BlackBox();
            int y = getHeight() - ((getHeight()-540)/2);
            addObject(bb, getWidth()/2, y+78);
            bb.getImage().scale(getWidth(), y/4);

            BlackBox bb2 = new BlackBox();
            int y2 = 0;
            addObject(bb2, getWidth()/2, y2);
            bb2.getImage().scale(getWidth(), y/4 + 10);
        }
        getBackground().scale(getWidth(), getHeight());
    }

    //Written by John
    public double getXOffset()
    {
        return worldXOffset;
    }

    public void setXOffset(double Of)
    {
        worldXOffset=Of;
    }

    public void addXOffset(double Of)
    {
        worldXOffset+=Of;
    }

    public double getYOffset()
    {
        return worldYOffset;
    }

    public void setYOffset(double Of)
    {
        worldYOffset=Of;
    }

    public void addYOffset(double Of)
    {
        worldYOffset+=Of;
    }
}
