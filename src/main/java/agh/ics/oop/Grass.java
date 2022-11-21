package agh.ics.oop;

public class Grass {
    protected Vector2d grass;

    public Grass(Vector2d grass){
        this.grass= grass;
    }

    public Vector2d getPosition(){
        return grass;
    }

    @Override
    public String toString() {
        return "*";
    }

}
