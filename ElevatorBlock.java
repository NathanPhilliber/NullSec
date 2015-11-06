import greenfoot.*;

/**
 * Write a description of class ElevatorBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElevatorBlock extends Block
{

    public double spawnX;
    public double spawnY;
    public double speed = 2;
    public int radius = 4;
     

    public ElevatorBlock(){
        this(0);
    }

    public ElevatorBlock(int blockType){
        super(blockType);

    }

    public void act(){
        super.act();
        setRealY(getRealY() + speed);

       
        if((radius*27) <= Math.abs(getRealY()-spawnY)){
            speed *= -1;
            
            
        }
        
    }

    public void addedToWorld(World world){
        super.addedToWorld(world);

        spawnX = getRealX();
        spawnY = getRealY();

    }

}
