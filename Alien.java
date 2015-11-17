import greenfoot.*;

//Written by John


public class Alien extends MovingNonPlayer
{
    public void act()
    {
        super.act();
        gravity(gravity);
    }
    public Alien()
    {
        super();
        moveBackAndForth(true); //Makes the alien walk until it hits something then turns around. 
        setHasGif(true); //Sets variable in moving player to change image depending on velocity etc. Will override images in this class eventually.
    }
}