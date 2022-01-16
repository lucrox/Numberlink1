package gloo.numberlink.model;

import java.util.ArrayList;
import java.util.List;

public class Path {
    private final List<Cell> cells;
    private final Tag tag;

    public Path(Tag tag) {
        this.cells = new ArrayList<>();
        this.tag = tag;
    }

    public Tag getTag() {
        return tag;
    }

    /**
     * Adds the cell to the path if it is not already present.
     *
     * @param cell the cell we want to add to the path
     */
    public void addCell(Cell cell) {
        if (!cells.contains(cell)) cells.add(cell);
    }

    /**
     * Gets the cell that's last added to the path.
     *
     * @return last added cell
     */
    private Cell getLastCell() {
        return cells.get(cells.size() - 1);
    }

    /**
     * Determines whether the path is complete, by looking at whether the path contains more than one cell, and if
     * the last cell is an end cell.
     *
     * @return whether the path has reached its end
     */
    public boolean isEndReached() {
        return (cells.size() > 1 && getLastCell().hasEnd());
    }

    /**
     * Advances the path in the indicated direction with respect to the previous cell.
     *
     * @param dir direction of advancing
     * @return whether a new cell has been added to the path
     */
    public boolean advance(Direction dir) {
        Cell nextCell = this.getLastCell().getNeighbor(dir);
        return nextCell.acceptPath(this);
    }

    public String getLabel() {
        return tag.getLabel();
    }

    // for debugging
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Path with following cells: \n");
        for (Cell cell : this.cells) {
            sb.append(cell).append("\n");
        }
        sb.append("End of path");
        return sb.toString();
    }

}
