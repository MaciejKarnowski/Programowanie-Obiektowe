package agh.ics.oop;

import java.net.NoRouteToHostException;
import java.util.Map;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;
    public String toString(){
        return switch (this) {
            case NORTH -> "Północ";
            case SOUTH -> "Południe";
            case WEST -> "Zachód";
            case EAST -> "Wschód";
        };
    }
    public MapDirection next(){
        return switch (this) {
            case NORTH -> MapDirection.EAST;
            case SOUTH -> MapDirection.WEST;
            case EAST -> MapDirection.SOUTH;
            case WEST -> MapDirection.NORTH;
        };
    }
    public MapDirection previous(){
        return switch (this) {
            case NORTH -> MapDirection.WEST;
            case SOUTH -> MapDirection.EAST;
            case EAST -> MapDirection.NORTH;
            case WEST -> MapDirection.SOUTH;
        };
    }
    public Vector2d toUnitVector(){
        return switch (this) {
            case NORTH -> new Vector2d(0,1);
            case SOUTH -> new Vector2d(0,-1);
            case EAST -> new Vector2d(1,0);
            case WEST -> new Vector2d(-1,0);
        };
    }


}
