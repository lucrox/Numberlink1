package gloo.numberlink;

import gloo.numberlink.view.CommandlineInterface;

/**
 * Run the main method of this class to start the game.
 */
public class Main {
    public static void main(String[] args) {
        CommandlineInterface cli = new CommandlineInterface();
        cli.runGame();
    }
}

//TODO: clear screen every time we print