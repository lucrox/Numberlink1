package gloo.numberlink.control;

import gloo.numberlink.model.Cell;
import gloo.numberlink.model.Direction;
import gloo.numberlink.model.Grid;
import gloo.numberlink.model.Path;

import java.io.IOException;

public class Controller {
    private final Grid grid;

    /**
     * currPath indicates the current path the player is advancing on. If currPath is null, the player must select
     * a new cell to start a new path.
     */
    private Path currPath;
    public Controller(int size) throws Exception {
        grid = new Grid(size);
    }

    /**
     * Determines whether there is an unfinished path the player is advancing on.
     */
    public boolean hasCurrentPath() {
        return (currPath != null);
    }

    /**
     * Determines whether the row and col coordinates correspond to a valid cell coordinate in the grid.
     *
     * @param row the row coordinate
     * @param col the column coordinate
     * @return whether the coordinates are valid
     */
    public boolean isCoordinatesValid(int row, int col) {
        return grid.isCoordinatesValid(row, col);
    }

    public String[][] getLabels() {
        return grid.getLabels();
    }

    /**
     * Starts a new path from the chosen coordinates.
     *
     * @param row the row index
     * @param col the column index
     * @return whether a new path is successfully created
     */
    public boolean selectCell(int row, int col) {
        Path newPath = grid.createNewPath(row, col); // null if the grid failed to create a new path
        if (newPath == null) {
            return false;
        }
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
    public void continuePath(Direction dir){
        if(this.hasCurrentPath()) {
            System.out.println(dir);
            boolean isGameFinished = this.action(dir);
            if (isGameFinished) {

                System.out.println("Congratulations, you won !");

            }
        }
    }


    // for highlight functions in the console
    public int[] getLastCellCoordinates() {
        Cell lastCell = currPath.getLastCell();
        return grid.getCellCoordinates(lastCell);
    }


    public int getNbCols(){
        return grid.getNbCols();
    }
    public int getNbRows(){
        return grid.getNbRows();
    }

    public Grid getGrid(){
        return grid;
    }

}
