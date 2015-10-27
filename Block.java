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
        if(blockType == 0)
        {
        setImage("brick.png");
        }
        
        if(blockType == 1)
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
