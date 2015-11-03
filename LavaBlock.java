import greenfoot.*;
public class LavaBlock extends NonPlayer
{
    public void act() 
    {
        super.act();
    }    
    public LavaBlock(int p)
    {
        super();
        if(p == 1)
        {
            setImage("Lava.png");
        }
        if(p == 2)
        {
            setImage("Lava2.png");
        }
    }  
}
