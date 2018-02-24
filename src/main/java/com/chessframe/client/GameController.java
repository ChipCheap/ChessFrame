package com.chessframe.client;

import com.chessframe.util.Resizable;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class GameController implements Resizable {
    @FXML
    private Button back;
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



    }

    /**
     * Get the root view element.
     *
     * @return the root view element.
     */
    public Parent getRoot() {
        return root;
    }

    @FXML
    private void onBack() {
        mainController.showView(CurrentView.MainMenu);
    }
}
