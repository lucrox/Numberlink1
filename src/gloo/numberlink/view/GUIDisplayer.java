package gloo.numberlink.view;

import gloo.numberlink.control.Controller;

import javax.swing.*;
import java.awt.*;

public class GUIDisplayer implements Runnable{
    private Controller controller;

    public GUIDisplayer(Controller controller){
        this.controller = controller;
    }



    @Override
    public void run() {
        ViewGrid viewGrid = new ViewGrid(controller);
        viewGrid.setPreferredSize(new Dimension(900, 900)); // permet d'indiquer la taille par défaut de la fenêtre
        viewGrid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewGrid.setVisible(true);

        viewGrid.pack();
    }




}
