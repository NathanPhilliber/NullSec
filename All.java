import greenfoot.*;/**>>>>John<<<<**/
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
    //from 0 to 360 to -180 to 180 
    protected int angleRange(int angle)
    {
        if (angle<=180)
        {
            return angle;
        }
        else
        {
            return angle-360;
        }
    }
}
