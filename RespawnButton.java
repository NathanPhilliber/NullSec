import greenfoot.*;
/**
 * Write a description of class RespawnButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RespawnButton extends RespawnMenu 
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class RespawnButton
     */
    public RespawnButton()
    {
        
    }
    public void act()
    {
        activate();
    }
    public void activate()
    {
        if(Greenfoot.mouseClicked(this))
        {
            Player.resetHealth();
            space.setPause = false;
            Player.respawnIsPressed = true;
            Player.justDied = true;
            getWorld().removeObjects(getWorld().getObjects(RespawnMenu.class));
        }
    }
}
