package gloo.numberlink;

import java.util.Arrays;

public class Path {
    private Cell[] cells;
    private Tag tag;

    public void addCell(Cell cell){
        cells = Arrays.copyOf(cells,cells.length +1);

    }

    public boolean advance(Direction dir){

        Cell cell = cells[cells.length-1];
        Cell nextCell = cell.getNeighbor(dir);
        return nextCell.acceptPath(this);

    }

}
