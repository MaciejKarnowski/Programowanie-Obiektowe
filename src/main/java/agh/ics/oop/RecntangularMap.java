package agh.ics.oop;

import java.util.*;

class RectangularMap extends AbstractWorldMap{
    private final Vector2d lowerLeft;
    private final Vector2d UpperRight;


    public RectangularMap(int width,int height ) {
        this.lowerLeft = new Vector2d(0,0);
        this.UpperRight=new Vector2d(width,height);
        this.mapUpperRight=this.UpperRight;
        this.mapLowerLeft=this.lowerLeft;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return super.canMoveTo(position)
                && position.follows(lowerLeft)
                && position.precedes(upperRight);
    }

    @Override
    public void setBounds() {
        mapLowerLeft = this.lowerLeft;
        mapUpperRight = this.UpperRight;
    }
}
