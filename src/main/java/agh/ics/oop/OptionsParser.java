package agh.ics.oop;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    MoveDirection direct = null;
    public MoveDirection parse(String ruchy){

            if ((ruchy.equals("f")) || (ruchy.equals("forward"))){
                direct = MoveDirection.FORWARD;
            }
            if ((ruchy.equals("b")) || (ruchy.equals("backward"))){
                direct = MoveDirection.BACKWARD;
            }
            if ((ruchy.equals("l")) || (ruchy.equals("left"))){
                direct = MoveDirection.LEFT;
            }
            if ((ruchy.equals("r")) || (ruchy.equals("right"))){
                direct = MoveDirection.RIGHT;
            }
     return direct;
    }

}
