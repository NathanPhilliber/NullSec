import greenfoot.*;

/**
 * Write a description of class Track here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Track extends NoCollisionBlock
{
    public Track(){
        this(0);
    }
    
    public Track(int blockType){
        
        super();

        setImage(LevelCreatorDisplayBlock.getBlock()[blockType]);
        
    }
    public void act() 
    {
        super.act();
        // Add your action code here.
    }  
}
