package gloo.numberlink.view;

import gloo.numberlink.control.Controller;

import javax.swing.*;
import java.awt.*;

public class GUIDisplayer implements Runnable{
    private Controller controller;
    private ViewGrid viewGrid;

    public GUIDisplayer(Controller controller, ViewGrid viewGrid){
        this.controller = controller;
        this.viewGrid = viewGrid;
    }

    public void run() {

        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(900, 900)); // permet d'indiquer la taille par défaut de la fenêtre
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewGrid = new ViewGrid(controller);
        frame.add(viewGrid);
        frame.pack();
        frame.setVisible(true);
    }



}