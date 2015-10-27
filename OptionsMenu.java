import greenfoot.*;
public class OptionsMenu extends World
{
    private Actor back=new Back();
    private Actor soundToggle=new SoundToggle();
    private boolean playing=false;
    private GreenfootSound music=new GreenfootSound("AmbientSpace.wav");
    public OptionsMenu(GreenfootSound m)
    {    
        super(920,540,1); 
        music=m;
        prepare();
    }
    
    private void prepare()
    {
        addObject(soundToggle,870,490);
        addObject(back,460,450);
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
