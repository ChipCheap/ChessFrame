package com.chessframe.game;

/**
 * Represents a tile on a board
 */
public abstract class Tile {
    /**
     * The coordinates to locate this tile with
     */
    private Coordinates coordinates;
    /**
     * The color of the tile
     * TODO image in TC or separate?
     */
    private TileColor color;

    /**
     * Execute special tile event on certain occasions, for example after a move
     */
    public abstract void applyTileFunction();
}
