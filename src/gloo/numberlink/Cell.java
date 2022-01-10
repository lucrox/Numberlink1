package gloo.numberlink;

public class Cell {
    private End end;
    private boolean isAvailable = true;
    private Grid grid;
    private Path currPath;
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
            return this.currPath.getTag().toString();
        } else {
            return "x";
        }
    }

    public Path createNewPath() {
        if (!this.hasEnd()) {
            return null;
        }
        Path path = end.createNewPath();
        path.addCell(this);
        this.currPath = path;
        isAvailable = false;
        return path;
    }

    public boolean acceptPath(Path path) {
        if (!isAvailable || !this.hasEnd()) {
            return false;
        }
        path.addCell(this);
        this.currPath = path;
        isAvailable = false;
        return true;
    }

    public Cell getNeighbor(Direction dir) {
        return grid.getNeighbor(this, dir);
    }

}