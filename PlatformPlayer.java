import greenfoot.*;
import java.util.List;
import java.lang.reflect.*;

/*
 * Written by John, Trace and Nathan
 */
public class PlatformPlayer extends PlatformObject
{

    /************************************************************************************
     *    *****CONSTANTS*****
     * DO NOT MAKE THE CODE CHANGE
     ************************************************************************************
     */
    static final double dragX = .7;
    static final double walkSpeed = 3.3;
    static final double jumpSpeedAir = 10;
    static final double climbSpeed = 3;
    static final double swimSpeed = 2;
    static final int scrollDistX = 400;
    static final int scrollDistY = 200; //>>MUST<< BE LESS THAN 250
    static final Class blockType = Block.class;

    private final int ladderRadius = 9;
    private boolean hansMode = false;
    private boolean gravityToggle = false;

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
    private int scrollYType=0; /**0 is off 1 is with scroll threshold 2 is locked on player*/
    private double maxYScroll=0;
    private int delay = 100;
    private Actor port;
    private boolean anyPortal = false;
    private boolean firstTime = true;

    //antistuck
    private double oldXOffset;
    private double oldYOffset;
    private double oldRealX;
    private double oldRealY;
    private int ticksStuckInBlock = 0;

    //Written by Trace
    GifImage walkRight = new GifImage("WalkingAnimation.gif");
    GifImage walkLeft = new GifImage("WalkingAnimationLeft.gif");
    GifImage standRight = new GifImage("StandingRight.png");
    GifImage standLeft = new GifImage("StandingLeft.png");

    private Number goldNumber = new Number(Player.gold+"",2);
    private double lastGoldCount = Player.goldPotential;

    private boolean firstAct = true;

    private boolean escDown = false;
    private boolean escUp = true;

    public static boolean pauseEverything = false;
    public static boolean quitting = false;

    //Written by Nathan
    private void setUpGoldScore(){
        w.addObject(new GoldText(),w.getWidth()-158,22);
        w.addObject(goldNumber, w.getWidth()-65, 18);
    }

    //Written by Nathan
    private void updateGoldScore(){
        if(lastGoldCount != Player.goldPotential){
            goldNumber.remove();
            goldNumber = new Number((Player.gold+Player.goldPotential)+"",2);
            w.addObject(goldNumber, w.getWidth()-65, 18);
        }
        lastGoldCount = Player.goldPotential;
    }

    //Written by John
    public void addedToWorld(World world)
    {
        w=(Platformer)getWorld();
        setRealX(getX());
        setRealY(getY());
        setUpGoldScore();
    }
    //Written by John
    public PlatformPlayer()
    {
        velX = 0;
        velY = 0;
        setImage(standRight.getCurrentImage());
        pauseEverything = false;

    }
    //Written by John
    public PlatformPlayer(int scrollY, double maxY)
    {
        this();
        scrollYType=scrollY;
        maxYScroll=maxY;
    }
    //Written by John
    public PlatformPlayer(boolean scrollY)
    {
        this();
        if(scrollY)
        { 
            scrollYType=1;
        }
        else
        {
            scrollYType=0;
        }
    }
    //Written by Nathan
    public boolean isMovingX(){
        if(velX != 0){
            return true;
        }
        return false;
    }

    public void act() 
    {
        firstAct();
        pausePlayerHelper();
        checkEsc();

        if(playerPaused == false && pauseEverything == false){
            if(locked == false){
                jump();
                leftRight();
            }
            showDebug(false);
            gravity(gravity);
            restartWorld();
            checkIfOffEdge();
            checkSpecialCollisions();
            updateGoldScore();
            updatePosition();//LAST
        }

        //System.out.println(isMovingX());
    }

    public void checkEsc(){

        if(!Greenfoot.isKeyDown("escape")){
            escUp = true;

        }
        if(Greenfoot.isKeyDown("escape")){
            if(escUp && !escDown)
                escDown = true;

        }

        if(escDown && escUp){

            escDown = false;
            escUp = false;

            if(pauseEverything){
                pauseEverything = false;
            }
            else{
                pauseEverything = true; 
                returnToSpace();//CHANGE THIS LATER ADD A BUTTON
            }

        }

    }

