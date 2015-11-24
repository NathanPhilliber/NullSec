import greenfoot.*;

/**
 * Write a description of class Level16 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level16 extends Platformer
{

    /**
     * Constructor for objects of class Level16.
     * 
     */
    public Level16(){
        this(0,0);
    }

    public Level16(double x, double y)
    {
        super(x,y);
    }

    private boolean firstPass = true;
    public void act()
    {
        if(firstPass)
        {
            prepare();
            firstPass = false;
        }
    }

    public void prepare()
    {
        //Level Generated

        int offsetX = 0;
        int offsetY = 0;

        setBackground("PlanetOneBG.png");
        addObject(new Block(51),13+offsetX,445+offsetY);
        addObject(new Block(51),13+offsetX,499+offsetY);
        addObject(new Block(51),13+offsetX,472+offsetY);
        addObject(new Block(51),40+offsetX,445+offsetY);
        addObject(new Block(51),40+offsetX,499+offsetY);
        addObject(new Block(51),40+offsetX,472+offsetY);
        addObject(new Block(51),94+offsetX,472+offsetY);
        addObject(new Block(51),67+offsetX,445+offsetY);
        addObject(new Block(51),94+offsetX,445+offsetY);
        addObject(new Block(51),67+offsetX,499+offsetY);
        addObject(new Block(51),94+offsetX,499+offsetY);
        addObject(new Block(51),67+offsetX,472+offsetY);
        addObject(new Block(51),148+offsetX,472+offsetY);
        addObject(new Block(51),121+offsetX,445+offsetY);
        addObject(new Block(51),148+offsetX,445+offsetY);
        addObject(new Block(51),121+offsetX,499+offsetY);
        addObject(new Block(51),148+offsetX,499+offsetY);
        addObject(new Block(51),121+offsetX,472+offsetY);
        addObject(new Block(51),175+offsetX,445+offsetY);
        addObject(new Block(51),175+offsetX,499+offsetY);
        addObject(new Block(51),175+offsetX,472+offsetY);
        addObject(new Block(51),229+offsetX,472+offsetY);
        addObject(new Block(51),202+offsetX,445+offsetY);
        addObject(new Block(51),229+offsetX,445+offsetY);
        addObject(new Block(51),202+offsetX,499+offsetY);
        addObject(new Block(51),229+offsetX,499+offsetY);
        addObject(new Block(51),202+offsetX,472+offsetY);
        addObject(new Block(51),283+offsetX,472+offsetY);
        addObject(new Block(51),256+offsetX,445+offsetY);
        addObject(new Block(51),283+offsetX,445+offsetY);
        addObject(new Block(51),256+offsetX,499+offsetY);
        addObject(new Block(51),283+offsetX,499+offsetY);
        addObject(new Block(51),256+offsetX,472+offsetY);
        addObject(new Block(51),310+offsetX,445+offsetY);
        addObject(new Block(51),310+offsetX,499+offsetY);
        addObject(new Block(51),310+offsetX,472+offsetY);
        addObject(new Block(51),337+offsetX,445+offsetY);
        addObject(new Block(51),337+offsetX,499+offsetY);
        addObject(new Block(51),337+offsetX,472+offsetY);
        addObject(new Block(51),391+offsetX,472+offsetY);
        addObject(new Block(51),364+offsetX,445+offsetY);
        addObject(new Block(51),391+offsetX,445+offsetY);
        addObject(new Block(51),418+offsetX,445+offsetY);
        addObject(new Block(51),364+offsetX,499+offsetY);
        addObject(new Block(51),391+offsetX,499+offsetY);
        addObject(new Block(51),418+offsetX,499+offsetY);
        addObject(new Block(51),364+offsetX,472+offsetY);
        addObject(new Block(51),418+offsetX,472+offsetY);
        addObject(new Block(51),445+offsetX,445+offsetY);
        addObject(new Block(51),445+offsetX,499+offsetY);
        addObject(new Block(51),445+offsetX,472+offsetY);
        addObject(new Block(51),499+offsetX,472+offsetY);
        addObject(new Block(51),472+offsetX,445+offsetY);
        addObject(new Block(51),499+offsetX,445+offsetY);
        addObject(new Block(51),526+offsetX,445+offsetY);
        addObject(new Block(51),472+offsetX,499+offsetY);
        addObject(new Block(51),499+offsetX,499+offsetY);
        addObject(new Block(51),526+offsetX,499+offsetY);
        addObject(new Block(51),472+offsetX,472+offsetY);
        addObject(new Block(51),526+offsetX,472+offsetY);
        addObject(new Block(51),580+offsetX,472+offsetY);
        addObject(new Block(51),553+offsetX,445+offsetY);
        addObject(new Block(51),580+offsetX,445+offsetY);
        addObject(new Block(51),553+offsetX,499+offsetY);
        addObject(new Block(51),580+offsetX,499+offsetY);
        addObject(new Block(51),553+offsetX,472+offsetY);
        addObject(new Block(51),634+offsetX,472+offsetY);
        addObject(new Block(51),607+offsetX,445+offsetY);
        addObject(new Block(51),634+offsetX,445+offsetY);
        addObject(new Block(51),607+offsetX,499+offsetY);
        addObject(new Block(51),634+offsetX,499+offsetY);
        addObject(new Block(51),607+offsetX,472+offsetY);
        addObject(new Block(51),661+offsetX,445+offsetY);
        addObject(new Block(51),661+offsetX,499+offsetY);
        addObject(new Block(51),661+offsetX,472+offsetY);
        addObject(new Block(51),715+offsetX,472+offsetY);
        addObject(new Block(51),688+offsetX,445+offsetY);
        addObject(new Block(51),715+offsetX,445+offsetY);
        addObject(new Block(51),688+offsetX,499+offsetY);
        addObject(new Block(51),715+offsetX,499+offsetY);
        addObject(new Block(51),688+offsetX,472+offsetY);
        addObject(new Block(51),742+offsetX,445+offsetY);
        addObject(new Block(51),742+offsetX,499+offsetY);
        addObject(new Block(51),742+offsetX,472+offsetY);
        addObject(new Block(51),796+offsetX,472+offsetY);
        addObject(new Block(51),769+offsetX,445+offsetY);
        addObject(new Block(51),796+offsetX,445+offsetY);
        addObject(new Block(51),823+offsetX,445+offsetY);
        addObject(new Block(51),769+offsetX,499+offsetY);
        addObject(new Block(51),796+offsetX,499+offsetY);
        addObject(new Block(51),823+offsetX,499+offsetY);
        addObject(new Block(51),769+offsetX,472+offsetY);
        addObject(new Block(51),823+offsetX,472+offsetY);
        addObject(new Block(51),94+offsetX,418+offsetY);
        addObject(new Block(51),121+offsetX,391+offsetY);
        addObject(new Block(51),148+offsetX,364+offsetY);
        addObject(new Block(51),175+offsetX,337+offsetY);
        addObject(new Block(51),202+offsetX,310+offsetY);
        addObject(new Block(51),229+offsetX,283+offsetY);
        addObject(new Block(92),310+offsetX,418+offsetY);
        addObject(new Block(92),472+offsetX,418+offsetY);
        addObject(new Block(92),634+offsetX,418+offsetY);
        addObject(new Block(92),796+offsetX,418+offsetY);
        addObject(new TraceHead(91),310+offsetX,391+offsetY);
        addObject(new TraceHead(91),472+offsetX,391+offsetY);
        addObject(new TraceHead(91),634+offsetX,391+offsetY);
        addObject(new TraceHead(91),796+offsetX,391+offsetY);
        addObject(new PlatformPlayer(),67+offsetX,121+offsetY);
        addObject(new Block(51),850+offsetX,445+offsetY);
        addObject(new Block(51),850+offsetX,499+offsetY);
        addObject(new Block(51),850+offsetX,472+offsetY);
        addObject(new Block(51),877+offsetX,445+offsetY);
        addObject(new Block(51),877+offsetX,499+offsetY);
        addObject(new Block(51),877+offsetX,472+offsetY);
        addObject(new Block(51),904+offsetX,445+offsetY);
        addObject(new Block(51),904+offsetX,499+offsetY);
        addObject(new Block(51),904+offsetX,472+offsetY);
        addObject(new Block(51),931+offsetX,445+offsetY);
        addObject(new Block(51),931+offsetX,499+offsetY);
        addObject(new Block(51),931+offsetX,472+offsetY);
        addObject(new Block(51),985+offsetX,472+offsetY);
        addObject(new Block(51),958+offsetX,445+offsetY);
        addObject(new Block(51),985+offsetX,445+offsetY);
        addObject(new Block(51),958+offsetX,499+offsetY);
        addObject(new Block(51),985+offsetX,499+offsetY);
        addObject(new Block(51),958+offsetX,472+offsetY);
        addObject(new Block(51),1012+offsetX,445+offsetY);
        addObject(new Block(51),1012+offsetX,499+offsetY);
        addObject(new Block(51),1012+offsetX,472+offsetY);
        addObject(new Block(51),1039+offsetX,445+offsetY);
        addObject(new Block(51),1039+offsetX,499+offsetY);
        addObject(new Block(51),1039+offsetX,472+offsetY);
        addObject(new Block(51),1093+offsetX,472+offsetY);
        addObject(new Block(51),1066+offsetX,445+offsetY);
        addObject(new Block(51),1093+offsetX,445+offsetY);
        addObject(new Block(51),1066+offsetX,499+offsetY);
        addObject(new Block(51),1093+offsetX,499+offsetY);
        addObject(new Block(51),1066+offsetX,472+offsetY);
        addObject(new Block(51),1147+offsetX,472+offsetY);
        addObject(new Block(51),1120+offsetX,445+offsetY);
        addObject(new Block(51),1147+offsetX,445+offsetY);
        addObject(new Block(51),1174+offsetX,445+offsetY);
        addObject(new Block(51),1120+offsetX,499+offsetY);
        addObject(new Block(51),1147+offsetX,499+offsetY);
        addObject(new Block(51),1174+offsetX,499+offsetY);
        addObject(new Block(51),1120+offsetX,472+offsetY);
        addObject(new Block(51),1174+offsetX,472+offsetY);
        addObject(new ExitPortal(),1120+offsetX,364+offsetY);

    }
}
