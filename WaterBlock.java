import greenfoot.*;
public class WaterBlock extends NonPlayer
{
    public void act() 
    {
        // Add your action code here.
        super.act();
    }   
    
    public WaterBlock(){
        this(0);
    }
    
    public WaterBlock(int p)
    {
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
        
        getImage().setTransparency(150);
    } 
}
