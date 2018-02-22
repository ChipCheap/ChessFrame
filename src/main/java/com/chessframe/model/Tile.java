package main.java.com.chessframe.model;

public abstract class Tile {
    private Coordinates coordinates;
    private TileColor color;

    public abstract void applyTileFunction();
}
