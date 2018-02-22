package com.chessframe.game;

import javafx.scene.image.Image;

/**
 * Represents
 */
public abstract class TileColor {
    /**
     * Holds the image this tile is to be represented with
     */
    private Image image;
    /**
     * The color this tile is to have
     */
    private BoardColors color;

    /**
     * Sets the image of this tile
     * @param image The new image of this tile
     */
    public void setImage(Image image) {this.image = image;}
}
