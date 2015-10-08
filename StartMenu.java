import greenfoot.*;
import java.awt.Color;
/**
 * Write a description of class StartMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartMenu extends World
{

    /**
     * Constructor for objects of class StartMenu.
     * 
     */
    public StartMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(920, 540, 1, false); 
        createStars(100);
        prepare();
    }

    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
        Logo logo = new Logo();
        addObject(logo, 460, 150);

        Play play = new Play();
        addObject(play, 460, 280);

        Options options = new Options();
        addObject(options, 460, 330);

        About about = new About();
        addObject(about, 460, 380);

        Exit exit = new Exit();
        addObject(exit, 460, 430);
        
        IconSjip iconsjip = new IconSjip();
        addObject(iconsjip, 325, 280);
        
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
}
