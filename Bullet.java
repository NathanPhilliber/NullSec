import greenfoot.*;

//Written by John, Nathan

public class Bullet extends MovingNonPlayer
{
    
    private double speed=5;
    private boolean deleteMe = false;
    private boolean imOnscreenOnce = false;
    private double lastX = -1;
    
    //Written by John
    public void act() 
    {
        super.act();
        move(speed);
        deleteOnEdge();
        deleteMe();
    }  
    
    //Written by John
    public Bullet(int angle)
    {
        super();
        setRotation(angle);
    }

        
    //Written by Nathan
    public void deleteOnEdge(){
        if(getX() > w.getWidth()+50 || getX() < -50){
            if(imOnscreenOnce){
                deleteMe = true;
            }
        }
        else{
            imOnscreenOnce = true;
        }
        
        if(lastX == getRealX()){
            deleteMe = true;
        }
        lastX = getRealX();
    }

    

    //Written by Nathan
    public void deleteMe()
    {
        if ( deleteMe){
            w.removeObject(this);
        }
    }
}
