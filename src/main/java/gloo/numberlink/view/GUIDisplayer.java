package gloo.numberlink.view;

import gloo.numberlink.control.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class GUIDisplayer implements Runnable{
    private Controller controller;
    private final int width = 500; //On détermine la taille de la fenêtre, non accessible au joueur
    private final int height = 500;
    JFrame frame;

    public GUIDisplayer(Controller controller){
        this.controller = controller;
        frame = new JFrame();
    }



    @Override
    public void run() { //Classical Swing things
        ViewGrid viewGrid = new ViewGrid(controller,width,height);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(viewGrid);
        frame.setVisible(true);
        frame.addMouseListener(new MouseManager(controller,width,height));
        frame.addKeyListener(new KeyBoardManager(controller,this));
        frame.pack();
    }

    /**
     * Used by the Keylistener to repaint after an action
     */
    public void repaint(){
        frame.repaint();
    }




}
