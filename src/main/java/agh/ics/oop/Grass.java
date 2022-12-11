package agh.ics.oop;

public class Grass implements IElementMap{
    protected Vector2d grass;
    @Override
    public String getFileName() {
        return "grass.png";
    }
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
