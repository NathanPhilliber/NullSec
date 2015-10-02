import greenfoot.*;

/**
 * Write a description of class BackgroundStar1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackgroundStar extends SpaceObject
{
    
    private static int numStars = 0;
    
    public BackgroundStar(double x, double y){
        super(x,y);
        addStar();
    }
    
    public BackgroundStar(){
        super();
        addStar();
    }
    
    public void act() 
    {
        // Add your action code here.
        super.act();
    } 
    
    public static int getNumStars(){
        return numStars;
    }
    
    private static void addStar(){
        numStars++;
    }
}
