package gloo.numberlink.view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class ViewCell extends JButton implements ActionListener {
    private ViewGrid viewGrid;
    private ColorCell colorCell = new ColorCell();
    private Object monitor;

    public ViewCell(ViewGrid viewGrid){
        this.viewGrid = viewGrid;
        monitor = viewGrid.getMonitor();
        this.setForeground(Color.BLACK);
        this.setFont(new Font("Arial", Font.BOLD, 18));
        this.setEnabled(false);
        this.addActionListener(this);
    }
    public void chargeLabel(String label){
        if(label == " "){
        this.setBackground(Color.WHITE);
        }
        else {
            this.setEnabled(true);
            this.setLabel(label);
            colorCell.setColor(label);
            this.setBackground(colorCell.setColor(label));
        }


    }

    public void chargePath(String label){

        this.setBackground(colorCell.setColor(label));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        synchronized (monitor) {
            viewGrid.selectCell(this);
            monitor.notify();
        }

    }
}
