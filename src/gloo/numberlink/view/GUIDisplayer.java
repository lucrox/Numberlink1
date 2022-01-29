package gloo.numberlink.view;

import gloo.numberlink.control.Controller;

import javax.swing.*;
import java.awt.*;

public class GUIDisplayer implements Runnable{
    private Controller controller;
    private ViewGrid viewGrid;
    private JFrame frame;


    public GUIDisplayer(Controller controller, JFrame frame){
        this.controller = controller;
        this.viewGrid = new ViewGrid(controller);
        this.frame = frame;
    }

    public void run() {


        frame.setPreferredSize(new Dimension(900, 900)); // permet d'indiquer la taille par défaut de la fenêtre
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewGrid = new ViewGrid(controller);
        frame.add(viewGrid);
        frame.pack();
        frame.setVisible(true);
        viewGrid.chargeLabel(controller.getLabels());
        frame.repaint();

    }

    public void chargeLabel(String[][] labels){
        viewGrid.chargeLabel(labels);
        frame.repaint();
    }

    public void displayChoice(int[] coord, String label){
        viewGrid.chargePath(coord,label);
        frame.repaint();
    }



}