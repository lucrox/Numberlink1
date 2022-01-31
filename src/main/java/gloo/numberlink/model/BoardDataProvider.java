package gloo.numberlink.model;

/**
 * An interface for the view components. For providing data useful for user interface only.
 */
public interface BoardDataProvider {
    /**
     * @return A matrix of Strings, each representing what to be displayed for a cell.
     */
    String[][] getLabels();

    int getNbRows();

    int getNbCols();

    /**
     * Determines whether the cell as the indicated row and column is an end cell for highligting purposes.
     * @param row the row
     * @param col the column
     * @return whether the cell at the corresponding row and column is an end cell
     */
    boolean hasEnd(int row, int col);
}
