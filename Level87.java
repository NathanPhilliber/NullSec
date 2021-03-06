import greenfoot.*;

//Level generated by Level Creator
//Level designed by: 

public class Level87 extends Platformer{
    public Level87(){
        this(0,0);
    }

    public Level87(double x, double y){
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
        int offsetY = (getHeight()-540)/2;

        setBackground("PlanetOneBG.png");
        addObject(new LavaBlock(2),202+offsetX,499+offsetY);
        addObject(new LavaBlock(2),256+offsetX,499+offsetY);
        addObject(new LavaBlock(2),229+offsetX,499+offsetY);
        addObject(new LavaBlock(2),283+offsetX,499+offsetY);
        addObject(new LavaBlock(2),310+offsetX,499+offsetY);
        addObject(new LavaBlock(2),337+offsetX,499+offsetY);
        addObject(new LavaBlock(2),364+offsetX,499+offsetY);
        addObject(new LavaBlock(2),418+offsetX,499+offsetY);
        addObject(new LavaBlock(2),445+offsetX,499+offsetY);
        addObject(new LavaBlock(2),526+offsetX,499+offsetY);
        addObject(new LavaBlock(2),472+offsetX,499+offsetY);
        addObject(new LavaBlock(2),499+offsetX,499+offsetY);
        addObject(new LavaBlock(2),553+offsetX,499+offsetY);
        addObject(new LavaBlock(2),580+offsetX,499+offsetY);
        addObject(new LavaBlock(2),607+offsetX,499+offsetY);
        addObject(new LavaBlock(2),634+offsetX,499+offsetY);
        addObject(new LavaBlock(2),661+offsetX,499+offsetY);
        addObject(new LavaBlock(2),688+offsetX,499+offsetY);
        addObject(new LavaBlock(2),715+offsetX,499+offsetY);
        addObject(new LavaBlock(2),742+offsetX,499+offsetY);
        addObject(new LavaBlock(2),769+offsetX,499+offsetY);
        addObject(new LavaBlock(2),796+offsetX,499+offsetY);
        addObject(new LavaBlock(2),823+offsetX,499+offsetY);
        addObject(new LavaBlock(2),850+offsetX,499+offsetY);
        addObject(new LavaBlock(2),877+offsetX,499+offsetY);
        addObject(new LavaBlock(2),931+offsetX,499+offsetY);
        addObject(new LavaBlock(2),958+offsetX,499+offsetY);
        addObject(new LavaBlock(2),985+offsetX,499+offsetY);
        addObject(new LavaBlock(2),904+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1012+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1039+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1066+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1120+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1093+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1147+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1174+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1201+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1228+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1255+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1309+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1363+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1336+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1282+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1390+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1417+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1444+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1471+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1498+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1525+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1552+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1579+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1606+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1633+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1660+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1687+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1714+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1741+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1768+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1795+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1822+offsetX,499+offsetY);
        addObject(new Block(56),1957+offsetX,472+offsetY);
        addObject(new Block(56),1984+offsetX,472+offsetY);
        addObject(new Block(56),2011+offsetX,472+offsetY);
        addObject(new Block(56),2038+offsetX,472+offsetY);
        addObject(new Block(56),2065+offsetX,472+offsetY);
        addObject(new Block(56),2092+offsetX,472+offsetY);
        addObject(new Block(56),2119+offsetX,472+offsetY);
        addObject(new Block(56),2146+offsetX,472+offsetY);
        addObject(new Block(56),2146+offsetX,499+offsetY);
        addObject(new Block(56),2119+offsetX,499+offsetY);
        addObject(new Block(56),2092+offsetX,499+offsetY);
        addObject(new Block(56),2065+offsetX,499+offsetY);
        addObject(new Block(56),2038+offsetX,499+offsetY);
        addObject(new Block(56),2011+offsetX,499+offsetY);
        addObject(new Block(56),1984+offsetX,499+offsetY);
        addObject(new Block(56),1957+offsetX,499+offsetY);
        addObject(new Block(56),1930+offsetX,472+offsetY);
        addObject(new Block(56),1930+offsetX,499+offsetY);
        addObject(new Block(56),1903+offsetX,499+offsetY);
        addObject(new Block(56),1903+offsetX,472+offsetY);
        addObject(new Block(56),1876+offsetX,472+offsetY);
        addObject(new Block(56),1876+offsetX,499+offsetY);
        addObject(new Block(56),1849+offsetX,499+offsetY);
        addObject(new Block(56),1849+offsetX,472+offsetY);
        addObject(new Block(56),13+offsetX,499+offsetY);
        addObject(new Block(56),40+offsetX,499+offsetY);
        addObject(new Block(56),67+offsetX,499+offsetY);
        addObject(new Block(56),94+offsetX,499+offsetY);
        addObject(new Block(56),121+offsetX,499+offsetY);
        addObject(new Block(56),148+offsetX,499+offsetY);
        addObject(new Block(56),175+offsetX,499+offsetY);
        addObject(new Block(56),175+offsetX,472+offsetY);
        addObject(new Block(56),121+offsetX,472+offsetY);
        addObject(new Block(56),94+offsetX,472+offsetY);
        addObject(new Block(56),67+offsetX,472+offsetY);
        addObject(new Block(56),40+offsetX,472+offsetY);
        addObject(new Block(56),13+offsetX,472+offsetY);
        addObject(new Block(56),148+offsetX,472+offsetY);
        addObject(new LavaBlock(1),202+offsetX,472+offsetY);
        addObject(new LavaBlock(1),229+offsetX,472+offsetY);
        addObject(new LavaBlock(1),256+offsetX,472+offsetY);
        addObject(new LavaBlock(1),364+offsetX,472+offsetY);
        addObject(new LavaBlock(1),310+offsetX,472+offsetY);
        addObject(new LavaBlock(1),283+offsetX,472+offsetY);
        addObject(new LavaBlock(1),337+offsetX,472+offsetY);
        addObject(new LavaBlock(1),391+offsetX,472+offsetY);
        addObject(new LavaBlock(1),418+offsetX,472+offsetY);
        addObject(new LavaBlock(1),445+offsetX,472+offsetY);
        addObject(new LavaBlock(1),472+offsetX,472+offsetY);
        addObject(new LavaBlock(1),553+offsetX,472+offsetY);
        addObject(new LavaBlock(1),499+offsetX,472+offsetY);
        addObject(new LavaBlock(1),526+offsetX,472+offsetY);
        addObject(new LavaBlock(1),580+offsetX,472+offsetY);
        addObject(new LavaBlock(1),634+offsetX,472+offsetY);
        addObject(new LavaBlock(1),661+offsetX,472+offsetY);
        addObject(new LavaBlock(1),607+offsetX,472+offsetY);
        addObject(new LavaBlock(1),688+offsetX,472+offsetY);
        addObject(new LavaBlock(1),715+offsetX,472+offsetY);
        addObject(new LavaBlock(1),742+offsetX,472+offsetY);
        addObject(new LavaBlock(1),769+offsetX,472+offsetY);
        addObject(new LavaBlock(1),796+offsetX,472+offsetY);
        addObject(new LavaBlock(1),823+offsetX,472+offsetY);
        addObject(new LavaBlock(1),850+offsetX,472+offsetY);
        addObject(new LavaBlock(1),877+offsetX,472+offsetY);
        addObject(new LavaBlock(1),904+offsetX,472+offsetY);
        addObject(new LavaBlock(1),931+offsetX,472+offsetY);
        addObject(new LavaBlock(1),958+offsetX,472+offsetY);
        addObject(new LavaBlock(1),985+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1012+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1039+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1066+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1120+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1093+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1147+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1174+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1201+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1255+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1282+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1228+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1309+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1336+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1363+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1390+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1417+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1444+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1471+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1498+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1525+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1552+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1579+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1606+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1633+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1660+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1687+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1714+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1741+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1768+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1795+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1822+offsetX,472+offsetY);
        addObject(new LavaBlock(2),391+offsetX,499+offsetY);
        addObject(new ElevatorBlock(87),229+offsetX,391+offsetY);
        addObject(new ElevatorBlock(87),256+offsetX,391+offsetY);
        addObject(new ElevatorBlock(87),283+offsetX,391+offsetY);
        addObject(new ElevatorBlock(87),310+offsetX,283+offsetY);
        addObject(new ElevatorBlock(87),337+offsetX,283+offsetY);
        addObject(new ElevatorBlock(87),364+offsetX,283+offsetY);
        addObject(new ElevatorBlock(87),418+offsetX,364+offsetY);
        addObject(new ElevatorBlock(87),445+offsetX,364+offsetY);
        addObject(new ElevatorBlock(87),472+offsetX,364+offsetY);
        addObject(new ElevatorBlock(87),499+offsetX,229+offsetY);
        addObject(new ElevatorBlock(87),526+offsetX,229+offsetY);
        addObject(new ElevatorBlock(87),553+offsetX,229+offsetY);
        addObject(new ElevatorBlock(87),580+offsetX,229+offsetY);
        addObject(new ElevatorBlock(87),607+offsetX,310+offsetY);
        addObject(new ElevatorBlock(87),634+offsetX,310+offsetY);
        addObject(new ElevatorBlock(87),661+offsetX,310+offsetY);
        addObject(new ElevatorBlock(87),688+offsetX,175+offsetY);
        addObject(new ElevatorBlock(87),715+offsetX,175+offsetY);
        addObject(new ElevatorBlock(87),742+offsetX,175+offsetY);
        addObject(new ElevatorBlock(87),796+offsetX,67+offsetY);
        addObject(new ElevatorBlock(87),823+offsetX,67+offsetY);
        addObject(new ElevatorBlock(87),850+offsetX,67+offsetY);
        addObject(new ElevatorBlock(87),877+offsetX,175+offsetY);
        addObject(new ElevatorBlock(87),904+offsetX,175+offsetY);
        addObject(new ElevatorBlock(87),931+offsetX,175+offsetY);
        addObject(new ElevatorBlock(87),958+offsetX,256+offsetY);
        addObject(new ElevatorBlock(87),985+offsetX,256+offsetY);
        addObject(new ElevatorBlock(87),1012+offsetX,256+offsetY);
        addObject(new ElevatorBlock(87),1039+offsetX,148+offsetY);
        addObject(new ElevatorBlock(87),1066+offsetX,148+offsetY);
        addObject(new ElevatorBlock(87),1093+offsetX,148+offsetY);
        addObject(new ElevatorBlock(87),1120+offsetX,148+offsetY);
        addObject(new ElevatorBlock(87),1147+offsetX,229+offsetY);
        addObject(new ElevatorBlock(87),1174+offsetX,229+offsetY);
        addObject(new ElevatorBlock(87),1201+offsetX,229+offsetY);
        addObject(new ElevatorBlock(87),1228+offsetX,229+offsetY);
        addObject(new ElevatorBlock(87),1255+offsetX,310+offsetY);
        addObject(new ElevatorBlock(87),1282+offsetX,310+offsetY);
        addObject(new ElevatorBlock(87),1309+offsetX,310+offsetY);
        addObject(new ElevatorBlock(87),1363+offsetX,202+offsetY);
        addObject(new ElevatorBlock(87),1390+offsetX,202+offsetY);
        addObject(new ElevatorBlock(87),1417+offsetX,202+offsetY);
        addObject(new ElevatorBlock(87),1444+offsetX,121+offsetY);
        addObject(new ElevatorBlock(87),1471+offsetX,121+offsetY);
        addObject(new ElevatorBlock(87),1498+offsetX,121+offsetY);
        addObject(new ElevatorBlock(87),1525+offsetX,202+offsetY);
        addObject(new ElevatorBlock(87),1552+offsetX,202+offsetY);
        addObject(new ElevatorBlock(87),1579+offsetX,202+offsetY);
        addObject(new ElevatorBlock(87),1606+offsetX,283+offsetY);
        addObject(new ElevatorBlock(87),1633+offsetX,283+offsetY);
        addObject(new ElevatorBlock(87),1660+offsetX,283+offsetY);
        addObject(new ElevatorBlock(87),1687+offsetX,148+offsetY);
        addObject(new ElevatorBlock(87),1714+offsetX,148+offsetY);
        addObject(new ElevatorBlock(87),1741+offsetX,148+offsetY);
        addObject(new ElevatorBlock(87),1822+offsetX,67+offsetY);
        addObject(new ElevatorBlock(87),1849+offsetX,67+offsetY);
        addObject(new GravityBlock(95),1849+offsetX,94+offsetY);
        addObject(new FallingBlock(75),796+offsetX,310+offsetY);
        addObject(new FallingBlock(75),823+offsetX,310+offsetY);
        addObject(new FallingBlock(75),850+offsetX,310+offsetY);
        addObject(new FallingBlock(75),1255+offsetX,94+offsetY);
        addObject(new FallingBlock(75),1282+offsetX,94+offsetY);
        addObject(new FallingBlock(75),1309+offsetX,94+offsetY);
        addObject(new BulletLauncher(86,180),796+offsetX,283+offsetY);
        addObject(new BulletLauncher(85,0),850+offsetX,283+offsetY);
        addObject(new BulletLauncher(86,180),1255+offsetX,121+offsetY);
        addObject(new BulletLauncher(85,0),1309+offsetX,121+offsetY);
        addObject(new SpikeBlock(84),1282+offsetX,121+offsetY);
        addObject(new SpikeBlock(84),823+offsetX,283+offsetY);
        addObject(new GravityBlock(95),742+offsetX,148+offsetY);
        addObject(new Coin(90),310+offsetX,202+offsetY);
        addObject(new Coin(90),337+offsetX,202+offsetY);
        addObject(new Coin(90),364+offsetX,202+offsetY);
        addObject(new Coin(90),445+offsetX,310+offsetY);
        addObject(new Coin(90),472+offsetX,310+offsetY);
        addObject(new Coin(90),418+offsetX,310+offsetY);
        addObject(new Coin(90),877+offsetX,121+offsetY);
        addObject(new Coin(90),904+offsetX,121+offsetY);
        addObject(new Coin(90),931+offsetX,121+offsetY);
        addObject(new Coin(90),958+offsetX,310+offsetY);
        addObject(new Coin(90),1012+offsetX,310+offsetY);
        addObject(new Coin(90),985+offsetX,310+offsetY);
        addObject(new Coin(90),1039+offsetX,202+offsetY);
        addObject(new Coin(90),1066+offsetX,202+offsetY);
        addObject(new Coin(90),1093+offsetX,202+offsetY);
        addObject(new Coin(90),1120+offsetX,202+offsetY);
        addObject(new Coin(90),1147+offsetX,283+offsetY);
        addObject(new Coin(90),1174+offsetX,283+offsetY);
        addObject(new Coin(90),1228+offsetX,283+offsetY);
        addObject(new Coin(90),1201+offsetX,283+offsetY);
        addObject(new Coin(90),607+offsetX,256+offsetY);
        addObject(new Coin(90),634+offsetX,256+offsetY);
        addObject(new Coin(90),661+offsetX,256+offsetY);
        addObject(new Coin(90),229+offsetX,337+offsetY);
        addObject(new Coin(90),256+offsetX,337+offsetY);
        addObject(new Coin(90),283+offsetX,337+offsetY);
        addObject(new Coin(90),1363+offsetX,256+offsetY);
        addObject(new Coin(90),1390+offsetX,256+offsetY);
        addObject(new Coin(90),1417+offsetX,256+offsetY);
        addObject(new Coin(90),1606+offsetX,337+offsetY);
        addObject(new Coin(90),1633+offsetX,337+offsetY);
        addObject(new Coin(90),1660+offsetX,337+offsetY);
        addObject(new Coin(90),1444+offsetX,175+offsetY);
        addObject(new Coin(90),1471+offsetX,175+offsetY);
        addObject(new Coin(90),1498+offsetX,175+offsetY);
        addObject(new Block(56),2119+offsetX,445+offsetY);
        addObject(new Block(56),2146+offsetX,445+offsetY);
        addObject(new Block(56),2146+offsetX,418+offsetY);
        addObject(new Block(56),2119+offsetX,418+offsetY);
        addObject(new Block(56),2119+offsetX,391+offsetY);
        addObject(new Block(56),2146+offsetX,391+offsetY);
        addObject(new Block(56),2146+offsetX,364+offsetY);
        addObject(new Block(56),2119+offsetX,364+offsetY);
        addObject(new Block(56),2119+offsetX,337+offsetY);
        addObject(new Block(56),2146+offsetX,337+offsetY);
        addObject(new Block(56),2146+offsetX,310+offsetY);
        addObject(new Block(56),2119+offsetX,310+offsetY);
        addObject(new Block(56),2119+offsetX,283+offsetY);
        addObject(new Block(56),2146+offsetX,283+offsetY);
        addObject(new Block(56),2146+offsetX,256+offsetY);
        addObject(new Block(56),2119+offsetX,256+offsetY);
        addObject(new Block(56),2119+offsetX,229+offsetY);
        addObject(new Block(56),2146+offsetX,229+offsetY);
        addObject(new Block(56),2146+offsetX,202+offsetY);
        addObject(new Block(56),2119+offsetX,202+offsetY);
        addObject(new Block(56),2119+offsetX,175+offsetY);
        addObject(new Block(56),2146+offsetX,175+offsetY);
        addObject(new Block(56),2146+offsetX,148+offsetY);
        addObject(new Block(56),2119+offsetX,148+offsetY);
        addObject(new Block(56),2119+offsetX,121+offsetY);
        addObject(new Block(56),2146+offsetX,121+offsetY);
        addObject(new Block(56),2146+offsetX,94+offsetY);
        addObject(new Block(56),2119+offsetX,94+offsetY);
        addObject(new Block(56),2146+offsetX,67+offsetY);
        addObject(new Block(56),2119+offsetX,67+offsetY);
        addObject(new Block(56),2119+offsetX,40+offsetY);
        addObject(new Block(56),2146+offsetX,40+offsetY);
        addObject(new Block(56),2146+offsetX,13+offsetY);
        addObject(new Block(56),2119+offsetX,13+offsetY);
        addObject(new ExitPortal(),2038+offsetX,391+offsetY);
        addObject(new PlatformPlayer(),40+offsetX,418+offsetY);

    }
}
