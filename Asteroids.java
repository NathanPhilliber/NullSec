import greenfoot.*;

/**
 * Write a description of class Asteroids here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Asteroids extends Object
{

    private int turnSpeed = Greenfoot.getRandomNumber(10);
    private int speed = Greenfoot.getRandomNumber(20) - 10;
    
    public void act() 
    {
       super.act();
       asteroidMovement();
    }
    public void asteroidMovement()
    {
      turn(turnSpeed);
      setLocation(this.getX() + speed, this.getY() + speed);
    }
}
