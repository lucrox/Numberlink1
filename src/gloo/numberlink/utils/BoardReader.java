package gloo.numberlink.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.InvalidParameterException;

public class BoardReader {
    /**
     * A reasonable board length is at least 5.
     */
    public static final int minBoardLength = 5; // hardcoded minimum board length

    /**
     * The largest board stored in the board directory has a size of 12 by 12.
     */
    public static final int maxBoardLength = 12; // hardcoded maximum board length
    private static final String boardFolderPath = "boards"; // hardcoded path of the boards in the project

    // checks if the board length is valid
    public static boolean isBoardLengthValid(int boardLength) {
        return (minBoardLength <= boardLength && boardLength <= maxBoardLength);
    }

    /**
     * Reads the puzzle board file and deserialize it to an 2D integer matrix.
     *
     * @param boardLength the length of the board side.
     * @return the deserialized 2D int[][] matrix representing the puzzle board
     */
    public static int[][] readBoard(int boardLength) throws IOException, ClassNotFoundException {
        // board length validation
        if (!isBoardLengthValid(boardLength)) {
            throw new InvalidParameterException(
                    String.format("The board length should be between %d and %d", minBoardLength, maxBoardLength)
            );
        }
        // reading the board

        String path = boardFolderPath + String.format("/%d_%d_board.dat", boardLength, boardLength);
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream iis = new ObjectInputStream(fis);
        return (int[][]) iis.readObject();
    }

    /**
     * Finds the number of labels present on the board.
     *
     * @param board the game board
     * @return the number of labels
     */
    public static int getLabelCount(int[][] board) {
        int currMax = 0;
        for (int[] row : board) {
            for (int val : row) {
                currMax = Math.max(currMax, val);
            }
        }
        return currMax;
    }
}
