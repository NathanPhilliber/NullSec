import greenfoot.*;
public class IconShip extends Menu
{
    private int initialDelay = 10;
    private int delay = initialDelay;
    GreenfootSound music;
    public IconShip(GreenfootSound m)
    {
        music=m;
    }
    
    public IconShip()
    {
    }
    
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
        if(delay <= -1000000){
            delay =  0;
        }
    }

    public void selectOption()
    {
        if(Greenfoot.isKeyDown("ENTER"))
        {
            if(getY() == 280)
            {
                music.stop();
                Greenfoot.setWorld(new TutorialWorld());
            }
            if(getY() == 430)
            {
                Greenfoot.stop(); 
            }
            if(getY() == 330)
            {
                Greenfoot.setWorld(new OptionsMenu(music));
            }
        }
    }
}
