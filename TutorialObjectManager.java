import greenfoot.*;

/**
 * Write a description of class TutorialObjectManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TutorialObjectManager extends SpaceObject
{
    /**
     * Act - do whatever the TutorialObjectManager wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    private int currentTick = 0;

    private Space space;
    private Ship ship;

    private AlienShip alien1;
    private AlienShip alien2;

    private int stage = 0;

    protected void addedToWorld(World world){
        space = (Space) world;
        ship = space.getShip();

    }

    public void act() 
    {

        currentTick++;

        if(currentTick == 100 && stage == 0){
            setImage("images/TutorialSlide1.png");
            setLocation(450,110);
            stage++;
        }
        else if(Greenfoot.isKeyDown("e") && stage == 1){
            setLocation(1000,1000);
            currentTick = 0;
            stage++;
        }

        else if(currentTick == 50 && stage == 2){
            setImage("images/TutorialSlide2.png");
            setLocation(450,110);
            stage++;
        }
        else if(Greenfoot.isKeyDown("e") && stage == 3){
            setLocation(1000,1000);
            currentTick = 0;
            stage++;
        }

        else if(currentTick == 50 && stage == 4){
            setImage("images/TutorialSlide3.png");
            setLocation(450,110);
            stage++;
        }
        else if(Greenfoot.isKeyDown("e") && stage == 5){
            setLocation(1000,1000);
            currentTick = 0;
            stage++;
        }

        else if(currentTick == 50 && stage == 6){
            setImage("images/TutorialSlide4.png");
            setLocation(450,110);
            stage++;
        }
        else if(Greenfoot.isKeyDown("e") && stage == 7){
            setLocation(1000,1000);
            currentTick = 0;
            stage++;
        }

        else if(currentTick == 75 && stage == 8){
            setImage("images/TutorialSlide5.png");
            setLocation(450,110);
            stage++;
        }
        else if(Greenfoot.isKeyDown("e") && stage == 9){
            stage++;
            setLocation(1000,1000);
            currentTick = 0;

            alien1 = new AlienShip(ship.getShipLocX()+500, ship.getShipLocY()+500);
            alien2 = new AlienShip(ship.getShipLocX()-500, ship.getShipLocY()-500);

            alien1.decayOff();
            alien2.decayOff();

            space.addObject(alien1, -10,-10);
            space.addObject(alien2, -10, -10);

            alien1.spawnX = (int)ship.getShipLocX()+75;
            alien1.spawnY = (int)ship.getShipLocY()+80;

            alien2.spawnX = (int)ship.getShipLocX()-45;
            alien2.spawnY = (int)ship.getShipLocY()-65;

            alien1.addAction("moveTo/" + (ship.getShipLocX()+75) + "/" + (ship.getShipLocY()+80));
            alien2.addAction("moveTo/" + (ship.getShipLocX()-45) + "/" + (ship.getShipLocY()-65));
        }

        else if(stage == 10){
            if(alien1 != null && alien2 != null){
                if(alien1.isAlive == false && alien2.isAlive == false){
                    stage++;
                }
            }
        }
        
            

    }    
}