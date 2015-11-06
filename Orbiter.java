import greenfoot.*;
public class Orbiter extends SpaceObject 
{
    private double centerX;
    private double centerY;
    private double radius;
    private int step;
    public void act()
    {
        super.act();
        step++;
        if(step>=360)
        {
            step=0;
        }
        setSpaceX(centerX+radius*cos(step));
        setSpaceY(centerY+radius*sin(step));
    }    
    public Orbiter(double x,double y,double rad)
    {
        super(x+rad,y);
        centerX=x;
        centerY=y;
        radius=rad;
    }
}
