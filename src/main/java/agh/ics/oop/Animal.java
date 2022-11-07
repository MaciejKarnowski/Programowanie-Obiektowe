package agh.ics.oop;

import java.util.Map;

public class Animal {
    private Vector2d position = new Vector2d(2,2);
    private MapDirection map= MapDirection.NORTH;
    public String toString() {
        return "(Zwierze znajduje się na: "
                + position +
                ", i jest zwrócone w strone: " + map +
                ')';
    }
    public boolean isAt(Vector2d position) {
        return position == this.position;
    }
    public void move(MoveDirection direction){
        if (direction==MoveDirection.LEFT){
            this.map=map.previous();
        }
        if (direction==MoveDirection.RIGHT){
            this.map=map.next();
        }
        if (direction==MoveDirection.FORWARD){
            this.position=this.position.add(map.toUnitVector());
                if((this.position.x==5) || (this.position.x==-1) || (this.position.y==5) || (this.position.y==-1)){
                    this.position=this.position.substract(map.toUnitVector());
                }
        }
        if (direction==MoveDirection.BACKWARD){
            this.position=this.position.substract(map.toUnitVector());
            if((this.position.x==5) || (this.position.x==-1)|| (this.position.y==5)|| (this.position.y==-1)){
                this.position=this.position.add(map.toUnitVector());
            }
        }

    }


}
