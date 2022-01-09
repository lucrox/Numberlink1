package gloo.numberlink;

public class Cell {
    private End end;
    private boolean isAvailable = true;
    private boolean hasEnd;
    private final int coordX;
    private final int coordY;

    public boolean hasPath() {
        return !isAvailable;
    }

    public Path createNewPath(){
        Path  path = End.createNewPath();
        path.addCell(this);
        isAvailable = false;
        return path;

    }
    public boolean acceptPath(Path path){
        if(isAvailable && hasEnd){
        path.addCell(this);
        isAvailable = false;
        return true;}
        else return false;
    }

    public Cell(int coordX, int coordY, boolean hasEnd, End end) {
        this.coordX = coordX;
        this.coordY = coordY;
        this.hasEnd = hasEnd;
        if (hasEnd) this.end =end;
    }


    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

}
