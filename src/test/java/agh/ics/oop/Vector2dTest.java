package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    Vector2d vector2d = new Vector2d(1,2);
    @Test
    public void testtoString(){
        assertEquals("(1,2)", this.vector2d.toString());
    }
    @Test
    public void testprecedes(){
        Vector2d larger = new Vector2d(2,3);
        Vector2d smaller = new Vector2d(0,1);
        assertTrue(this.vector2d.precedes(larger));
        assertFalse(this.vector2d.precedes(smaller));

    }
    @Test
    public void testfollows(){
        Vector2d larger = new Vector2d(2,3);
        Vector2d smaller = new Vector2d(0,1);
        assertFalse(this.vector2d.follows(larger));
        assertTrue(this.vector2d.follows(smaller));
    }
    @Test
    public void testupperRight(){
        Vector2d testvector = new Vector2d(0,3);
        assertEquals(new Vector2d(1,3),this.vector2d.upperRight(testvector));
    }

    @Test
    public void testlowerLeft(){
        Vector2d testvector = new Vector2d(0,3);
        assertEquals(new Vector2d(0,2),this.vector2d.lowerLeft(testvector));
    }
    @Test
    public void testadd(){
        Vector2d testadd = new Vector2d(-1,1);
        assertEquals(new Vector2d(0,3),this.vector2d.add(testadd));
    }
    @Test
    public void testsubstract(){
        Vector2d testadd = new Vector2d(-1,1);
        assertEquals(new Vector2d(2,1),this.vector2d.substract(testadd));
    }
    @Test
    public void testopposite(){
        assertEquals(new Vector2d(-1,-2),this.vector2d.opposite());
    }

}
