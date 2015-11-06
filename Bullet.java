import greenfoot.*;
public class Bullet extends MovingNonPlayer
{
    private double speed=5;
    private boolean deleteMe = false;
    private boolean imOnscreenOnce = false;
    private double lastX = -1;
    public void act() 
    {
        super.act();
        move(speed);
        deleteOnEdge();
        deleteMe();
    }  

    public Bullet(int angle)
    {
        super();
        setRotation(angle);
    }

        
    
    public void deleteOnEdge(){
        if(getX() > w.getWidth() || getX() < 0){
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

    

    public void deleteMe()
    {
        if ( deleteMe){
            w.removeObject(this);
        }
    }
}
