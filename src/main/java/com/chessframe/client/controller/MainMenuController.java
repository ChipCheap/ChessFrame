package com.chessframe.client.controller;

import javafx.fxml.FXML;
import javafx.scene.Parent;

public class MainMenuController implements Resizable {
    @FXML
    private Parent root;

    public void handleResize(double newWidth, double newHeight) {

    }

    /**
     * Get the root view element.
     *
     * @return the root view element.
     */
    public Parent getRoot() {
        return root;
    }
}
