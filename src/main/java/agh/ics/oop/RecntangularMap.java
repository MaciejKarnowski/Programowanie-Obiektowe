package agh.ics.oop;

import java.util.*;

class RectangularMap implements IWorldMap {
    protected Vector2d lowerLeft;
    protected Vector2d UpperRight;

    private final MapVisualizer mapVisualizer;
    private final HashSet<Animal> animals;

    public RectangularMap(int width,int height ) {
        this.lowerLeft = new Vector2d(0,0);
        this.UpperRight=new Vector2d(width,height);
        mapVisualizer = new MapVisualizer(this);
        this.animals = new HashSet<>();
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(lowerLeft) && position.precedes(UpperRight);
    }
    @Override
    public boolean place(Animal animal) {
        if(!canMoveTo(animal.getPosition())){
            return false;
        }
        this.animals.add(animal);
        return true;
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal i: this.animals) {
            if (i.isAt(position)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public Object objectAt(Vector2d position) {
        for (Animal i: this.animals) {
            if (i.isAt(position)) {
                return position;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return mapVisualizer.draw(lowerLeft, UpperRight);
    }



}
