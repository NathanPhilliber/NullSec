import greenfoot.*;
import java.awt.Color;
import java.util.List;

//Written by Nathan

public class Planet extends SpaceObject
{
    public World world;
    public PlanetLevelText label;
    private boolean labelInWorld = false;
    private CompletedLabel complete = new CompletedLabel();
    String worldNumber;
    public boolean isBeaten = false;
    public int sectorLevel; //use a number 0-4

    private boolean firstTime = true;

    public Planet(double startX, double startY, World world, String image, String worldNumber, int sectorLevel){
        super(startX, startY);
        this.world = world;
        setImage(image);
        this.worldNumber = worldNumber;
        this.sectorLevel = sectorLevel;
        //System.out.println(world);
    }

    public void act() 
    {
        super.act();
        if(isBeaten){
            miniMap(new PlanetCompletedMP());
        }
        else{
            miniMap(new PlanetMP());
        }

        tryDrawLabel();
        if(firstTime){
            firstTime = false;
            if(Player.levelsBeaten[sectorLevel][space.getSector(this)]){
                //GreenfootImage image=getImage();
                //image.setColor(Color.WHITE);
                //image.fill();
                //setImage(image);

                isBeaten = true;
            }
        }
        //checkDock();
    }

    public void exitWorldWithoutWinning(){
        System.out.println(Player.aboutToPlayCompletedLevel);
        if(Player.aboutToPlayCompletedLevel == false){
            System.out.println("IM FUCKING HERE");
            Player.levelsBeaten[sectorLevel][space.getSector(this)] = false;
            isBeaten = false;
        }
    }

    public void loadWorld(){
        //add check for what world is beaten. Going to have to store it in player or some shit because this variable will
        //be overwritten when outerspace is reloaded every time. 
        //Add check to make sure you dont run off the player.levelsbeaten array.

        Player.planetImGoingTo = this;

        if(Player.levelsBeaten[sectorLevel][space.getSector(this)]){
            Player.aboutToPlayCompletedLevel = true;
            System.out.println("THIS LEVEL IS ALREADY FUCKING DONE");
        }
        else{
            Player.aboutToPlayCompletedLevel = false;
            System.out.println("THIS LEVEL IS FUCKING NEW");
        }

        Player.levelsBeaten[sectorLevel][space.getSector(this)] = true;

        if(!isBeaten){
            if(Player.isSectorComplete(Player.workingSector)){ //RESET THIS BULLSHIT FUCK YOU TRACE ILL DO THIS LATER
                Player.workingSector++;
            }
        }
        //Player.levelsBeaten[Player.getNextIncompleteLevel(space.getSector(this))][space.getSector(this)] = true;

        Greenfoot.setWorld(world);
    }

    public void addedToWorld(World world){
        super.addedToWorld(world);
        label = new PlanetLevelText(worldNumber, 1);

    }

    public void tryDrawLabel(){
        MouseInfo mouse = Greenfoot.getMouseInfo();

        if (mouse != null) {

            if(label != null && labelInWorld){
                label.remove();
                labelInWorld = false;

                if(isBeaten){
                    space.removeObject(complete);
                }
            }
            List<Actor> objects = getWorld().getObjectsAt(mouse.getX(), mouse.getY(), Planet.class);
            for (Actor object : objects)
            {
                if (object == this)
                {
                    space.addObject(label, getX(), getY()-25);
                    labelInWorld = true;

                    if(isBeaten){
                        space.addObject(complete, getX()+10, getY()+25);
                    }

                    //space.showText("Planet 1", getX(), getY()-50);
                }
            }
        }
    }

}
