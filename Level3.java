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
        addObject(new Block(17),40+offsetX,472+offsetY);
        addObject(new Block(17),67+offsetX,472+offsetY);
        addObject(new Block(17),94+offsetX,472+offsetY);
        addObject(new Block(17),121+offsetX,472+offsetY);
        addObject(new Block(17),148+offsetX,472+offsetY);
        addObject(new Block(17),175+offsetX,472+offsetY);
        addObject(new Block(17),202+offsetX,472+offsetY);
        addObject(new Block(17),229+offsetX,472+offsetY);
        addObject(new ElevatorBlock(87),256+offsetX,418+offsetY);
        addObject(new ElevatorBlock(87),283+offsetX,418+offsetY);
        addObject(new ElevatorBlock(87),310+offsetX,418+offsetY);
        addObject(new Block(17),337+offsetX,364+offsetY);
        addObject(new Block(17),364+offsetX,364+offsetY);
        addObject(new Block(17),391+offsetX,364+offsetY);
        addObject(new ElevatorBlock(87),418+offsetX,310+offsetY);
        addObject(new ElevatorBlock(87),445+offsetX,310+offsetY);
        addObject(new ElevatorBlock(87),472+offsetX,310+offsetY);
        addObject(new Block(17),499+offsetX,256+offsetY);
        addObject(new Block(17),526+offsetX,256+offsetY);
        addObject(new Block(17),553+offsetX,256+offsetY);
        addObject(new Block(17),580+offsetX,256+offsetY);
        addObject(new Block(17),607+offsetX,256+offsetY);
        addObject(new Block(17),634+offsetX,256+offsetY);
        addObject(new Block(17),661+offsetX,256+offsetY);
        addObject(new SlimeBlock(88),688+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),715+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),742+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),769+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),796+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),823+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),850+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),877+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),904+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),931+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),958+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),985+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),1012+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),1039+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),1066+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),1093+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),1120+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),1147+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),1174+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),1201+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),1228+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),1255+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),1282+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),1309+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),1336+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),1363+offsetX,472+offsetY);
        addObject(new BulletLauncher(85,0),634+offsetX,418+offsetY);
        addObject(new BulletLauncher(85,0),526+offsetX,364+offsetY);
        addObject(new Block(46),526+offsetX,283+offsetY);
        addObject(new Block(46),634+offsetX,310+offsetY);
        addObject(new Block(46),634+offsetX,283+offsetY);
        addObject(new BackgroundBlock(46),634+offsetX,337+offsetY);
        addObject(new BackgroundBlock(46),634+offsetX,391+offsetY);
        addObject(new BackgroundBlock(46),634+offsetX,364+offsetY);
        addObject(new BackgroundBlock(46),526+offsetX,337+offsetY);
        addObject(new Block(46),526+offsetX,310+offsetY);
        addObject(new SlimeBlock(88),1390+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),1417+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),1444+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),1471+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),1498+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),1525+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),1552+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),1579+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),1606+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),1633+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),1660+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),1687+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),1714+offsetX,472+offsetY);
        addObject(new SlimeBlock(88),1741+offsetX,472+offsetY);
        addObject(new FallingBlock(75),1768+offsetX,391+offsetY);
        addObject(new FallingBlock(75),1795+offsetX,391+offsetY);
        addObject(new FallingBlock(75),1822+offsetX,391+offsetY);
        addObject(new FallingBlock(75),1849+offsetX,391+offsetY);
        addObject(new FallingBlock(75),1876+offsetX,391+offsetY);
        addObject(new FallingBlock(75),1903+offsetX,391+offsetY);
        addObject(new FallingBlock(75),1930+offsetX,391+offsetY);
        addObject(new FallingBlock(75),1957+offsetX,391+offsetY);
        addObject(new FallingBlock(75),1984+offsetX,391+offsetY);
        addObject(new FallingBlock(75),2011+offsetX,391+offsetY);
        addObject(new FallingBlock(75),2038+offsetX,391+offsetY);
        addObject(new FallingBlock(75),2065+offsetX,391+offsetY);
        addObject(new FallingBlock(75),2092+offsetX,391+offsetY);
        addObject(new FallingBlock(75),2119+offsetX,391+offsetY);
        addObject(new FallingBlock(75),2146+offsetX,391+offsetY);
        addObject(new FallingBlock(75),2173+offsetX,391+offsetY);
        addObject(new FallingBlock(75),2200+offsetX,391+offsetY);
        addObject(new FallingBlock(75),2227+offsetX,391+offsetY);
        addObject(new FallingBlock(75),2254+offsetX,391+offsetY);
        addObject(new FallingBlock(75),2281+offsetX,391+offsetY);
        addObject(new FallingBlock(75),2308+offsetX,391+offsetY);
        addObject(new FallingBlock(75),2335+offsetX,391+offsetY);
        addObject(new FallingBlock(75),2362+offsetX,391+offsetY);
        addObject(new FallingBlock(75),2389+offsetX,391+offsetY);
        addObject(new FallingBlock(75),2416+offsetX,391+offsetY);
        addObject(new FallingBlock(75),2443+offsetX,391+offsetY);
        addObject(new FallingBlock(75),2470+offsetX,391+offsetY);
        addObject(new FallingBlock(75),2497+offsetX,391+offsetY);
        addObject(new FallingBlock(75),2524+offsetX,391+offsetY);
        addObject(new FallingBlock(75),2551+offsetX,391+offsetY);
        addObject(new FallingBlock(75),2578+offsetX,391+offsetY);
        addObject(new FallingBlock(75),2605+offsetX,391+offsetY);
        addObject(new FallingBlock(75),2632+offsetX,391+offsetY);
        addObject(new FallingBlock(75),2659+offsetX,391+offsetY);
        addObject(new Block(44),2686+offsetX,391+offsetY);
        addObject(new Block(44),2713+offsetX,391+offsetY);
        addObject(new Block(44),2740+offsetX,391+offsetY);
        addObject(new Block(44),2767+offsetX,391+offsetY);
        addObject(new Block(44),2794+offsetX,391+offsetY);
        addObject(new Block(44),2821+offsetX,391+offsetY);
        addObject(new Block(44),2848+offsetX,391+offsetY);
        addObject(new Block(44),2875+offsetX,391+offsetY);
        addObject(new Block(44),2902+offsetX,391+offsetY);
        addObject(new Block(44),2929+offsetX,391+offsetY);
        addObject(new Block(44),2956+offsetX,391+offsetY);
        addObject(new Block(44),2983+offsetX,391+offsetY);
        addObject(new Block(44),3010+offsetX,391+offsetY);
        addObject(new Block(44),3037+offsetX,391+offsetY);
        addObject(new Block(44),3064+offsetX,391+offsetY);
        addObject(new Block(44),3091+offsetX,391+offsetY);
        addObject(new Block(44),3118+offsetX,391+offsetY);
        addObject(new Block(44),3145+offsetX,391+offsetY);
        addObject(new Block(44),3145+offsetX,364+offsetY);
        addObject(new Block(44),3145+offsetX,337+offsetY);
        addObject(new Block(44),3145+offsetX,310+offsetY);
        addObject(new Block(44),3145+offsetX,283+offsetY);
        addObject(new Block(44),3145+offsetX,256+offsetY);
        addObject(new Block(44),3145+offsetX,229+offsetY);
        addObject(new Block(44),3145+offsetX,202+offsetY);
        addObject(new Block(44),3145+offsetX,175+offsetY);
        addObject(new Block(44),3145+offsetX,148+offsetY);
        addObject(new Block(44),3145+offsetX,121+offsetY);
        addObject(new Block(44),3145+offsetX,94+offsetY);
        addObject(new Block(44),3145+offsetX,67+offsetY);
        addObject(new Block(44),3145+offsetX,40+offsetY);
        addObject(new PlatformPlayer(),94+offsetX,202+offsetY);

    }
}
