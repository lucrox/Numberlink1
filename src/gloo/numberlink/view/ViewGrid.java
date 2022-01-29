package gloo.numberlink.view;

import gloo.numberlink.control.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static java.lang.Integer.parseInt;

public class ViewGrid extends JPanel {
    private ViewCell[][] viewCells;
    private Controller controller;


    public ViewGrid(Controller controller){

        super(new GridLayout(controller.getNbRows(),controller.getNbCols()));
        int nbRows = controller.getNbRows();
        int nbCols = controller.getNbCols();
        this.controller = controller;
        viewCells = new ViewCell[nbRows][nbCols];



    }

    public void chargeLabel(String[][] labels) {
        int nbRows = controller.getNbRows();
        int nbCols = controller.getNbCols();
        for (int i = 0; i < nbRows; i++) {

            for (int j = 0; j < nbCols; j++) {
                viewCells[i][j].chargeLabel(labels[i][j]);
                this.add(viewCells[i][j]);

            }
        }
    }
    public void selectCell(ViewCell viewCell){
        int [] coord = new int[2];
        for (int row = 0; row < controller.getNbRows(); row++) {
            for (int col = 0; col < controller.getNbCols(); col++) {
                if (viewCells[row][col] == viewCell) {
                    coord = new int[]{row, col};
                }
            }
        }
       controller.selectCell(coord[0], coord[1]);
    }

    public void chargePath(int[] coord, String label){
        viewCells[coord[0]][coord[1]].chargePath(label);
    }

    }


