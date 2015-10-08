import greenfoot.*;

/**
 * Write a description of class IconSjip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IconSjip extends Menu
{
    /**
     * Act - do whatever the IconSjip wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int initialDelay = 10;
    private int delay = initialDelay;
    
    public void act()
    {
        selectionMove();
        selectOption();
    }
    public void selectionMove()
    {
     if(delay <= 0)
     {
       delay = 0;
     }
     if(Greenfoot.isKeyDown("S") && delay == 0)
     {
            setLocation(getX(), getY()+50);
            delay = initialDelay; 
     }
     if(Greenfoot.isKeyDown("W") && delay == 0)
        {
            setLocation(getX(), getY()-50);
            delay = initialDelay; 
        }
     if(getY() <= 280)
     {
         setLocation(getX(), 280);
     }
     if(getY() >= 430)
     {
         setLocation(getX(), 430);
     }
     delay--;
    }
    public void selectOption()
    {
     if(Greenfoot.isKeyDown("ENTER"))
     {
         if(getY() == 280)
         {
             Greenfoot.setWorld(new Space());
         }
         if(getY() == 430)
         {
            Greenfoot.stop(); 
         }
     }
    }
}
