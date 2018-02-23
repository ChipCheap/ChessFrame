package com.chessframe.game.rules;


/**
 * Specifies when the game is won or how to determine a winner, e.g. points for 4 player chess
 */
public abstract class WinCondition{
    //fields

    //methods
    /**
     * Checks whether this single win condition is met for a player
     * @return True if the condition is met
     */
    public abstract boolean checkCondition();
}
