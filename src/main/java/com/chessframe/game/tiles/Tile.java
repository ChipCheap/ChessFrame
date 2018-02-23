package com.chessframe.game.tiles;

import com.chessframe.game.Coordinates;

/**
 * Represents a tile on a board
 */
public abstract class Tile {
    /**
     * The coordinates to locate this tile with
     */
    Coordinates coordinates;
    /**
     * The color of the tile
     * TODO image in TC or separate?
     */
    TileColor color;

    /**
     * Execute special tile event on certain occasions, for example after a move
     */
    public abstract void applyTileFunction();
}
