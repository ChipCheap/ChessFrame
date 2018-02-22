package com.chessframe.client.controller;

/**
 * Specifies that the view of a FXML controller is resizable.
 * The view is resized when the {@link #handleResize(double, double)} method is called.
 * It is usually called when the scene detects
 */
public interface Resizable {
    /**
     * Resize the managed view elements to fit the current scene's size.
     * @param newWidth the new width of the scene.
     * @param newHeight the new height of the scene.
     */
    void handleResize(double newWidth, double newHeight);
}
