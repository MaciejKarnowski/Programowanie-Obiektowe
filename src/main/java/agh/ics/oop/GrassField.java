package agh.ics.oop;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class GrassField extends AbstractWorldMap{
    protected int amount;
    Vector2d lowerBound;
    Vector2d upperBound;
    Map<Vector2d, Grass> positions_of_grass = new HashMap<>();

    private void bounds(int n) {
        this.lowerBound = new Vector2d(0,0);
        this.upperBound = new Vector2d((int)Math.sqrt(n*10), (int)Math.sqrt(n*10));
    }
    public GrassField(int amount){
        this.amount= amount;
        bounds(amount);
        for (int i=0;i<amount;i++ ){
            addGrass();
        }
    }


    private void addGrass() {
        int max = this.upperBound.x;
        Random rand = new Random();
        Vector2d loc = new Vector2d(rand.nextInt(max), rand.nextInt(max));
        while (isOccupied(loc)) {
            int x = rand.nextInt(max);
            int y = rand.nextInt(max);
            loc = new Vector2d(x, y);
        }
        positions_of_grass.put(loc,new Grass(loc));
        bounds.addElement(loc);
    }
    public boolean canMoveTo(Vector2d position){
        Object obj = this.objectAt(position);
        return obj == null || obj instanceof Grass;
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        if (super.isOccupied(position)) return true;
        return this.positions_of_grass.get(position) != null;
    }
    @Override
    public Object objectAt(Vector2d position) {
        if (super.objectAt(position) != null )
            return super.objectAt(position);
        return this.positions_of_grass.get(position);
    }
    @Override
    public Vector2d getLowerBound() {
        return bounds.getLowerBoundaries();
    }
    @Override
    public Vector2d getUpperBound(){
        return bounds.getUpperBoundaries();
    }

}
