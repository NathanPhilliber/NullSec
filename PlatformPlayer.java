import greenfoot.*;
import java.util.List;
import java.lang.reflect.*;

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
    static final double gravity = .5; 
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
    private boolean isWalkingRight=true;
    private boolean isWalkingLeft=false;
    Platformer w;

    private boolean locked = false;

    private int ticksStuckInBlock = 0;

    GifImage walkRight = new GifImage("WalkingAnimation.gif");
    GifImage walkLeft = new GifImage("WalkingAnimationLeft.gif");
    GifImage standRight = new GifImage("StandingRight.png");
    GifImage standLeft = new GifImage("StandingLeft.png");
    public void addedToWorld(World world)
    {
        realX=getX();
        realY=getY();
        w=(Platformer)getWorld();
    }

    public PlatformPlayer()
    {
        velX = 0;
        velY = 0;
        setImage(standRight.getCurrentImage());
    }

    public void act() 
    {
        pausePlayerHelper();
        if(playerPaused == false){
            if(locked == false){
                jump();
                leftRight();
            }
            showDebug(false);
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
            if(Greenfoot.isKeyDown("shift")){
                velY = -gravity;
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

        World world = getWorld();
        try{
            if(deleteMe){
                Class cl = world.getClass();
                
                Platformer p = (Platformer) getWorld();
                double param1 = p.returnX;
                double param2 = p.returnY;
                Constructor con = cl.getConstructor(double.class, double.class);

                java.lang.Object xyz = con.newInstance(param1, param2);
                Greenfoot.setWorld((World) xyz);
            }
        }
        catch(InstantiationException e){   
        }
        catch(IllegalAccessException e){   
        }
        catch(NoSuchMethodException e){   
        }
        catch(InvocationTargetException e){   
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
        setLocation(getExactX(),getExactY()-10000);
        deleteMe = true;
    }

    private void updatePosition()
    {
        int steps=10;
        double oldX=getExactX();
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
        if ((getExactX()>=getWorld().getWidth()-sideScrollDist&&isWalkingRight)||(getExactX()<=sideScrollDist&&isWalkingLeft))
        {
            //System.out.println("move");
            //System.out.println(getExactX()-oldX);
            w.addOffset(getExactX()-oldX);
            setLocation(oldX,getExactY());
        }

        
        /*
        double dif=getExactX()-sideScrollDist;
        if(dif<=0&&velX<=0)
        {
        w.addOffset(dif);
        }
        dif=getExactX()+sideScrollDist-getWorld().getWidth();
        if(dif>=0&&velX>=0)
        {
        w.addOffset(dif);
        }*/

        //Y check
        for (int i=0;i<=steps-1;i++)
        {
            addRealY(getVelY()/steps);
            setLocation(getExactX(),getRealY());
            Actor b=getOneIntersectingObject(blockType);

            if(b instanceof FallingBlock){
                FallingBlock r = (FallingBlock) b;
                r.startFalling();
            }

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

        //This runs if you get stuck in a block for a long time
        //Will push you out after 75 game ticks;
        Actor g = getOneIntersectingObject(blockType);
        if(g != null){
            ticksStuckInBlock++;
            if(ticksStuckInBlock > 75){
                addRealY(-5);
                //setLocation(getRealX(), getExactY()-5);
                //System.out.println("Help Me");
            }
        }
        else{
            ticksStuckInBlock = 0;
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

        //hack
        if(Greenfoot.isKeyDown("\\")){
            setRealY(150);

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
            w.showText("X: "+String.format("%.02f", (realX)), x, 25);
            w.showText("Y: "+String.format("%.02f", (realY)), x, 50); 
            w.showText("vX: "+String.format("%.02f", (velX)), x, 75);
            w.showText("vY: "+String.format("%.02f", (velY)), x, 100);
            w.showText("wOffset: "+String.format("%.02f", (w.getOffset())), x, 125);
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
