package main.java.com.chessframe.model;

import java.util.ArrayList;

/**
 * Represents any piece, containing information about the owner, its movement capabilities
 * and any other info needed for a piece to operate
 */
public abstract class Piece {
    private boolean atInitialPosition;
    private boolean royal;
    private Coordinates position;
    private Player owner;
    private MovementOptions movementOptions;
    private CaptureOptions captureOptions;

    /**
     * Calculates all the tiles on which this piece can potentially perform a capture move
     */
    public ArrayList<Tile> calculateCaptureMoves(){
        return new ArrayList<>();
    }

    public void calculateStandardMoves(){

    }
}
