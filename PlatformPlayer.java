import greenfoot.*;
import java.util.List;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlatformPlayer extends PlatformObject
{

    /************************************************************************************
     * constants
     * DO NOT MAKE THE COSE CHANGE
     * (you were changeing walkSpeed constant(was moveSpeed))
     *
     ************************************************************************************
     */
    static final double gravity = .5; //Make final constants since we change this throughout
    static final double dragX = .25;
    static final double walkSpeed = 4;
    static final double jumpSpeedAir = 16;
    static final double climbSpeed = 3;
    static final double swimSpeed = 2;
    static final int sideScrollDist = 400;
    static final Class blockType = Block.class;
    
    /************************************************************************************
     * varibles
     * use these to change during gameplay
     ************************************************************************************ 
     */
    private double jumpSpeed=jumpSpeedAir;
    private double moveSpeed=walkSpeed;
    private boolean onBlock=false;
    private double realX;
    private double realY;
    private double velX;
    private double velY;
    private boolean isWalkingRight;
    private boolean isWalkingLeft;
    Platformer w;

    private boolean locked = false;

    GifImage walkRight = new GifImage("WalkingAnimation.gif");
    GifImage walkLeft = new GifImage("WalkingAnimationLeft.gif");
    GifImage standRight = new GifImage("StandingRight.png");
    GifImage standLeft = new GifImage("StandingLeft.png");
    public void addedToWorld(World world)
    {
        realX=getX();
        realY=getY();
    }

    public PlatformPlayer()
    {
        velX = 0;
        velY = 0;
        setImage(standRight.getCurrentImage());
    }

    public void act() 
    {
        Actor b=getOneIntersectingObject(Block.class);
        w=(Platformer)getWorld();
        if(b!=null)
        {
            //System.out.println(b);
        }
        pausePlayerHelper();
        if(playerPaused == false){
            if(locked == false){
                jump();
                leftRight();
            }
            showDebug(true);
            gravity(gravity);
            updatePosition();
            restartWorld();
            checkIfOffEdge();
            checkSpecialCollisions();
        }
    }

    public void lockPlayerMovement(boolean lock){
        locked = lock;
    }

    private void checkIfOffEdge(){
        if(getY() > 1500){
            kill();
        }
    }

    private void checkSpecialCollisions()
    {
        List<PlatformObject> objects = getIntersectingObjects(PlatformObject.class);

        boolean anyWater = false;
        boolean anyClimb = false;

        for(PlatformObject object : objects){

            if(object instanceof ExitPortal){
                Platformer plat = (Platformer) getWorld();
                Greenfoot.setWorld(new OuterSpace(plat.returnX, plat.returnY));
            }
            else if(object instanceof LavaBlock){
                kill();
            }
            else if(object instanceof WaterBlock){
                anyWater = true;

            }
            else if(object instanceof ClimbBlock){
                anyClimb = true;
            }

        }
        if(anyWater){

            moveSpeed = .8;
            jumpSpeed = 6;
            if(Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("space")){
                velY = -swimSpeed;
                onBlock = false;

            }
        }
        else if(anyClimb){
            jumpSpeed = 0;
            if(Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("space")){
                velY = -climbSpeed;
                onBlock = false;
                
            }
        }
        else{
            moveSpeed = walkSpeed;
            jumpSpeed = jumpSpeedAir;
        }

    }
    private int pauseCycles = 0;
    private boolean playerPaused = false;
    private boolean deleteMe = false;

    private void restartWorld(){
        if(deleteMe){

            //Greenfoot.setWorld(getWorld());

            World world = getWorld();
            if(world instanceof Level1){
                Level1 level = (Level1) world;
                Greenfoot.setWorld(new Level1(level.returnX, level.returnY));
            }
            if(world instanceof Level2){
                Level2 level = (Level2) world;
                Greenfoot.setWorld(new Level2(level.returnX, level.returnY));
            }
            if(world instanceof Level3){
                Level3 level = (Level3) world;
                Greenfoot.setWorld(new Level3(level.returnX, level.returnY));
            }
            /*if(world instanceof Level4){
            Level4 level = (Level4) world;
            Greenfoot.setWorld(new Level4(level.returnX, level.returnY));
            }*/
            if(world instanceof Level5){
                Level5 level = (Level5) world;
                Greenfoot.setWorld(new Level5(level.returnX, level.returnY));
            }
            if(world instanceof Level6){
                Level6 level = (Level6) world;
                Greenfoot.setWorld(new Level6(level.returnX, level.returnY));
            }
            if(world instanceof Level7){
                Level7 level = (Level7) world;
                Greenfoot.setWorld(new Level7(level.returnX, level.returnY));
            }
             if(world instanceof Level8){
                Level8 level = (Level8) world;
                Greenfoot.setWorld(new Level8(level.returnX, level.returnY));
            }

            else{
                System.out.println("ADD WORLD TO PLATFORMPLAYER");
            }
        }
    }

    private void pausePlayerHelper(){
        pauseCycles--;
        if(pauseCycles > 0){
            playerPaused = true;
        }
        else{
            playerPaused = false;
        }
    }

    public void kill(){
        lockPlayerMovement(true);
        pauseCycles = 50;
        setLocation(getX(), getY() -10000);
        deleteMe = true;
    }

        private void updatePosition()
    {
        int steps=10;
        //X check
        for (int i=0;i<=steps-1;i++)
        {
            addRealX(getVelX()/steps);
            setLocation(getRealX()-w.getOffset(),getExactY());
            Actor b=getOneIntersectingObject(blockType);
            if (b!=null)
            { 
                addRealX(-getVelX()/steps);
                setLocation(getRealX()-w.getOffset(),getExactY());
                velX=0;
                i=steps;
            }
        }
        double dif=getExactX()-sideScrollDist;
        if(dif<=0&&velX<=0)
        {
            w.addOffset(dif);
        }
        dif=getExactX()+sideScrollDist-getWorld().getWidth();
        if(dif>=0&&velX>=0)
        {
            w.addOffset(dif);
        }
        
        //Y check
        for (int i=0;i<=steps-1;i++)
        {
            addRealY(getVelY()/steps);
            setLocation(getExactX(),getRealY());
            Actor b=getOneIntersectingObject(blockType);
            if (b!=null)
            {
                addRealY(-getVelY()/steps);
                setLocation(getExactX(),getRealY());
                velY=0;
                i=steps;
                onBlock=true;
            }
            if(velY!=0)
            {
                onBlock=false;
            }
        }
    }

    private void leftRight()
    {
        slowX();
        if (Greenfoot.isKeyDown("d"))
        {
            velX=moveSpeed;
            setImage(walkRight.getCurrentImage());
        }

        if (Greenfoot.isKeyDown("a"))
        {
            velX=-moveSpeed;
            setImage(walkLeft.getCurrentImage());
        }

        if (Greenfoot.isKeyDown("d")&&!isWalkingRight)
        {
            isWalkingRight = true;
        }

        if(!Greenfoot.isKeyDown("d")&&isWalkingRight)
        {
            setImage(standRight.getCurrentImage());
            isWalkingRight = false;
        }

        if (Greenfoot.isKeyDown("a")&&!isWalkingLeft)
        {
            isWalkingLeft = true;
        }

        if(!Greenfoot.isKeyDown("a")&&isWalkingLeft)
        {
            setImage(standLeft.getCurrentImage());
            isWalkingLeft = false;
        }
    }

    private void jump()
    {
        if ((Greenfoot.isKeyDown("space")||Greenfoot.isKeyDown("w")) && onBlock)
        {
            onBlock=false;
            velY-=jumpSpeed;
        }
    }
    private void slowX()
    {
        if (onBlock)
        {
            velX-=dragX*velX;
        }
        if(velX<=.1&&velX>=-.1)
        {
            velX=0;
        }
    }
    private void gravity(double grav)
    {
        velY += grav;
    }
    private void showDebug(boolean show)
    {
        if(show)
        {
            int x = getWorld().getWidth() - 75;

            getWorld().showText("X: "+String.format("%.02f", (realX)), x, 25);
            getWorld().showText("Y: "+String.format("%.02f", (realY)), x, 50); 

            getWorld().showText("vX: "+String.format("%.02f", (velX)), x, 75);
            getWorld().showText("vY: "+String.format("%.02f", (velY)), x, 100);
        }
    }
        private void setRealX(double x)
    {
        realX=x;
    }
    private void addRealX(double x)
    {
        realX+=x;
    }
    private double getRealX()
    {
        return realX;
    }
    private void setRealY(double y)
    {
        realY=y;
    }
    private void addRealY(double y)
    {
        realY+=y;
    }
    private double getRealY()
    {
        return realY;
    }
     private void setVelX(double x)
    {
        velX=x;
    }
    private void addVelX(double x)
    {
        velX+=x;
    }
    private double getVelX()
    {
        return velX;
    }
    private void setVelY(double y)
    {
        velY=y;
    }
    private void addVelY(double y)
    {
        velY+=y;
    }
    private double getVelY()
    {
        return velY;
    }
}
