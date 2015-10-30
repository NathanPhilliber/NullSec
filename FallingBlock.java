import greenfoot.*;

/**
 * Write a description of class FallingBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FallingBlock extends Block
{
    private boolean isFalling = false;
    private double orgX;
    private double orgY;

    private double fallSpeed = 5.0;

    private int cycleRespawn = 100;
    public int delayToFall = 25;

    private int curDelay = 0;

    public void act() 
    {
        super.act();
        fallHelper();
    }    

    public FallingBlock()
    {
        this(0);
    }

    public FallingBlock(int blockType)
    {
        super(blockType);

    } 

    public void startFalling(){
        if(isFalling == false){
            isFalling = true;
            curDelay = delayToFall;
        }
    }

    private void fallHelper(){
        if(isFalling){
            if(curDelay > 0){
                curDelay--;
            }
            else{

                setRealY(getRealY()+fallSpeed);
                if(getY() > 1200){
                    isFalling = false;
                    setRealX(orgX);
                    setRealY(orgY);
                }
            }
        }
    }

    protected void addedToWorld(World world)
    {
        setRealX(getX());
        setRealY(getY());
        orgX = getX();
        orgY = getY();

    }  
}
