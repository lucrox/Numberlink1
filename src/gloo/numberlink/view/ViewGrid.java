package gloo.numberlink.view;

import gloo.numberlink.control.Controller;

import javax.swing.*;

public class ViewGrid extends JFrame {
    private ViewCell[][] viewCells;
    private Controller controller;



    public ViewGrid(Controller controller){
        super();
        int nbRows = controller.getNbRows();
        int nbCols = controller.getNbCols();
        this.controller = controller;
        viewCells = new ViewCell[nbRows][nbCols];
        String[][] labels = controller.getLabels();

        for(int i=0; i<nbRows;i++){
            for(int j=0;j<nbCols;j++){
                viewCells[i][j] = new ViewCell(labels[i][j],this);
                this.add(viewCells[i][j]);
                repaint();

            }
        }
}

    public int getNbRows() {
        return controller.getNbRows();
    }

    public int getNbCols() {
        return controller.getNbCols();
    }

    public int[] getCoordinates(ViewCell viewCell) {
        int nbRows = controller.getNbRows();
        int nbCols = controller.getNbCols();
        for (int row = 0; row <nbRows; row++) {
            for (int col = 0; col < nbCols; col++) {
                if (viewCells[row][col] == viewCell) {
                    return new int[]{row, col};
                }
            }
        }
    return new int[]{-1,-1};
    }
}
