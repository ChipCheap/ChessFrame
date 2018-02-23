package com.chessframe.client;

import com.chessframe.util.Resizable;
import javafx.fxml.FXML;
import javafx.scene.Parent;

public class GameController implements Resizable {
    @FXML
    private Parent root;

    /**
     * The supervising main controller.
     */
    private MainController mainController;

    /**
     * Set the supervising main controller,
     * which can be used for changing the the currently displayed view.
     *
     * @param mainController the supervising main controller.
     */
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void handleResize(double newWidth, double newHeight) {
        int fontSizeSmall = (int) Math.min(newWidth * 0.03 * (9 / (double) 16), newHeight * 0.03);
        int fontSizeBig = (int) Math.min(newWidth * 0.06 * (9 / (double) 16), newHeight * 0.06);


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
