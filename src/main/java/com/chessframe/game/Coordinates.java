package com.chessframe.game;

/**
 * Contains the necessary information for a piece/tile to be located.
 * Handles all operations on working with these coordinates
 */
public class Coordinates {
    //fields
    /**
     * The x coordinate in a 2-dimensional system
     */
    private int x;
    /**
     * the y coordinate in a 2-dimensional system
     */
    private int y;

    //constructors
    /**
     * Creates a new instance with the passed values
     * @param x The x value of the coordinate pair
     * @param y The y value of the coordinate pair
     */
    public Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    //methods
    /**
     * Creates a new Coordinates-instance with the passed x and y values added to the original ones
     * @param x The amount of shift to occur in x-direction
     * @param y The amount of shift to occur in y-direction
     * @return The new coordinates with the adjusted x and y values
     * @throws OutOfBoardException If the coordinates created are negative
     */
    public Coordinates shiftCoordinates(int x, int y) throws OutOfBoardException{
        if(this.x + x < 0 || this.y + y < 0){
            throw new OutOfBoardException();
        }
        return new Coordinates(this.x + x, this.y + y);
    }

    //getters
    /**
     * Gets the x value of the coordinate-pair
     * @return The x value
     */
    public int getX() {return x;}

    /**
     * Gets the y value of the coordinate-pair
     * @return The y value
     */
    public int getY() {return y;}
}
