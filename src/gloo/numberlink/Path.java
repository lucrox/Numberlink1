package gloo.numberlink;

import java.util.ArrayList;

public class Path {
    //TODO: Remove comment below
    // J’ai changé cells du type tableau en type ArrayList, en gros c’est équivalent aux listes Python
    // Comme ça on n’a pas à recréer un nouveau tableau et recopier tous les éléments
    private ArrayList<Cell> cells;
    private final Tag tag;


    //TODO: remove comment below
    // Path a besoin de connaître son tag, j’ai rajouté this au paramètre de Path()
    public Path(Tag tag) {
        this.cells = new ArrayList<>();
        this.tag = tag;
    }

    public Tag getTag() {
        return tag;
    }

    public void addCell(Cell cell){
        if (this.contains(cell)) return;
        cells.add(cell);
    }

    private Cell getLastCell() {
        return cells.get(cells.size() - 1);
    }

    public boolean isEndReached() {
        return (cells.size() > 0 && getLastCell().hasEnd() && getLastCell().getTag() == this.tag);
    }

    public boolean advance(Direction dir){
        Cell nextCell = this.getLastCell().getNeighbor(dir);
        return nextCell.acceptPath(this);
    }

    public boolean contains(Cell cell) {
        return cells.contains(cell);
    }

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
