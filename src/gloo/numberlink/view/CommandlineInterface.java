package gloo.numberlink.view;

import gloo.numberlink.control.Controller;
import gloo.numberlink.exception.InvalidParametersException;
import gloo.numberlink.model.Direction;
import gloo.numberlink.utils.BoardReader;

import java.util.Scanner;

public class CommandlineInterface {
    private final Controller controller;
    private final Scanner scanner; // for user input

    public CommandlineInterface() {
        scanner = new Scanner(System.in);
        int boardSize = inputBoardSize();
        controller = new Controller(boardSize);
    }

    /**
     * Asks user for board size and handles exceptions
     *
     * @return board size
     */
    private int inputBoardSize() {
        System.out.println("Choose a board size from " + BoardReader.minBoardLength + " to " + BoardReader.maxBoardLength + ".");
        try {
            int boardSize = Integer.parseInt(scanner.nextLine());
            return boardSize;
        } catch(Exception ex) {
            System.out.println("Invalid input, please try again");
            return inputBoardSize();
        }
    }

    /**
     * Prints the current game-board with highlighting.
     */
    private void printGrid(int highlightRow, int highlightCol) {
        controller.printGrid(highlightRow, highlightCol);
    }

    private void printGrid() {
        printGrid(-1, -1);
    }

    public void runGame() {
        System.out.println("Welcome to NumberLink.");
        long startTime = System.currentTimeMillis();
        while (true) {
            if (controller.hasCurrentPath()) {
                int[] lastCellCoordinates = controller.getLastCellCoordinates();
                int lastCellRow = lastCellCoordinates[0];
                int lastCellColumn = lastCellCoordinates[1];
                printGrid(lastCellRow, lastCellColumn);
            } else {
                printGrid();
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
