package gloo.numberlink;

public class PuzzleGenerator {

    //TODO: make puzzle generator generate random puzzles
    public static int[][] generate() {
        return new int[][]{
                {0, 1, 2, -1, -1, -1, 3, -1, -1},
                {-1, -1, -1, -1, 4, -1, 0, -1, -1},
                {-1, -1, -1, -1, -1, -1, 5, -1, -1},
                {-1, -1, -1, -1, -1, 1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, 5, -1, -1},
                {-1, -1, -1, 2, -1, -1, 4, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, 3, -1, -1}
        };
    }
}
