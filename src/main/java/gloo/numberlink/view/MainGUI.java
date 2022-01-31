package gloo.numberlink.view;

import gloo.numberlink.control.Controller;
import gloo.numberlink.model.Grid;
import gloo.numberlink.utils.BoardReader;

import javax.swing.*;
import java.util.Scanner;

public class MainGUI {

    public static void main(String[] args) {
        Grid grid = new Grid(inputBoardSize());
        Controller controller = new Controller(grid); //Asks the User for the size of the board
        System.out.println("Welcome to NumberLink.");
        SwingUtilities.invokeLater(new GUIDisplayer(controller, grid));
    }

    private static int inputBoardSize() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a board size from " + BoardReader.minBoardLength + " to " + BoardReader.maxBoardLength + ".");
        try {
            return Integer.parseInt(scanner.nextLine()); // board size
        } catch (Exception ex) {
            System.out.println("Invalid input, please try again");
            return inputBoardSize();
        }
    }
}
