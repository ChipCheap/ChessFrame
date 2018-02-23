package com.chessframe.game.tiles;

import com.chessframe.game.Coordinates;

/**
 * Represents a standard tile with no special effects
 */
public class StandardTile extends Tile {
    //constructors
    public StandardTile(Coordinates coordinates, TileColor color){
        this.coordinates = coordinates;
        this.color = color;
    }

    /**
     * {@inheritDoc}
     * <br>
     * For a standard tile, this does nothing
     */
    @Override
    public void applyTileFunction(){}
}
