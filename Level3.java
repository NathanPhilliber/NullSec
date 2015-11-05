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
        addObject(new PlatformPlayer(),54+offsetX,27+offsetY);
        setBackground("PlanetOneBG.png");
        addObject(new Block(77),13+offsetX,445+offsetY);
        addObject(new Block(77),13+offsetX,499+offsetY);
        addObject(new Block(77),13+offsetX,472+offsetY);
        addObject(new Block(77),67+offsetX,472+offsetY);
        addObject(new Block(77),40+offsetX,445+offsetY);
        addObject(new Block(77),67+offsetX,445+offsetY);
        addObject(new Block(77),40+offsetX,499+offsetY);
        addObject(new Block(77),67+offsetX,499+offsetY);
        addObject(new Block(77),40+offsetX,472+offsetY);
        addObject(new Block(77),94+offsetX,445+offsetY);
        addObject(new Block(77),94+offsetX,499+offsetY);
        addObject(new Block(77),94+offsetX,472+offsetY);
        addObject(new Block(77),121+offsetX,445+offsetY);
        addObject(new Block(77),121+offsetX,499+offsetY);
        addObject(new Block(77),121+offsetX,472+offsetY);
        addObject(new Block(77),175+offsetX,472+offsetY);
        addObject(new Block(77),148+offsetX,445+offsetY);
        addObject(new Block(77),175+offsetX,445+offsetY);
        addObject(new Block(77),202+offsetX,445+offsetY);
        addObject(new Block(77),148+offsetX,499+offsetY);
        addObject(new Block(77),175+offsetX,499+offsetY);
        addObject(new Block(77),202+offsetX,499+offsetY);
        addObject(new Block(77),148+offsetX,472+offsetY);
        addObject(new Block(77),202+offsetX,472+offsetY);
        addObject(new Block(77),229+offsetX,445+offsetY);
        addObject(new Block(77),229+offsetX,499+offsetY);
        addObject(new Block(77),229+offsetX,472+offsetY);
        addObject(new Block(77),256+offsetX,445+offsetY);
        addObject(new Block(77),256+offsetX,499+offsetY);
        addObject(new Block(77),256+offsetX,472+offsetY);
        addObject(new Block(77),364+offsetX,445+offsetY);
        addObject(new Block(77),391+offsetX,445+offsetY);
        addObject(new Block(77),418+offsetX,445+offsetY);
        addObject(new Block(77),445+offsetX,445+offsetY);
        addObject(new Block(77),472+offsetX,445+offsetY);
        addObject(new Block(77),499+offsetX,445+offsetY);
        addObject(new Block(77),526+offsetX,445+offsetY);
        addObject(new Block(77),769+offsetX,445+offsetY);
        addObject(new Block(77),769+offsetX,499+offsetY);
        addObject(new Block(77),769+offsetX,472+offsetY);
        addObject(new Block(77),715+offsetX,472+offsetY);
        addObject(new Block(77),715+offsetX,499+offsetY);
        addObject(new Block(77),742+offsetX,499+offsetY);
        addObject(new Block(77),742+offsetX,472+offsetY);
        addObject(new Block(77),661+offsetX,499+offsetY);
        addObject(new Block(77),661+offsetX,472+offsetY);
        addObject(new Block(77),688+offsetX,472+offsetY);
        addObject(new Block(77),661+offsetX,526+offsetY);
        addObject(new Block(77),688+offsetX,526+offsetY);
        addObject(new Block(77),688+offsetX,499+offsetY);
        addObject(new Block(77),607+offsetX,499+offsetY);
        addObject(new Block(77),580+offsetX,472+offsetY);
        addObject(new Block(77),607+offsetX,472+offsetY);
        addObject(new Block(77),634+offsetX,472+offsetY);
        addObject(new Block(77),580+offsetX,526+offsetY);
        addObject(new Block(77),607+offsetX,526+offsetY);
        addObject(new Block(77),634+offsetX,526+offsetY);
        addObject(new Block(77),580+offsetX,499+offsetY);
        addObject(new Block(77),634+offsetX,499+offsetY);
        addObject(new Block(77),526+offsetX,499+offsetY);
        addObject(new Block(77),526+offsetX,472+offsetY);
        addObject(new Block(77),553+offsetX,472+offsetY);
        addObject(new Block(77),526+offsetX,526+offsetY);
        addObject(new Block(77),553+offsetX,526+offsetY);
        addObject(new Block(77),553+offsetX,499+offsetY);
        addObject(new Block(77),472+offsetX,499+offsetY);
        addObject(new Block(77),472+offsetX,472+offsetY);
        addObject(new Block(77),499+offsetX,472+offsetY);
        addObject(new Block(77),472+offsetX,526+offsetY);
        addObject(new Block(77),499+offsetX,526+offsetY);
        addObject(new Block(77),499+offsetX,499+offsetY);
        addObject(new Block(77),418+offsetX,499+offsetY);
        addObject(new Block(77),391+offsetX,472+offsetY);
        addObject(new Block(77),418+offsetX,472+offsetY);
        addObject(new Block(77),445+offsetX,472+offsetY);
        addObject(new Block(77),391+offsetX,526+offsetY);
        addObject(new Block(77),418+offsetX,526+offsetY);
        addObject(new Block(77),445+offsetX,526+offsetY);
        addObject(new Block(77),391+offsetX,499+offsetY);
        addObject(new Block(77),445+offsetX,499+offsetY);
        addObject(new Block(77),364+offsetX,472+offsetY);
        addObject(new Block(77),310+offsetX,526+offsetY);
        addObject(new Block(77),337+offsetX,526+offsetY);
        addObject(new Block(77),364+offsetX,526+offsetY);
        addObject(new Block(77),364+offsetX,499+offsetY);
        addObject(new Block(77),310+offsetX,472+offsetY);
        addObject(new Block(77),283+offsetX,445+offsetY);
        addObject(new Block(77),310+offsetX,445+offsetY);
        addObject(new Block(77),337+offsetX,445+offsetY);
        addObject(new Block(77),283+offsetX,499+offsetY);
        addObject(new Block(77),310+offsetX,499+offsetY);
        addObject(new Block(77),337+offsetX,499+offsetY);
        addObject(new Block(77),283+offsetX,472+offsetY);
        addObject(new Block(77),337+offsetX,472+offsetY);
        addObject(new SpikeBlock(84),742+offsetX,445+offsetY);
        addObject(new SpikeBlock(84),715+offsetX,445+offsetY);
        addObject(new SpikeBlock(84),688+offsetX,445+offsetY);
        addObject(new SpikeBlock(84),661+offsetX,445+offsetY);
        addObject(new SpikeBlock(84),634+offsetX,445+offsetY);
        addObject(new SpikeBlock(84),607+offsetX,445+offsetY);
        addObject(new SpikeBlock(84),580+offsetX,445+offsetY);
        addObject(new SpikeBlock(84),553+offsetX,445+offsetY);
        addObject(new SpikeBlock(84),445+offsetX,418+offsetY);
        addObject(new SpikeBlock(84),418+offsetX,418+offsetY);
        addObject(new SpikeBlock(84),391+offsetX,418+offsetY);
        addObject(new SpikeBlock(84),364+offsetX,418+offsetY);

    }
}
