import greenfoot.*;

//Level generated by Level Creator
//Level designed by: 

public class Level85 extends Platformer{
    GreenfootSound song = new GreenfootSound("Dungeon.mp3");
    public Level85(){
        this(0,0);
    }

    public Level85(double x, double y){
        super(x,y);
        song.playLoop();
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
        int offsetX = 0;
        int offsetY = (getHeight()-540)/2;

        setBackground("Background3.png");
        addObject(new Block(48),13+offsetX,499+offsetY);
        addObject(new Block(48),-14+offsetX,472+offsetY);
        addObject(new Block(48),13+offsetX,472+offsetY);
        addObject(new Block(48),40+offsetX,472+offsetY);
        addObject(new Block(48),-14+offsetX,526+offsetY);
        addObject(new Block(48),13+offsetX,526+offsetY);
        addObject(new Block(48),40+offsetX,526+offsetY);
        addObject(new Block(48),-14+offsetX,499+offsetY);
        addObject(new Block(48),40+offsetX,499+offsetY);
        addObject(new Block(48),67+offsetX,472+offsetY);
        addObject(new Block(48),67+offsetX,526+offsetY);
        addObject(new Block(48),67+offsetX,499+offsetY);
        addObject(new Block(48),94+offsetX,472+offsetY);
        addObject(new Block(48),94+offsetX,526+offsetY);
        addObject(new Block(48),94+offsetX,499+offsetY);
        addObject(new Block(48),121+offsetX,472+offsetY);
        addObject(new Block(48),121+offsetX,526+offsetY);
        addObject(new Block(48),121+offsetX,499+offsetY);
        addObject(new Block(48),148+offsetX,472+offsetY);
        addObject(new Block(48),148+offsetX,526+offsetY);
        addObject(new Block(48),148+offsetX,499+offsetY);
        addObject(new Block(48),175+offsetX,472+offsetY);
        addObject(new Block(48),175+offsetX,526+offsetY);
        addObject(new Block(48),175+offsetX,499+offsetY);
        addObject(new Block(48),202+offsetX,472+offsetY);
        addObject(new Block(48),202+offsetX,526+offsetY);
        addObject(new Block(48),202+offsetX,499+offsetY);
        addObject(new Block(48),229+offsetX,472+offsetY);
        addObject(new Block(48),229+offsetX,526+offsetY);
        addObject(new Block(48),229+offsetX,499+offsetY);
        addObject(new Block(48),256+offsetX,472+offsetY);
        addObject(new Block(48),256+offsetX,526+offsetY);
        addObject(new Block(48),256+offsetX,499+offsetY);
        addObject(new Block(48),283+offsetX,472+offsetY);
        addObject(new Block(48),283+offsetX,526+offsetY);
        addObject(new Block(48),283+offsetX,499+offsetY);
        addObject(new Block(48),310+offsetX,472+offsetY);
        addObject(new Block(48),310+offsetX,526+offsetY);
        addObject(new Block(48),310+offsetX,499+offsetY);
        addObject(new Block(48),364+offsetX,499+offsetY);
        addObject(new Block(48),337+offsetX,472+offsetY);
        addObject(new Block(48),364+offsetX,472+offsetY);
        addObject(new Block(48),337+offsetX,526+offsetY);
        addObject(new Block(48),364+offsetX,526+offsetY);
        addObject(new Block(48),337+offsetX,499+offsetY);
        addObject(new Block(48),391+offsetX,472+offsetY);
        addObject(new Block(48),391+offsetX,526+offsetY);
        addObject(new Block(48),391+offsetX,499+offsetY);
        addObject(new Block(48),418+offsetX,526+offsetY);
        addObject(new Block(48),445+offsetX,526+offsetY);
        addObject(new Block(48),472+offsetX,526+offsetY);
        addObject(new Block(48),499+offsetX,526+offsetY);
        addObject(new Block(48),526+offsetX,526+offsetY);
        addObject(new Block(48),553+offsetX,526+offsetY);
        addObject(new Block(48),580+offsetX,526+offsetY);
        addObject(new Block(48),607+offsetX,526+offsetY);
        addObject(new Block(48),634+offsetX,526+offsetY);
        addObject(new Block(48),661+offsetX,526+offsetY);
        addObject(new Block(48),688+offsetX,526+offsetY);
        addObject(new Block(48),715+offsetX,526+offsetY);
        addObject(new Block(48),742+offsetX,526+offsetY);
        addObject(new Block(48),769+offsetX,526+offsetY);
        addObject(new Block(48),796+offsetX,526+offsetY);
        addObject(new Block(48),823+offsetX,526+offsetY);
        addObject(new Block(48),850+offsetX,526+offsetY);
        addObject(new Block(48),877+offsetX,526+offsetY);
        addObject(new Block(48),904+offsetX,526+offsetY);
        addObject(new Block(48),931+offsetX,526+offsetY);
        addObject(new Block(48),958+offsetX,526+offsetY);
        addObject(new Block(48),985+offsetX,526+offsetY);
        addObject(new Block(48),1012+offsetX,526+offsetY);
        addObject(new Block(48),1039+offsetX,526+offsetY);
        addObject(new Block(48),1066+offsetX,526+offsetY);
        addObject(new Block(48),1093+offsetX,526+offsetY);
        addObject(new Block(48),1120+offsetX,526+offsetY);
        addObject(new Block(48),1147+offsetX,526+offsetY);
        addObject(new Block(48),1174+offsetX,526+offsetY);
        addObject(new Block(48),1201+offsetX,526+offsetY);
        addObject(new Block(48),1228+offsetX,526+offsetY);
        addObject(new Block(48),1255+offsetX,526+offsetY);
        addObject(new Block(48),1282+offsetX,526+offsetY);
        addObject(new Block(48),1309+offsetX,526+offsetY);
        addObject(new Block(48),1336+offsetX,526+offsetY);
        addObject(new Block(48),1363+offsetX,526+offsetY);
        addObject(new Block(48),1390+offsetX,526+offsetY);
        addObject(new Block(48),1417+offsetX,526+offsetY);
        addObject(new Block(48),1444+offsetX,526+offsetY);
        addObject(new Block(48),1471+offsetX,526+offsetY);
        addObject(new Block(48),1498+offsetX,526+offsetY);
        addObject(new Block(48),1525+offsetX,526+offsetY);
        addObject(new Block(48),1552+offsetX,526+offsetY);
        addObject(new Block(48),1579+offsetX,526+offsetY);
        addObject(new Block(48),1606+offsetX,526+offsetY);
        addObject(new Block(48),1633+offsetX,526+offsetY);
        addObject(new Block(48),1660+offsetX,526+offsetY);
        addObject(new Block(48),1687+offsetX,526+offsetY);
        addObject(new Block(48),1714+offsetX,526+offsetY);
        addObject(new Block(48),1741+offsetX,526+offsetY);
        addObject(new Block(48),1768+offsetX,526+offsetY);
        addObject(new Block(48),1795+offsetX,526+offsetY);
        addObject(new Block(48),1822+offsetX,526+offsetY);
        addObject(new Block(48),1849+offsetX,472+offsetY);
        addObject(new Block(48),1849+offsetX,526+offsetY);
        addObject(new Block(48),1849+offsetX,499+offsetY);
        addObject(new Block(48),1876+offsetX,472+offsetY);
        addObject(new Block(48),1876+offsetX,526+offsetY);
        addObject(new Block(48),1876+offsetX,499+offsetY);
        addObject(new Block(48),1903+offsetX,472+offsetY);
        addObject(new Block(48),1903+offsetX,526+offsetY);
        addObject(new Block(48),1903+offsetX,499+offsetY);
        addObject(new Block(48),1930+offsetX,472+offsetY);
        addObject(new Block(48),1930+offsetX,526+offsetY);
        addObject(new Block(48),1930+offsetX,499+offsetY);
        addObject(new Block(48),1957+offsetX,472+offsetY);
        addObject(new Block(48),1957+offsetX,526+offsetY);
        addObject(new Block(48),1957+offsetX,499+offsetY);
        addObject(new Block(48),1984+offsetX,472+offsetY);
        addObject(new Block(48),1984+offsetX,526+offsetY);
        addObject(new Block(48),1984+offsetX,499+offsetY);
        addObject(new Block(48),2011+offsetX,472+offsetY);
        addObject(new Block(48),2011+offsetX,526+offsetY);
        addObject(new Block(48),2011+offsetX,499+offsetY);
        addObject(new Block(48),2038+offsetX,472+offsetY);
        addObject(new Block(48),2038+offsetX,526+offsetY);
        addObject(new Block(48),2038+offsetX,499+offsetY);
        addObject(new Block(48),2065+offsetX,472+offsetY);
        addObject(new Block(48),2065+offsetX,526+offsetY);
        addObject(new Block(48),2065+offsetX,499+offsetY);
        addObject(new Block(48),2092+offsetX,472+offsetY);
        addObject(new Block(48),2092+offsetX,526+offsetY);
        addObject(new Block(48),2092+offsetX,499+offsetY);
        addObject(new Block(48),2092+offsetX,-14+offsetY);
        addObject(new Block(48),2092+offsetX,40+offsetY);
        addObject(new Block(48),2092+offsetX,13+offsetY);
        addObject(new Block(48),2065+offsetX,-14+offsetY);
        addObject(new Block(48),2065+offsetX,40+offsetY);
        addObject(new Block(48),2065+offsetX,13+offsetY);
        addObject(new Block(48),2038+offsetX,-14+offsetY);
        addObject(new Block(48),2038+offsetX,40+offsetY);
        addObject(new Block(48),2038+offsetX,13+offsetY);
        addObject(new Block(48),2011+offsetX,-14+offsetY);
        addObject(new Block(48),2011+offsetX,40+offsetY);
        addObject(new Block(48),2011+offsetX,13+offsetY);
        addObject(new Block(48),1984+offsetX,-14+offsetY);
        addObject(new Block(48),1984+offsetX,40+offsetY);
        addObject(new Block(48),1984+offsetX,13+offsetY);
        addObject(new Block(48),1957+offsetX,-14+offsetY);
        addObject(new Block(48),1957+offsetX,40+offsetY);
        addObject(new Block(48),1957+offsetX,13+offsetY);
        addObject(new Block(48),1930+offsetX,-14+offsetY);
        addObject(new Block(48),1930+offsetX,40+offsetY);
        addObject(new Block(48),1930+offsetX,13+offsetY);
        addObject(new Block(48),1903+offsetX,-14+offsetY);
        addObject(new Block(48),1903+offsetX,40+offsetY);
        addObject(new Block(48),1903+offsetX,13+offsetY);
        addObject(new Block(48),1876+offsetX,-14+offsetY);
        addObject(new Block(48),1876+offsetX,40+offsetY);
        addObject(new Block(48),1876+offsetX,13+offsetY);
        addObject(new Block(48),1849+offsetX,-14+offsetY);
        addObject(new Block(48),1849+offsetX,40+offsetY);
        addObject(new Block(48),1849+offsetX,13+offsetY);
        addObject(new Block(48),1822+offsetX,-14+offsetY);
        addObject(new Block(48),1822+offsetX,40+offsetY);
        addObject(new Block(48),1822+offsetX,13+offsetY);
        addObject(new Block(48),1795+offsetX,-14+offsetY);
        addObject(new Block(48),1795+offsetX,40+offsetY);
        addObject(new Block(48),1795+offsetX,13+offsetY);
        addObject(new Block(48),1768+offsetX,-14+offsetY);
        addObject(new Block(48),1768+offsetX,40+offsetY);
        addObject(new Block(48),1768+offsetX,13+offsetY);
        addObject(new Block(48),1741+offsetX,-14+offsetY);
        addObject(new Block(48),1741+offsetX,40+offsetY);
        addObject(new Block(48),1741+offsetX,13+offsetY);
        addObject(new Block(48),1714+offsetX,-14+offsetY);
        addObject(new Block(48),1714+offsetX,40+offsetY);
        addObject(new Block(48),1714+offsetX,13+offsetY);
        addObject(new Block(48),1687+offsetX,-14+offsetY);
        addObject(new Block(48),1687+offsetX,40+offsetY);
        addObject(new Block(48),1687+offsetX,13+offsetY);
        addObject(new Block(48),1660+offsetX,-14+offsetY);
        addObject(new Block(48),1660+offsetX,40+offsetY);
        addObject(new Block(48),1660+offsetX,13+offsetY);
        addObject(new Block(48),1633+offsetX,-14+offsetY);
        addObject(new Block(48),1633+offsetX,40+offsetY);
        addObject(new Block(48),1633+offsetX,13+offsetY);
        addObject(new Block(48),1606+offsetX,-14+offsetY);
        addObject(new Block(48),1606+offsetX,40+offsetY);
        addObject(new Block(48),1606+offsetX,13+offsetY);
        addObject(new Block(48),1579+offsetX,-14+offsetY);
        addObject(new Block(48),1579+offsetX,40+offsetY);
        addObject(new Block(48),1579+offsetX,13+offsetY);
        addObject(new Block(48),1552+offsetX,-14+offsetY);
        addObject(new Block(48),1552+offsetX,40+offsetY);
        addObject(new Block(48),1552+offsetX,13+offsetY);
        addObject(new Block(48),1525+offsetX,-14+offsetY);
        addObject(new Block(48),1525+offsetX,40+offsetY);
        addObject(new Block(48),1525+offsetX,13+offsetY);
        addObject(new Block(48),1498+offsetX,-14+offsetY);
        addObject(new Block(48),1498+offsetX,40+offsetY);
        addObject(new Block(48),1498+offsetX,13+offsetY);
        addObject(new Block(48),1471+offsetX,-14+offsetY);
        addObject(new Block(48),1471+offsetX,40+offsetY);
        addObject(new Block(48),1471+offsetX,13+offsetY);
        addObject(new Block(48),1444+offsetX,-14+offsetY);
        addObject(new Block(48),1444+offsetX,40+offsetY);
        addObject(new Block(48),1444+offsetX,13+offsetY);
        addObject(new Block(48),1417+offsetX,-14+offsetY);
        addObject(new Block(48),1417+offsetX,40+offsetY);
        addObject(new Block(48),1417+offsetX,13+offsetY);
        addObject(new Block(48),1390+offsetX,-14+offsetY);
        addObject(new Block(48),1390+offsetX,40+offsetY);
        addObject(new Block(48),1390+offsetX,13+offsetY);
        addObject(new Block(48),1309+offsetX,-14+offsetY);
        addObject(new Block(48),1336+offsetX,-14+offsetY);
        addObject(new Block(48),1363+offsetX,-14+offsetY);
        addObject(new Block(48),1363+offsetX,13+offsetY);
        addObject(new Block(48),1363+offsetX,40+offsetY);
        addObject(new Block(48),1309+offsetX,40+offsetY);
        addObject(new Block(48),1309+offsetX,13+offsetY);
        addObject(new Block(48),1336+offsetX,13+offsetY);
        addObject(new Block(48),1336+offsetX,40+offsetY);
        addObject(new Block(48),1282+offsetX,-14+offsetY);
        addObject(new Block(48),1282+offsetX,40+offsetY);
        addObject(new Block(48),1282+offsetX,13+offsetY);
        addObject(new Block(48),1255+offsetX,-14+offsetY);
        addObject(new Block(48),1255+offsetX,40+offsetY);
        addObject(new Block(48),1255+offsetX,13+offsetY);
        addObject(new Block(48),1228+offsetX,-14+offsetY);
        addObject(new Block(48),1228+offsetX,40+offsetY);
        addObject(new Block(48),1228+offsetX,13+offsetY);
        addObject(new Block(48),1201+offsetX,-14+offsetY);
        addObject(new Block(48),1201+offsetX,40+offsetY);
        addObject(new Block(48),1201+offsetX,13+offsetY);
        addObject(new Block(48),1174+offsetX,-14+offsetY);
        addObject(new Block(48),1174+offsetX,40+offsetY);
        addObject(new Block(48),1174+offsetX,13+offsetY);
        addObject(new Block(48),1147+offsetX,-14+offsetY);
        addObject(new Block(48),1147+offsetX,40+offsetY);
        addObject(new Block(48),1147+offsetX,13+offsetY);
        addObject(new Block(48),1120+offsetX,-14+offsetY);
        addObject(new Block(48),1120+offsetX,40+offsetY);
        addObject(new Block(48),1120+offsetX,13+offsetY);
        addObject(new Block(48),1066+offsetX,13+offsetY);
        addObject(new Block(48),1066+offsetX,-14+offsetY);
        addObject(new Block(48),1093+offsetX,-14+offsetY);
        addObject(new Block(48),1066+offsetX,40+offsetY);
        addObject(new Block(48),1093+offsetX,40+offsetY);
        addObject(new Block(48),1093+offsetX,13+offsetY);
        addObject(new Block(48),1039+offsetX,-14+offsetY);
        addObject(new Block(48),1039+offsetX,40+offsetY);
        addObject(new Block(48),1039+offsetX,13+offsetY);
        addObject(new Block(48),1012+offsetX,-14+offsetY);
        addObject(new Block(48),1012+offsetX,40+offsetY);
        addObject(new Block(48),1012+offsetX,13+offsetY);
        addObject(new Block(48),958+offsetX,13+offsetY);
        addObject(new Block(48),958+offsetX,-14+offsetY);
        addObject(new Block(48),985+offsetX,-14+offsetY);
        addObject(new Block(48),958+offsetX,40+offsetY);
        addObject(new Block(48),985+offsetX,40+offsetY);
        addObject(new Block(48),985+offsetX,13+offsetY);
        addObject(new Block(48),931+offsetX,-14+offsetY);
        addObject(new Block(48),931+offsetX,40+offsetY);
        addObject(new Block(48),931+offsetX,13+offsetY);
        addObject(new Block(48),877+offsetX,13+offsetY);
        addObject(new Block(48),877+offsetX,-14+offsetY);
        addObject(new Block(48),904+offsetX,-14+offsetY);
        addObject(new Block(48),877+offsetX,40+offsetY);
        addObject(new Block(48),904+offsetX,40+offsetY);
        addObject(new Block(48),904+offsetX,13+offsetY);
        addObject(new Block(48),823+offsetX,13+offsetY);
        addObject(new Block(48),823+offsetX,-14+offsetY);
        addObject(new Block(48),850+offsetX,-14+offsetY);
        addObject(new Block(48),823+offsetX,40+offsetY);
        addObject(new Block(48),850+offsetX,40+offsetY);
        addObject(new Block(48),850+offsetX,13+offsetY);
        addObject(new Block(48),769+offsetX,13+offsetY);
        addObject(new Block(48),769+offsetX,-14+offsetY);
        addObject(new Block(48),796+offsetX,-14+offsetY);
        addObject(new Block(48),769+offsetX,40+offsetY);
        addObject(new Block(48),796+offsetX,40+offsetY);
        addObject(new Block(48),796+offsetX,13+offsetY);
        addObject(new Block(48),742+offsetX,-14+offsetY);
        addObject(new Block(48),742+offsetX,40+offsetY);
        addObject(new Block(48),742+offsetX,13+offsetY);
        addObject(new Block(48),688+offsetX,13+offsetY);
        addObject(new Block(48),688+offsetX,-14+offsetY);
        addObject(new Block(48),715+offsetX,-14+offsetY);
        addObject(new Block(48),688+offsetX,40+offsetY);
        addObject(new Block(48),715+offsetX,40+offsetY);
        addObject(new Block(48),715+offsetX,13+offsetY);
        addObject(new Block(48),661+offsetX,-14+offsetY);
        addObject(new Block(48),661+offsetX,40+offsetY);
        addObject(new Block(48),661+offsetX,13+offsetY);
        addObject(new Block(48),634+offsetX,-14+offsetY);
        addObject(new Block(48),634+offsetX,40+offsetY);
        addObject(new Block(48),634+offsetX,13+offsetY);
        addObject(new Block(48),580+offsetX,13+offsetY);
        addObject(new Block(48),580+offsetX,-14+offsetY);
        addObject(new Block(48),607+offsetX,-14+offsetY);
        addObject(new Block(48),580+offsetX,40+offsetY);
        addObject(new Block(48),607+offsetX,40+offsetY);
        addObject(new Block(48),607+offsetX,13+offsetY);
        addObject(new Block(48),553+offsetX,-14+offsetY);
        addObject(new Block(48),553+offsetX,40+offsetY);
        addObject(new Block(48),553+offsetX,13+offsetY);
        addObject(new Block(48),526+offsetX,-14+offsetY);
        addObject(new Block(48),526+offsetX,40+offsetY);
        addObject(new Block(48),526+offsetX,13+offsetY);
        addObject(new Block(48),499+offsetX,-14+offsetY);
        addObject(new Block(48),499+offsetX,40+offsetY);
        addObject(new Block(48),499+offsetX,13+offsetY);
        addObject(new Block(48),445+offsetX,13+offsetY);
        addObject(new Block(48),445+offsetX,-14+offsetY);
        addObject(new Block(48),472+offsetX,-14+offsetY);
        addObject(new Block(48),445+offsetX,40+offsetY);
        addObject(new Block(48),472+offsetX,40+offsetY);
        addObject(new Block(48),472+offsetX,13+offsetY);
        addObject(new Block(48),418+offsetX,-14+offsetY);
        addObject(new Block(48),418+offsetX,40+offsetY);
        addObject(new Block(48),418+offsetX,13+offsetY);
        addObject(new Block(48),364+offsetX,13+offsetY);
        addObject(new Block(48),364+offsetX,-14+offsetY);
        addObject(new Block(48),391+offsetX,-14+offsetY);
        addObject(new Block(48),364+offsetX,40+offsetY);
        addObject(new Block(48),391+offsetX,40+offsetY);
        addObject(new Block(48),391+offsetX,13+offsetY);
        addObject(new Block(48),310+offsetX,13+offsetY);
        addObject(new Block(48),310+offsetX,-14+offsetY);
        addObject(new Block(48),337+offsetX,-14+offsetY);
        addObject(new Block(48),310+offsetX,40+offsetY);
        addObject(new Block(48),337+offsetX,40+offsetY);
        addObject(new Block(48),337+offsetX,13+offsetY);
        addObject(new Block(48),283+offsetX,-14+offsetY);
        addObject(new Block(48),283+offsetX,40+offsetY);
        addObject(new Block(48),283+offsetX,13+offsetY);
        addObject(new Block(48),256+offsetX,-14+offsetY);
        addObject(new Block(48),256+offsetX,40+offsetY);
        addObject(new Block(48),256+offsetX,13+offsetY);
        addObject(new Block(48),229+offsetX,-14+offsetY);
        addObject(new Block(48),229+offsetX,40+offsetY);
        addObject(new Block(48),229+offsetX,13+offsetY);
        addObject(new Block(48),175+offsetX,13+offsetY);
        addObject(new Block(48),175+offsetX,-14+offsetY);
        addObject(new Block(48),202+offsetX,-14+offsetY);
        addObject(new Block(48),175+offsetX,40+offsetY);
        addObject(new Block(48),202+offsetX,40+offsetY);
        addObject(new Block(48),202+offsetX,13+offsetY);
        addObject(new Block(48),121+offsetX,13+offsetY);
        addObject(new Block(48),121+offsetX,-14+offsetY);
        addObject(new Block(48),148+offsetX,-14+offsetY);
        addObject(new Block(48),121+offsetX,40+offsetY);
        addObject(new Block(48),148+offsetX,40+offsetY);
        addObject(new Block(48),148+offsetX,13+offsetY);
        addObject(new Block(48),94+offsetX,-14+offsetY);
        addObject(new Block(48),94+offsetX,40+offsetY);
        addObject(new Block(48),94+offsetX,13+offsetY);
        addObject(new Block(48),67+offsetX,-14+offsetY);
        addObject(new Block(48),67+offsetX,40+offsetY);
        addObject(new Block(48),67+offsetX,13+offsetY);
        addObject(new Block(48),13+offsetX,13+offsetY);
        addObject(new Block(48),-14+offsetX,-14+offsetY);
        addObject(new Block(48),13+offsetX,-14+offsetY);
        addObject(new Block(48),40+offsetX,-14+offsetY);
        addObject(new Block(48),-14+offsetX,40+offsetY);
        addObject(new Block(48),13+offsetX,40+offsetY);
        addObject(new Block(48),40+offsetX,40+offsetY);
        addObject(new Block(48),-14+offsetX,13+offsetY);
        addObject(new Block(48),40+offsetX,13+offsetY);
        addObject(new Block(48),2119+offsetX,472+offsetY);
        addObject(new Block(48),2119+offsetX,526+offsetY);
        addObject(new Block(48),2119+offsetX,499+offsetY);
        addObject(new Block(48),2146+offsetX,472+offsetY);
        addObject(new Block(48),2146+offsetX,526+offsetY);
        addObject(new Block(48),2146+offsetX,499+offsetY);
        addObject(new Block(48),2173+offsetX,472+offsetY);
        addObject(new Block(48),2173+offsetX,526+offsetY);
        addObject(new Block(48),2173+offsetX,499+offsetY);
        addObject(new Block(48),2200+offsetX,472+offsetY);
        addObject(new Block(48),2200+offsetX,526+offsetY);
        addObject(new Block(48),2200+offsetX,499+offsetY);
        addObject(new Block(48),2227+offsetX,472+offsetY);
        addObject(new Block(48),2227+offsetX,526+offsetY);
        addObject(new Block(48),2227+offsetX,499+offsetY);
        addObject(new Block(48),2254+offsetX,472+offsetY);
        addObject(new Block(48),2254+offsetX,526+offsetY);
        addObject(new Block(48),2254+offsetX,499+offsetY);
        addObject(new Block(48),2119+offsetX,-14+offsetY);
        addObject(new Block(48),2119+offsetX,40+offsetY);
        addObject(new Block(48),2119+offsetX,13+offsetY);
        addObject(new Block(48),2146+offsetX,-14+offsetY);
        addObject(new Block(48),2146+offsetX,40+offsetY);
        addObject(new Block(48),2146+offsetX,13+offsetY);
        addObject(new Block(48),2173+offsetX,-14+offsetY);
        addObject(new Block(48),2173+offsetX,40+offsetY);
        addObject(new Block(48),2173+offsetX,13+offsetY);
        addObject(new Block(48),2200+offsetX,-14+offsetY);
        addObject(new Block(48),2200+offsetX,40+offsetY);
        addObject(new Block(48),2200+offsetX,13+offsetY);
        addObject(new Block(48),2227+offsetX,-14+offsetY);
        addObject(new Block(48),2227+offsetX,40+offsetY);
        addObject(new Block(48),2227+offsetX,13+offsetY);
        addObject(new Block(48),2254+offsetX,-14+offsetY);
        addObject(new Block(48),2254+offsetX,40+offsetY);
        addObject(new Block(48),2254+offsetX,13+offsetY);
        addObject(new Block(92),121+offsetX,445+offsetY);
        addObject(new TraceHead(91),121+offsetX,418+offsetY);
        addObject(new SpikeBlock(84),148+offsetX,445+offsetY);
        addObject(new SpikeBlock(84),175+offsetX,418+offsetY);
        addObject(new BulletLauncher(85,0),202+offsetX,445+offsetY);
        addObject(new BulletLauncher(86,180),175+offsetX,445+offsetY);
        addObject(new SpikeBlock(84),202+offsetX,418+offsetY);
        addObject(new SpikeBlock(84),229+offsetX,445+offsetY);
        addObject(new MeltingBlock(89),175+offsetX,283+offsetY);
        addObject(new MeltingBlock(89),202+offsetX,283+offsetY);
        addObject(new Coin(90),175+offsetX,202+offsetY);
        addObject(new Coin(90),202+offsetX,202+offsetY);
        addObject(new Block(92),256+offsetX,445+offsetY);
        addObject(new TraceHead(91),256+offsetX,418+offsetY);
        addObject(new SlimeBlock(88),310+offsetX,445+offsetY);
        addObject(new SlimeBlock(88),337+offsetX,445+offsetY);
        addObject(new SlimeBlock(88),364+offsetX,445+offsetY);
        addObject(new Block(92),283+offsetX,445+offsetY);
        addObject(new TraceHead(91),283+offsetX,418+offsetY);
        addObject(new SlimeBlock(88),391+offsetX,445+offsetY);
        addObject(new LavaBlock(2),418+offsetX,499+offsetY);
        addObject(new LavaBlock(2),445+offsetX,499+offsetY);
        addObject(new LavaBlock(2),472+offsetX,499+offsetY);
        addObject(new LavaBlock(2),499+offsetX,499+offsetY);
        addObject(new LavaBlock(2),526+offsetX,499+offsetY);
        addObject(new LavaBlock(2),553+offsetX,499+offsetY);
        addObject(new LavaBlock(2),580+offsetX,499+offsetY);
        addObject(new LavaBlock(2),607+offsetX,499+offsetY);
        addObject(new LavaBlock(2),634+offsetX,499+offsetY);
        addObject(new LavaBlock(2),661+offsetX,499+offsetY);
        addObject(new LavaBlock(2),688+offsetX,499+offsetY);
        addObject(new LavaBlock(2),715+offsetX,499+offsetY);
        addObject(new LavaBlock(1),418+offsetX,472+offsetY);
        addObject(new LavaBlock(1),445+offsetX,472+offsetY);
        addObject(new LavaBlock(1),472+offsetX,472+offsetY);
        addObject(new LavaBlock(1),499+offsetX,472+offsetY);
        addObject(new LavaBlock(1),526+offsetX,472+offsetY);
        addObject(new LavaBlock(1),553+offsetX,472+offsetY);
        addObject(new LavaBlock(1),580+offsetX,472+offsetY);
        addObject(new LavaBlock(1),607+offsetX,472+offsetY);
        addObject(new LavaBlock(1),634+offsetX,472+offsetY);
        addObject(new LavaBlock(1),661+offsetX,472+offsetY);
        addObject(new LavaBlock(1),688+offsetX,472+offsetY);
        addObject(new LavaBlock(1),715+offsetX,472+offsetY);
        addObject(new Block(21),472+offsetX,256+offsetY);
        addObject(new Block(21),499+offsetX,256+offsetY);
        addObject(new Block(21),526+offsetX,256+offsetY);
        addObject(new Block(21),553+offsetX,256+offsetY);
        addObject(new Block(21),580+offsetX,256+offsetY);
        addObject(new Block(21),634+offsetX,256+offsetY);
        addObject(new Block(21),661+offsetX,256+offsetY);
        addObject(new Block(21),688+offsetX,256+offsetY);
        addObject(new Block(21),607+offsetX,256+offsetY);
        addObject(new Block(21),445+offsetX,256+offsetY);
        addObject(new Block(21),715+offsetX,256+offsetY);
        addObject(new GravityBlock(95),715+offsetX,229+offsetY);
        addObject(new SpikeBlock(84),526+offsetX,229+offsetY);
        addObject(new BulletLauncher(86,180),553+offsetX,229+offsetY);
        addObject(new BulletLauncher(85,0),580+offsetX,229+offsetY);
        addObject(new SpikeBlock(84),607+offsetX,229+offsetY);
        addObject(new LavaBlock(2),742+offsetX,499+offsetY);
        addObject(new LavaBlock(2),769+offsetX,499+offsetY);
        addObject(new LavaBlock(2),796+offsetX,499+offsetY);
        addObject(new LavaBlock(2),823+offsetX,499+offsetY);
        addObject(new LavaBlock(2),850+offsetX,499+offsetY);
        addObject(new LavaBlock(2),877+offsetX,499+offsetY);
        addObject(new LavaBlock(2),904+offsetX,499+offsetY);
        addObject(new LavaBlock(2),931+offsetX,499+offsetY);
        addObject(new LavaBlock(2),958+offsetX,499+offsetY);
        addObject(new LavaBlock(2),985+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1012+offsetX,499+offsetY);
        addObject(new LavaBlock(1),742+offsetX,472+offsetY);
        addObject(new LavaBlock(1),850+offsetX,472+offsetY);
        addObject(new LavaBlock(1),877+offsetX,472+offsetY);
        addObject(new LavaBlock(1),823+offsetX,472+offsetY);
        addObject(new LavaBlock(1),796+offsetX,472+offsetY);
        addObject(new LavaBlock(1),769+offsetX,472+offsetY);
        addObject(new LavaBlock(1),904+offsetX,472+offsetY);
        addObject(new LavaBlock(1),931+offsetX,472+offsetY);
        addObject(new LavaBlock(1),958+offsetX,472+offsetY);
        addObject(new LavaBlock(1),985+offsetX,472+offsetY);
        addObject(new GravityBlock(95),1093+offsetX,67+offsetY);
        addObject(new PlatformPlayer(),40+offsetX,283+offsetY);
        addObject(new SpikeBlock(84),850+offsetX,67+offsetY);
        addObject(new SpikeBlock(84),1012+offsetX,67+offsetY);
        addObject(new Block(48),2227+offsetX,67+offsetY);
        addObject(new Block(48),2227+offsetX,94+offsetY);
        addObject(new Block(48),2227+offsetX,121+offsetY);
        addObject(new Block(48),2227+offsetX,148+offsetY);
        addObject(new Block(48),2227+offsetX,175+offsetY);
        addObject(new Block(48),2227+offsetX,202+offsetY);
        addObject(new Block(48),2227+offsetX,229+offsetY);
        addObject(new Block(48),2227+offsetX,256+offsetY);
        addObject(new Block(48),2227+offsetX,283+offsetY);
        addObject(new Block(48),2227+offsetX,310+offsetY);
        addObject(new Block(48),2227+offsetX,337+offsetY);
        addObject(new Block(48),2227+offsetX,364+offsetY);
        addObject(new Block(48),2227+offsetX,391+offsetY);
        addObject(new Block(48),2227+offsetX,418+offsetY);
        addObject(new Block(48),2227+offsetX,445+offsetY);
        addObject(new Block(48),2254+offsetX,445+offsetY);
        addObject(new Block(48),2254+offsetX,418+offsetY);
        addObject(new Block(48),2254+offsetX,391+offsetY);
        addObject(new Block(48),2254+offsetX,364+offsetY);
        addObject(new Block(48),2254+offsetX,337+offsetY);
        addObject(new Block(48),2254+offsetX,310+offsetY);
        addObject(new Block(48),2254+offsetX,283+offsetY);
        addObject(new Block(48),2254+offsetX,256+offsetY);
        addObject(new Block(48),2254+offsetX,229+offsetY);
        addObject(new Block(48),2254+offsetX,202+offsetY);
        addObject(new Block(48),2254+offsetX,175+offsetY);
        addObject(new Block(48),2254+offsetX,148+offsetY);
        addObject(new Block(48),2254+offsetX,121+offsetY);
        addObject(new Block(48),2254+offsetX,94+offsetY);
        addObject(new Block(48),2254+offsetX,67+offsetY);
        addObject(new LavaBlock(2),1039+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1066+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1093+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1120+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1147+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1174+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1201+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1228+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1255+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1282+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1309+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1336+offsetX,499+offsetY);
        addObject(new LavaBlock(2),1363+offsetX,499+offsetY);
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
        addObject(new LavaBlock(1),1822+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1795+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1768+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1741+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1714+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1687+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1660+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1633+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1606+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1579+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1552+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1525+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1498+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1471+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1444+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1417+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1390+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1363+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1336+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1309+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1282+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1255+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1228+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1201+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1174+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1147+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1120+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1093+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1066+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1012+offsetX,472+offsetY);
        addObject(new LavaBlock(1),1039+offsetX,472+offsetY);
        addObject(new ElevatorBlock(87),1147+offsetX,202+offsetY);
        addObject(new ElevatorBlock(87),1174+offsetX,202+offsetY);
        addObject(new ElevatorBlock(87),1201+offsetX,202+offsetY);
        addObject(new ElevatorBlock(87),1228+offsetX,202+offsetY);
        addObject(new ElevatorBlock(87),1255+offsetX,337+offsetY);
        addObject(new ElevatorBlock(87),1282+offsetX,337+offsetY);
        addObject(new ElevatorBlock(87),1309+offsetX,337+offsetY);
        addObject(new ElevatorBlock(87),1336+offsetX,337+offsetY);
        addObject(new ElevatorBlock(87),1363+offsetX,229+offsetY);
        addObject(new ElevatorBlock(87),1390+offsetX,229+offsetY);
        addObject(new ElevatorBlock(87),1417+offsetX,229+offsetY);
        addObject(new ElevatorBlock(87),1444+offsetX,229+offsetY);
        addObject(new ElevatorBlock(87),1471+offsetX,364+offsetY);
        addObject(new ElevatorBlock(87),1498+offsetX,364+offsetY);
        addObject(new ElevatorBlock(87),1525+offsetX,364+offsetY);
        addObject(new ElevatorBlock(87),1552+offsetX,364+offsetY);
        addObject(new ElevatorBlock(87),1579+offsetX,202+offsetY);
        addObject(new ElevatorBlock(87),1606+offsetX,202+offsetY);
        addObject(new ElevatorBlock(87),1633+offsetX,202+offsetY);
        addObject(new ElevatorBlock(87),1660+offsetX,202+offsetY);
        addObject(new ElevatorBlock(87),1687+offsetX,310+offsetY);
        addObject(new ElevatorBlock(87),1714+offsetX,310+offsetY);
        addObject(new ElevatorBlock(87),1741+offsetX,310+offsetY);
        addObject(new ElevatorBlock(87),1768+offsetX,310+offsetY);
        addObject(new Coin(90),1687+offsetX,229+offsetY);
        addObject(new Coin(90),1741+offsetX,229+offsetY);
        addObject(new Coin(90),1768+offsetX,229+offsetY);
        addObject(new Coin(90),1660+offsetX,121+offsetY);
        addObject(new Coin(90),1633+offsetX,121+offsetY);
        addObject(new Coin(90),1606+offsetX,121+offsetY);
        addObject(new Coin(90),1579+offsetX,121+offsetY);
        addObject(new Coin(90),1336+offsetX,256+offsetY);
        addObject(new Coin(90),1282+offsetX,256+offsetY);
        addObject(new Coin(90),1255+offsetX,256+offsetY);
        addObject(new Coin(90),1147+offsetX,121+offsetY);
        addObject(new Coin(90),1174+offsetX,121+offsetY);
        addObject(new Coin(90),1228+offsetX,121+offsetY);
        addObject(new SpikeBlock(84),1201+offsetX,121+offsetY);
        addObject(new SpikeBlock(84),1309+offsetX,256+offsetY);
        addObject(new SpikeBlock(84),1714+offsetX,229+offsetY);
        addObject(new Coin(90),1444+offsetX,148+offsetY);
        addObject(new Coin(90),1417+offsetX,148+offsetY);
        addObject(new Coin(90),1390+offsetX,148+offsetY);
        addObject(new Coin(90),1363+offsetX,148+offsetY);
        addObject(new Coin(90),1471+offsetX,283+offsetY);
        addObject(new Coin(90),1498+offsetX,283+offsetY);
        addObject(new Coin(90),1525+offsetX,283+offsetY);
        addObject(new Coin(90),1552+offsetX,283+offsetY);
        addObject(new ExitPortal(),2119+offsetX,391+offsetY);
        addObject(new MeltingBlock(89),1849+offsetX,445+offsetY);
        addObject(new MeltingBlock(89),1876+offsetX,418+offsetY);
        addObject(new MeltingBlock(89),1903+offsetX,391+offsetY);
        addObject(new MeltingBlock(89),1903+offsetX,418+offsetY);
        addObject(new MeltingBlock(89),1930+offsetX,391+offsetY);
        addObject(new MeltingBlock(89),1930+offsetX,364+offsetY);
        addObject(new MeltingBlock(89),1957+offsetX,391+offsetY);
        addObject(new MeltingBlock(89),1957+offsetX,418+offsetY);
        addObject(new MeltingBlock(89),1984+offsetX,418+offsetY);
        addObject(new MeltingBlock(89),2011+offsetX,445+offsetY);
        addObject(new MeltingBlock(89),1930+offsetX,337+offsetY);
        addObject(new MeltingBlock(89),1903+offsetX,310+offsetY);
        addObject(new MeltingBlock(89),1957+offsetX,310+offsetY);
        addObject(new MeltingBlock(89),1984+offsetX,283+offsetY);
        addObject(new MeltingBlock(89),1876+offsetX,283+offsetY);
        addObject(new MeltingBlock(89),1849+offsetX,256+offsetY);
        addObject(new MeltingBlock(89),2011+offsetX,256+offsetY);
        addObject(new SpikeBlock(84),1903+offsetX,445+offsetY);
        addObject(new SpikeBlock(84),1930+offsetX,445+offsetY);
        addObject(new SpikeBlock(84),1957+offsetX,445+offsetY);
        addObject(new SpikeBlock(84),1930+offsetX,418+offsetY);
        addObject(new SpikeBlock(84),1876+offsetX,445+offsetY);
        addObject(new SpikeBlock(84),1984+offsetX,445+offsetY);

    }
}
