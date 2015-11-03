import greenfoot.*;
import java.util.ArrayList;

/**
 * Write a description of class Number here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Number extends Menu
{
    ArrayList<Digit> digits = new ArrayList();

    public Number(String numbers){
        setImage("transparent.png");

        for(int i = 0; i < numbers.length(); i++){
            char c = numbers.charAt(i); 

            digits.add(new Digit((Integer)Character.getNumericValue(c)));
        }

    }
    public void addedToWorld(World world){
        for(int i = 0; i < digits.size(); i++){
            world.addObject(digits.get(i), getX()+i*45-45, getY());
        }

    }

    public void remove(){
        World world = getWorld();
        
        world.removeObjects(digits);

        world.removeObject(this);

    }

    public void act() 
    {
        // Add your action code here.
    }    
}
