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

    //TODO: remove after asking professor how to get cell
    private int[] getCellCoordinates(Cell cell) {
        for (int i = 0; i < nbLines; i++) {
            for (int j = 0; j < nbColumns; j++) {
                if (cells[i][j] == cell) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    //TODO: Ask professor how grid can get the neighbor without exhalstif search
    public Cell getNeighbor(Cell cell, Direction direction) {

        int[] cellCoordinates = this.getCellCoordinates(cell);

        int neighborX = cellCoordinates[0]; // Initialize neighbor coordinates to cell coordinates
        int neighborY = cellCoordinates[1];

        // Calculate neighbor coordinates based on direction
        switch (direction) {
            case UP:
                neighborX -= 1;
                break;
            case DOWN:
                neighborX += 1;
                break;
            case LEFT:
                neighborY -= 1;
                break;
            case RIGHT:
                neighborY += 1;
                break;
        }

        // Return the cell itself the neighbor coordinates are invalid
        if (neighborX < 0 || neighborY < 0 || neighborX >= nbLines || neighborY >= nbColumns) {
            return cell;
        }
        return cells[neighborX][neighborY];
    }

}
