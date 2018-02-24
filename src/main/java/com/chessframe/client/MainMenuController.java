package com.chessframe.client;

import com.chessframe.server.MainServer;
import com.chessframe.util.Resizable;
import com.chessframe.util.ResizeUtils;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The main menu allows the players to connect to a server, or to create pieces and game modes.
 */
public class MainMenuController implements Resizable {
    private final static Logger log = LogManager.getLogger((MainMenuController.class.getName()));

    @FXML
    private Button startGame;
    @FXML
    private Parent root;
    @FXML
    private Label header;
    @FXML
    private Button startServer;
    @FXML
    private Button connect;
    @FXML
    private Button pieceCreator;
    @FXML
    private Button gameCreator;

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
        int fontSizeSmall = ResizeUtils.getSmallFontSize(newWidth, newHeight);
        int fontSizeBig = ResizeUtils.getHeaderFontSize(newWidth, newHeight);

        header.setStyle("-fx-font-size:" + fontSizeBig);
        startServer.setStyle("-fx-font-size: " + fontSizeSmall);
        connect.setStyle("-fx-font-size: " + fontSizeSmall);
        startGame.setStyle("-fx-font-size: " + fontSizeSmall);
        pieceCreator.setStyle("-fx-font-size: " + fontSizeSmall);
        gameCreator.setStyle("-fx-font-size: " + fontSizeSmall);
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
    private void onStartServer() {
        try {
            new MainServer().start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
            mainController.showAlert(Alert.AlertType.ERROR, "Error", "Unable to start the server!", e.getMessage());
        }

    }

    @FXML
    private void onConnect() {
        mainController.showView(CurrentView.Connect);
    }

    @FXML
    private void onPieceCreator() {
        mainController.showView(CurrentView.PieceCreator);
    }

    @FXML
    private void onGameCreator() {
        mainController.showView(CurrentView.GameCreator);
    }

    @FXML
    private void onStartGame() {
        mainController.showView(CurrentView.Game);
    }
}
