import greenfoot.*;

/**
 * Write a description of class Ball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ball extends NonPlayer
{
    /**
     * Act - do whatever the Ball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        turnAtEdge();
        super.act();
    }    

    public void turnAtEdge()
    {

        if (Greenfoot.getRandomNumber (100) < 30)
        {
            setRealX(getRealX() + Greenfoot.getRandomNumber (50-(25)));
        }

        if (getX() <= 5 || getX() >= getWorld().getWidth() -5)
        {
            turn(180);
        }
        if (getY() <= 5 || getY() >= getWorld().getHeight() -5)
        {
            turn(180);
        }

    }
}
