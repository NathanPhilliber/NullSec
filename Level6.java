import greenfoot.*;

/**
 * Write a description of class Level6 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level6 extends Platformer
{

    /**
     * Constructor for objects of class Level6.
     * 
     */
    public Level6(double x, double y)
    {
        super (x,y);
        int offsetX = 0;
        int offsetY = 0;

        setBackground("BackgroundLevel4.png");
        addObject(new Block(0),27+offsetX,486+offsetY);
        addObject(new Block(0),54+offsetX,486+offsetY);
        addObject(new Block(0),81+offsetX,486+offsetY);
        addObject(new Block(0),108+offsetX,486+offsetY);
        addObject(new Block(0),135+offsetX,486+offsetY);
        addObject(new Block(0),162+offsetX,486+offsetY);
        addObject(new BackgroundBlock(10),270+offsetX,351+offsetY);
        addObject(new BackgroundBlock(0),189+offsetX,486+offsetY);
        addObject(new Block(1),216+offsetX,459+offsetY);
        addObject(new Block(0),216+offsetX,486+offsetY);
        addObject(new Block(0),243+offsetX,459+offsetY);
        addObject(new Block(0),270+offsetX,486+offsetY);
        addObject(new Block(0),297+offsetX,486+offsetY);
        addObject(new Block(0),324+offsetX,486+offsetY);
        addObject(new Block(0),351+offsetX,459+offsetY);
        addObject(new Block(0),432+offsetX,459+offsetY);
        addObject(new Block(0),540+offsetX,459+offsetY);
        addObject(new Block(0),594+offsetX,459+offsetY);
        addObject(new Block(0),621+offsetX,459+offsetY);
        addObject(new Block(0),486+offsetX,459+offsetY);
        addObject(new Block(0),378+offsetX,459+offsetY);
        addObject(new Block(0),324+offsetX,459+offsetY);
        addObject(new Block(0),297+offsetX,459+offsetY);
        addObject(new Block(0),405+offsetX,459+offsetY);
        addObject(new Block(0),459+offsetX,459+offsetY);
        addObject(new Block(0),567+offsetX,459+offsetY);
        addObject(new Block(0),513+offsetX,459+offsetY);
        addObject(new BackgroundBlock(0),405+offsetX,405+offsetY);
        addObject(new BackgroundBlock(0),405+offsetX,324+offsetY);
        addObject(new BackgroundBlock(0),405+offsetX,351+offsetY);
        addObject(new BackgroundBlock(0),405+offsetX,378+offsetY);
        addObject(new BackgroundBlock(0),405+offsetX,432+offsetY);
        addObject(new Block(0),351+offsetX,297+offsetY);
        addObject(new Block(0),378+offsetX,297+offsetY);
        addObject(new Block(0),405+offsetX,297+offsetY);
        addObject(new Block(0),513+offsetX,297+offsetY);
        addObject(new Block(0),540+offsetX,297+offsetY);
        addObject(new Block(0),567+offsetX,297+offsetY);
        addObject(new Block(0),459+offsetX,297+offsetY);
        addObject(new Block(0),432+offsetX,297+offsetY);
        addObject(new Block(0),486+offsetX,297+offsetY);
        addObject(new PlatformPlayer(),135+offsetX,432+offsetY);
        addObject(new ExitPortal(),594+offsetX,378+offsetY);

    }
}
