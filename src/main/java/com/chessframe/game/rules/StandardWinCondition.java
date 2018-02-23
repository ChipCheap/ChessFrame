package com.chessframe.game.rules;

/**
 * Specifies the standard condition needed to be met for a player to win
 */
public class StandardWinCondition extends WinCondition{
    /**
     * {@inheritDoc}
     * @return True if the opposing only royalty, the king, is checkmated,
     * i.e. has no legal moves to move out of check while the check cannot be blocked either
     */
    @Override
    public boolean checkCondition() {
        return false;
    }
}
