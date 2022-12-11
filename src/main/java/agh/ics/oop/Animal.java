package agh.ics.oop;

import java.util.ArrayList;
import java.util.Map;

public class Animal implements IElementMap{
    private final IWorldMap map;
    private Vector2d position;
    private MapDirection direction = MapDirection.NORTH;
    private ArrayList<IPositionChangeObserver> observerList = new ArrayList<>();
    public Animal(IWorldMap map) {
        this(map, new Vector2d(2, 2));
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
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
    @Override
    public Vector2d getPosition() {
        return position;
    }
    @Override
    public String getFileName() {
        switch (this.direction) {
            case NORTH -> {return "up.png";}
            case WEST -> {return "left.png";}
            case SOUTH -> {return "down.png";}
            case EAST -> {return "right.png";}
            default -> {return "grass.png";}
        }
    }
    public MapDirection getDirection() {
        return direction;
    }
    private void correctMove(Vector2d move) {
        if(map.canMoveTo(move)) {
            positionChanged(move);
            position = move;
        }
    }

    public void move(MoveDirection orientation) {
        switch(orientation) {
            case FORWARD -> correctMove(position.add(direction.toUnitVector()));
            case BACKWARD -> correctMove(position.substract(direction.toUnitVector()));
            case RIGHT -> direction = direction.next();
            case LEFT -> direction = direction.previous();

        }
    }
    void addObserver(IPositionChangeObserver observer) {
        observerList.add(observer);
    }

    void removeObserver(IPositionChangeObserver observer) {
        observerList.remove(observer);
    }
    private void positionChanged(Vector2d newPos) {
        for(IPositionChangeObserver observer : observerList)
            observer.positionChanged(position, newPos);
    }



}
