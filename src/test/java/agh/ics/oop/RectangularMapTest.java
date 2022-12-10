package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RectangularMapTest {
    @Test
    void testCantMoveOutsideTheMap() {
        RectangularMap map = new RectangularMap(10, 10);
        assertFalse(map.canMoveTo(new Vector2d(-10, 0)));
        assertFalse(map.canMoveTo(new Vector2d(0, -10)));
        assertFalse(map.canMoveTo(new Vector2d(0, 20)));
        assertFalse(map.canMoveTo(new Vector2d(20, 0)));
    }

    @Test
    void testPLaceAnimal() {
        RectangularMap map = new RectangularMap(10, 10);
        assertTrue(map.place(new Animal(map, new Vector2d(1, 1))));
        assertFalse(map.place(new Animal(map, new Vector2d(1, 1))));
        assertFalse(map.place(new Animal(map, new Vector2d(-1, -1))));
    }
    @Test
    void testIsOccupied() {
        RectangularMap map = new RectangularMap(10, 10);
        Vector2d pos = new Vector2d(1, 1);

        map.place(new Animal(map, pos));

        assertTrue(map.isOccupied(pos));
    }
    @Test
    void testObjectAt() {
        RectangularMap map = new RectangularMap(10, 10);
        Vector2d pos = new Vector2d(1, 1);
        Animal animal = new Animal(map, pos);

        map.place(animal);

        assertEquals(animal, map.objectAt(pos));
    }
}
