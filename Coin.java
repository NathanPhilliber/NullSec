import greenfoot.*;

//Written by Nathan

public class Coin extends NoCollisionBlock
{
    private GifImage coinAnimation = new GifImage("coinAnimation.gif");
    //private int delay = 0;
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
        /*
        delay++;
        if(delay>10){
            delay = 0;
            if(getX()>0 && getX()<w.getWidth())
                setImage(coinAnimation.getCurrentImage());
        }
        */
    }  

    public void pickup(){
        Player.goldPotential++;
        w.removeObject(this);
    }
}
