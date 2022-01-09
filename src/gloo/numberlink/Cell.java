package gloo.numberlink;

public class Cell {
    private End end;
    private boolean isAvailable;
    private final int coordX;
    private final int coordY;

    public Cell(int coordX, int coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }
}
