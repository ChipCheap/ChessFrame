package com.chessframe;

import com.chessframe.client.MainClient;
import com.chessframe.server.MainServer;
import javafx.application.Application;

import java.util.Arrays;

/**
 * The main class. By default, this launches the client application,
 * however, if "-server" is passed as an argument, this can be used
 * to only start the server application.
 */
public class Main {
    /**
     * Main method.
     *
     * @param args the passed arguments.
     * @throws Exception if there is an error when reading internal resources.
     */
    public static void main(String[] args) throws Exception {
        System.setProperty("log4j.configurationFile", "log4j2.xml");
        if (Arrays.asList(args).contains("-server")) {
            Application.launch(MainServer.class, args);
        } else {
            Application.launch(MainClient.class, args);
        }
    }
}
