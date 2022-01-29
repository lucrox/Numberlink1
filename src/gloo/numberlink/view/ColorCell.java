package gloo.numberlink.view;

import java.awt.*;

public class ColorCell {
    Color color = Color.WHITE;
    public void setColor(String label) {
        switch(label){
            case " ":  color = new Color(255, 255, 255);
            case "1":  color = new Color(80, 0, 200);
            case "2":  color = new Color(0, 200, 0);
            case "3":  color = new Color(0, 70, 200);
            case "4":  color = new Color(200, 37, 0);
            case "5":  color = new Color(0, 27, 200);
            case "6":  color = new Color(105, 27, 27);
            case "7":  color = new Color(180, 0, 200);
            case "8":  color = new Color(32, 183, 144);
            case "9":  color = new Color(239, 228, 2);
            case "10":  color = new Color(159, 118, 222);
            case "11":  color = new Color(194, 92, 19);
            case "12":  color = new Color(24, 0, 35);
            case "13":  color = new Color(159, 144, 40);}

    }

    public Color getColor(){
        return color;
    }
}
