import greenfoot.*;
import java.util.ArrayList;

/**
 * Write a description of class TraceHead here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TraceHead extends Block
{

    public int distanceFromOrg = 0;
    public int speed = 1;

    public int timeSince = 1;
    private int last = 0;

    private ArrayList<Block> necks = new ArrayList<Block>();

    private Block neck = new Block(92);

    public TraceHead(){
        this(91);
    }

    public TraceHead(int blockType){
        super(blockType);
    }

    public void act() 
    {
        super.act();
        
        if(timeSince > 10 && distanceFromOrg > 0){
            
            distanceFromOrg -= speed;
            if(distanceFromOrg%27==0){
                if(necks.size()>0){
                    w.removeObject(necks.get(necks.size()-1));
                    necks.remove(necks.size()-1);
                }
            }
            addRealY(speed);
            neck.addRealY(speed);
        }
        
        
        timeSince++;
    } 

    public void addedToWorld(World world){
        super.addedToWorld(world);
        w.addObject(neck, getX(), getY()+27);
        w.addObject(new Block(92), getX(), getY()+27);
    }

    public void grow(){
        
        timeSince = 0;
        addRealY(-speed);

        neck.addRealY(-speed);
        distanceFromOrg += speed;
        if(distanceFromOrg%27 == 0){
            Block j = new Block(92);
            w.addObject(j, getX(), getY()+27);
            necks.add(j);
        }
    }

}
