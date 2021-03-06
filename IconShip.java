import greenfoot.*;
public class IconShip extends Menu
{
    private int initialDelay = 10;
    private int delay = initialDelay;
    GreenfootSound music;
    private boolean dontAct = true;
    public IconShip(GreenfootSound m)
    {
        music=m;
    }

    public IconShip()
    {
    }

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
        if(getY() <= getWorld().getHeight()/2-50 && getWorld() instanceof OptionsMenu)
        {
            setLocation(getX(), getWorld().getHeight()/2-50);
        }
        if(getY() <= 280 && getWorld() instanceof StartMenu)
        {
            setLocation(getX(), 280);
        }
        if(getY() >= 380 && getWorld() instanceof OptionsMenu)
        {
            setLocation(getX(), 380); 
        }
        if(getY() >= 430 && getWorld() instanceof StartMenu)
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
            GreenfootSound ding = new GreenfootSound("sounds/buttonSound.wav");
            ding.play();
            if(getY() == 280)
            {
                Greenfoot.setWorld(new TutorialWorld());
            }
            if(getY() == 430)
            {
                System.exit(0);
            }
            if(getY() == 330)
            {
                Greenfoot.setWorld(new OptionsMenu(music));
            }
            if(getY() == 380)
            {
                Greenfoot.setWorld(new Credits(new StartMenu()));
            } 
        }
    }
}
