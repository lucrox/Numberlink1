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
        int[][] puzzle = PuzzleGenerator.generate();
        this.cells = new Cell[9][9];
        this.nbRows = 9;
        this.nbCols = 9;

        Tag[] tags = new Tag[6]; //Hard coded

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


    //TODO: remove after asking professor how to get cell
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

    //TODO: Ask professor how grid can get the neighbor without exhaustive search
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

    public boolean isCoordinatesValid(int row, int col) {
        return row >= 0 && col >= 0 && row < nbRows && col < nbCols;
    }

    //TODO: differentiate invalid coordinates and cell not available
    public Path createNewPath(int row, int col) {
        return isCoordinatesValid(row, col) ? cells[row][col].createNewPath() : null;
    }

    /**
     * Exhaustively goes through the cells and check if every cell has a path.
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
