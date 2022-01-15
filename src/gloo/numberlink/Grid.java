package gloo.numberlink;

public class Grid {
    private final int nbRows, nbCols;
    private final Cell[][] cells;

    //TODO: Make an actual random generation of grid
    public Grid(int nbRows, int nbColumns) {
        this.nbRows = nbRows;
        this.nbCols = nbColumns;
        this.cells = new Cell[nbRows][nbColumns];
    }

    // For testing purposes
    public Grid() {

        this.cells = new Cell[9][9];
        this.nbRows = 9;
        this.nbCols = 9;
        int[][] puzzle = PuzzleGenerator.generate(nbRows,nbCols);

        Tag[] tags = new Tag[10]; //Hard coded
        System.out.println(puzzle.length);
        System.out.println(puzzle[0].length);
        for (int row = 0; row < nbRows; row++) {
            for (int col = 0; col < nbCols; col++) {
                if (puzzle[row][col] == -1) {
                    cells[row][col] = new Cell(this);
                } else {
                    int tagLabel = puzzle[row][col];
                    if (tags[tagLabel] == null) {
                        tags[tagLabel] = new Tag(tagLabel);
                    }
                    cells[row][col] = new Cell(this, new End(tags[tagLabel]));
                }
            }
        }
    }

    public void printGrid() {
        for (int row = 0; row < 2 * nbRows + 4; row++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.print("   ");
        for (int row = 0; row < nbRows; row++) {
            System.out.print(row + " ");
        }
        System.out.println();
        for (int row = 0; row < nbRows; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < nbCols; col++) {
                System.out.print("|" + cells[row][col].getLabel());
            }
            System.out.println("|");
        }
        for (int row = 0; row < 2 * nbRows + 4; row++) {
            System.out.print("-");
        }
    }


    /**
     * Scans the cells matrix to find the coordinates of the cell.
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
     * Does an exhaustive search in the cells matrix to find the coordinates of the original cell, then return the
     * neighbor cell according to the direction.
     *
     * @param cell the cell we want to get neighbor from.
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
     * Determines whether the row and column coordinates are valid indices of the cells matrix.
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
     * @return the newly created path
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

}
