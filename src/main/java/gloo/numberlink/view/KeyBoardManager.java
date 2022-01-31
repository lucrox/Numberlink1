package gloo.numberlink.view;

import gloo.numberlink.control.Controller;
import gloo.numberlink.model.Direction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardManager implements KeyListener {
    private Controller controller;
    private GUIDisplayer GUI;
    public KeyBoardManager(Controller controller, GUIDisplayer GUI) {
        this.controller = controller;
        this.GUI = GUI;

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        controller.continuePath(switch (e.getKeyCode()){
            case KeyEvent.VK_UP -> Direction.UP;
            case KeyEvent.VK_DOWN -> Direction.DOWN;
            case KeyEvent.VK_LEFT -> Direction.LEFT;
            case KeyEvent.VK_RIGHT -> Direction.RIGHT;
            default -> null;
        });
        GUI.repaint();

        }

    }

