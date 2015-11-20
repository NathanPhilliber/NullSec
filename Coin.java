import greenfoot.*;

//Written by Nathan

public class Coin extends NoCollisionBlock
{
    private GifImage coinAnimation = new GifImage("coinAnimation.gif");
    public Coin(){
        this(90);
    }
    
    public Coin(int blockType){
        super();
        setImage(coinAnimation.getCurrentImage());
    }
    
    public void act() 
    {
        super.act();
        //setImage(coinAnimation.getCurrentImage());
    }  
    
    public void pickup(){
        Player.goldPotential++;
        w.removeObject(this);
    }
}
