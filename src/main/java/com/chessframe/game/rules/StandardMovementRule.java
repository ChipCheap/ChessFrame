package com.chessframe.game.rules;

/**
 * Specifies the rule for defining a legal move in standard chess
 */
public class StandardMovementRule extends MovementRule{
    /**
     * {@inheritDoc}
     * @return True in case the move does not place a royalty, e.g. the king, in check
     */
    @Override
    public boolean checkRule() {
        return false;
    }
}
