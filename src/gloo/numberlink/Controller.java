package gloo.numberlink;

public class Controller {
    private final Grid grid;
    private Path currPath;

    public Controller(int nbRows, int nbCols) {
        this.grid = new Grid();
    }

    public boolean hasCurrentPath() {
        return (currPath != null);
    }

    public boolean isCoordinatesValid(int row, int col) {
        return grid.isCoordinatesValid(row, col);
    }

    public void printGrid() {
        grid.printGrid();
    }

    /**
     * Starts a new path from the coordinates.
     *
     * @param row the row index
     * @param col the column index
     * @return whether a new path is successfully created
     */
    public boolean selectCell(int row, int col) {
        Path newPath = grid.createNewPath(row, col); // null if the grid failed to create a new path
        if (newPath == null) return false;
        currPath = newPath;
        return true;
    }

    /**
     * Advances the current path in the direction indicated by <code>dir</code>,
     * and checks whether the game has finished.
     *
     * @param dir direction of the next move
     * @return whether the game has finished
     */
    public boolean action(Direction dir) {
        boolean hasPathAdvanced = currPath.advance(dir);
        if (!hasPathAdvanced) return false;
        if (this.currPath.isEndReached()) {
            currPath = null;
        }
        return grid.isFinished();
    }
}
