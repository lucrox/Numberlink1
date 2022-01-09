package gloo.numberlink;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


    //TODO: Remove comment below
    // J’ai changé cells du type tableau en type ArrayList, en gros c’est équivalent aux listes Python
    // Comme ça on n’a pas à recréer un nouveau tableau et recopier tous les éléments


public class Path {
    private ArrayList<Cell> cells;
    private Tag tag;


    //TODO: remove comment below
    // Path a besoin de connaître son tag, j’ai rajouté this au paramètre de Path()
    public Path(Tag tag) {
        this.cells = new ArrayList<Cell>();
        this.tag = tag;
    }

    public void addCell(Cell cell){
        cells.add(cell);
    }

    public boolean advance(Direction dir){
        Cell cell = cells.get(cells.size() -1);
        Cell nextCell = cell.getNeighbor(dir);
        return nextCell.acceptPath(this);
    }

}
