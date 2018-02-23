package com.chessframe.game.pieces;

import com.chessframe.game.*;
import com.chessframe.game.tiles.Tile;
import javafx.scene.image.Image;

import java.util.ArrayList;

/**
 * Represents any piece, containing information about the owner, its movement capabilities
 * and any other info needed for a piece to operate
 */
public abstract class Piece {
    /**
     * Shows whether this piece is still considered to be at its initial position to perform specific actions
     */
    private boolean atInitialPosition;
    /**
     * Shows whether this piece is considered royal and can therefore be checked
     * and is key part of the standard win condition
     */
    private boolean royal;
    /**
     * Shows whether this piece is considered to be usable for castling by the king
     */
    private boolean isCastleBlock;
    /**
     * The coordinates of the location in which this piece resides on
     */
    private Coordinates position;
    /**
     * The owning player of this piece
     */
    private Player owner;
    /**
     * The full name of this piece
     */
    private String fullName;
    /**
     * The shortened name for notation and transmission
     */
    private String abbreviation;
    /**
     * The image to represent this piece in the view with
     */
    private Image image;
    /**
     * The movement options this piece has
     */
    private MovementOptions movementOptions;
    /**
     * The capture options this piece has
     */
    private CaptureOptions captureOptions;

    //methods
    /**
     * Calculates all the tiles on which this piece can potentially perform a capture move
     * @return The list of tiles within the board
     */
    public ArrayList<Tile> calculateCaptureMoves(){
        return new ArrayList<>();
    }

    /**
     * Calculates all the tiles on which this piece can potentially move
     * @return The list of tiles within the board
     */
    public ArrayList<Tile> calculateStandardMoves(){
        return new ArrayList<>();
    }

    //getters
    /**
     * Returns whether this piece is considered {@link #royal}
     * @return The royalty status of this piece
     */
    public boolean isRoyal() {return royal;}

    /**
     * Returns whether this piece is at its starting location
     * @return The internal {@link #atInitialPosition} status
     */
    public boolean isAtInitialPosition() {
        return atInitialPosition;
    }

    /**
     * Returns whether this piece may be used for castling
     * @return The internal {@link #isCastleBlock} flag
     */
    public boolean isCastleBlock() {
        return isCastleBlock;
    }

    /**
     * Returns the coordinates of this piece's whereabouts
     * @return The {@link #position} of this piece
     */
    public Coordinates getPosition() {
        return position;
    }
}
