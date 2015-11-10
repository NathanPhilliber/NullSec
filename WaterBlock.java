import greenfoot.*;

//Written by Nathan

public class WaterBlock extends NoCollisionBlock
{
    public void act() 
    {
        // Add your action code here.
        super.act();
    }   
    
    public WaterBlock(){
        this(0);
    }
    
    private int myImage;
    
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
        myImage = p;
        getImage().setTransparency(150);
    } 
    
    public void addedToWorld(World world){
        super.addedToWorld(world);
        world.addObject(new WaterBlockBackground(myImage), getX(), getY());
    }
    
}
