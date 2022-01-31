package gloo.numberlink.view;

import gloo.numberlink.control.Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseManager implements MouseListener {
    private final Controller controller;
    private final int width_frame;
    private final int height_frame;

    public MouseManager(Controller controller, int width_frame, int height_frame){
        this.width_frame = width_frame;
        this.height_frame = height_frame;
        this.controller = controller;
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        controller.selectCell(controller.getNbCols()*my/width_frame,controller.getNbRows()*mx/height_frame);
        // on trouve sur quelle Cell on a cliqué et on essaye de la séléctionner, le controller s'occupe du reste
        }



    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
