package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GrassFieldTest {
    @Test
    void canMoveToTest() {
        IWorldMap map = new GrassField(4);
        Assertions.assertTrue(map.canMoveTo(new Vector2d(0,1)));
        Assertions.assertTrue(map.canMoveTo(new Vector2d(-9999, -9999)));
    }
    @Test
    void placeTest() {
        IWorldMap map = new GrassField(10);
        Vector2d position = new Vector2d(4,4);
        Animal a = new Animal(map, position);
        Assertions.assertTrue(map.place(a));
    }

    @Test
    void isOccupiedTestandGrassCount() {
        IWorldMap map = new GrassField(1);
        Vector2d position = new Vector2d(5,3);
        Animal a = new Animal(map, position);
        map.place(a);
        Assertions.assertTrue(map.isOccupied(position));
        assertFalse(map.isOccupied(new Vector2d(-10,1)));
        int touchedGrass = 0;
        Vector2d testVector;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                testVector = new Vector2d(i, j);
                if (map.isOccupied(testVector)) {
                    touchedGrass += 1;
                }
            }
        }
        System.out.print(map.toString());
        assertEquals(1, touchedGrass);
    }
    @Test
    void testMoveAnimalOnOtherAnimalPlace() {
        GrassField map = new GrassField(0);
        Vector2d pos = new Vector2d(1, 1);
        map.place(new Animal(map, pos));
        assertFalse(map.canMoveTo(pos));
    }

    @Test
    void testAnimalObjectAt() {
        GrassField map = new GrassField(0);
        Vector2d pos = new Vector2d(1, 1);
        Animal animal = new Animal(map, pos);

        map.place(animal);

        assertEquals(animal, map.objectAt(pos));
    }


}
