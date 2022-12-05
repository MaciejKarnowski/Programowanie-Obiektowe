package agh.ics.oop;

import java.util.Objects;
import java.util.Vector;

public class Vector2d {
        final int x;
        final int y;

    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "("
                + x +
                "," + y +
                ')';
    }
    public boolean precedes(Vector2d other){
        return (this.x <= other.x) & (this.y <= other.y);
    }
    public boolean follows(Vector2d other){
        return (this.x >= other.x) & (this.y >= other.y);
    }
    public Vector2d add(Vector2d other){
        int X=this.x+other.x;
        int Y=this.y+other.y;
        return new Vector2d(X,Y);
    }
    public Vector2d substract(Vector2d other){
        int X=this.x-other.x;
        int Y=this.y-other.y;
        return new Vector2d(X,Y);
    }
    public Vector2d upperRight(Vector2d other){
        int newx = this.x;
        int newy = this.y;
        if (this.x < other.x)
            newx=other.x;
        if (this.y < other.y)
            newy=other.y;
        return new Vector2d(newx,newy);
    }
    public Vector2d lowerLeft(Vector2d other){
        int newx = this.x;
        int newy = this.y;
        if (this.x > other.x)
            newx=other.x;
        if (this.y >other.y)
            newy=other.y;
        return new Vector2d(newx,newy);
    }
    public Vector2d opposite(){
        return new Vector2d((-1)*this.x,(-1)*this.y);
 }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || getClass() != other.getClass())
            return false;
        Vector2d vector2d = (Vector2d) other;
        return x == vector2d.x && y == vector2d.y;
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }

}
