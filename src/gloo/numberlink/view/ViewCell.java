package gloo.numberlink.view;

import javax.swing.*;
import java.awt.*;

import static gloo.numberlink.view.ColorCell.linkColorLabel;

public class ViewCell extends JPanel {
    private String label;
    private Color color;
    private ViewGrid viewGrid;
    public ViewCell(String label,ViewGrid viewGrid){
        super();
        this.label = label;
        this.viewGrid = viewGrid;
        color = linkColorLabel(label);
    }
    @Override
    public void paint(Graphics g) {
        int[] coord = viewGrid.getCoordinates(this);
        int nbRows = viewGrid.getNbRows();
        int nbCols = viewGrid.getNbCols();
        int width = 900/nbCols;
        int height = 900/nbRows;
        int x = coord[0]*width;
        int y = coord[1]*height;
        System.out.println(x);
        System.out.println(y);


        Color color = this.color;
        g.setColor(color);
        g.fillRect(x,y,width,height);

    }

    public void setColor(Color color) {
        this.color = color;
        this.repaint();
    }
    public Color getColor() {
        return this.color;
    }
}
