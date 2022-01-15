package gloo.numberlink.model;

import gloo.numberlink.exception.InvalidParametersException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class BoardReader {
    private static final int minBoardLength = 5; // hardcoded minimum board length
    private static final int maxBoardLength = 12; // hardcoded maximum board length
    private static final String boardFolderPath = "boards"; // path of the boards

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
    public static int[][] readBoard(int boardLength) throws Exception {
        // board length validation
        if (!isBoardLengthValid(boardLength)) {
            throw new InvalidParametersException
                    (String.format("The board length should be between %d and %d", minBoardLength, maxBoardLength)
                    );
        }
        // reading the board
        try {
            String path = boardFolderPath + String.format("/%d_%d_board.dat", boardLength, boardLength);
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream iis = new ObjectInputStream(fis);
            return (int[][]) iis.readObject();
        } catch (Exception e) {
            throw new Exception("Error reading the board.");
        }
    }
}
