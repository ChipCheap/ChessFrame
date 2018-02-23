package com.chessframe.game.rules;

/**
 * Specifies when a move is allowed and what happens afterwards by checking all rules set
 */
public abstract class MovementRule {
    /**
     * Checks whether a move is considered to be legal
     * @return True if no rules are conflicted
     */
    public abstract boolean checkRule();
}
