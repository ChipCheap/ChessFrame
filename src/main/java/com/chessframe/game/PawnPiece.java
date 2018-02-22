package com.chessframe.game;

import java.util.List;

/**
 * Represents a Pawn-like piece which can be promoted to a different, stronger piece
 */
public class PawnPiece extends Piece {
    private List<Piece> promotionOptions;

    /**
     * Replaces the PawnPiece with the new piece to promote to with the same owner etc,
     * unless other rules specify otherwise
     * @param promotion The piece to promote this pawn piece to
     */
    public void promote(Piece promotion){

    }
}
