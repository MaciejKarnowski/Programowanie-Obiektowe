package agh.ics.oop;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class GrassField extends AbstractWorldMap{
    protected int amount;
    Vector2d lowerBound;
    Vector2d upperBound;
    protected final Map<Vector2d, Grass> positions_of_grass = new LinkedHashMap<>();


    public GrassField(int amount){
        this.amount= amount;
        bounds(amount);
        this.upperRight=new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
        this.lowerLeft=new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);
        for (int i=0;i<amount;i++ ){
            addGrass();
        }
    }
    private void bounds(int n) {
        this.lowerBound = new Vector2d(0,0);
        this.upperBound = new Vector2d((int)Math.sqrt(n*10), (int)Math.sqrt(n*10));
    }

    private void addGrass() {
        int max = this.upperBound.x;
        Random rand = new Random();
        rand.setSeed(100);
        Vector2d loc = new Vector2d(rand.nextInt(max), rand.nextInt(max));
        while (isOccupied(loc)) {
            int x = rand.nextInt(max);
            int y = rand.nextInt(max);
            loc = new Vector2d(x, y);
        }
        positions_of_grass.put(loc,new Grass(loc));
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        if (this.isOccupied(position)) {
            return (objectAt(position) instanceof Grass);
        }
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        if (super.isOccupied(position)) return true;
        return this.positions_of_grass.get(position) != null;
    }
    @Override
    public Object objectAt(Vector2d position) {
        if (super.objectAt(position) != null ) return super.objectAt(position);
        return this.positions_of_grass.get(position);
    }
    @Override
    public void setBounds() {
        if (!animals.isEmpty()) {
            for (Animal i: animals.values()) {
                mapLowerLeft = mapUpperRight = i.getPosition();
                break;
            }
        } else if (!positions_of_grass.isEmpty()) {
            for (Grass i: positions_of_grass.values()) {
                mapLowerLeft = mapUpperRight = i.getPosition();
                break;
            }
        } else {
            mapLowerLeft = new Vector2d(0,0);
            mapUpperRight = new Vector2d(0,0);
            return;
        }
        for (Animal i: animals.values()) {
            mapLowerLeft = mapLowerLeft.lowerLeft(i.getPosition());
            mapUpperRight = mapUpperRight.upperRight(i.getPosition());
        }
        for (Grass i: positions_of_grass.values()) {
            mapLowerLeft = mapLowerLeft.lowerLeft(i.getPosition());
            mapUpperRight = mapUpperRight.upperRight(i.getPosition());
        }
    }
}
