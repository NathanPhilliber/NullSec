import greenfoot.*;
public class BulletLauncher extends Block
{
    public void act() 
    {
        super.act();
        getWorld().addObject(new Bullet(180),getX(),getY());
    }   
    public BulletLauncher()
    {
        super();
    }
}
