package agh.ics.oop;

import java.util.*;

abstract public class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    Vector2d lowerLeft, upperRight;
    Vector2d mapLowerLeft, mapUpperRight;

    protected Map<Vector2d, Animal> animals = new LinkedHashMap<>();
    @Override
    public boolean place(Animal animal) {
        if (!this.canMoveTo(animal.getPosition())) return false;
        if (isOccupied(animal.getPosition()) && (objectAt(animal.getPosition()) instanceof Animal)) {return false;}
        animals.put(animal.getPosition(), animal);
        animal.addObserver(this);
        return true;
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal this_animal = this.animals.get(oldPosition);
        this.animals.remove(oldPosition);
        this.animals.put(newPosition, this_animal);

    }
    public boolean isOccupied(Vector2d position) {
        return animals.get(position) != null;
    }
    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }
    public Map<Vector2d, Animal> getAnimals() {
        return this.animals;
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        if (this.isOccupied(position)) return false;
        return position.precedes(this.upperRight) && position.follows(this.lowerLeft);
    }
    @Override
    public String toString() {
        MapVisualizer visualization = new MapVisualizer(this);
        setBounds();
        return visualization.draw(this.mapLowerLeft, this.mapUpperRight);
    }
    abstract public void setBounds();

}