import greenfoot.*;
import java.awt.Color;

//Written by Trace and John

public class StartMenu extends World
{
    public static boolean musicToggle = true;
    private boolean playing=false;
    GreenfootSound music = new GreenfootSound("sounds/AmbientSpace.wav");
    private Options options = new Options();
    private Play play = new Play();
    private About about = new About();
    private Exit exit = new Exit();
    
    //Written by Trace
    public StartMenu()
    {    
        super(OptionsMenu.getWorldWidth(), OptionsMenu.getWorldHeight(), 1, false); 
        createStars(100);
        prepare();
    }
    //Written by Trace
    private void prepare()
    {
        Logo logo = new Logo();
        addObject(logo, getWidth()/2, 150);
        
        addObject(play, getWidth()/2, 280);
        addObject(options, getWidth()/2, 330);       
        addObject(about, getWidth()/2, 380);
        addObject(exit, getWidth()/2, 430);
        
        addObject(new IconShip(music), (getWidth()/2) - 135, 280);
    }
    
    //http://www.greenfoot.org/topics/730
    public void createStars(int number)
    {
        GreenfootImage background = getBackground();
        for(int i = 0; i < number; i++) 
        {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            GreenfootImage image = new GreenfootImage(2, 2);
            background.setColor(new Color(Greenfoot.getRandomNumber(255), Greenfoot.getRandomNumber(255), 
            Greenfoot.getRandomNumber(255)));
            background.fillOval(Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()), Greenfoot.getRandomNumber(3)+1,Greenfoot.getRandomNumber(3)+1);
        }
    }
    //Written by John
    public void act()
    {
        musicTogggle();
        mouseMenu();
    }
    //Written by John
    private void mouseMenu()
    {       
        if(Greenfoot.mouseClicked(options))
        {
            Greenfoot.setWorld(new OptionsMenu(music));
        }  
        if(Greenfoot.mouseClicked(play))
        {
            music.stop();
            Greenfoot.setWorld(new TutorialWorld());
        } 
        if(Greenfoot.mouseClicked(exit))
        {
            Greenfoot.stop();
        }
    }
    //Written by John
    private void musicTogggle()
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
    }
}
