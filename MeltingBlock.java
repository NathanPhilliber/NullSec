import greenfoot.*;

//Written by Nathan

public class MeltingBlock extends Block
{

    public boolean deleteMe = false;
    private int delayDelete = 0;
    private int delay = 0;
    private boolean start = false;

    public int meltDelay = 9;

    MeltingBlock left = null;
    MeltingBlock right = null;
    MeltingBlock up = null;
    MeltingBlock down = null;

    public MeltingBlock(){
        this(89);
    }

    public MeltingBlock(int blockType){
        super(blockType);
    }

    public void act() 
    {
        super.act();
        delayDelete();
        delayCommand();
    } 

    public void delayDelete(){
        if(deleteMe == true){
            delayDelete++;
            if(delayDelete > meltDelay){
                w.removeObject(this);
            }
        }
    }

    private void delayCommand(){
        if(start){
            delay++;
            if(delay > meltDelay){
                if(left != null){
                    left.melt(0);
                }
                if(right != null){
                    right.melt(1);
                }
                if(up != null){
                    up.melt(2);
                }
                if(down != null){
                    down.melt(3);
                }
            }
        }
    }

    public void melt(int f){

        

        deleteMe = true;
        start = true;

        left = (MeltingBlock)getOneObjectAtOffset(-27,0, MeltingBlock.class);
        right = (MeltingBlock)getOneObjectAtOffset(27,0, MeltingBlock.class);
        up = (MeltingBlock)getOneObjectAtOffset(0,-27, MeltingBlock.class);
        down = (MeltingBlock)getOneObjectAtOffset(0,27, MeltingBlock.class);

        switch(f){
            case 0:
            right = null;
            break;
            case 1:
            left = null;
            break;
            case 2:
            down = null;
            break;
            case 3: 
            up = null;
            break;
        }

    }
}
