package gloo.numberlink.model;

public class Cell {
    private End end;
    private boolean isAvailable = true;
    private final Grid grid;
    private Path path;

    /**
     * Constructor for initially inoccupied
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
     * @param end  the end of the cell which contains the tag information
     */
    public Cell(Grid grid, End end) {
        this.grid = grid;
        this.end = end;
    }


    public boolean hasEnd() {
        return (this.end != null);
    }

    /**
     * @return whether the cell is currently part of a path
     */
    public boolean hasPath() {
        return !isAvailable;
    }

    /**
     * Returns a label string for representing the cell visually in the command line interface.
     *
     * @return the label
     */
    public String getLabel() {
        if (hasEnd()) { // get label from the end
            return end.getTag().toString();
        } else if (hasPath()) { // get label from the path
            return path.toString();
        } else {
            return "x"; // get default label for unoccupied x
        }
    }

    public Tag getTag() {
        if (this.hasEnd()) return this.end.getTag();
        return this.path.getTag();
    }


    // Returns the coordinates and the label of the cell for debugging purposes
    public String toString() {
        int[] coordinates = grid.getCellCoordinates(this);
        int row = coordinates[0];
        int col = coordinates[1];
        return String.format("Cell( row: %d, column: %d, label: %s)", row, col, getLabel());
    }

    /**
     * Creates a new path starting from the current cell.
     *
     * @return the newly created path
     */
    public Path createNewPath() {
        if (!hasEnd()) return null; // a new path can only start from an end cell
        path = end.createNewPath();
        path.addCell(this);
        isAvailable = false;
        return path;
    }

    /**
     * Checks if the conditions of adding the cell to the path are satisfied, and adds the cell to the path if they are.
     *
     * @param path
     * @return whether the cell is added to the path
     */
    public boolean acceptPath(Path path) {
        // A cell can only belong to one path
        if (!isAvailable) {
            return false;
        }
        // A path can't contain cells with different tags
        if (this.hasEnd()) {
            if (path.getTag() != this.getTag()) {
                return false;
            }
        }
        this.path = path;
        path.addCell(this);
        isAvailable = false;
        return true;
    }

    public Cell getNeighbor(Direction dir) {
        return grid.getNeighbor(this, dir);
    }

}