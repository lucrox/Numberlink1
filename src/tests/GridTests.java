package tests;

import gloo.numberlink.Grid;

public class GridTests {
    public static void main(String[] args) {
        testPrintGrid();
    }

    public static void testPrintGrid() {
        Grid grid = new Grid();
        grid.printGrid();
    }

    public static void testNewPath() {
        Grid grid = new Grid();
        grid.printGrid();
        System.out.println(grid.createNewPath(0, 1));
    }
}
