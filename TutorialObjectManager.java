import greenfoot.*;
import java.awt.Color;

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

    CutsceneObject blackScreen = new CutsceneObject();

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
            //Greenfoot.setWorld(new OuterSpace());
        }

        if(stage == 8 && currentTick > 100){
            if(Greenfoot.isKeyDown("w")){
                stage++;
                currentTick = 0;
            }
        }

        if(currentTick == 50 && stage == 9){
            setImage("images/MsgBox_Maximo_0.png");
            getImage().setTransparency(200);
            setLocation(space.getWidth()/2,120);
            stage++;
            ding1.play();
        }
        else if(Greenfoot.isKeyDown("e") && stage == 10){
            setLocation(-1000,-1000);
            currentTick = 0;
            stage++;
            ding2.play();

            alien1 = new AlienShip(ship.getShipLocX()+100, ship.getShipLocY()-700);
            alien2 = new AlienShip(ship.getShipLocX()-250, ship.getShipLocY()-900);
            space.addObject(alien1, -1000,0);
            space.addObject(alien2, -1000,0);
        }

        if(stage == 11){
            if(!alien1.isAlive && !alien2.isAlive){
                stage++;
                currentTick = 0;
            }
        }

        if(currentTick == 50 && stage == 12){
            setImage("images/MsgBox_Jebediah_3.png");
            getImage().setTransparency(200);
            setLocation(space.getWidth()/2,120);
            stage++;
            ding1.play();
        }
        else if(Greenfoot.isKeyDown("e") && stage == 13){
            setLocation(-1000,-1000);
            currentTick = 0;
            stage++;
            ding2.play();
        }

        if(currentTick == 50 && stage == 14){
            setImage("images/MsgBox_Luther_2.png");
            getImage().setTransparency(200);
            setLocation(space.getWidth()/2,120);
            stage++;
            ding1.play();
        }
        else if(Greenfoot.isKeyDown("e") && stage == 15){
            setLocation(-1000,-1000);
            currentTick = 0;
            stage++;
            ding2.play();
        }

        if(currentTick == 50 && stage == 16){
            setImage("images/MsgBox_Jebediah_4.png");
            getImage().setTransparency(200);
            setLocation(space.getWidth()/2,120);
            stage++;
            ding1.play();
        }
        else if(Greenfoot.isKeyDown("e") && stage == 17){
            setLocation(-1000,-1000);
            currentTick = 0;
            stage++;
            ding2.play();
        }

        if(currentTick == 50 && stage == 18){
            setImage("images/MsgBox_Allis_0.png");
            getImage().setTransparency(200);
            setLocation(space.getWidth()/2,120);
            stage++;
            ding1.play();
        }
        else if(Greenfoot.isKeyDown("e") && stage == 19){
            setLocation(-1000,-1000);
            currentTick = 0;
            stage++;
            ding2.play();
        }

        if(currentTick == 50 && stage == 20){
            setImage("images/MsgBox_Rosa_0.png");
            getImage().setTransparency(200);
            setLocation(space.getWidth()/2,120);
            stage++;
            ding1.play();
        }
        else if(Greenfoot.isKeyDown("e") && stage == 21){
            setLocation(-1000,-1000);
            currentTick = 0;
            stage++;
            ding2.play();
        }

        if(currentTick == 50 && stage == 22){
            setImage("images/MsgBox_Jebediah_5.png");
            getImage().setTransparency(200);
            setLocation(space.getWidth()/2,120);
            stage++;
            ding1.play();
        }
        else if(Greenfoot.isKeyDown("e") && stage == 23){
            setLocation(-1000,-1000);
            currentTick = 0;
            stage++;
            ding2.play();
        }

        if(currentTick == 50 && stage == 24){
            setImage("images/MsgBox_Luther_3.png");
            getImage().setTransparency(200);
            setLocation(space.getWidth()/2,120);
            stage++;
            ding1.play();
        }
        else if(Greenfoot.isKeyDown("e") && stage == 25){
            setLocation(-1000,-1000);
            currentTick = 0;
            stage++;
            ding2.play();
        }

        if(currentTick == 50 && stage == 26){
            setImage("images/MsgBox_Rosa_1.png");
            getImage().setTransparency(200);
            setLocation(space.getWidth()/2,120);
            stage++;
            ding1.play();
        }
        else if(Greenfoot.isKeyDown("e") && stage == 27){
            setLocation(-1000,-1000);
            currentTick = 0;
            stage++;
            ding2.play();
        }

        if(currentTick == 50 && stage == 28){
            setImage("images/MsgBox_Rosa_2.png");
            getImage().setTransparency(200);
            setLocation(space.getWidth()/2,120);
            stage++;
            ding1.play();
        }
        else if(Greenfoot.isKeyDown("e") && stage == 29){
            setLocation(-1000,-1000);
            currentTick = 0;
            stage++;
            ding2.play();
        }

        if(currentTick == 50 && stage == 30){
            setImage("images/MsgBox_Rosa_3.png");
            getImage().setTransparency(200);
            setLocation(space.getWidth()/2,120);
            stage++;
            ding1.play();
        }
        else if(Greenfoot.isKeyDown("e") && stage == 31){
            setLocation(-1000,-1000);
            currentTick = 0;
            stage++;
            ding2.play();
        }

        if(currentTick == 50 && stage == 32){
            setImage("images/MsgBox_Jebediah_6.png");
            getImage().setTransparency(200);
            setLocation(space.getWidth()/2,120);
            stage++;
            ding1.play();
        }
        else if(Greenfoot.isKeyDown("e") && stage == 33){
            setLocation(-1000,-1000);
            currentTick = 0;
            stage++;
            ding2.play();
        }

        if(stage == 34 && currentTick == 75){
            space.addObject(blackScreen, space.getWidth()/2, space.getHeight()/2);
            blackScreen.fillScreen(Color.BLACK);
            blackScreen.getImage().setTransparency(0);
            stage++;
            currentTick = 0;
        }
        
        if(stage == 35){
            blackScreen.getImage().setTransparency(currentTick);
            if(currentTick >= 255){
                stage++;
                currentTick =0;
            }
        }
        
        if(stage == 36){
            OuterSpace s = new OuterSpace();
            Greenfoot.setWorld(new CutsceneA(s));
        }


    }    
}
