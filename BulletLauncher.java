import greenfoot.*;

//Written by Nathan

public class BulletLauncher extends Block
{
    public int rotation = 0;
    private int cooldown = 0;

    public void act() 
    {
        super.act();
        cooldown++;
        if(cooldown > 80){
            cooldown = 0;
            if(rotation == 0){
                getWorld().addObject(new Bullet(rotation),getX()+20,getY());
            }
            else if(rotation == 180){
                getWorld().addObject(new Bullet(rotation),getX()-20,getY());
            }

            if((getX()>0&&getX()<w.getWidth())&&(getY()>0&&getY()<w.getHeight())){
                GreenfootSound chime = new GreenfootSound("sounds/turretshoot.wav");
                chime.play();
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
