package gloo.numberlink;

public class Cell {
    private End end;
    private boolean isAvailable;

    public Path createNewPath(){
        Path  path = End.createNewPath();
        path.addCell(this);
        return path;

    }





}
