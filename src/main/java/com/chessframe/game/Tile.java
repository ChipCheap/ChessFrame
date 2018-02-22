package com.chessframe.game;

public abstract class Tile {
    private Coordinates coordinates;
    private TileColor color;

    public abstract void applyTileFunction();
}
