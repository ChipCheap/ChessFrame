package com.chessframe;

import com.chessframe.client.controller.MainController;
import com.chessframe.client.model.CurrentView;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The main application class for the client.
 */
public class MainClient extends Application {
    private static final CurrentView INITIAL_VIEW = CurrentView.MainMenu;
    private static final double WIDTH = 1280;
    private static final double HEIGHT = 720;


    @Override
    public void start(Stage primaryStage) throws Exception {

        // just load fxml file and display it in the stage:


        MainController mainController = new MainController(INITIAL_VIEW, WIDTH, HEIGHT);
        primaryStage.setScene(mainController.getScene());
        primaryStage.show();
    }

    // main method to support non-JavaFX-aware environments:

    public static void main(String[] args) {
        launch(args);
    }
}
