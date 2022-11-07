package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapDirectionTest {
    @Test
    public void testnext(){
        MapDirection mapDirection = MapDirection.SOUTH;
        assertEquals(MapDirection.WEST, mapDirection.next());

        mapDirection=MapDirection.WEST;
        assertEquals(MapDirection.NORTH,mapDirection.next());

        mapDirection=MapDirection.NORTH;
        assertEquals(MapDirection.EAST,mapDirection.next());

        mapDirection=MapDirection.EAST;
        assertEquals(MapDirection.SOUTH,mapDirection.next());

    }

    @Test
    public void testprevious(){
        MapDirection mapDirection = MapDirection.SOUTH;
        assertEquals(MapDirection.EAST, mapDirection.previous());

        mapDirection=MapDirection.WEST;
        assertEquals(MapDirection.SOUTH,mapDirection.previous());

        mapDirection=MapDirection.NORTH;
        assertEquals(MapDirection.WEST,mapDirection.previous());

        mapDirection=MapDirection.EAST;
        assertEquals(MapDirection.NORTH,mapDirection.previous());

    }
    @Test
    public void testtoString(){
        MapDirection mapDirection = MapDirection.SOUTH;
        assertEquals("Południe", mapDirection.toString());

        mapDirection = MapDirection.NORTH;
        assertEquals("Północ", mapDirection.toString());

        mapDirection = MapDirection.EAST;
        assertEquals("Wschód", mapDirection.toString());

        mapDirection = MapDirection.WEST;
        assertEquals("Zachód", mapDirection.toString());
    }
}
