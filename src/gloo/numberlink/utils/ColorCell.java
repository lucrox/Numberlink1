package gloo.numberlink.utils;

import java.awt.*;

/**
 * This class is here to defines the colors used for each label, it is an aesthetic choice changeable here
 */
public class ColorCell {
    public static Color linkColorLabel(String label) {
        System.out.println(label);
        return switch (label) {
            case " " -> new Color(255, 255, 255);
            case "1" -> new Color(80, 0, 200);
            case "2" -> new Color(0, 200, 0);
            case "3" -> new Color(0, 70, 200);
            case "4" -> new Color(200, 37, 0);
            case "5" -> new Color(0, 27, 200);
            case "6" -> new Color(105, 27, 27);
            case "7" -> new Color(180, 0, 200);
            case "8" -> new Color(32, 183, 144);
            case "9" -> new Color(239, 228, 2);
            case "10" -> new Color(159, 118, 222);
            case "11" -> new Color(194, 92, 19);
            case "12" -> new Color(24, 0, 35);
            case "13" -> new Color(159, 144, 40);
            default -> Color.WHITE;
        };
    }
}
