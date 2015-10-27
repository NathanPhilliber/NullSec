import greenfoot.*;
import java.awt.Color;
public class StartMenu extends World
{
    static boolean musicToggle = true; 
    private boolean playing=false;
    GreenfootSound music = new GreenfootSound("sounds/AmbientSpace.wav");
    private Options options = new Options();
    private Play play = new Play();
    private About about = new About();
    private Exit exit = new Exit();
    public StartMenu()
    {    
        super(920, 540, 1, false); 
        createStars(100);
        prepare();
    }
    private void prepare()
    {
        Logo logo = new Logo();
        addObject(logo, 460, 150);
        
        addObject(play, 460, 280);
        addObject(options, 460, 330);       
        addObject(about, 460, 380);
        addObject(exit, 460, 430);
        
        addObject(new IconShip(music), 325, 280);
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
    public void act()
    {
        musicTogggle();
        mouseMenu();
    }
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
