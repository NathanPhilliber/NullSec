import greenfoot.*;

/**
 * Write a description of class Level7 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level7 extends Platformer
{

    /**
     * Constructor for objects of class Level7.
     * 
     */
    public Level7(){
        
    }
    public Level7(double x, double y)
    {
        super(x,y);
        //Level Generated

        int offsetX = 0;
        int offsetY = 0;

        setBackground("BackgroundLevel4.png");
        addObject(new Block(0),270+offsetX,459+offsetY);
        addObject(new Block(0),297+offsetX,459+offsetY);
        addObject(new Block(1),324+offsetX,432+offsetY);
        addObject(new Block(6),324+offsetX,459+offsetY);
        addObject(new Block(6),351+offsetX,459+offsetY);
        addObject(new Block(6),378+offsetX,459+offsetY);
        addObject(new Block(6),351+offsetX,432+offsetY);
        addObject(new Block(8),378+offsetX,432+offsetY);
        addObject(new Block(8),378+offsetX,405+offsetY);
        addObject(new Block(8),405+offsetX,405+offsetY);
        addObject(new Block(8),405+offsetX,432+offsetY);
        addObject(new Block(8),405+offsetX,459+offsetY);
        addObject(new Block(8),432+offsetX,459+offsetY);
        addObject(new Block(8),459+offsetX,459+offsetY);
        addObject(new Block(8),486+offsetX,459+offsetY);
        addObject(new Block(8),513+offsetX,459+offsetY);
        addObject(new Block(8),486+offsetX,432+offsetY);
        addObject(new Block(8),486+offsetX,405+offsetY);
        addObject(new Block(8),513+offsetX,405+offsetY);
        addObject(new BackgroundBlock(8),513+offsetX,432+offsetY);
        addObject(new BackgroundBlock(8),540+offsetX,459+offsetY);
        addObject(new BackgroundBlock(9),540+offsetX,378+offsetY);
        addObject(new BackgroundBlock(9),540+offsetX,405+offsetY);
        addObject(new BackgroundBlock(9),540+offsetX,351+offsetY);
        addObject(new BackgroundBlock(9),540+offsetX,297+offsetY);
        addObject(new BackgroundBlock(9),540+offsetX,324+offsetY);
        addObject(new Block(9),540+offsetX,432+offsetY);
        addObject(new Block(9),567+offsetX,459+offsetY);
        addObject(new Block(9),594+offsetX,459+offsetY);
        addObject(new Block(9),594+offsetX,432+offsetY);
        addObject(new Block(9),621+offsetX,459+offsetY);
        addObject(new Block(9),675+offsetX,459+offsetY);
        addObject(new Block(16),648+offsetX,459+offsetY);
        addObject(new Block(16),702+offsetX,459+offsetY);
        addObject(new PlatformPlayer(),324+offsetX,216+offsetY);
        addObject(new ExitPortal(),702+offsetX,378+offsetY);

    }
}
