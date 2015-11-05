import greenfoot.*;
public class BulletLauncher extends Block
{
    public int rotation = 0;
    private int cooldown = 0;

    public void act() 
    {
        super.act();
        cooldown++;
        if(cooldown > 100){
            cooldown = 0;
            if(rotation == 0){
                getWorld().addObject(new Bullet(rotation),getX()+28,getY());
            }
            else if(rotation == 180){
                getWorld().addObject(new Bullet(rotation),getX()-28,getY());
            }
        }

    }   

    public BulletLauncher(int blockType, int direction)
    {
        super(blockType);
        rotation = direction;
    }
    public BulletLauncher()
    {
        this(0,0);
    }
}
