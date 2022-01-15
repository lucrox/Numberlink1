package gloo.numberlink.view;

import gloo.numberlink.control.Controller;
import gloo.numberlink.model.Direction;

import java.util.Scanner;

public class CommandlineInterface {
    public static Controller controller = new Controller(9, 9);

    public static void main(String[] args) {
        runGame();
    }


    private static void printGrid() {
        controller.printGrid();
    }

    private static void runGame() {
        System.out.println("Welcome to NumberLink.");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printGrid();
            if (!controller.hasCurrentPath()) {
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
                controller.action(dir);
            }
        }
        System.out.println("Thanks for playing the game. Goodbye!");
        scanner.close();
    }
}
