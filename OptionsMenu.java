import greenfoot.*;

//Written by John

public class OptionsMenu extends World
{
    private Actor back=new Back();
    private Actor soundToggle=new SoundToggle();
    private boolean playing=false;
    private GreenfootSound music=new GreenfootSound("AmbientSpace.wav");
    
<<<<<<< HEAD
    private static int worldWidth = (int)(920);
    private static int worldHeight = (int)(540);
=======



    private static int worldWidth = (int)(1280/1.5);
    private static int worldHeight = (int)(720/1.5);
>>>>>>> 30b3c7081b8ac4994947e319dbb78d1c881c76e8

    
    public OptionsMenu(GreenfootSound m)
    {    
        super(worldWidth, worldHeight, 1, false); 
        music=m;
        prepare();
    }
    
    public static int getWorldWidth()
    {
        return worldWidth;
    }
    
    public static int getWorldHeight()
    {
        return worldHeight;
    }
    
    public OptionsMenu()
    {    
        super(920,540,1); 
        prepare();
    }   
    

    private void prepare()
    {    

        Resolution resolution2 = new Resolution(1);
        addObject(resolution2, getWidth()/2, getHeight()/2-50);

        Resolution resolution3 = new Resolution(2);
        addObject(resolution3, getWidth()/2, getHeight()/2);

        Resolution resolution4 = new Resolution(3);
        addObject(resolution4, getWidth()/2, getHeight()/2 + 50);
    }
}
