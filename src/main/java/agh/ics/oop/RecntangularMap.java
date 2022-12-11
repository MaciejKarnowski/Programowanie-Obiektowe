package agh.ics.oop;

import java.util.*;

class RectangularMap extends AbstractWorldMap{
    public Vector2d mapLowerLeft, mapUpperRight;
    public RectangularMap(int width,int height ) {
        this.lowerLeft = new Vector2d(0,0);
        this.upperRight=new Vector2d( width,height);
        this.mapUpperRight=this.upperRight;
        this.mapLowerLeft=this.lowerLeft;
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        if (!isOccupied(position)) {
            return position.follows(upperRight) && position.precedes(lowerLeft);
        } else {
            return false;
        }
    }
    @Override
    public Vector2d getLowerBound() {
        return mapLowerLeft=this.lowerLeft;
    }
    @Override
    public Vector2d getUpperBound(){
        return mapUpperRight=this.upperRight;
    }
}
