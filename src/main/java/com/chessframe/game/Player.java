package com.chessframe.game;

import java.util.ArrayList;

/**
 * Represents a single player participating in a game
 */
public class Player {
    //fields
    /**
     * All owned pieces currently on the board
     */
    private ArrayList<Piece> piecesInPlay;
    /**
     * All owned pieces currently not in play
     */
    private ArrayList<Piece> piecesOnHand;
    /**
     * The color of this player
     */
    private PlayerColors color;
    /**
     * Shows whether this player is still allowed to castle
     */
    private boolean canCastle;
    /**
     * Shows whether one of this player's royal pieces is under attack
     */
    private boolean inCheck;

    //TODO fill in methods
    //constructors
    public Player(){}

    //methods
    public void movePiece(){

    }

    public void castle(){

    }
}
