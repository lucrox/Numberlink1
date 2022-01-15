package gloo.numberlink;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class PuzzleReader {

    public static boolean check(int[][] board) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] row : board) {
            for (int val : row) {
                if (val == 0) {
                    continue;
                }
                if (!map.containsKey(val)) {
                    map.put(val, 1);
                    continue;
                }
                if (map.get(val) >= 2) {
                    System.out.println(val);
                    System.out.println("greater than 2");
                    return false;
                }
                map.put(val, map.get(val) + 1);
            }
        }
        for (int k : map.keySet()) {
            if (map.get(k) != 2) {
                System.out.println(k);
                System.out.println("not 2 not good good");
                return false;
            }
        }
        System.out.println("good.");
        return true;
    }

    public static void main(String[] args) throws Exception {

        // {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        int[][] before = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 6, 0, 0, 3, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0},
                {0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9},
                {0, 2, 0, 0, 0, 0, 0, 0, 0, 7, 0, 0},
                {0, 0, 0, 5, 0, 5, 8, 6, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 7, 0, 9, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 8},
        };

        String path = "boards/12_12_board.dat";
        check(before);

        int[][] after = null; // will deserialize to this

        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(before);

            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream iis = new ObjectInputStream(fis);
            after = (int[][]) iis.readObject();

        } catch (Exception e) {
            System.out.println("error");
        }

    }
}
