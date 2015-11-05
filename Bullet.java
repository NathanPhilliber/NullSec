import greenfoot.*;
public class Bullet extends MovingNonPlayer
{
    private double speed=5;
    private boolean deleteMe = false;
    
    public void act() 
    {
        super.act();
        move(speed);
        deleteMe();
    }  
    public Bullet(int angle)
    {
        //super();
        setRotation(angle);
    }
    
    
    
    public void deleteOnEdge(){
        if(isOffEdge(20)){
            deleteMe = true;
        }
    }
    private void inBlock()
    {
        Actor b=getOneIntersectingObject(blockType);
        if (b!=null)
        {
            addRealX(speed*Math.cos(getRotation()*2*Math.PI/360));
            addRealX(speed*Math.sin(getRotation()*2*Math.PI/360));
            //setLocation(speed*Math.cos(getRotation()*2*Math.PI/360)l
        }
    }
    
    public void deleteMe(){
        if ( deleteMe){
            w.removeObject(this);
        }
    }
}
