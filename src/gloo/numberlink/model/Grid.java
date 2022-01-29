package gloo.numberlink.model;

import gloo.numberlink.utils.BoardReader;

import java.io.IOException;

public class Grid {
    private final int nbRows, nbCols;

    /**
     * A matrix of cell objects is stored in the grid.
     */
    private final Cell[][] cells;

    public Grid(int size) throws IOException, ClassNotFoundException {
        nbRows = size;
        nbCols = size;
        cells = new Cell[nbRows][nbCols];

        // Read and deserialize the board file into integer matrix
        int[][] board;
        board = BoardReader.readBoard(size);

        // Initialize an array of tags
        int labelCount = BoardReader.getLabelCount(board);
        Tag[] tags = new Tag[labelCount];
        for (int label = 1; label <= labelCount; label++) {
            tags[label - 1] = new Tag(label);
        }

        // Fill the cell matrix
        for (int row = 0; row < nbRows; row++) {
            for (int col = 0; col < nbCols; col++) {
                if (board[row][col] == 0) { // 0 represents empty cell
                    cells[row][col] = new Cell(this); // empty cell
                } else {
                    int label = board[row][col];
                    cells[row][col] = new Cell(this, new End(tags[label - 1])); // numbered cell
                }
            }
        }
    }


    /**
     * Returns a matrix of Strings, each being the string representation of the cell (e.g. 1, 2, 3, 4 or blank space).
     *
     * @return Labels of the cells
     */
    public String[][] getLabels() {
        String[][] labelMatrix = new String[nbRows][nbCols];
        for (int row = 0; row < nbRows; row++) {
            for (int col = 0; col < nbCols; col++) {
                labelMatrix[row][col] = cells[row][col].getLabel();
            }
        }
        return labelMatrix;
    }

    /**
     * Scans the cells' matrix to find the coordinates of the cell.
     *
     * @param cell the cell for which we want to get coordinates.
     * @return coordinates of the cell
     */
    public int[] getCellCoordinates(Cell cell) {
        for (int row = 0; row < nbRows; row++) {
            for (int col = 0; col < nbCols; col++) {
                if (cells[row][col] == cell) {
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * Does an exhaustive search in the cells' matrix to find the coordinates of the original cell, then return the
     * neighbor cell according to the direction.
     *
     * @param cell      the cell we want to get neighbor from.
     * @param direction the direction of the neighbor with respect to the cell
     * @return the neighboring cell in the specified direction
     */
    public Cell getNeighbor(Cell cell, Direction direction) {

        int[] cellCoordinates = this.getCellCoordinates(cell);

        int neighborRow = cellCoordinates[0]; // Initialize neighbor coordinates to cell coordinates
        int neighborCol = cellCoordinates[1];

        // Calculate neighbor coordinates based on direction
        switch (direction) {
            case UP -> neighborRow -= 1;
            case DOWN -> neighborRow += 1;
            case LEFT -> neighborCol -= 1;
            case RIGHT -> neighborCol += 1;
        }

        // Return the cell itself the neighbor coordinates are invalid
        if (neighborRow < 0 || neighborCol < 0 || neighborRow >= nbRows || neighborCol >= nbCols) {
            return cell;
        }
        return cells[neighborRow][neighborCol];
    }

    /**
     * Determines whether the row and column coordinates are valid indices of the cells' matrix.
     *
     * @param row the row index
     * @param col the column index
     * @return whether the coordinates are valid
     */
    public boolean isCoordinatesValid(int row, int col) {
        return row >= 0 && col >= 0 && row < nbRows && col < nbCols;
    }

    /**
     * Determines whether we can start a new path from the chosen coordinates, and returns the newly created path.
     * The method returns null if the new path isn't created successfully.
     *
     * @param row the row index
     * @param col the column index
     * @return the newly created path if path creation was successful, null otherwise
     */
    public Path createNewPath(int row, int col) {
        return isCoordinatesValid(row, col) ? cells[row][col].createNewPath() : null;
    }

    /**
     * Scans cells matrix to check if every cell has a path.
     * Returns false immediately when a cell doesn't have a path yet.
     *
     * @return whether the board game is finished.
     */
    public boolean isFinished() {
        for (int row = 0; row < nbRows; row++) {
            for (int col = 0; col < nbCols; col++) {
                if (!cells[row][col].hasPath()) return false;
            }
        }
        return true;
    }

    public int getNbCols() {
        return nbCols;
    }

    public int getNbRows() {
        return nbRows;
    }

    public Cell[][] getCells() {
        return cells;
    }
}
