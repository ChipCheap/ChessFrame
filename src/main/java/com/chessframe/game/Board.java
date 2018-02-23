package com.chessframe.game;

import com.chessframe.game.tiles.StandardTile;
import com.chessframe.game.tiles.Tile;
import com.chessframe.game.tiles.TileColorDark;
import com.chessframe.game.tiles.TileColorLight;

import java.io.File;

/**
 * Represents a x * y board with any number of tiles inside
 */
public class Board {
    //fields
    /**
     * The tiles defined inside the board
     */
    private Tile[][] tiles;

    //constructors
    /**
     * Creates a standard Board for a standard game
     */
    public Board(){
        tiles = new Tile[8][8];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                tiles[i][j] = new StandardTile(new Coordinates(i, j), ((i + j) % 2 == 0 ?
                        new TileColorLight() : new TileColorDark()));
            }
        }
    }

    /**
     * Reads in a file and returns the Board with the initialized tiles and pieces
     * @param mapFile The file containing the information of the board to be created
     */
    public Board(File mapFile){
        //read out the x width and y height first
        //create all tiles not marked with e.g. 'X' or ' '
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
