import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class BackgroundBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackgroundBlock extends NonPlayer
{
    public void act() 
    {
        super.act();
    }    

    public BackgroundBlock()
    {
        this(0);
    }

    public BackgroundBlock(int blockType)
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
        
        //getImage().setTransparency(200);
        getImage().setColor(new Color(0,0,0,120));
        getImage().fill();
        
    }  

    protected void addedToWorld(World world)
    {
        setRealX(getX());
        setRealY(getY());
    }   
}
