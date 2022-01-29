package gloo.numberlink.view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class ViewCell extends JButton implements ActionListener {
    private ViewGrid viewGrid;
    private Object monitor;

    public ViewCell(ViewGrid viewGrid) {
        this.viewGrid = viewGrid;
        monitor = viewGrid.getMonitor();
        this.setForeground(Color.BLACK);
        this.setFont(new Font("Arial", Font.BOLD, 18));
        this.setEnabled(false);
        this.addActionListener(this);
    }

    public void chargeLabel(String label) {
        if (label == " ") {
            this.setBackground(Color.WHITE);
        } else {
            this.setEnabled(true);
            this.setLabel(label);
            this.setBackground(this.setColor(label));
        }


    }

    public void chargePath(String label) {

        this.setBackground(this.setColor(label));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        synchronized (monitor) {
            viewGrid.selectCell(this);
            monitor.notify();
        }

    }

    public Color setColor(String label) {
        System.out.println(label);
        switch (label) {
            case " ":
                return new Color(255, 255, 255);
            case "1":
                return new Color(80, 0, 200);
            case "2":
                return new Color(0, 200, 0);
            case "3":
                return new Color(0, 70, 200);
            case "4":
                return new Color(200, 37, 0);
            case "5":
                return new Color(0, 27, 200);
            case "6":
                return new Color(105, 27, 27);
            case "7":
                return new Color(180, 0, 200);
            case "8":
                return new Color(32, 183, 144);
            case "9":
                return new Color(239, 228, 2);
            case "10":
                return new Color(159, 118, 222);
            case "11":
                return new Color(194, 92, 19);
            case "12":
                return new Color(24, 0, 35);
            case "13":
                return new Color(159, 144, 40);
            default:
                return Color.WHITE;
        }
    }
}
