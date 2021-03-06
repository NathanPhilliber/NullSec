import greenfoot.*;

//Written by Trace

public class BoostBarSegment extends BoostBar implements ProjectileObject
{
   private int delay = 100;
    
   public void act()
   {
       removeMe();
   }
   public void removeMe()
   {
      if(delay <= 0)
      {
          space.removeObject(this);
          delay = 10;
      }
      else 
      {
          delay--;
      }
   }
}
