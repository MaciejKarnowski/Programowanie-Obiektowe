package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

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
        try {
            Application.launch(App.class, args);
        } catch (IllegalArgumentException e) {
            System.out.println("incorrect input, " + e.getMessage());
        }
//        try
//        {
//            MoveDirection[] directions = new OptionsParser().parse(args);
//            IWorldMap map = new GrassField(10);
//            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4)};
//            IEngine engine = new SimulationEngine(directions, map, positions);
//            engine.run();
//            System.out.print(map.toString());
//        }
//        catch (Exception ex)
//        {   System.out.println(ex.toString());
//        }

    }


}
