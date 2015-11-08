import greenfoot.*;
import java.util.List;
import java.lang.reflect.*;
public class PlatformPlayer extends PlatformObject
{

    /************************************************************************************
     * constants
     * DO NOT MAKE THE COSE CHANGE
     * (you were changeing walkSpeed constant(was moveSpeed))
     *
     ************************************************************************************
     */
    static final double dragX = .7;
    static final double walkSpeed = 3.3;
    static final double jumpSpeedAir = 10;
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
    private boolean isWalkingRight=true;
    private boolean isWalkingLeft=false;
    private boolean locked = false;
    private boolean onClimb=false;

    private int ticksStuckInBlock = 0;

    GifImage walkRight = new GifImage("WalkingAnimation.gif");
    GifImage walkLeft = new GifImage("WalkingAnimationLeft.gif");
    GifImage standRight = new GifImage("StandingRight.png");
    GifImage standLeft = new GifImage("StandingLeft.png");
    public void addedToWorld(World world)
    {
        w=(Platformer)getWorld();
        setRealX(getX());
        setRealY(getY());
    }

    public PlatformPlayer()
    {
        velX = 0;
        velY = 0;
        setImage(standRight.getCurrentImage());
    }

    public boolean isMovingX(){
        if(velX != 0){
            return true;
        }
        return false;
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
            restartWorld();
            checkIfOffEdge();
            checkSpecialCollisions();
            updatePosition();//LAST
        }

        //System.out.println(isMovingX());
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
        ElevatorBlock elevator = null;
        boolean anyWater = false;
        boolean anyClimb = false;
        boolean anyAir = false;
        boolean anySpike = false;
        boolean anyBullet = false;
        boolean anyElevator = false;
        boolean anySlime = false;
        

        for(PlatformObject object : objects){

            if(object instanceof ExitPortal){
                Player.gold += Player.goldPotential;
                Player.goldPotential = 0;
                Platformer plat = (Platformer) getWorld();
                Greenfoot.setWorld(new OuterSpace(plat.returnX, plat.returnY));
            }
            else if(object instanceof LavaBlock){
                kill();
            }
            else if(object instanceof WaterBlock){
                anyWater = true;
                if(getOneObjectAtOffset(0,-27, WaterBlock.class) == null){
                    anyAir = true;
                }

            }
            else if(object instanceof ClimbBlock){
                anyClimb = true;
            }
            else if(object instanceof SpikeBlock){
                anySpike = true;
            }
            else if(object instanceof Bullet){
                anyBullet = true;
            }
            else if(object instanceof Coin){
                Coin coin = (Coin) object;
                coin.pickup();
            }
            else if(object instanceof ElevatorBlock){
                if(getOneObjectAtOffset(0,20, ElevatorBlock.class) == null){
                    anyElevator = true;
                }
                
            }
            else if(object instanceof SlimeBlock){
                anySlime = true;
                System.out.println(1);
                
            }

        }
        if(anyWater){
            if(anyAir){
                onBlock = true;
                jumpSpeed = 11;
            }
            else{

                moveSpeed = .8;
                jumpSpeed = 6;
                if(Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("space")){
                    velY = -swimSpeed;
                    onBlock = false;

                }
            }
        }
        else if(anySpike){
            kill();
        }
        else if(anyBullet){
            kill();
        }
        else if(anySlime){
            velY = -velY;
            addRealY(-3);
            onBlock = true;
        }
        else if(anyElevator){
            
            addRealY(-5);
            
        }
        else if(anyClimb){
            ClimbBlock climb=(ClimbBlock)getOneIntersectingObject(ClimbBlock.class);
            if(getRealX()<=climb.getRealX()+6&&getRealX()>=climb.getRealX()-6)
            {
                if(Greenfoot.isKeyDown("w")||Greenfoot.isKeyDown("space"))
                {
                    velX=0;
                    onClimb=true;
                }
                if(onClimb)
                {
                    onBlock=true;
                    jumpSpeed = 0;
                    velY=0;
                    if(Greenfoot.isKeyDown("w")||Greenfoot.isKeyDown("space"))
                    {
                        velY=-climbSpeed;
                    }
                    if(Greenfoot.isKeyDown("s"))
                    {
                        velY=climbSpeed;
                    }
                    if(Greenfoot.isKeyDown("shift"))
                    {
                        onClimb=false;
                    }
                }
            }
            else
            {
                onClimb=false;
                onBlock=false;
            }
        }
        else{
            moveSpeed=walkSpeed;
            jumpSpeed=jumpSpeedAir;
        }
        if(getY()>getWorld().getHeight()+100)
        {
            kill();
        }

    }
    private int pauseCycles = 0;
    private boolean playerPaused = false;
    private boolean deleteMe = false;

    private void restartWorld(){

        World world = getWorld();
        try{
            if(deleteMe){
                
                Player.goldPotential = 0;
                
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
        
        if(deleteMe){
            turn(10);
            setRealY(getRealY()+2);
            setLocation(getRealX()-w.getOffset(), getRealY()+2);
        }
    }

    public void kill(){
        lockPlayerMovement(true);
        pauseCycles = 50;
        
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
                if(b instanceof MeltingBlock){
                    MeltingBlock melt = (MeltingBlock) b;
                    melt.melt(5);
                }
                addRealX(-getVelX()/steps);
                setLocation(getRealX()-w.getOffset(),getExactY());
                velX=0;
                i=steps;
            }
        }
        /*
        if ((getExactX()>=getWorld().getWidth()-sideScrollDist&&(isWalkingRight))
        ||(getExactX()<=sideScrollDist&&(isWalkingLeft)))
        {
        //System.out.println("move");
        //System.out.println(getExactX()-oldX);
        w.addOffset(getExactX()-oldX);
        setLocation(oldX,getExactY());
        }
         */
        /*
        if(isMovingX()){
        w.addOffset(getExactX()-oldX);
        setLocation(oldX,getExactY());
        }
         */

        double dif=getExactX()-sideScrollDist;
        if(dif<=0&&velX<0&&w.getOffset()>=0)
        {
            w.addOffset(dif);
        }
        dif=getExactX()+sideScrollDist-getWorld().getWidth();
        if(dif>=0&&velX>0)
        {
            w.addOffset(dif);
        }
        
        if(w.getOffset() < 0){
            w.setOffset(0);
        }

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
                if(b instanceof MeltingBlock){
                    MeltingBlock melt = (MeltingBlock) b;
                    melt.melt(5);
                }
                addRealY(-getVelY()/steps);
                setLocation(getExactX(),getRealY());
                if(velY > 0){
                    onBlock = true;  
                }
                velY=0;
                i=steps;

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
            if(ticksStuckInBlock > 50){
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
            velY = 0;

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
}
