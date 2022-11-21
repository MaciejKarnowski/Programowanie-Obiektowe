package agh.ics.oop;

import java.util.Map;

public class Animal {
    private Vector2d position;
    private final IWorldMap map;
    private MapDirection direction;

    public Animal(IWorldMap map, Vector2d InitialPosition) {
        this.map = map;
        this.direction = MapDirection.NORTH;
        this.position = InitialPosition;
    }

    public String toString() {
        return switch (direction) {
            case NORTH -> "^";
            case EAST -> ">";
            case SOUTH -> "v";
            case WEST -> "<";
        };
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }
    public Vector2d getPosition() {
        return position;
    }
    public MapDirection getDirection() {
        return direction;
    }
    private Vector2d correctMove(Vector2d move) {
        var new_pos = this.position.add(move);
        if (this.map.canMoveTo(new_pos) && !this.map.isOccupied(new_pos))
            return new_pos;
        else
            return this.position;
    }

    public void move(MoveDirection direction){
        switch (direction) {
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case FORWARD -> this.position = correctMove(this.direction.toUnitVector());
            case BACKWARD -> this.position = correctMove(this.direction.toUnitVector().opposite());
        }

    }


}
