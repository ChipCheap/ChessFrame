package com.chessframe.game.pieces;

import java.util.List;

/**
 * Represents a Pawn-like piece which can be promoted to a different, stronger piece
 */
public abstract class PawnPiece extends Piece {
    //fields
    /**
     * The options a pawn piece may be promoted to
     */
    private List<Piece> promotionOptions;

    //constructors
    public PawnPiece(){

    }

    //methods
    /**
     * Replaces the PawnPiece with the new piece to promote to with the same owner etc,
     * unless other rules specify otherwise
     * @param promotion The piece to promote this pawn piece to
     * TODO might have to be moved up a few stages
     */
    public void promote(Piece promotion){

    }

    /**
     * Checks whether a given piece this pawn is to be promoted to is contained within the options
     * @param promotion The piece to promote this to
     * @return True if promotion piece is contained in the options
     */
    public boolean isPromotionAllowed(Piece promotion){
        return promotionOptions.contains(promotion);
    }
}
