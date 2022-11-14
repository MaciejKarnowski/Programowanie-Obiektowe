package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTests {
    @Test
    void testFinalPosition() {
        String[] args = {"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f" ,"f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        assertEquals(new Vector2d(2,0),map.objectAt(new Vector2d(2, 0)));
        assertEquals(new Vector2d(3,5),map.objectAt(new Vector2d(3, 5)));
        assertNull(map.objectAt(new Vector2d(1, 5)));
        assertTrue(map.isOccupied(new Vector2d(3, 5)));
        assertTrue(map.isOccupied(new Vector2d(2, 0)));
    }
    @Test
    void testNoMoves() {
        String[] args = {};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        assertTrue(map.isOccupied(new Vector2d(2, 2)));
        assertTrue(map.isOccupied(new Vector2d(3, 4)));
    }
    @Test
    void TestEdge() {
        String[] args = {"f", "f", "f", "f", "f" ,"f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = {new Vector2d(2,2)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        assertTrue(map.isOccupied(new Vector2d(2, 5)));

    }
    @Test
    void testAnimalsCollisions() {
        String[] args = {"f", "r", "f", "r", "f", "f", "f", "f", "f", "f", "f", "f", "f" ,"f", "f", "f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = {new Vector2d(2,2),new Vector2d(2,3)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        assertTrue(map.isOccupied(new Vector2d(2, 2)));
        assertTrue(map.isOccupied(new Vector2d(2, 3)));
    }

}
