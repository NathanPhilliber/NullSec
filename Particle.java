import greenfoot.*;

//Written by Manny

public class Particle extends SpaceObject
{

    private int straightness;
    private double radius;
    private int lifetime;
    private double speed;
    private int turnTimer = 0;
    private int chance;

    public Particle(double startX, double startY, int straightness, double radius, int lifetime, double particleSpeed, int lifetimeRandom, String image)
    {
        
        this(startX, startY, straightness, radius, lifetime, particleSpeed, lifetimeRandom,0, image);
        
        
    }
    
    public Particle(double startX, double startY, int straightness, double radius, int lifetime, double particleSpeed, int lifetimeRandom,int chance, String image)
    {
        super(startX, startY);
        this.straightness = straightness;
        this.radius = radius;
        this.lifetime = lifetime + Greenfoot.getRandomNumber(lifetimeRandom+1);
        speed = particleSpeed;
        turn(Greenfoot.getRandomNumber(360));
        setImage(image);
        this.chance = chance;
        if(Greenfoot.getRandomNumber(100) + chance > 100){
            this.lifetime = 0;
        }
    }
    // Counts down the particles life and removes them after a certain amount of time.
    public void particleLife()
    {
        if (lifetime <= 0)
        {   
            getWorld().removeObject(this);

        }
        lifetime--;
    }
    // Dictates how the particles move
    public void particleMovement()
    {
        spaceMove(speed);
        if (turnTimer%straightness == 0)
        {   
            turn(Greenfoot.getRandomNumber(360));
        }
        turnTimer++;
    }
   
    public void act() 
    {
        // Add your action code here.
        super.act();
        particleLife();
        particleMovement();
    }    
}
