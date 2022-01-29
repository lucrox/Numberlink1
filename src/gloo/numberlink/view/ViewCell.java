package gloo.numberlink.view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class ViewCell extends JButton implements ActionListener {
    private ViewGrid viewGrid;
    private ColorCell colorCell;

    public ViewCell(ViewGrid grid){
        this.viewGrid = grid;
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
            this.setBackground(colorCell.getColor());
        }


    }

    public void chargePath(String label){
        colorCell.setColor(label);
        this.setBackground(colorCell.getColor());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        viewGrid.selectCell(this);

    }
}
