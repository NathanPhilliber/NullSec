import greenfoot.*;
public class Bullet extends MovingNonPlayer
{
    private double speed=5;
    public void act() 
    {
        super.act();
        move(speed);
    }  
    public Bullet(int angle)
    {
        super();
        setRotation(angle);
    }
    private void inBlock()
    {
        Actor b=getOneIntersectingObject(blockType);
        if (b!=null)
        {
            addRealX(speed*Math.cos(getRotation()*2*Math.PI/360));
            addRealX(speed*Math.sin(getRotation()*2*Math.PI/360));
            //setLocation(speed*Math.cos(getRotation()*2*Math.PI/360)l
        }
    }
}
