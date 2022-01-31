package gloo.numberlink.model;

import java.util.ArrayList;
import java.util.List;

public class Path {
    /**
     * cells stores the cell objects that are part of the path, in the order in which they are added.
     */
    private final List<Cell> cells;

    /**
     * Every cell of the path have the same tag, hence the tag is initialized during instantiation.
     */
    private final Tag tag;

    public Path(Tag tag) {
        this.cells = new ArrayList<>(); // For automatic resizing of the list and O(1) time accessing elements.
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
    public Cell getLastCell() {
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
     * @return whether a new cell has been successfully added to the path
     */
    public boolean advance(Direction dir) {
        Cell nextCell = getLastCell().getNeighbor(dir);
        return nextCell.acceptPath(this);
    }

    public String getLabel() {
        return tag.getLabel();
    }

    /**
     * Generates a string representation of the path, with all of its cells.
     * This function is mainly used for debugging purposes.
     *
     * @return the string representation of the path
     */
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
