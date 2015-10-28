import greenfoot.*;

/**
 * Write a description of class Resolution here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Resolution extends Menu
{
    /**
     * Act - do whatever the Resolution wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    public Resolution(int opt)
    {
        if(opt == 1)
        {
            setImage("1920x1080.png");
        }
        if(opt == 2)
        {
            setImage("1280x720.png");
        }
        if(opt == 3)
        {
            setImage("920x540.png");
        }
    }
}
