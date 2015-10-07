import greenfoot.*;

/**
 * DamageBar is a visual representation of player/entity health. Follows player/entity 
 * above or below
 * 
 * Written by Nathan Philliber
 */
public class DamageBar extends Object
{
    
    //Object to follow
    private Object obj;
    
    //Health values
    private double maxHealth;
    private double health;
    
    //Follow above or below object, negative for above, postitive for below
    private double offset;
    
    
    //Current image being displayed (array iterator)
    private int curImgI = 0;
    
    //Array of all image names. All images must be equally divided. These are divided by 5. Could be smaller or larger.
    private String img[] = {"images/DamageBar_100.png","images/DamageBar_95.png","images/DamageBar_90.png",
        "images/DamageBar_85.png","images/DamageBar_80.png","images/DamageBar_75.png","images/DamageBar_70.png",
        "images/DamageBar_65.png","images/DamageBar_60.png","images/DamageBar_55.png","images/DamageBar_50.png",
        "images/DamageBar_45.png","images/DamageBar_40.png","images/DamageBar_35.png","images/DamageBar_30.png",
        "images/DamageBar_25.png","images/DamageBar_20.png","images/DamageBar_15.png","images/DamageBar_10.png",
        "images/DamageBar_5.png","images/DamageBar_0.png"};
        
    
    //Constructors
    public DamageBar(Player player, double off, double health, double maxHealth){
        obj = player;
        setOffset(off);
        setHealth(health);
        setMaxHealth(maxHealth);
    }
    
    public DamageBar(Entity entity, double off, double health, double maxHealth){
        obj = entity;
        setOffset(off);
        setHealth(health);
        setMaxHealth(maxHealth);
        
    }
    
    public DamageBar(Entity entity, double health, double maxHealth){
        this(entity, -40, health, maxHealth);
    }
    
    public DamageBar(Player player, double health, double maxHealth){
        this(player, -40, health, maxHealth);
    }
   
    //Only updates position, updating the visual is the responsibility of the class damagebar belongs to.
    public void act() 
    {
        if(isScheduledForDeletion() == false){
            updatePosition();
        }
        
        tryToDelete();
        
    } 
    
    //Change location as object moves.
    public void updatePosition(){
        setLocation(obj.getX(), obj.getY()+getOffset());
    }
    
    //Updates damage values / displayed image.
    public void updateDamage(double cur, double max){
        setHealth(cur);
        setMaxHealth(max);
        updateImage();
    }
    
    //In class method used to change image based on ratio of health
    private void updateImage(){
        
        
        //How much damage is between each image state
        int interval = (int)getMaxHealth()/(img.length-1);
        /*
        //Decide when it is time to switch to the next down state
        if((((int)(getMaxHealth()-getHealth()))-(interval*curImgI)) >= interval){
            System.out.println("DOWN");
            curImgI++; //Iterate to next image in array
            
            setImage(img[curImgI]); //Switch image
            
        }
        
        if((((int)(getMaxHealth()-getHealth()))-(interval*curImgI)) <= interval){
            //System.out.println((((int)(getMaxHealth()-getHealth()))-(interval*curImgI)));
            System.out.println("UP");
            curImgI--; //Iterate to next image in array
            if(curImgI < 0){
                curImgI = 0;
            }
            setImage(img[curImgI]); //Switch image
            
        }
        */
       //System.out.println(((int)(getMaxHealth()-getHealth()))%interval);
       if(((int)(getMaxHealth()-getHealth()))/interval>curImgI){
           
           curImgI++;
           setImage(img[curImgI]);
        }
        
        if(((int)(getMaxHealth()-getHealth()))/interval<curImgI){
           
           curImgI--;
           setImage(img[curImgI]);
        }
       
    }
    
    public double getOffset(){
        return offset;
    }
    
    public void setOffset(double off){
        offset = off;
    }
    
    public double getHealth(){
        return health;
    }
    
    public double getMaxHealth(){
        return maxHealth;
    }
    
    public void setHealth(double health){
        if(health > getMaxHealth()){
            this.health = getMaxHealth();
        }
        else if(health < 0.0){
            this.health = 0.0;
        }
        else{
            this.health = health;
        }
        
    }
    
    public void setMaxHealth(double health){
        if(getHealth() > health){
            setHealth(health);
        }
        else{
            maxHealth = health;
        }
        
    }
    
    public void addHealth(double add){
        setHealth(getHealth()+add);
    }
    

}
