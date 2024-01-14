package world;

import humans.enums.Direction;

import java.util.ArrayList;
import java.util.Arrays;

public class Way {
    public Way(){}
     public final ArrayList<Direction> wayFromCentreToTop;
     public final ArrayList<Direction> wayFromTopToPlain;
    {
        wayFromCentreToTop =new ArrayList<>(Arrays.asList(Direction.LEFT,Direction.UP,Direction.RIGHT,Direction.UP));
        wayFromTopToPlain = new ArrayList<>(Arrays.asList(Direction.DOWN,Direction.RIGHT,Direction.DOWN));
    }


}









