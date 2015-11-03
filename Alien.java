import greenfoot.*;
public class Alien extends MovingNonPlayer
{
    
    GifImage walkRight = new GifImage("Alien1.png");
    GifImage walkLeft = new GifImage("Alien1.png");
    GifImage standRight = new GifImage("Alien1.png");
    GifImage standLeft = new GifImage("Alien1.png");
    public void act()
    {
        super.act();
        gravity(gravity);
        //moveX();
    }
    public Alien()
    {
        super();
    }
   
}