package gloo.numberlink;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        PuzzleGenerator gen = new PuzzleGenerator();
        int[][] puzzle  = gen.generate(9,9);
        for (int[] tab: puzzle) {
            for (int s: tab) {
                System.out.print(s + "\t");
            }
            System.out.println("\n");
        }
    }
}
