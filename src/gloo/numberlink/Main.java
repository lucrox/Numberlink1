package gloo.numberlink;

import gloo.numberlink.control.Controller;
import gloo.numberlink.utils.BoardReader;
import gloo.numberlink.view.CommandlineInterface;
import gloo.numberlink.view.GUIDisplayer;
import gloo.numberlink.view.GUISwing;
import gloo.numberlink.view.ViewGrid;

import javax.swing.*;
import java.util.Scanner;

/**
 * Run the main method of this class to start the game.
 */
public class Main {
    public static void main(String[] args) {
        int boardSize = inputBoardSize(new Scanner(System.in));
        JFrame frame = new JFrame();

        Controller controller = new Controller(boardSize);
        ViewGrid viewGrid = new ViewGrid(controller);
        CommandlineInterface cli = new CommandlineInterface(controller, frame,viewGrid);
        cli.start();
        GUIDisplayer GUI = new GUIDisplayer(controller,frame,viewGrid);
        Thread display = new Thread(GUI);
        display.start();

    }

    private static int inputBoardSize(Scanner scanner) {
        System.out.println("Choose a board size from " + BoardReader.minBoardLength + " to " + BoardReader.maxBoardLength + ".");
        try {
            return Integer.parseInt(scanner.nextLine()); // board size
        } catch (Exception ex) {
            System.out.println("Invalid input, please try again");
            return inputBoardSize(scanner);
        }
    }
}

//TODO: clear screen every time we print