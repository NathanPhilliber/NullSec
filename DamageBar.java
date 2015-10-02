import greenfoot.*;

/**
 * Write a description of class DamageBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DamageBar extends Object
{
    
    private Object obj;
    
    private double maxHealth;
    private double health;
    
    private double offset;
    
    private int curImg = 100;
    private int curImgI = 0;
    private String img[] = {"images/DamageBar_100.png","images/DamageBar_95.png","images/DamageBar_90.png",
        "images/DamageBar_85.png","images/DamageBar_80.png","images/DamageBar_75.png","images/DamageBar_70.png",
        "images/DamageBar_65.png","images/DamageBar_60.png","images/DamageBar_55.png","images/DamageBar_50.png",
        "images/DamageBar_45.png","images/DamageBar_40.png","images/DamageBar_35.png","images/DamageBar_30.png",
        "images/DamageBar_25.png","images/DamageBar_20.png","images/DamageBar_15.png","images/DamageBar_10.png",
        "images/DamageBar_5.png","images/DamageBar_0.png"};
    public DamageBar(){
        
    }
    
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
   
    
    public void act() 
    {
        updatePosition();
        
    } 
    
    public void updatePosition(){
        setLocation(obj.getX(), obj.getY()+getOffset());
    }
    
    public void updateDamage(double cur, double max){
        setHealth(cur);
        setMaxHealth(max);
        updateImage();
    }
    
    public void updateImage(){
        
        //System.out.println(getHealth() + "/"+getMaxHealth());
        
        int interval = (int)getMaxHealth()/(img.length-1);
        //System.out.println(interval + " interval");
        //System.out.println(getHealth());
        if((((int)(getMaxHealth()-getHealth()))-(interval*curImgI)) >= interval){
            //System.out.println(((int)(getMaxHealth()-getHealth())-(interval*curImgI))-1);
            curImgI++;
            
            setImage(img[curImgI]);
            //System.out.println(curImgI);
            
            
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
