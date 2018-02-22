package com.chessframe.game;

import java.util.ArrayList;

/**
 * Contains all rules and important components for a game of chess
 */
public class Game {
    private ArrayList<Player> players;
    private Board board;
    private WinConditions winConditions;
    private CaptureRules captureRules;
    private MovementRules movementRules;
}
