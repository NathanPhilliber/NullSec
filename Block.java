import greenfoot.*;
public class Block extends NonPlayer
{
    public void act() 
    {
        super.act();
    }    
    public Block()
    {
        super();
    }
    
    public Block(int blockType)
    {
        if(blockType == 1)
        {
        setImage("brick.png");
        }
        
        if(blockType == 2)
        {
        setImage("BlueBrick.png");
        }
    }  
    protected void addedToWorld(World world)
    {
        setRealX(getX());
        setRealY(getY());
    }
}
