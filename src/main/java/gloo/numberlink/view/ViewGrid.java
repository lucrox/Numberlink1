package gloo.numberlink.view;

import gloo.numberlink.control.Controller;

import javax.swing.*;
import java.awt.*;

import static gloo.numberlink.utils.ColorCell.linkColorLabel;

public class ViewGrid extends JPanel {

    private Controller controller;
    private final int width_frame;
    private final int height_frame;



    public ViewGrid(Controller controller, int width_frame, int height_frame){
        super();
        int nbRows = controller.getNbRows();
        int nbCols = controller.getNbCols();
        this.controller = controller;
        this.width_frame = width_frame;
        this.height_frame = height_frame;
        String[][] labels = controller.getLabels();
            }
    @Override
    public void paint(Graphics g) {

        int nbRows = controller.getNbRows();
        int nbCols = controller.getNbCols();
        int width_rec = width_frame/nbCols; //On calcule la taille des rectangles
        int height_rec = height_frame/nbRows;
        String[][] labels = controller.getLabels();
        for(int i=0; i<nbRows;i++){
            for(int j=0;j<nbCols;j++){
                String label = labels[i][j];


                Color color = linkColorLabel(label);
                g.setColor(color);
                g.fillRect(j*height_rec,i*width_rec,width_rec,height_rec);
                g.setColor(Color.BLACK);
                if(controller.hasEnd(i,j)){
                g.setFont(new Font("Arial", Font.BOLD, 18));
                g.drawString(label,(j*height_rec+height_rec/2),(i*width_rec+width_rec/2));
                }


            }
        }
        }




}
