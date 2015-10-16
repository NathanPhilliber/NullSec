import greenfoot.*;
import java.util.List;
/**
 * Write a description of class PlayerHover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerHover extends PlatformOne
{
    public void act() 
    {
        if(Greenfoot.isKeyDown("d"))
        {
            List<WorldOneFG> floor = getWorld().getObjects(WorldOneFG.class);
            for(WorldOneFG a : floor)
            {
                a.setLocation(a.getX() - 5,a.getY());
            }
        }
        if(Greenfoot.isKeyDown("a"))
        {
            List<WorldOneFG> floor =  getWorld().getObjects(WorldOneFG.class);
            for(WorldOneFG a : floor)
            {
                a.setLocation(a.getX() + 5,a.getY());
            }
        }
    }
}    

