package gloo.numberlink.view;

import gloo.numberlink.control.Controller;
import gloo.numberlink.model.BoardDataProvider;
import gloo.numberlink.model.Direction;
import gloo.numberlink.model.Grid;
import gloo.numberlink.utils.BoardReader;
import gloo.numberlink.utils.ConsoleColors;

import java.util.Scanner;

public class MainCLI {
    private final Controller controller;
    private final Scanner scanner; // for user input
    private final BoardDataProvider boardData;

    public static void main(String[] args) {
        try {
            MainCLI cli = new MainCLI();
            cli.runGame();
        } catch (Exception e) {
            System.out.println("Error reading the game board. Check if board files are damaged.");
        }
    }

    public MainCLI() {
        scanner = new Scanner(System.in);
        int boardSize = inputBoardSize();
        Grid grid = new Grid(boardSize);
        boardData = grid;
        controller = new Controller(grid);
    }


    /**
     * Asks user for board size and handles exceptions
     *
     * @return board size
     */
    private int inputBoardSize() {
        System.out.println("Choose a board size from " + BoardReader.minBoardLength + " to " + BoardReader.maxBoardLength + ".");
        try {
            return Integer.parseInt(scanner.nextLine()); // board size
        } catch (Exception ex) {
            System.out.println("Invalid input, please try again");
            return inputBoardSize();
        }
    }

    /**
     * Prints the grid for the command line interface.
     *
     * @param highlightCol column of the cell to be highlighted
     * @param highlightRow row of the cell to be highlighted
     */
    public void printGrid(String[][] labels, int highlightRow, int highlightCol) {

        int nbRows = labels.length;
        int nbCols = labels[0].length;

        // Reset console color
        ConsoleColors.setColor(ConsoleColors.RESET);

        // Column indices
        System.out.println();
        System.out.print("      ");
        for (int row = 0; row < nbRows; row++) {
            System.out.print(row + (row >= 10 ? "    " : "     "));
        }

        // Upper border
        System.out.println();
        System.out.print("  ");
        for (int col = 0; col < nbCols; col++) {
            System.out.print(col == 0 ? " ┏━━━━━" : "┯━━━━━");
        }
        System.out.println("┓");


        for (int row = 0; row < nbRows; row++) {
            System.out.print(row + (row >= 10 ? "" : " "));
            for (int col = 0; col < nbCols; col++) {
                System.out.print((col == 0 ? " ┃ " : "│ "));
                if (row == highlightRow && col == highlightCol) {
                    ConsoleColors.setColor(ConsoleColors.YELLOW_BACKGROUND);
                }
                System.out.print(" " + labels[row][col] + " ");
                if (row == highlightRow && col == highlightCol) {
                    ConsoleColors.setColor(ConsoleColors.RESET);
                }
                System.out.print(" ");
            }
            System.out.println("┃");

            System.out.print("  ");
            for (int col = 0; col < nbCols; col++) {
                if (row == nbRows - 1) {
                    System.out.print(col == 0 ? " ┗━━━━━" : "┷━━━━━");
                } else {
                    System.out.print(col == 0 ? " ┠─────" : "┼─────");
                }
            }
            System.out.println(row == nbCols - 1 ? "┛" : "┨");
        }
    }

    public void printGrid(String[][] labels) {
        printGrid(labels, -1, -1);
    }


    public void runGame() {
        System.out.println("Welcome to NumberLink.");
        long startTime = System.currentTimeMillis();
        while (true) {
            // Retrieve the labels of the cells for printing
            String[][] labels = boardData.getLabels();
            if (controller.hasCurrentPath()) {
                int[] lastCellCoordinates = controller.getLastCellCoordinates();
                int lastCellRow = lastCellCoordinates[0];
                int lastCellColumn = lastCellCoordinates[1];
                printGrid(labels, lastCellRow, lastCellColumn);
            } else {
                printGrid(labels);
            }
            if (!controller.hasCurrentPath()) {
                // When we don't have a current path, select a cell to start a new path
                System.out.println("Please select a cell: ");
                System.out.print("row (type QUIT to quit): ");
                String userInput = scanner.nextLine();
                if (userInput.equalsIgnoreCase("QUIT")) break;
                int row = Integer.parseInt(userInput);
                System.out.print("column (type QUIT to quit): ");
                userInput = scanner.nextLine();
                if (userInput.equalsIgnoreCase("QUIT")) break;
                int col = Integer.parseInt(userInput);
                if (!controller.isCoordinatesValid(row, col)) {
                    System.out.println("Invalid coordinates, please try again");
                    continue;
                }
                controller.selectCell(row, col);
            } else {
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
        }
        System.out.println("Thanks for playing the game. Goodbye!");
    }
}
