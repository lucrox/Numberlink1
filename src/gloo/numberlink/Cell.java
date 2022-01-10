package gloo.numberlink;

public class Cell {
    private End end;
    private boolean isAvailable = true;
    private final Grid grid;
    private Path path;
//    private final int coordX;
//    private final int coordY;

    /**
     * Constructor for initially free cell
     *
     * @param grid the grid that contains the cell
     */
    public Cell(Grid grid) {
        this.grid = grid;
    }

    /**
     * Constructor for initially numbered cell
     *
     * @param grid the grid that contains the cell
     * @param end  the end of the cell
     */
    public Cell(Grid grid, End end) {
        this.grid = grid;
        this.end = end;
    }

    // TODO : Remove comment : J’ai enlevé l’attribut hasEnd parce que c’est de la redondance de donnée
    public boolean hasEnd() {
        return (this.end != null);
    }

    /**
     * @return whether the cell is currently part of a path
     */
    public boolean hasPath() {
        return !isAvailable;
    }

    public String getLabel() {
        if (this.hasEnd()) {
            return this.end.getTag().toString();
        } else if (this.hasPath()) {
            return this.path.getTag().toString();
        } else {
            return "x";
        }
    }

    public String toString() {
        int[] coordinates = grid.getCellCoordinates(this);
        int row = coordinates[0];
        int col = coordinates[1];
        return String.format("Cell( row: %d, column: %d, label: %s)", row, col, getLabel());
    }

    public Path createNewPath() {
        if (!this.hasEnd()) {
            return null;
        }
        Path path = end.createNewPath();
        path.addCell(this);
        this.path = path;
        isAvailable = false;
        return path;
    }

    public boolean acceptPath(Path path) {
        if (!isAvailable || !this.hasEnd()) {
            return false;
        }
        path.addCell(this);
        this.path = path;
        isAvailable = false;
        return true;
    }

    public Cell getNeighbor(Direction dir) {
        return grid.getNeighbor(this, dir);
    }

}