package com.chessframe.game;

import com.chessframe.game.pieces.Piece;

/**
 * Represents a single move containing the player executing it,
 * which piece is moved and the new location for the piece
 */
public class Move {
    //fields
    /**
     * The player playing the move
     */
    private Player player;
    /**
     * The piece to be moved
     */
    private Piece pieceMoved;
    /**
     * The new location for the piece to be moved onto
     */
    private Coordinates targetLocation;
    /**
     * Whether the move played is to be a capturing move
     */
    private boolean isCapture;

    //constructors
    public Move(){

    }

    public Move(String moveString){

    }

    //methods
}
