package com.chessframe.server;


/**
 * The current view which parent is being shown in the main scene of the game at the moment.
 */
public enum CurrentView {
    /**
     * The setup menu allows the user to start a server at a specified port.
     */
    SetupMenu,
    /**
     * The console allows the host to enter server queries/commands.
     */
    Console
}
