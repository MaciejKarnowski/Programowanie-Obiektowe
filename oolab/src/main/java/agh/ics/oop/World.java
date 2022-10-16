package agh.ics.oop;

import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        out.print("System wystartował \n");

        for (String argument : args) {
            Direction direction = null;
            switch (argument) {
                case "f" -> direction = Direction.FORWARD;
                case "b" -> direction = Direction.BACKWARD;
                case "l" -> direction = Direction.LEFT;
                case "r" -> direction = Direction.RIGHT;
                default -> direction = null;

            }
            if (direction!=null){
                run(direction);
            }

        }
        ;
        out.print("System zakończył działanie");
    }

    public static void run(Direction args) {

        String direction = switch (args) {
            case FORWARD -> "zwierzak idzie do przodu";
            case BACKWARD -> "zwierzak idzie do tyłu";
            case LEFT -> "zwierzak idzie w lewo";
            case RIGHT -> "zwierzak idzie w prawo";
            default -> null;
        };
        out.println(direction);
    }
}
