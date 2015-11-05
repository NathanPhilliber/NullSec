import greenfoot.*;
public class Cannon extends Player
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
