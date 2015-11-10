import greenfoot.*;

//Written by Nathan

public class Coin extends NoCollisionBlock
{
    
    public Coin(){
        this(90);
    }
    
    public Coin(int blockType){
        super();

        setImage(LevelCreatorDisplayBlock.getBlock()[blockType]);
    }
    
    public void act() 
    {
        super.act();
    }  
    
    public void pickup(){
        Player.goldPotential++;
        w.removeObject(this);
    }
}
