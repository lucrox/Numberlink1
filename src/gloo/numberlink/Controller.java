package gloo.numberlink;

public class Controller {
    private final Grid grid;
    private Path currPath;

    public Controller(int nbRows, int nbCols) {
        grid = new Grid(nbRows, nbCols);
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
        return grid.isFinished();
    }
}
