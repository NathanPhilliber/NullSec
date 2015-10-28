import greenfoot.*;
public class Block extends NonPlayer
{
    
    
    public void act() 
    {
        super.act();
    }    

    public Block()
    {
        this(0);
    }

    public Block(int blockType)
    {
        super();
        
        if(blockType == 0)
        {
            setImage("brick.png");
        }

        if(blockType == 1)
        {
            setImage("BlueBrick.png");
        }

        if(blockType == 6){
            setImage("MoonBrick.png");
        }
        if(blockType == 7){
            setImage("MoonBrickTop.png");
        }
        if(blockType == 8){
            setImage("GooTop.png");
        }
        if(blockType == 9){
            setImage("GooBottom.png");
        }
        if(blockType == 10){
            setImage("WaterTop.png");
        }
        if(blockType == 11){
            setImage("WaterMiddle.png");
        }
        if(blockType == 12){
            setImage("WaterBottom.png");
        }
        if(blockType == 13){
            setImage("Dirt.png");
        }
        if(blockType == 14){
            setImage("Grass.png");
        }
        if(blockType == 15){
            setImage("SingleStone.png");
        }if(blockType == 16){
            setImage("StoneSquare.png");
        }
        if(blockType == 17){
            setImage("GreyStone1.png");
        }

        if(blockType == 18){
            setImage("GreyStone2.png");
        }
        if(blockType == 19){
            setImage("SandTop.png");
        }
        if(blockType == 20){
            setImage("SandMiddle.png");
        }
        if(blockType == 21){
            setImage("CrackedPurple.png");
        }
        
        
    }  

    protected void addedToWorld(World world)
    {
        setRealX(getX());
        setRealY(getY());
    }
}
