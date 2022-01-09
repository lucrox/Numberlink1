package gloo.numberlink;

public class Cell {
    private End end;
    private boolean isAvailable = true;
    private boolean hasEnd;
    private Grid grid;
    private final int coordX;
    private final int coordY;

    public Cell(int coordX, int coordY, boolean hasEnd, End end,Grid grid) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.hasEnd = hasEnd;
        this.grid = grid;
        if (hasEnd) this.end =end;
    }
    public Path createNewPath(){
        if(hasEnd){
        Path  path = End.createNewPath();
        path.addCell(this);
        isAvailable = false;
        return path;
        }

    }
    public boolean acceptPath(Path path){
        if(isAvailable && hasEnd){
        path.addCell(this);
        isAvailable = false;
        return true;}
        else return false;
    }

    public Cell getNeighbor(Direction dir){
        return grid.getNeighbor(this, dir);
    }


    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

}
