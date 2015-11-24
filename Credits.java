import greenfoot.*;
import java.awt.Color;

public class Credits extends Cutscene
{

    private int time = 0;
    private int stage = 0;
    private int fade = 0;
    private int fade2 = 255;

    CutsceneObject enterText = new CutsceneObject("images/NullsecTitle.png");
    CutsceneObject manny = new CutsceneObject("images/Manny.png");
    CutsceneObject nathan = new CutsceneObject("images/Nathan.png");
    CutsceneObject amanda = new CutsceneObject("images/Amanda.png");
    CutsceneObject trace = new CutsceneObject("images/Trace.png");
    CutsceneObject john = new CutsceneObject("images/John.png");
        CutsceneObject traceQuote = new CutsceneObject("images/TraceQuote.png");
    
    GreenfootSound music = new GreenfootSound("sounds/AmbientSpace.wav");

    public Credits(){
        this(null);
    }

    public Credits(World world)
    {
        super(world);

    }

    public void act(){
        super.act();
        time++;
        
        if(time == 1){
            music.play();
        }

        if(time == 20){
            addObject(enterText, getWidth()/2, getHeight()+200);

        }
        if(time > 20){
            enterText.setLocation(enterText.getX(), enterText.getY()-1);
        }

        if(time == 350){
            addObject(manny, getWidth()/2, getHeight()+200);

        }
        if(time > 350){
            manny.setLocation(manny.getX(), manny.getY()-1);
        }
        
        if(time == 500){
            addObject(amanda, getWidth()/2, getHeight()+200);

        }
        if(time > 500){
            amanda.setLocation(amanda.getX(), amanda.getY()-1);
        }
        
        if(time == 650){
            addObject(nathan, getWidth()/2, getHeight()+200);

        }
        if(time > 650){
            nathan.setLocation(nathan.getX(), nathan.getY()-1);
        }
        
        if(time == 800){
            addObject(trace, getWidth()/2, getHeight()+200);

        }
        if(time > 800){
            trace.setLocation(trace.getX(), trace.getY()-1);
        }
        
        if(time == 950){
            addObject(john, getWidth()/2, getHeight()+200);

        }
        if(time > 950){
            john.setLocation(john.getX(), john.getY()-1);
        }
        
        if(time == 1400){
            addObject(traceQuote, getWidth()/2, getHeight()/2+140);
            traceQuote.getImage().setTransparency(0);

        }
        if(time > 1400 && fade < 255){
            fade++;
            traceQuote.getImage().setTransparency(fade);
        }
        
        
        if(time > 1656+150 && fade2 > 0){
            fade2--;
            traceQuote.getImage().setTransparency(fade2);
        }
        
        if(time > 1656+255+150 || Greenfoot.isKeyDown("escape")){
            music.stop();
            end();
        }
        
        
        

    }
}
