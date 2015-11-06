/**
 * Write a description of class BeamBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
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
          getWorld().removeObject(this);
          delay = 10;
      }
      else 
      {
          delay--;
      }
   }
}
