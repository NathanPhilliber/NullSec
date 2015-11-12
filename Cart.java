import greenfoot.*;

public class Cart extends Block
{
    public int speed = 1;

    public Track left;
    public Track right;
    public Track up;
    public Track down;

    public int lastDirection = -1;
    public int currentDirection = -1;

    private int moves = 0;

    public Cart(){
        this(94);
    }

    public Cart(int blockType){
        super(blockType);
    }

    public void act(){
        super.act();

        if(moves > 0){
            moves--;

            //make appropriate moves
            switch(currentDirection){
                case 0:
                addRealX(speed);
                break;
                case 1:
                addRealY(-speed);
                break;
                case 2:
                addRealX(-speed);
                break;
                case 3:
                addRealY(speed);
                break;
            }

        }
        else{
            checkTracks();
        }

        
    }

    public void checkTracks(){
        left = (Track)getOneObjectAtOffset(-27,0, Track.class);
        right = (Track)getOneObjectAtOffset(27,0, Track.class);
        up = (Track)getOneObjectAtOffset(0,-27, Track.class);
        down = (Track)getOneObjectAtOffset(0,27, Track.class);

        lastDirection = currentDirection;

        boolean notNothing = true;

        if(left != null && currentDirection != 0){
            currentDirection = 2;
            notNothing = false;
        }
        else if(down != null && currentDirection != 1){
            currentDirection = 3;
            notNothing = false;
        }
        else if(right != null && currentDirection != 2){
            currentDirection = 0;
            notNothing = false;
        }
        else if(up != null && currentDirection != 3){
            currentDirection = 1;
            notNothing = false;
        }
        
        

        if(notNothing == false){
            moves = 27;
        }
        else{
            switch(currentDirection){
                case 0:
                currentDirection = 2;
                break;
                case 1:
                currentDirection = 3;
                break;
                case 2:
                currentDirection = 0;
                break;
                case 3:
                currentDirection = 1;
                break;
            }
        }

    }
}
