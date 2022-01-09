package gloo.numberlink;

public class Cell {
    private End end;
    private boolean isAvailable = true;
    private Grid grid;
//    private final int coordX;
//    private final int coordY;

    public Cell(Grid grid) {
        this.grid = grid;
    }

    public Cell(Grid grid, End end) {
        this.grid = grid;
        this.end = end;
    }

    // TODO : Remove comment : J’ai enlevé l’attribut hasEnd parce que c’est de la redondance de donnée
    public boolean hasEnd() {
        return (this.end != null);
    }

    public boolean hasPath() {
        return !isAvailable;
    }

    public Path createNewPath() {
        if (!this.hasEnd()) {
            return null;
        }
        Path path = end.createNewPath();
        path.addCell(this);
        isAvailable = false;
        return path;
    }

    public boolean acceptPath(Path path) {
        if (!isAvailable || !this.hasEnd()) {
            return false;
        }
        path.addCell(this);
        isAvailable = false;
        return true;
    }

    public Cell getNeighbor(Direction dir) {
        return grid.getNeighbor(this, dir);
    }

}