package tests;

import gloo.numberlink.model.Grid;


public class GridTests {
    public static void main(String[] args) {
//        testNewPath();
    }

    public static void testPrintGrid() {
        Grid grid = new Grid();
        grid.printGrid();
    }

//    public static void testNewPath() {
//        Grid grid = new Grid();
//        Scanner sc = new Scanner(System.in);
//        Path path = grid.createNewPath(0, 1);
//        while (true) {
//            String input = sc.nextLine().toLowerCase();
//            if (input == "quit") {
//                System.out.println("Thank you for playing this game. Good bye.");
//                break;
//            }
//            Direction dir = null;
//            switch (input) {
//                case "up":
//                    dir = Direction.UP;
//                    break;
//                case "down":
//                    dir = Direction.DOWN;
//                    break;
//                case "left":
//                    dir = Direction.LEFT;
//                    break;
//                case "right":
//                    dir = Direction.RIGHT;
//                    break;
//            }
//            if (dir == null) {
//                System.out.println("Invalid input, please try again:");
//                break;
//            }
//
//        }
//    }
}
