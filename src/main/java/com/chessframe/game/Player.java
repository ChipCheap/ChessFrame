package com.chessframe.game;

import java.util.ArrayList;

/**
 * Represents a single player participating in a game
 */
public class Player {
    private ArrayList<Piece> piecesInPlay;
    private ArrayList<Piece> piecesOnHand;
    private PlayerColors color;
    private boolean canCastle;
    private boolean inCheck;
}
