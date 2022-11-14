package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
//        out.print("System wystartował \n");
//
//        for (String argument : args) {
//            Direction direction = null;
//            switch (argument) {
//                case "f" -> direction = Direction.FORWARD;
//                case "b" -> direction = Direction.BACKWARD;
//                case "l" -> direction = Direction.LEFT;
//                case "r" -> direction = Direction.RIGHT;
//                default -> {
//                }
//
//            }
//            if (direction!=null){
//                run(direction);
//            }
//
//        }
//        out.print("System zakończył działanie\n");

//        Vector2d position1 = new Vector2d(1,2);
//        System.out.println(position1);
//        Vector2d position2 = new Vector2d(-2,1);
//        System.out.println(position2);

//        Animal malpa = new Animal();
//        System.out.println(malpa.toString());
//        malpa.move(MoveDirection.RIGHT);
//        System.out.println(malpa.toString());
//        malpa.move(MoveDirection.FORWARD);
//        System.out.println(malpa.toString());
//        malpa.move(MoveDirection.FORWARD);
//        System.out.println(malpa.toString());
//        malpa.move(MoveDirection.FORWARD);
//        System.out.println(malpa.toString());

//        Animal koza = new Animal();
//        for (String element : args) {
//            OptionsParser duchy = new OptionsParser();
//            koza.move(duchy.parse(element));
//        }
//        System.out.println(koza.toString());
    //Sprawdzanie dwóch zwierzaków na tych samych miejscach: Stworzyć tablice, która przechowuje aktualne miejsca zwierzaków,
        // a następnie sprawdza, czy zwierzak moze ruszyc sie na dane miejsce.

        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
    }



    public static void run(Direction args) {

        String direction = switch (args) {
            case FORWARD -> "zwierzak idzie do przodu";
            case BACKWARD -> "zwierzak idzie do tyłu";
            case LEFT -> "zwierzak idzie w lewo";
            case RIGHT -> "zwierzak idzie w prawo";
        };
        out.println(direction);
    }

}
