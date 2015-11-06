import greenfoot.*;

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
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
