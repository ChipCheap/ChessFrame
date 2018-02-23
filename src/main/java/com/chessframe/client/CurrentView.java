package com.chessframe.client;


/**
 * The current view which parent is being shown in the main scene of the game at the moment.
 */
public enum CurrentView {
    /**
     * The main menu allows the user to connect to a server, or to create pieces and game modes.
     */
    MainMenu,
    /**
     * The piece creator allows the user to create a new piece which can be used in the {@link #GameCreator}.
     */
    PieceCreator,
    /**
     * The game creator allows the user to create a new game mode.
     */
    GameCreator,
    /**
     * The connect state allows the user to establish the connection to a server.
     */
    Connect,
    /**
     * In the lobby browser state, the user can choose or create a {@link #Lobby}.
     */
    LobbyBrowser,
    /**
     * In the lobby state, the game host can specify the game mode which should be used in the {@link #Game}.
     */
    Lobby,
    /**
     * In the game state, a match against another player is currently being played out.
     */
    Game;
}
