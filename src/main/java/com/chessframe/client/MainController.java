package com.chessframe.client;

import com.chessframe.util.Resizable;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.text.Font;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.*;

/**
 * The main controller loads all FXML files, all controllers,
 * and manages the {@link Scene}.
 */
public class MainController implements Resizable {
    /**
     * The logger.
     */
    private final static Logger log = LogManager.getLogger((MainController.class.getName()));

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
     * The width which was used for the last resize event.
     */
    private double lastWidth;
    /**
     * The height which was used for the last resize event.
     */
    private double lastHeight;
    /**
     * The main menu controller.
     */
    private MainMenuController mainMenuController;
    /**
     * The game controller.
     */
    private GameController gameController;


    /**
     * The constructor loads all FXML files,
     * initializes the controllers, and defines the scene.
     *
     * @param initialView        the initial view of the main controller.
     * @param initialSceneWidth  the initial width of the scene.
     * @param initialSceneHeight the initial height of the scene.
     * @throws IOException if there is an issue with loading the FXML files.
     */
    public MainController(CurrentView initialView, double initialSceneWidth, double initialSceneHeight) throws IOException {
        this.previousViewStack = new Stack<>();
        this.currentViewParentMap = new HashMap<>();
        this.resizableElements = new ArrayList<>();

        log.debug("Loading FXML files ...");
        loadFXML();

        log.debug("Loading Scene ...");
        //Define scene
        this.scene = new Scene(currentViewParentMap.get(initialView), initialSceneWidth, initialSceneHeight);

        //Add resize event
        InvalidationListener resizeEvent = observable -> {
            double width = Math.min(scene.getHeight() * 1.8, scene.getWidth());
            double height = Math.min(scene.getHeight(), scene.getWidth() * 0.6);

            handleResize(width, height);
        };

        scene.widthProperty().addListener(resizeEvent);
        scene.heightProperty().addListener(resizeEvent);
    }

    /**
     * Load all required FXML files.
     *
     * @throws IOException if there is an issue with loading the FXML files.
     */
    private void loadFXML() throws IOException {
        ClassLoader classLoader = this.getClass().getClassLoader();

        //Load font
        Font.loadFont(classLoader.getResourceAsStream("fonts/zorque.ttf"), 12);

        //Load FXML
        //Main Menu
        log.trace("Loading MainMenu.fmxl ...");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(classLoader.getResource("fxml/client/MainMenu.fxml"));
        Parent mainMenuView = fxmlLoader.load();
        this.currentViewParentMap.put(CurrentView.MainMenu, mainMenuView);
        this.mainMenuController = fxmlLoader.getController();
        this.mainMenuController.setMainController(this);
        this.resizableElements.add(this.mainMenuController);

        //Piece creator
        /*
        log.trace("Loading PieceCreator.fxml ...");
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(classLoader.getResource("fxml/client/PieceCreator.fxml"));
        Parent pieceCreatorView = fxmlLoader.load();
        this.currentViewParentMap.put(CurrentView.PieceCreator, pieceCreatorView)
        this.pieceCreatorController = fxmlLoader.getController();
        this.pieceCreatorController.setMainController(this);
        this.resizableElements.add(this.pieceCreatorController);
        */

        //Game creator
        /*
        log.trace("Loading GameCreator.fxml ...");
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(classLoader.getResource("fxml/client/GameCreator.fxml"));
        Parent gameCreatorView = fxmlLoader.load();
        this.currentViewParentMap.put(CurrentView.GameCreator, gameCreatorView);
        this.gameCreatorController = fxmlLoader.getController();
        this.gameCreatorController.setMainController(this);
        this.resizableElements.add(this.gameCreatorController);
        */

        //Connect
        /*
        log.trace("Loading Connect.fxml ...");
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(classLoader.getResource("fxml/client/Connect.fxml"));
        Parent connectView = fxmlLoader.load();
        this.currentViewParentMap.put(CurrentView.Connect, connectView);
        this.connectController = fxmlLoader.getController();
        this.connectController.setMainController(this);
        this.resizableElements.add(this.connectController);
        */

        //Lobby browser
        /*
        log.trace("Loading LobbyBrowser.fxml ...");
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(classLoader.getResource("fxml/client/LobbyBrowser.fxml"));
        Parent lobbyBrowserView = fxmlLoader.load();
        this.currentViewParentMap.put(CurrentView.LobbyBrowser, lobbyBrowserView);
        this.lobbyBrowserController = fxmlLoader.getController();
        this.lobbyBrowserController.setMainController(this);
        this.resizableElements.add(this.lobbyBrowserController);
        */

        //Lobby
        /*
        log.trace("Loading Lobby.fxml ...");
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(classLoader.getResource("fxml/client/Lobby.fxml"));
        Parent lobbyView = fxmlLoader.load();
        this.currentViewParentMap.put(CurrentView.Lobby, lobbyView);
        this.lobbyController = fxmlLoader.getController();
        this.lobbyController.setMainController(this);
        this.resizableElements.add(this.lobbyController);
        */

        //Game
        log.trace("Loading Game.fxml ...");
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(classLoader.getResource("fxml/client/Game.fxml"));
        Parent gameView = fxmlLoader.load();
        this.currentViewParentMap.put(CurrentView.Game, gameView);
        this.gameController = fxmlLoader.getController();
        this.gameController.setMainController(this);
        this.resizableElements.add(this.gameController);
    }

    /**
     * Method for creating an alert of type warning.
     *
     * @param alertType the type of the alert.
     * @param title     the title of the alert
     * @param header    the header of the alert
     * @param content   the content text of the alert
     */
    public void showAlert(Alert.AlertType alertType, String title, String header, String content) {
        Platform.runLater(() -> {
            Alert alert = new Alert(alertType);
            alert.setTitle(title);
            alert.setHeaderText(header);
            alert.setContentText(content);

            alert.showAndWait();
        });
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
        log.trace("Setting view to " + currentView.toString());
        this.currentView = currentView;

        Platform.runLater(() -> {
            Parent root = currentViewParentMap.get(currentView);
            if (root != null) {
                scene.setRoot(root);
                root.requestFocus();
            } else {
                log.error("Unable to show view " + currentView.toString() + "!");
            }
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
     * @param newWidth  the new width of the scene.
     * @param newHeight the new height of the scene.
     */
    public void handleResize(double newWidth, double newHeight) {
        this.lastHeight = newHeight;
        this.lastWidth = newWidth;

        for (Resizable resizableElement : resizableElements) {
            resizableElement.handleResize(newWidth, newHeight);
        }
    }

    /**
     * Get the height which was used for the last resize event.
     *
     * @return the height which was used for the last resize event.
     */
    public double getLastHeight() {
        return lastHeight;
    }


    /**
     * Get the width which was used for the last resize event.
     *
     * @return the width which was used for the last resize event.
     */
    public double getLastWidth() {
        return lastWidth;
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