    public void returnToSpace(){
        quitting = true;
        System.out.println(quitting);
        Greenfoot.setWorld(new OuterSpace(w.returnX, w.returnY));
    }

    public void firstAct(){
        if(firstAct){
            firstAct = false;
            if(Player.aboutToPlayCompletedLevel){
                w.removeObjects(w.getObjects(Coin.class));
            }
        }
    }

    //Written by Nathan
    public void lockPlayerMovement(boolean lock){
        locked = lock;
    }

    //Written by Nathan
    private void checkIfOffEdge(){
        if(getY() > 1500 || getY() < -200){
            kill();
        }
    }

    //Written by Nathan
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
        boolean anyCart = false;
        boolean anyGravity = false;
        boolean anyButton = false;

        for(PlatformObject object : objects){
            if(object instanceof Alien){
                kill();
            }
            else if(object instanceof ExitPortal){
                Player.gold += Player.goldPotential;
                Player.goldPotential = 0;
                Platformer plat = (Platformer) getWorld();
                anyPortal = true;
                velX = 0;
                velY = 0;
                lockPlayerMovement(true);
            }
            else if(object instanceof LavaBlock){
                GreenfootSound chime = new GreenfootSound("sounds/lavasizzle.wav");
                chime.play();
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
            else if(object instanceof GravityBlock){
                anyGravity = true;

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
            else if(object instanceof Cart){
                if(getOneObjectAtOffset(0,20, Cart.class) == null){
                    anyCart = true;
                }

            }
            else if(object instanceof SlimeBlock){
                anySlime = true;

            }
            else if(object instanceof WireButton){
                anyButton = true;

            }
            else if(object instanceof PushButton){
                setVelX(velX/2);
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
            GreenfootSound chime = new GreenfootSound("sounds/spikehit.wav");
            chime.play();
            kill();
        }
        else if(anyBullet){
            kill();
        }
        else if(anySlime){
            velY = -velY*.97;
            addRealY(-3);
            onBlock = true;
        }
        else if(anyElevator){
            /*ElevatorBlock e=(ElevatorBlock)getOneIntersectingObject(ElevatorBlock.class);
            addRealX(e.getVelX());
            addRealY(e.getVelY());*/
            addRealY(-5);
            setLocation(getRealX()-w.getXOffset(),getRealY()-w.getYOffset());
        }
        else if(anyCart){
            addRealY(-2);
            setLocation(getRealX()-w.getXOffset(),getRealY()-w.getYOffset());
        }
        else if(anyButton){
            Actor butt = getOneIntersectingObject(WireButton.class);
            Actor buttDown = new WireButtonDown();
            w.addObject(buttDown, butt.getX(), butt.getY());

            w.removeObject(butt);
        } 
        else if(anyGravity && gravityToggle == false){
            gravity *= -1;

            gravityToggle = true;
        }
        else if(anyPortal){
            delay--;
            if(delay > 45)
            {
                double scaleToMax = (delay)*.01;
                double width = getImage().getWidth();
                double height = getImage().getHeight();
                List<PlatformObject> port = w.getObjects(ExitPortal.class);
                if(getImage().getWidth() > 1)
                {
                    getImage().scale((int) Math.ceil(width*scaleToMax),(int)  Math.ceil(height*scaleToMax));
                }
                for(PlatformObject p : port)
                {
                    addRealX((p.getRealX()-getRealX())/10);
                    addRealY((p.getRealY()-getRealY())/10);
                }
            }
            if(delay < 45)
            {
                if(firstTime)
                {
                    List<Actor> port = w.getObjects(ExitPortal.class);
                    for(Actor p : port)
                    {
                        w.addObject(new RocketLaunch(), p.getX(), p.getY() - 220);
                        w.removeObject(p);
                    }
                }
                firstTime = false;
            }
            if(delay <= 0)
            {
                quitting = false;
                Greenfoot.setWorld(new OuterSpace(w.returnX, w.returnY));
            }
        }
        else if(anyClimb){

            //Written by John

            ClimbBlock climb=(ClimbBlock)getOneIntersectingObject(ClimbBlock.class);
            if(getRealX()<=climb.getRealX()+ladderRadius&&getRealX()>=climb.getRealX()-ladderRadius)
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
            if(anyGravity == false){
                gravityToggle = false;
            }

        }
        if(getY()>w.getHeight()+100)
        {
            kill();
        }

    }
    private int pauseCycles = 0;
    private boolean playerPaused = false;
    private boolean deleteMe = false;

    //Written by Trace
    private void restartWorld(){

        try{
            if(deleteMe && !hansMode){

                Player.goldPotential = 0;
                World world = getWorld();
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

    //Written by Nathan
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
            List<NonPlayer> blocks = w.getObjects(NonPlayer.class);

            for(int i = 0; i < (int)(blocks.size()/10); i++){

                w.removeObject(blocks.get(Greenfoot.getRandomNumber(blocks.size())));

            }
            setRealY(getRealY()+2);
            setLocation(getRealX()-w.getXOffset(), getRealY()+2);
        }
    }

    public void teleportToEnd(){
        List<ExitPortal> objects = w.getObjects(ExitPortal.class);

        setRealX(objects.get(0).getX());
        setRealY(objects.get(0).getY());
        setLocation(getRealX(), getRealY());
    }

    //Written by Nathan
    public void kill(){
        if(hansMode){

        }
        else{
            GreenfootSound dong = new GreenfootSound("sounds/button-12.mp3");
            dong.play();

            lockPlayerMovement(true);
            pauseCycles = 50;

            deleteMe = true;
        }
    }

    //Written by John (fourth rewrite)
    private void updatePosition()
    {
        Actor b;

        /**
         * Collision Type2
         * due to moveing blocks
         */
        ElevatorBlock e=(ElevatorBlock)getOneIntersectingObject(ElevatorBlock.class);
        if(e!=null)
        {
            addVelX(e.getVelX());
            addVelY(e.getVelY());
        }

        /**
         * Collision Type0
         * worst case catch all
         * reverts cycle
         *
         */
        if (ticksStuckInBlock==0)
        {
            b=getOneIntersectingObject(blockType);
            if (b!=null)
            {
                w.setXOffset(oldXOffset);
                setRealX(oldRealX);
                setLocation(getRealX()-w.getXOffset(),getRealY()-w.getYOffset());
            }
            b=getOneIntersectingObject(blockType);
            if (b!=null)
            {
                w.setYOffset(oldYOffset);
                setRealY(oldRealY);
                setLocation(getRealX()-w.getXOffset(),getRealY()-w.getYOffset());
            }
        }
        b=getOneIntersectingObject(blockType);
        if(b==null)
        {
            oldXOffset = w.getXOffset();
            oldYOffset = w.getYOffset();
            oldRealX = getRealX();
            oldRealY = getRealY();
        }

        /**
         * Collision Type1
         * due to player movement
         */
        int steps=10;
        //double oldRealX=getRealX();//Type2
        //double oldOffset=w.getOffset();//Type2
        //X check
        for (int i=0;i<=steps-1;i++)
        {
            addRealX(getVelX()/steps);
            setLocation(getRealX()-w.getXOffset(),getExactY());
            b=getOneIntersectingObject(blockType);
            if (b!=null)
            { 
                if(b instanceof MeltingBlock){
                    MeltingBlock melt = (MeltingBlock) b;
                    melt.melt(5);
                }
                addRealX(-getVelX()/steps);
                setLocation(getRealX()-w.getXOffset(),getExactY());
                velX=0;
                i=steps;
            }
        }        
        //Y check
        for (int i=0;i<=steps-1;i++)
        {
            addRealY(getVelY()/steps);
            setLocation(getExactX(),getRealY()-w.getYOffset());
            b=getOneIntersectingObject(blockType);
            if(b instanceof FallingBlock){
                FallingBlock fall = (FallingBlock) b;
                fall.startFalling();
            }
            if (b!=null)
            {
                if(b instanceof MeltingBlock){
                    MeltingBlock melt = (MeltingBlock) b;
                    melt.melt(5);
                }
                if(b instanceof TraceHead){
                    TraceHead t = (TraceHead) b;
                    addRealY(-1);
                    t.grow();

                }
                if(b instanceof Cart){
                    Cart c = (Cart)b;
                    addRealY(-c.speed);
                }

                addRealY(-getVelY()/steps);
                setLocation(getExactX(),getRealY()-w.getYOffset());
                if(velY > 0 && gravity > 0){
                    onBlock = true;  
                }
                if(velY < 0 && gravity < 0){
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
        /**scrolling stuff*/
        scroll();//sets location

        /**
         * Collision Type-1
         * if broken
         * moves player after 50 cycles
         */
        b = getOneIntersectingObject(blockType);
        if(b != null){
            ticksStuckInBlock++;
            if(ticksStuckInBlock > 50){
                addRealY(-5);
            }
        }
        else{
            ticksStuckInBlock = 0;
        }
    }

    public double getPlayerVelX()
    {
        double thisVelX = velX;
        return thisVelX;
    }
    //Written by John
    private void scroll()//called in update player method
    {
        //x
        double dif=getExactX()-scrollDistX;
        if(dif<=0&&velX<0&&w.getXOffset()>=0)
        {
            w.addXOffset((int)dif);
        }
        dif=getExactX()+scrollDistX-w.getWidth();
        if(dif>=0&&velX>0)
        {
            w.addXOffset((int)dif);
        }
        if(w.getXOffset()<0){
            w.setXOffset(0);
        }
        //y
        if(scrollYType==1)
        {
            dif=getExactY()-scrollDistY;
            if(dif<=0&&velY<0&&w.getYOffset()<=0)
            {
                w.addYOffset((int)dif);
            }
            dif=getExactY()+scrollDistY-w.getHeight();
            if(dif>=0&&velY>0)
            {
                w.addYOffset((int)dif);
            }
        }
        else if(scrollYType==2)
        {
            w.setYOffset((int)(w.getYOffset()+getExactY()-w.getHeight()/2));
        }

        if(w.getYOffset()>0){
            w.setYOffset(0);
        }

        if(w.getYOffset()>maxYScroll){
            w.setYOffset(maxYScroll);
        }

        setLocation(getRealX()-w.getXOffset(),getRealY()-w.getYOffset());//end of scroll
    }

    //Written by John, Trace
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

        if(Greenfoot.isKeyDown("]")){
            deleteMe = false;
            hansMode = true;
        }
        else{
            hansMode = false;
        }

        if(Greenfoot.isKeyDown("[")){
            teleportToEnd();
        }
    }

    //Written by John
    private void jump()
    {
        if ((Greenfoot.isKeyDown("space")||Greenfoot.isKeyDown("w")) && onBlock)
        {
            onBlock=false;
            if(gravity > 0){
                velY-=jumpSpeed;
            }
            if(gravity < 0){
                velY+=jumpSpeed;
            }
        }
    }

    //Written by John
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

    //Written by John
    private void gravity(double grav)
    {
        velY += grav;
    }

    //Written by John
    private void showDebug(boolean show)
    {
        if(show)
        {
            int x = w.getWidth() - 75;
            w.showText("X: "+String.format("%.02f", (realX)), x, 25);
            w.showText("Y: "+String.format("%.02f", (realY)), x, 50); 
            w.showText("vX: "+String.format("%.02f", (velX)), x, 75);
            w.showText("vY: "+String.format("%.02f", (velY)), x, 100);
            w.showText("XOffset: "+String.format("%.02f", (w.getXOffset())), x, 125);
            w.showText("YOffset: "+String.format("%.02f", (w.getYOffset())), x, 150);
        }
    }
}
