import greenfoot.*;

/**
 * Write a description of class OptionsMenuPointer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OptionsMenuPointer extends Menu
{
    private int initialDelay = 10;
    private int delay = initialDelay;
    GreenfootSound music;
    private boolean dontAct = true;

    public void act()
    {
        if(!dontAct)
        {
            selectionMove();
            selectOption();
        }
        else
        {
            if(!Greenfoot.isKeyDown("ENTER"))
            {
                dontAct = false;
            }
        }
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
        if(getY() <= getWorld().getHeight()/2-50)
        {
            setLocation(getX(), getWorld().getHeight()/2-50);
        }
        if(getY() >= getWorld().getHeight()/2+50)
        {
            setLocation(getX(), getWorld().getHeight()/2+50); 
        }
        delay--;
        if(delay <= -1000000){
            delay =  0;
        }
    }

    public void selectOption()
    {
        if(Greenfoot.isKeyDown("ENTER")){
            if(getY() == getWorld().getHeight()/2-50)
            {
                OptionsMenu.worldWidth = 1920;
                OptionsMenu.worldHeight = 1080;
            }
            if(getY() == getWorld().getHeight()/2)
            {
                OptionsMenu.worldWidth = 1280;
                OptionsMenu.worldHeight = 720;
            }
            if(getY() == getWorld().getHeight()/2+50)
            {
                OptionsMenu.worldWidth = 920;
                OptionsMenu.worldHeight = 540;
            }
            Greenfoot.setWorld(new StartMenu());
        }
    }
}
