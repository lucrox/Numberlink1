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

    public void selectCell(int row, int col) {
        currPath = grid.createNewPath(row, col);
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
