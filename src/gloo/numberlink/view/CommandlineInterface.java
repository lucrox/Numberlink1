package gloo.numberlink.view;

import gloo.numberlink.control.Controller;
import gloo.numberlink.model.Direction;
import gloo.numberlink.utils.BoardReader;
import gloo.numberlink.utils.ConsoleColors;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.util.Scanner;

public class CommandlineInterface extends Thread {
    private final Controller controller;
    private final Scanner scanner;
    private GUIDisplayer GUI;
    private Object monitor;
    private JFrame frame;

    public CommandlineInterface(Controller controller, JFrame frame) {
        scanner = new Scanner(System.in);
        this.frame = frame;
        this.controller = controller;
        GUI = new GUIDisplayer(controller,frame);
        monitor = controller.getMonitor();
    }


    /**
     * Asks user for board size and handles exceptions
     *
     * @return board size
     */


    /**
     * Prints the grid for the command line interface.
     *
     * @param highlightCol column of the cell to be highlighted
     * @param highlightRow row of the cell to be highlighted
     */
    public void printGrid(String[][] labels, int highlightRow, int highlightCol) {

        int nbRows = labels.length;
        int nbCols = labels[0].length;

    }

    public void printGrid(String[][] labels) {
        printGrid(labels, -1, -1);
    }

    @Override
    public void run() {
        Thread display = new Thread(GUI);
        display.start();
        System.out.println("Welcome to NumberLink.");
        long startTime = System.currentTimeMillis();
        while (true) {
            // Retrieve the labels of the cells for printing
            String[][] labels = controller.getLabels();
            if (controller.hasCurrentPath()) {
                int[] lastCellCoordinates = controller.getLastCellCoordinates();
                GUI.displayChoice(lastCellCoordinates, controller.getLabelCurrentPath());
                int lastCellRow = lastCellCoordinates[0];
                int lastCellColumn = lastCellCoordinates[1];
                printGrid(labels, lastCellRow, lastCellColumn);
            } else {
                printGrid(labels);
                System.out.println("on charge les labels");
                GUI.chargeLabel(labels);
            }


            synchronized (monitor){
            while (!controller.hasCurrentPath()) {
                // When we don't have a current path, select a cell to start a new path
                System.out.println("Please select a cell: ");
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            }
                // Choose the next cell
                System.out.println("Please select your next move:");
                System.out.println("Choose from: UP, DOWN, LEFT, RIGHT, QUIT");
                String userInput = scanner.nextLine().toUpperCase();
                if (userInput.equals("QUIT")) {
                    break;
                }
                Direction dir = switch (userInput) {
                    case "UP" -> Direction.UP;
                    case "DOWN" -> Direction.DOWN;
                    case "LEFT" -> Direction.LEFT;
                    case "RIGHT" -> Direction.RIGHT;
                    default -> null;
                };
                if (dir == null) {
                    System.out.println("Invalid direction, please try again");
                    continue;
                }
                boolean isGameFinished = controller.action(dir);
                if (isGameFinished) {
                    long timeElapsedSeconds = ((System.currentTimeMillis() - startTime) / 1000L);
                    System.out.println("Congratulations, you won !");
                    System.out.println("Total time spent on the puzzle: " + timeElapsedSeconds + " seconds.");
                    break;
                }


        }
        System.out.println("Thanks for playing the game. Goodbye!");
    }




}
