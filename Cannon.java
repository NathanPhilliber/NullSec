import greenfoot.*;
public class Cannon extends Ship
{
    public void act() 
    { 
       Space theWorld = (Space) getWorld();
       if(!theWorld.isPaused)
       {
           setRotation(getMouseAngle());
       }
    }
}
