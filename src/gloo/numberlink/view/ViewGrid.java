package gloo.numberlink.view;

import gloo.numberlink.control.Controller;

import javax.swing.*;
import java.awt.*;

import static gloo.numberlink.utils.ColorCell.linkColorLabel;

public class ViewGrid extends JPanel {

    private Controller controller;



    public ViewGrid(Controller controller){
        super();
        int nbRows = controller.getNbRows();
        int nbCols = controller.getNbCols();
        this.controller = controller;
        String[][] labels = controller.getLabels();
            }
    @Override
    public void paint(Graphics g) {

        int nbRows = controller.getNbRows();
        int nbCols = controller.getNbCols();
        int width = 900/nbCols;
        int height = 900/nbRows;
        String[][] labels = controller.getLabels();
        for(int i=0; i<nbRows;i++){
            for(int j=0;j<nbCols;j++){
                String label = labels[i][j];


                Color color = linkColorLabel(label);
                g.setColor(color);
                g.fillRect(j*height,i*width,width,height);
                g.setColor(Color.BLACK);
                if(controller.hasEnd(i,j)){
                g.setFont(new Font("Arial", Font.BOLD, 18));
                g.drawString(label,(j*height+height/2),(i*width+width/2));
                }


            }
        }
        }




}
