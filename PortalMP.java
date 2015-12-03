import greenfoot.*;

/**
 * Write a description of class PortalMP here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PortalMP extends Minimap
{
    public PortalMP(){
        setImage("images/StarMP.png");
    }
    public void act()
    {
        space.removeObject(this);
    }  
}
