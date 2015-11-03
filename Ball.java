import greenfoot.*;
public class Ball extends MovingNonPlayer
{
    public void act() 
    {
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
