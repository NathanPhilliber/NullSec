import greenfoot.*;

//Written by Nathan

public class WaterBlockBackground extends NoCollisionBlock
{
    public WaterBlockBackground(int p){

        super();
        if(p == 0)
        {
            setImage("WaterTop.png");
        }
        if(p == 1)
        {
            setImage("WaterMiddle.png");
        }
        if(p == 2)
        {
            setImage("WaterBottom.png");
        }

    }

    public void act() 
    {
        super.act();
        // Add your action code here.
    }    
}
