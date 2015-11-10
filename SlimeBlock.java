import greenfoot.*;

//Written by Trace
public class SlimeBlock extends NoCollisionBlock
{
    private boolean playGif;
    GifImage gifImage = new GifImage("BouncyGif.gif");
    private final int gifLength = 9;
    private int delay = gifLength;
    
    public SlimeBlock(){
        this(88);
    }
    public SlimeBlock(int blockType){
        setImage("BounceBlock.png");
    }
    public void act() 
    {
        super.act();
        Actor s = getOneIntersectingObject(PlatformPlayer.class);
        playBounceGif();
        if(s != null)
        {
            delay = gifLength;
            playGif = true;
        }
    }
    
    public void playBounceGif()
    {
        if(delay <= gifLength && playGif)
        {
            setImage(gifImage.getCurrentImage());
            delay--;
        }
        if(delay <= 0)
        {
            playGif = false;
            setImage("BounceBlock.png");
        }
    }
}
