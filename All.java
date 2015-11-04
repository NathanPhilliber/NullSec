import greenfoot.*;
public class All extends Actor
{
    protected double cos(double angle)
    {
        return Math.cos(angle*2*Math.PI/360);
    }
    protected double sin(double angle)
    {
        return Math.sin(angle*2*Math.PI/360);
    }
    protected double cosRot()
    {
        return cos(getRotation());
    }
    protected double sinRot()
    {
        return sin(getRotation());
    }
}
