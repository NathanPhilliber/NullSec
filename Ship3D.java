import greenfoot.*;

/**
 * Write a description of class Ship3D here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ship3D extends WeaponShop
{
    /**
     * Act - do whatever the Ship3D wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GifImage gifImage = new GifImage("ShipAnimation.gif");
    public void act()
    {
        setImage(gifImage.getCurrentImage());
    }
}
