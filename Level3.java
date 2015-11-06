import greenfoot.*;
public class Level3 extends Platformer
{
    public Level3()
    {
        this(0,0);
    }

    public Level3(double returnX, double returnY)
    {
        super(returnX, returnY);
        prepare();
    }

    private void prepare()
    {
        //Level Generated

        int offsetX = 0;
        int offsetY = 0;

        setBackground("PlanetOneBG.png");
        addObject(new Block(60),67+offsetX,364+offsetY);
        addObject(new Block(60),94+offsetX,364+offsetY);
        addObject(new Block(60),121+offsetX,364+offsetY);
        addObject(new Block(60),229+offsetX,364+offsetY);
        addObject(new Block(60),175+offsetX,364+offsetY);
        addObject(new Block(60),148+offsetX,364+offsetY);
        addObject(new Block(60),202+offsetX,364+offsetY);
        addObject(new Block(60),256+offsetX,364+offsetY);
        addObject(new Block(60),310+offsetX,364+offsetY);
        addObject(new Block(60),283+offsetX,364+offsetY);
        addObject(new ElevatorBlock(87),337+offsetX,364+offsetY);
        addObject(new ElevatorBlock(87),364+offsetX,364+offsetY);
        addObject(new ElevatorBlock(87),391+offsetX,364+offsetY);
        addObject(new ElevatorBlock(87),418+offsetX,364+offsetY);
        addObject(new Block(60),445+offsetX,364+offsetY);
        addObject(new Block(60),472+offsetX,364+offsetY);
        addObject(new Block(60),499+offsetX,364+offsetY);
        addObject(new Block(60),526+offsetX,364+offsetY);
        addObject(new Block(60),445+offsetX,256+offsetY);
        addObject(new Block(60),472+offsetX,256+offsetY);
        addObject(new Block(60),499+offsetX,256+offsetY);
        addObject(new Block(60),526+offsetX,256+offsetY);
        addObject(new Block(60),553+offsetX,256+offsetY);
        addObject(new Block(60),580+offsetX,256+offsetY);
        addObject(new Block(60),607+offsetX,256+offsetY);
        addObject(new Block(60),634+offsetX,256+offsetY);
        addObject(new Block(60),661+offsetX,256+offsetY);
        addObject(new Block(60),688+offsetX,256+offsetY);

        addObject(new PlatformPlayer(),67+offsetX,337+offsetY);

    }
}
