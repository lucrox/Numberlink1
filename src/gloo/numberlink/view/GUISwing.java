package gloo.numberlink.view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;


public class GUISwing implements Runnable{
    private final int nbRows;
    private final int nbCols;
    private JButton[][] buttons;
    private final Color[] Couleur = new Color[]{Color.ORANGE,Color.CYAN,Color.GREEN,Color.BLUE,Color.YELLOW,Color.MAGENTA,Color.PINK };

    public GUISwing(int nbRows,int nbCols){
        this.nbCols = nbCols;
        this.nbRows = nbRows;
        buttons = new JButton[nbRows][nbCols];
        for (int i = 0; i < nbRows; i++) {
            for (int j = 0; j < nbCols; j++) {
                JButton button = new JButton("");//Integer.toString(i)+Integer.toString(j))
                button.setBackground(Color.WHITE);
                button.setForeground(Color.BLACK);
                button.setFont(new Font("Arial", Font.BOLD, 18));
                button.setEnabled(false);
                buttons[i][j] = button;}}
    }
    public void run() {

        JFrame frame = new JFrame();
        frame.setPreferredSize(new Dimension(900, 900)); // permet d'indiquer la taille par défaut de la fenêtre
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridLayout(nbRows, nbCols));
        for (int i = 0; i < nbRows; i++) {
            for (int j = 0; j < nbCols; j++) {
                JButton button = buttons[i][j];
                panel.add(button);
            }
        }



        frame.add(panel);
        frame.pack();
        frame.setVisible(true);}
        public JButton[][] getButtons(){return buttons;        }
        public void chargeLabel(String[][] labels){

            for(int i = 0;i<nbRows;i++) {

                for(int j =0;j<nbCols;j++){
                    String label = labels[i][j];
                    if(label !=" "){
                        buttons[i][j].setLabel(label);
                        buttons[i][j].setBackground(Couleur[parseInt(label)-1]);
                        buttons[i][j].setEnabled(true);
                        buttons[i][j].addActionListener(new AbstractAction() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JButton button = (JButton) e.getSource();
                                button.setBackground(Color.WHITE);
                            }
                        });
                    }
                }
            }



    }



}
