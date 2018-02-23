package com.chessframe.server;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The main server is the application for the server side of ChessFrame.
 */
public class MainServer extends Application {
    private static final CurrentView INITIAL_VIEW = CurrentView.SetupMenu;
    private static final double WIDTH = 800;
    private static final double HEIGHT = 600;

    @Override
    public void start(Stage primaryStage) throws Exception {
        MainController mainController = new MainController(INITIAL_VIEW, WIDTH, HEIGHT);
        primaryStage.setScene(mainController.getScene());
        primaryStage.setMinWidth(WIDTH);
        primaryStage.setMinHeight(HEIGHT);
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);
        primaryStage.show();
    }
}
