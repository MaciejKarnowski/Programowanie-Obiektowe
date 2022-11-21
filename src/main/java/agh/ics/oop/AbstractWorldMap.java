package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

abstract public class AbstractWorldMap implements IWorldMap {
    Vector2d lowerLeft, upperRight;
    Vector2d mapLowerLeft, mapUpperRight;

    protected ArrayList<Animal> animals = new ArrayList<>();
    @Override
    public boolean place(Animal animal) {
        if (!this.canMoveTo(animal.getPosition())) return false;
        animals.add(animal);
        return true;
    }


    @Override
    public String toString() {
        MapVisualizer visualization = new MapVisualizer(this);
        setBounds();
        return visualization.draw(this.mapLowerLeft, this.mapUpperRight);
    }
    abstract public void setBounds();

}