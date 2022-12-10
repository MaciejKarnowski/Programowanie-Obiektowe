package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashSet;


public class SimulationEngine implements IEngine{
    private final MoveDirection[] moves;
    protected Vector2d[] initialPositions;
    private final IWorldMap map;
    public SimulationEngine(MoveDirection[] movesList,IWorldMap map,Vector2d[] initialPositions){
        this.moves = movesList;
        this.map = map;
        this.initialPositions = initialPositions;

    }

    @Override
    public void run() {
        ArrayList<Animal> animals = new ArrayList<>();
        for (Vector2d position: initialPositions) {
            Animal newAnimal = new Animal(map, position);
            if (map.place(newAnimal)) {
                animals.add(newAnimal);
            }
        }
        if (animals.isEmpty())
            return;
        int curAnimal = 0;
        for(MoveDirection m: moves){
            animals.get(curAnimal).move(m);
            curAnimal += 1;
            curAnimal %= animals.size();

        }
    }
}