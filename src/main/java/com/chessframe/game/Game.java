package com.chessframe.game;

import java.util.ArrayList;

/**
 * Contains all rules and important components for a game of chess
 */
public class Game {
    /**
     * The list of all players participating
     */
    private ArrayList<Player> players;
    /**
     * The board of the game
     */
    private Board board;
    /**
     * The conditions needed to be fulfilled for a player to win
     */
    private WinConditions winConditions;
    /**
     * The rules for a capture
     */
    private CaptureRules captureRules;
    /**
     * The rules for a move
     */
    private MovementRules movementRules;
}
