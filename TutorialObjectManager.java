import greenfoot.*;

//Written by Nathan

public class TutorialObjectManager extends SpaceObject
{

    private int currentTick = 0;
    private Space space;
    private Ship ship;

    private AlienShip alien1;
    private AlienShip alien2;

    private int stage = 0;

    private GreenfootSound ding1 = new GreenfootSound("sounds/ding1.wav");
    private GreenfootSound ding2 = new GreenfootSound("sounds/ding2.wav");

    protected void addedToWorld(World world){
        space = (Space) world;
        ship = space.getShip();

    }

    public void act() 
    {

        currentTick++;

        if(currentTick == 100 && stage == 0){
            setImage("images/MsgBox_Jebediah_1.png");
            getImage().setTransparency(200);
            setLocation(space.getWidth()/2,120);
            stage++;
            ding1.play();
        }
        else if(Greenfoot.isKeyDown("e") && stage == 1){
            setLocation(-1000,-1000);
            currentTick = 0;
            stage++;
            ding2.play();
        }

        if(currentTick == 50 && stage == 2){
            setImage("images/MsgBox_Luther_1.png");
            getImage().setTransparency(200);
            setLocation(space.getWidth()/2,120);
            stage++;
            ding1.play();
        }
        else if(Greenfoot.isKeyDown("e") && stage == 3){
            setLocation(-1000,-1000);
            currentTick = 0;
            stage++;
            ding2.play();
        }
        
        if(currentTick == 50 && stage == 4){
            setImage("images/MsgBox_Allis_1.png");
            getImage().setTransparency(200);
            setLocation(space.getWidth()/2,120);
            stage++;
            ding1.play();
        }
        else if(Greenfoot.isKeyDown("e") && stage == 5){
            setLocation(-1000,-1000);
            currentTick = 0;
            stage++;
            ding2.play();
        }
        
        if(currentTick == 50 && stage == 6){
            setImage("images/MsgBox_Allis_2.png");
            getImage().setTransparency(200);
            setLocation(space.getWidth()/2,120);
            stage++;
            ding1.play();
        }
        else if(Greenfoot.isKeyDown("e") && stage == 7){
            setLocation(-1000,-1000);
            currentTick = 0;
            stage++;
            ding2.play();
            Greenfoot.setWorld(new OuterSpace());
        }


    }    
}
