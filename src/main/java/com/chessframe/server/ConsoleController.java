package com.chessframe.server;

import com.chessframe.util.Resizable;
import com.chessframe.util.ResizeUtils;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;

/**
 * The console controller allows the host to enter server queries/commands.
 */
public class ConsoleController implements Resizable {
    private final static Logger log = LogManager.getLogger((SetupMenuController.class.getName()));
    @FXML
    private Parent root;

    @FXML
    private TextField inputField;

    @FXML
    private TextArea outputArea;

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
        int fontSize = ResizeUtils.getSmallFontSize(newWidth, newHeight);

        outputArea.setStyle("-fx-font-size:" + fontSize);
        inputField.setStyle("-fx-font-size: " + fontSize);
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
    private void onInputAction() {
        String input = inputField.getText();

        if (input != null && !input.equals("")) {
            switch (input) {
                //Shutdown the server
                case "shutdown":
                    mainController.stopServer();
                    break;
                //Print all connected players
                case "players":
                    printPlayers();
                    break;
                //Print all existing lobbies
                case "lobbies":
                    printLobbies();
                    break;
                //Clear the chat
                case "clear":
                    outputArea.clear();
                    break;
                //Destroy all lobbies
                case "destroyAll":
                    destroyLobbies();
                    break;
                //Kick all players
                case "kickAll":
                    kickAllPlayers();
                    break;
                //Print help
                case "help":
                    printHelp();
                    break;
                default:
                    println(String.format("Unknown command \'%s\'! Type \'help\' for usage!", input));
            }
        }

        inputField.clear();
    }

    /**
     * Print the current time in the chat.
     */
    private void printTime() {
        LocalDateTime now = LocalDateTime.now();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();
        print(String.format("[%02d:%02d:%02d]: ", hour, minute, second));
    }

    /**
     * Kicks all players from the server
     */
    private void kickAllPlayers() {
        //TODO implement
        println("Unimplemented!");
    }

    /**
     * Prints a list of all commands to the chat
     */
    private void printHelp() {
        println(String.join("\n", "A list of all commands:",
                "\tshutdown\t\t|\tShuts down the server.",
                "\tplayers\t\t|\tPrints all players who are currently online.",
                "\tlobbies\t\t|\tPrints all existing lobbies.",
                "\tkickAll\t\t|\tDestroys all existing lobbies.",
                "\tdestroyAll\t|\tKick all logged in players.",
                "\tclear\t\t\t|\tClears the server console."));
    }


    /**
     * Destroys all existing lobbies
     */
    private void destroyLobbies() {
        //TODO implement
        println("Unimplemented!");
    }

    /**
     * Prints all exiting lobbies
     */
    private void printLobbies() {
        //TODO implement
        println("Unimplemented!");
    }

    /**
     * Prints all logged in players.
     */
    private void printPlayers() {
        //TODO implement
        println("Unimplemented!");
    }


    /**
     * Print a line of text to the output area.
     *
     * @param text the string to be printed.
     */
    public void print(String text) {
        outputArea.appendText(text);
    }


    /**
     * Print a line of text to the output area.
     * At the start, the current time is printed,
     * and at the end, a new line character is also printed.
     *
     * @param text the string to be printed.
     */
    public void println(String text) {
        printTime();
        print(text);
        print("\n");
    }
}
