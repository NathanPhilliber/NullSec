import greenfoot.*;
public class Back extends Menu
{
    public void act() 
    {
        if(Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new StartMenu());
        }
    }
}
