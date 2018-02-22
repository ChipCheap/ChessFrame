package com.chessframe.game;

/**
 * Exception is thrown when a coordinate points to a null tile on the board
 */
public class OutOfBoardException extends Exception {
    /**
     * Creates a new Exception
     */
    OutOfBoardException(){
        super("The coordinates are not in part of the board");
    }
}
