package com.chessframe.server;


import com.chessframe.util.IntegerField;
import com.chessframe.util.Resizable;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * The setup menu allows the user to start a server at a specified port.
 */
public class SetupMenuController implements Resizable {
    private final static Logger log = LogManager.getLogger((SetupMenuController.class.getName()));
    @FXML
    private IntegerField portField;

    @FXML
    private Parent root;

    @FXML
    private Label header;

    @FXML
    private Label portLabel;

    @FXML
    private Button startServer;

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

        header.setStyle("-fx-font-size:" + fontSizeBig);
        portLabel.setStyle("-fx-font-size: " + fontSizeSmall);
        portField.setStyle("-fx-font-size: " + fontSizeSmall);
        startServer.setStyle("-fx-font-size: " + fontSizeSmall);
    }

    /**
     * Get the root view element.
     *
     * @return the root view element.
     */
    public Parent getRoot() {
        return root;
    }

    /**
     * Gets called when the start server button is pressed.
     * Starts the server at the specified port.
     */
    @FXML
    private void onStartServer() {
        try {
            mainController.startServer(portField.getValue());
        } catch (IOException e) {
            mainController.showAlert(Alert.AlertType.ERROR, "Error", "Unable to start server!", e.getMessage());
        }
    }
}
