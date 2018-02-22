package com.chessframe.game;

/**
 * Represents a x * y board with any number of tiles inside
 */
public class Board {
    //fields
    /**
     * The tiles defined
     */
    private Tile[][] tiles;

    //constructors
    Board(){

    }

    //methods
    /**
     * Extracts the tile of the given coordinates and returns it
     * @param coordinates The coordinates to find the tile of
     * @return The tile corresponding to the passed coordinates
     * @throws OutOfBoardException If the given coordinates do not lead to an instantiated tile
     */
    public Tile getTileFromCoordinates(Coordinates coordinates) throws OutOfBoardException{
        int x = coordinates.getX(), y = coordinates.getY();
        if(tiles[x][y] == null){
            throw new OutOfBoardException();
        }
        return tiles[x][y];
    }
}
