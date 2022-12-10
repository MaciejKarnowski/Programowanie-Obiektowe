package agh.ics.oop;

import java.util.ArrayList;


public class OptionsParser {
    public MoveDirection[] parse(String[] input) throws IllegalArgumentException {
        int n = input.length;
        MoveDirection[] directions = new MoveDirection[n];
        int j =0;
        for (String s : input) {
            switch (s) {
                case "f", "forward" -> directions[j] = MoveDirection.FORWARD;
                case "b", "backward" -> directions[j] = MoveDirection.BACKWARD;
                case "r", "right" -> directions[j] = MoveDirection.RIGHT;
                case "l", "left" -> directions[j] = MoveDirection.LEFT;
                default ->  throw new IllegalArgumentException(s + " is not legal move specification");
            }
            j += 1;
        }
        return directions;
    }


}
