package agh.ics.oop;

import java.util.*;

class RectangularMap extends AbstractWorldMap{
    protected Vector2d lowerLeft;
    protected Vector2d UpperRight;


    public RectangularMap(int width,int height ) {
        this.lowerLeft = new Vector2d(0,0);
        this.UpperRight=new Vector2d(width,height);
        this.mapUpperRight=this.UpperRight;
        this.mapLowerLeft=this.lowerLeft;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (this.isOccupied(position)) return false;
        return position.follows(lowerLeft) && position.precedes(UpperRight);
    }

    @Override
    public boolean place(Animal animal) {
        if (!this.canMoveTo(animal.getPosition())) return false;
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
                return i;
            }
        }
        return null;
    }

    @Override
    public void setBounds() {
        mapLowerLeft = this.lowerLeft;
        mapUpperRight = this.UpperRight;
    }
}
