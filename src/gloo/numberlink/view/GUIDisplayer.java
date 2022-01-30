package gloo.numberlink.view;

import gloo.numberlink.control.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class GUIDisplayer implements Runnable{
    private Controller controller;
    private final int width = 900;
    private final int height = 900;
    JFrame frame;

    public GUIDisplayer(Controller controller){
        this.controller = controller;
        frame = new JFrame();
    }



    @Override
    public void run() {
        ViewGrid viewGrid = new ViewGrid(controller);
        frame.setPreferredSize(new Dimension(width, height)); // permet d'indiquer la taille par défaut de la fenêtre
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(viewGrid);
        frame.setVisible(true);
        frame.addMouseListener(new MouseManager(controller));
        frame.addKeyListener(new KeyBoardManager(controller,this));
        frame.pack();
    }

    public void repaint(){
        frame.repaint();
    }




}
