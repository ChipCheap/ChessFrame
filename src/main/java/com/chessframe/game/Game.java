package com.chessframe.game;

import com.chessframe.game.pieces.Piece;
import com.chessframe.game.rules.CaptureRule;
import com.chessframe.game.rules.MovementRule;
import com.chessframe.game.rules.StandardWinCondition;
import com.chessframe.game.rules.WinCondition;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Contains all rules and important components for a game of chess
 */
public class Game {
    //fields
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
    private HashSet<WinCondition> winConditionSet;
    /**
     * The rules for a capture
     */
    private HashSet<CaptureRule> captureRuleSet;
    /**
     * The rules for a move
     */
    private HashSet<MovementRule> movementRuleSet;

    //constructors
    /**
     * Creates a new game with standard rulings and setup
     */
    public Game(){
        winConditionSet = new HashSet<>();
        winConditionSet.add(new StandardWinCondition());
        captureRuleSet = new HashSet<>();
        movementRuleSet = new HashSet<>();
        board = new Board();
    }

    //TODO pass board and settings in some way
    public Game(int i){

    }
    //methods
    /**
     * Checks whether all necessary win conditions have been met
     * for the player fulfilling them to win the game
     * @return True in case all specified conditions are met and therefore true
     */
    public boolean checkAllWinConditions(){
        for(WinCondition wC : winConditionSet){
            if(!wC.checkCondition()){
                return false;
            }
        }
        return true;
    }

    /**
     * Moves a piece of a single player to a new position, including capturing moves
     * @param moveToPlay The move to be played
     */
    public void playMove(Move moveToPlay){

    }
}
