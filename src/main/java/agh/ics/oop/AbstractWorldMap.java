package agh.ics.oop;

import java.util.*;

abstract public class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    public Vector2d lowerLeft,upperRight;
    MapBoundary bounds = new MapBoundary();
    Map<Vector2d, Animal> animals = new HashMap<>();


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
        return position.precedes(upperRight) && position.follows(lowerLeft);
    }
    @Override
    public boolean place(Animal animal) throws IllegalArgumentException {
        Vector2d position = animal.getPosition();
        if (isOccupied(position) && (objectAt(position) instanceof Animal))
        {
            throw new IllegalArgumentException("You can't place animal at: " + position.toString() + ", position is already occupied by animal");
        }
        animals.put(position, animal);
        bounds.addElement(position);
        animal.addObserver(this);
        return true;
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal this_animal = this.animals.get(oldPosition);
        this.animals.remove(oldPosition);
        this.animals.put(newPosition, this_animal);
        if (this instanceof GrassField && this.objectAt(oldPosition) instanceof Grass) {
            bounds.addElement(newPosition);
        } else {
            bounds.positionChanged(oldPosition, newPosition);
        }

    }
    @Override
    public String toString() {
        MapVisualizer visualization = new MapVisualizer(this);
        return visualization.draw(getLowerBound(), getUpperBound());
    }
    public abstract Vector2d getLowerBound();
    public abstract Vector2d getUpperBound();

}