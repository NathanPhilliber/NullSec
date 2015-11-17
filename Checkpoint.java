import greenfoot.*;

/**
 * Write a description of class Checkpoint here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Checkpoint extends NoCollisionBlock
{
    /**
     * Act - do whatever the Checkpoint wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean checkpointToggled;
    public Checkpoint(int n)
    {
    }
    public void act() 
    {
        super.act();
    }
    
    public void toggleCheckpoint()
    {
        if(!checkpointToggled)
        {
            Platformer p = (Platformer) getWorld();
            //p.setSpawnX((int)getRealX());
            //p.setSpawnY((int)getRealY());
            setImage("SavedCheckpoint.png");
            checkpointToggled = true;
        }
    }
}
