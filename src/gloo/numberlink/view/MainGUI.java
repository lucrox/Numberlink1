package gloo.numberlink.view;

import gloo.numberlink.control.Controller;
import gloo.numberlink.utils.BoardReader;

import javax.swing.*;
import java.util.Scanner;

public class MainGUI {

    public static void main(String[] args) throws Exception {
        Controller controller = new Controller(inputBoardSize());



        System.out.println("Welcome to NumberLink.");
        SwingUtilities.invokeLater(new GUIDisplayer(controller));
        long startTime = System.currentTimeMillis();

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
