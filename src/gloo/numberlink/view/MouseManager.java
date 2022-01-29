package gloo.numberlink.view;

import gloo.numberlink.control.Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseManager implements MouseListener {
    private Controller controller;
    public MouseManager(Controller controller){
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
        controller.selectCell(controller.getNbCols()*my/900,controller.getNbRows()*mx/900);



        }



    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
