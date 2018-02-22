package com.chessframe.controller;

import com.chessframe.model.CurrentView;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * The main controller loads all FXML files, all controllers,
 * and manages the {@link Scene}.
 */
public class MainController implements Resizable {
    /**
     * A list of all resizable FXML controllers.
     */
    private List<Resizable> resizableElements;

    /**
     * The scene which contains the current view element.
     */
    private Scene scene;

    /**
     * The currently displayed view.
     */
    private CurrentView currentView;
    /**
     * The stack of the previous views.
     * This can be used to restore the previous view.
     */
    private Stack<CurrentView> previousViewStack;

    /**
     * Maps a view-status to the view-element which should be shown.
     */
    private Map<CurrentView, Parent> currentViewParentMap;

    /**
     * The main menu controller.
     */
    private MainMenuController mainMenuController;

    /**
     * The constructor loads all FXML files,
     * initializes the controllers, and defines the scene.
     *
     * @param initialView the initial view of the main controller.
     * @param initialSceneWidth the initial width of the scene.
     * @param initialSceneHeight the initial height of the scene.
     */
    public MainController(CurrentView initialView, double initialSceneWidth, double initialSceneHeight) throws IOException {
        loadFXML();
        this.scene = new Scene(currentViewParentMap.get(initialView), initialSceneWidth, initialSceneHeight);
    }


    /**
     * Load all required FXML files.
     */
    private void loadFXML() throws IOException{
        ClassLoader classLoader = this.getClass().getClassLoader();
        FXMLLoader fxmlLoader = new FXMLLoader();

        //Load font
        Font.loadFont(classLoader.getResourceAsStream("fonts/zorque.ttf"), 12);

        //Load FXML
        this.currentViewParentMap = new HashMap<>();
        this.currentViewParentMap.put(CurrentView.MainMenu,
                fxmlLoader.load(classLoader.getResourceAsStream("com/chessframe/view/MainMenu.fxml")));
        this.mainMenuController = fxmlLoader.getController();
        //TODO load FXML
    }


    /**
     * Getter for the current view which is currently being displayed.
     *
     * @return the current view.
     */
    public CurrentView getCurrentView() {
        return currentView;
    }

    /**
     * Setter for the current view.
     *
     * @param currentView the new view.
     */
    private void setCurrentView(CurrentView currentView) {
        this.currentView = currentView;

        Platform.runLater(() -> {
            Parent root = currentViewParentMap.get(currentView);
            scene.setRoot(root);
            root.requestFocus();
        });
    }

    /**
     * Restore the previous view.
     */
    public void restorePreviousView() {
        setCurrentView(previousViewStack.pop());
    }

    /**
     * Show the specified view, and save it on the stack of previous views.
     *
     * @param currentView the new current view.
     */
    public void showView(CurrentView currentView) {
        previousViewStack.push(getCurrentView());
        setCurrentView(currentView);
    }


    /**
     * Pass the resize event to all managed FXML controllers.
     *
     * @param newWidth the new width of the scene.
     * @param newHeight the new height of the scene.
     */
    public void handleResize(double newWidth, double newHeight) {
        for (Resizable resizableElement: resizableElements){
            resizableElement.handleResize(newWidth, newHeight);
        }
    }

    /**
     * Get the scene which always contains the current view element.
     *
     * @return the which always contains the current view element.
     */
    public Scene getScene() {
        return scene;
    }
}
