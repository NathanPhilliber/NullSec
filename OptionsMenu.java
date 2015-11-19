import greenfoot.*;

//Written by John

public class OptionsMenu extends World
{
    private Actor back=new Back();
    private Actor soundToggle=new SoundToggle();
    private boolean playing=false;
    private GreenfootSound music=new GreenfootSound("AmbientSpace.wav");
    
    private static int worldWidth = (int)(1280);
    private static int worldHeight = (int)(720);
    
    public OptionsMenu(GreenfootSound m)
    {    
        super(worldWidth, worldHeight, 1, false); 
        music=m;
        prepare();
    }
    
    public static int getWorldWidth()
    {
        return worldWidth;
    }
    
    public static int getWorldHeight()
    {
        return worldHeight;
    }
    
    public OptionsMenu()
    {    
        super(920,540,1); 
        prepare();
    }   
    

    private void prepare()
    {
        addObject(soundToggle,870,490);
        addObject(back,460,450);
        IconShip iconship = new IconShip();
        addObject(iconship, 59, 123);
        iconship.setLocation(41, 95);
        Resolution resolution = new Resolution(0);
        addObject(resolution, 210, 47);
        resolution.setLocation(209, 38);
        Resolution resolution2 = new Resolution(1);
        addObject(resolution2, 243, 106);
        resolution2.setLocation(224, 98);
        iconship.setLocation(40, 100);
        Resolution resolution3 = new Resolution(2);
        addObject(resolution3, 233, 150);
        resolution3.setLocation(238, 155);
        Resolution resolution4 = new Resolution(3);
        addObject(resolution4, 218, 215);
        resolution4.setLocation(252, 214);
        resolution3.setLocation(238, 157);
        resolution.setLocation(209, 34);
    }


    public void act()
    {
        mouseMenu();
        musicToggle();
    }
    private void mouseMenu()
    {       
        if (Greenfoot.mouseClicked(back))
        {
            music.stop();
        }
    }
    private void musicToggle()
    {
        if(StartMenu.musicToggle&&(!playing))
        {
            music.playLoop();
            playing=true;
        }
        if((!StartMenu.musicToggle)&&playing)
        {
            music.stop();
            playing=false;
        }
        if (StartMenu.musicToggle)
        {
            soundToggle.setImage("soundOn.png");
            if (Greenfoot.mouseClicked(soundToggle))
            {
                StartMenu.musicToggle=false;
            }
        }
        else
        {
            soundToggle.setImage("soundOff.png");
            if (Greenfoot.mouseClicked(soundToggle))
            {
                StartMenu.musicToggle=true;
            }
        }
    }
}
