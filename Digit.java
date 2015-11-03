import greenfoot.*;

/**
 * Write a description of class Digit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Digit extends Menu
{
    public Digit(int i){
        this(i,0);
    }

    public Digit(int d, int size){
        switch(d){
            case 0:
            setImage("Number0.png");
            break;
            case 1:
            setImage("Number1.png");
            break;
            case 2:
            setImage("Number2.png");
            break;
            case 3:
            setImage("Number3.png");
            break;
            case 4:
            setImage("Number4.png");
            break;
            case 5:
            setImage("Number5.png");
            break;
            case 6:
            setImage("Number6.png");
            break;
            case 7:
            setImage("Number7.png");
            break;
            case 8:
            setImage("Number8.png");
            break;
            case 9:
            setImage("Number9.png");
            break;

        }
        if(size == 1){
            GreenfootImage image = getImage();
            image.scale(image.getWidth() - 35, image.getHeight() - 35);
            setImage(image);
        }
    }

    public void act() 
    {
        // Add your action code here.
    }    
}
