package gloo.numberlink;

public class Grid {
    private int nbLines;
    private int nbColumns;
    private Cell[][] cells;

    public Grid(int nbLines, int nbColumns) {
        this.nbLines = nbLines;
        this.nbColumns = nbColumns;
        this.cells = new Cell[nbLines][nbColumns];
    }
}
