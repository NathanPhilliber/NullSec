import greenfoot.*;

/**
 * Write a description of class Level17 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level17 extends Platformer
{

    public Level17(){
        this(0,0);
    }

    public Level17(double x, double y)
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
        addObject(new Block(49),94+offsetX,229+offsetY);
        addObject(new Block(49),121+offsetX,229+offsetY);
        addObject(new Block(49),148+offsetX,229+offsetY);
        addObject(new Block(49),121+offsetX,283+offsetY);
        addObject(new Block(49),121+offsetX,256+offsetY);
        addObject(new Block(49),148+offsetX,256+offsetY);
        addObject(new Block(49),148+offsetX,283+offsetY);
        addObject(new Block(49),121+offsetX,337+offsetY);
        addObject(new Block(49),121+offsetX,310+offsetY);
        addObject(new Block(49),148+offsetX,310+offsetY);
        addObject(new Block(49),148+offsetX,337+offsetY);
        addObject(new Block(49),94+offsetX,364+offsetY);
        addObject(new Block(49),121+offsetX,364+offsetY);
        addObject(new Block(49),148+offsetX,364+offsetY);
        addObject(new Block(49),121+offsetX,391+offsetY);
        addObject(new Block(49),148+offsetX,391+offsetY);
        addObject(new Block(49),94+offsetX,418+offsetY);
        addObject(new Block(49),121+offsetX,418+offsetY);
        addObject(new Block(49),148+offsetX,418+offsetY);
        addObject(new Block(49),94+offsetX,445+offsetY);
        addObject(new Block(49),121+offsetX,445+offsetY);
        addObject(new Block(49),148+offsetX,445+offsetY);
        addObject(new Block(49),121+offsetX,499+offsetY);
        addObject(new Block(49),94+offsetX,472+offsetY);
        addObject(new Block(49),121+offsetX,472+offsetY);
        addObject(new Block(49),94+offsetX,526+offsetY);
        addObject(new Block(49),121+offsetX,526+offsetY);
        addObject(new Block(49),94+offsetX,499+offsetY);
        addObject(new Block(49),40+offsetX,229+offsetY);
        addObject(new Block(49),13+offsetX,202+offsetY);
        addObject(new Block(49),40+offsetX,202+offsetY);
        addObject(new Block(49),67+offsetX,202+offsetY);
        addObject(new Block(49),13+offsetX,229+offsetY);
        addObject(new Block(49),67+offsetX,229+offsetY);
        addObject(new Block(49),40+offsetX,283+offsetY);
        addObject(new Block(49),13+offsetX,256+offsetY);
        addObject(new Block(49),40+offsetX,256+offsetY);
        addObject(new Block(49),67+offsetX,256+offsetY);
        addObject(new Block(49),13+offsetX,310+offsetY);
        addObject(new Block(49),40+offsetX,310+offsetY);
        addObject(new Block(49),67+offsetX,310+offsetY);
        addObject(new Block(49),13+offsetX,283+offsetY);
        addObject(new Block(49),67+offsetX,283+offsetY);
        addObject(new Block(49),13+offsetX,337+offsetY);
        addObject(new Block(49),40+offsetX,337+offsetY);
        addObject(new Block(49),67+offsetX,337+offsetY);
        addObject(new Block(49),40+offsetX,391+offsetY);
        addObject(new Block(49),13+offsetX,364+offsetY);
        addObject(new Block(49),40+offsetX,364+offsetY);
        addObject(new Block(49),67+offsetX,364+offsetY);
        addObject(new Block(49),13+offsetX,391+offsetY);
        addObject(new Block(49),67+offsetX,391+offsetY);
        addObject(new Block(49),40+offsetX,445+offsetY);
        addObject(new Block(49),13+offsetX,418+offsetY);
        addObject(new Block(49),40+offsetX,418+offsetY);
        addObject(new Block(49),67+offsetX,418+offsetY);
        addObject(new Block(49),13+offsetX,445+offsetY);
        addObject(new Block(49),67+offsetX,445+offsetY);
        addObject(new Block(49),13+offsetX,472+offsetY);
        addObject(new Block(49),40+offsetX,472+offsetY);
        addObject(new Block(49),67+offsetX,472+offsetY);
        addObject(new Block(49),40+offsetX,526+offsetY);
        addObject(new Block(49),13+offsetX,499+offsetY);
        addObject(new Block(49),40+offsetX,499+offsetY);
        addObject(new Block(49),67+offsetX,499+offsetY);
        addObject(new Block(49),13+offsetX,553+offsetY);
        addObject(new Block(49),40+offsetX,553+offsetY);
        addObject(new Block(49),67+offsetX,553+offsetY);
        addObject(new Block(49),13+offsetX,526+offsetY);
        addObject(new Block(49),67+offsetX,526+offsetY);
        addObject(new Block(49),94+offsetX,202+offsetY);
        addObject(new Block(49),121+offsetX,202+offsetY);
        addObject(new Block(49),148+offsetX,202+offsetY);
        addObject(new Block(49),175+offsetX,499+offsetY);
        addObject(new Block(49),148+offsetX,472+offsetY);
        addObject(new Block(49),175+offsetX,472+offsetY);
        addObject(new Block(49),202+offsetX,472+offsetY);
        addObject(new Block(49),148+offsetX,526+offsetY);
        addObject(new Block(49),175+offsetX,526+offsetY);
        addObject(new Block(49),202+offsetX,526+offsetY);
        addObject(new Block(49),148+offsetX,499+offsetY);
        addObject(new Block(49),202+offsetX,499+offsetY);
        addObject(new Block(49),229+offsetX,472+offsetY);
        addObject(new Block(49),229+offsetX,526+offsetY);
        addObject(new Block(49),229+offsetX,499+offsetY);
        addObject(new Block(49),283+offsetX,499+offsetY);
        addObject(new Block(49),256+offsetX,472+offsetY);
        addObject(new Block(49),283+offsetX,472+offsetY);
        addObject(new Block(49),256+offsetX,526+offsetY);
        addObject(new Block(49),283+offsetX,526+offsetY);
        addObject(new Block(49),256+offsetX,499+offsetY);
        addObject(new Block(49),337+offsetX,499+offsetY);
        addObject(new Block(49),337+offsetX,472+offsetY);
        addObject(new Block(49),310+offsetX,526+offsetY);
        addObject(new Block(49),337+offsetX,526+offsetY);
        addObject(new Block(49),310+offsetX,499+offsetY);
        addObject(new Block(49),391+offsetX,499+offsetY);
        addObject(new Block(49),364+offsetX,472+offsetY);
        addObject(new Block(49),391+offsetX,472+offsetY);
        addObject(new Block(49),364+offsetX,526+offsetY);
        addObject(new Block(49),391+offsetX,526+offsetY);
        addObject(new Block(49),364+offsetX,499+offsetY);
        addObject(new Block(49),445+offsetX,499+offsetY);
        addObject(new Block(49),418+offsetX,472+offsetY);
        addObject(new Block(49),445+offsetX,472+offsetY);
        addObject(new Block(49),418+offsetX,526+offsetY);
        addObject(new Block(49),445+offsetX,526+offsetY);
        addObject(new Block(49),418+offsetX,499+offsetY);
        addObject(new Block(49),499+offsetX,499+offsetY);
        addObject(new Block(49),472+offsetX,472+offsetY);
        addObject(new Block(49),499+offsetX,472+offsetY);
        addObject(new Block(49),472+offsetX,526+offsetY);
        addObject(new Block(49),499+offsetX,526+offsetY);
        addObject(new Block(49),472+offsetX,499+offsetY);
        addObject(new Block(49),553+offsetX,499+offsetY);
        addObject(new Block(49),526+offsetX,472+offsetY);
        addObject(new Block(49),553+offsetX,472+offsetY);
        addObject(new Block(49),526+offsetX,526+offsetY);
        addObject(new Block(49),553+offsetX,526+offsetY);
        addObject(new Block(49),526+offsetX,499+offsetY);
        addObject(new Block(49),580+offsetX,472+offsetY);
        addObject(new Block(49),580+offsetX,526+offsetY);
        addObject(new Block(49),580+offsetX,499+offsetY);
        addObject(new Block(49),607+offsetX,526+offsetY);
        addObject(new Block(49),607+offsetX,499+offsetY);
        addObject(new Block(49),661+offsetX,499+offsetY);
        addObject(new Block(49),634+offsetX,472+offsetY);
        addObject(new Block(49),661+offsetX,472+offsetY);
        addObject(new Block(49),634+offsetX,526+offsetY);
        addObject(new Block(49),661+offsetX,526+offsetY);
        addObject(new Block(49),634+offsetX,499+offsetY);
        addObject(new Block(49),715+offsetX,499+offsetY);
        addObject(new Block(49),688+offsetX,472+offsetY);
        addObject(new Block(49),715+offsetX,472+offsetY);
        addObject(new Block(49),688+offsetX,526+offsetY);
        addObject(new Block(49),715+offsetX,526+offsetY);
        addObject(new Block(49),688+offsetX,499+offsetY);
        addObject(new Block(49),742+offsetX,472+offsetY);
        addObject(new Block(49),742+offsetX,526+offsetY);
        addObject(new Block(49),742+offsetX,499+offsetY);
        addObject(new Block(49),796+offsetX,499+offsetY);
        addObject(new Block(49),769+offsetX,472+offsetY);
        addObject(new Block(49),796+offsetX,472+offsetY);
        addObject(new Block(49),823+offsetX,472+offsetY);
        addObject(new Block(49),769+offsetX,526+offsetY);
        addObject(new Block(49),796+offsetX,526+offsetY);
        addObject(new Block(49),823+offsetX,526+offsetY);
        addObject(new Block(49),769+offsetX,499+offsetY);
        addObject(new Block(49),823+offsetX,499+offsetY);
        addObject(new Block(49),607+offsetX,472+offsetY);
        addObject(new Block(49),310+offsetX,472+offsetY);
        addObject(new Block(49),94+offsetX,391+offsetY);
        addObject(new Block(49),94+offsetX,256+offsetY);
        addObject(new Block(49),94+offsetX,337+offsetY);
        addObject(new Block(49),94+offsetX,310+offsetY);
        addObject(new Block(49),94+offsetX,283+offsetY);
        addObject(new PlatformPlayer(),94+offsetX,121+offsetY);
        addObject(new ExitPortal(),769+offsetX,391+offsetY);
        addObject(new Track(93),283+offsetX,175+offsetY);
        addObject(new Track(93),283+offsetX,202+offsetY);
        addObject(new Track(93),283+offsetX,229+offsetY);
        addObject(new Track(93),283+offsetX,256+offsetY);
        addObject(new Track(93),283+offsetX,283+offsetY);
        addObject(new Track(93),256+offsetX,283+offsetY);
        addObject(new Track(93),229+offsetX,283+offsetY);
        addObject(new Track(93),229+offsetX,310+offsetY);
        addObject(new Track(93),229+offsetX,337+offsetY);
        addObject(new Track(93),229+offsetX,364+offsetY);
        addObject(new Track(93),256+offsetX,364+offsetY);
        addObject(new Track(93),283+offsetX,364+offsetY);
        addObject(new Track(93),310+offsetX,364+offsetY);
        addObject(new Track(93),337+offsetX,364+offsetY);
        addObject(new Track(93),364+offsetX,364+offsetY);
        addObject(new Track(93),364+offsetX,337+offsetY);
        addObject(new Track(93),364+offsetX,310+offsetY);
        addObject(new Track(93),391+offsetX,310+offsetY);
        addObject(new Track(93),418+offsetX,310+offsetY);
        addObject(new Track(93),418+offsetX,337+offsetY);
        addObject(new Track(93),418+offsetX,364+offsetY);
        addObject(new Track(93),418+offsetX,391+offsetY);
        addObject(new Track(93),445+offsetX,391+offsetY);
        addObject(new Track(93),472+offsetX,391+offsetY);
        addObject(new Track(93),499+offsetX,391+offsetY);
        addObject(new Track(93),526+offsetX,391+offsetY);
        addObject(new Track(93),526+offsetX,364+offsetY);
        addObject(new Track(93),526+offsetX,337+offsetY);
        addObject(new Track(93),526+offsetX,310+offsetY);
        addObject(new Track(93),526+offsetX,283+offsetY);
        addObject(new Track(93),526+offsetX,256+offsetY);
        addObject(new Track(93),499+offsetX,256+offsetY);
        addObject(new Track(93),472+offsetX,256+offsetY);
        addObject(new Track(93),445+offsetX,256+offsetY);
        addObject(new Track(93),445+offsetX,229+offsetY);
        addObject(new Track(93),445+offsetX,202+offsetY);
        addObject(new Track(93),472+offsetX,202+offsetY);
        addObject(new Track(93),499+offsetX,202+offsetY);
        addObject(new Track(93),526+offsetX,202+offsetY);
        addObject(new Track(93),553+offsetX,202+offsetY);
        addObject(new Track(93),580+offsetX,202+offsetY);
        addObject(new Track(93),580+offsetX,175+offsetY);
        addObject(new Track(93),580+offsetX,148+offsetY);
        addObject(new Track(93),553+offsetX,148+offsetY);
        addObject(new Track(93),526+offsetX,148+offsetY);
        addObject(new Track(93),499+offsetX,148+offsetY);
        addObject(new Track(93),472+offsetX,148+offsetY);
        addObject(new Track(93),445+offsetX,148+offsetY);
        addObject(new Track(93),418+offsetX,148+offsetY);
        addObject(new Track(93),391+offsetX,148+offsetY);
        addObject(new Track(93),391+offsetX,175+offsetY);
        addObject(new Track(93),391+offsetX,202+offsetY);
        addObject(new Track(93),391+offsetX,229+offsetY);
        addObject(new Track(93),364+offsetX,229+offsetY);
        addObject(new Track(93),337+offsetX,229+offsetY);
        addObject(new Track(93),337+offsetX,202+offsetY);
        addObject(new Track(93),337+offsetX,175+offsetY);
        addObject(new Track(93),337+offsetX,148+offsetY);
        addObject(new Track(93),283+offsetX,148+offsetY);
        addObject(new Track(93),310+offsetX,148+offsetY);
        addObject(new Cart(94),310+offsetX,148+offsetY);
        addObject(new Cart(94),337+offsetX,148+offsetY);
        addObject(new Cart(94),283+offsetX,148+offsetY);

    }
}
