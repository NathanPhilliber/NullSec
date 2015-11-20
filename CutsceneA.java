import greenfoot.*;
import java.awt.Color;

public class CutsceneA extends Cutscene
{

    private int time = 0;
    private int stage = 0;
    private int countA = 0;

    CutsceneObject ship = new CutsceneObject("images/RocketBoost.png");
    CutsceneObject shockwave = new CutsceneObject("images/shockwave.png");
    CutsceneObject enterText = new CutsceneObject("images/enteringnullsec.png");
    CutsceneObject redScreen = new CutsceneObject();
    CutsceneObject whiteScreen = new CutsceneObject();
    public CutsceneA(){
        this(null);
    }

    public CutsceneA(World world)
    {
        super(world);

        addObject(ship, -100, getHeight()/2);
        addObject(enterText, getWidth()/2, 300);
        enterText.getImage().setTransparency(0);
    }

    public void act(){
        super.act();
        time++;

        if(time >= 20 && stage ==0){
            enterText.getImage().setTransparency(time-20);
            if(time-20 == 255){
                stage++;
            }
        }

        if(time >= 10 && stage == 1){
            ship.move(3);
            if(ship.getX()>= getWidth()/3){
                stage++;
                time = 0;
            }
        }

        if(time >= 40 && (stage == 1 || stage == 2)){
            countA+=4;
            if(255-countA >= 0){
                enterText.getImage().setTransparency(255-countA);
            }
            if(255-countA <=4){
                enterText.getImage().setTransparency(0);
            }

        }

        if(stage == 2){
            if(time >= 20){
                stage++;
                addObject(shockwave, getWidth()+100, getHeight()/2);
            }
            ship.setLocation(ship.getX()-Greenfoot.getRandomNumber(16)+8,ship.getY()-Greenfoot.getRandomNumber(16)+8);
        }

        if(stage == 3){
            if(time >= getWidth()/40+200){
                stage++;
                time = 0;
            }
            shockwave.move(-40);

            ship.setLocation(ship.getX()-Greenfoot.getRandomNumber(16)+8,ship.getY()-Greenfoot.getRandomNumber(16)+8);
        }

        if(stage == 4 && time == 0){
            ship.setLocation(getWidth()/3, getHeight()/2);
            addObject(redScreen, getWidth()/2, getHeight()/2);
            redScreen.fillScreen(Color.RED);
            redScreen.getImage().setTransparency(0);
            stage++;
            time = 0;
        }

        if(stage == 5 && time <= 300){
            ship.setLocation(ship.getX()-Greenfoot.getRandomNumber(16)+8,ship.getY()-Greenfoot.getRandomNumber(16)+8);
            ship.turn(Greenfoot.getRandomNumber(30)-15);
            redScreen.getImage().setTransparency(Math.abs((time*8)%255));
            if(time == 300){
                time = 0;
                stage++;
                redScreen.getImage().setTransparency(0);
                addObject(whiteScreen, getWidth()/2, getHeight()/2);
                whiteScreen.fillScreen(Color.WHITE);
                whiteScreen.getImage().setTransparency(0);
            }
        }

        if(stage == 6 && time <= 255){
            whiteScreen.getImage().setTransparency(time);
            ship.setLocation(ship.getX()-Greenfoot.getRandomNumber(16)+8,ship.getY()-Greenfoot.getRandomNumber(16)+8);
            ship.turn(Greenfoot.getRandomNumber(30)-15);
            
            if(time == 255){
                stage++;
                time = 0;
            }
        }

        
    }
}
