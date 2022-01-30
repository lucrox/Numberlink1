package gloo.numberlink.utils;

/**
 * This class was initially made for generating initial boards in run time.
 * This class has been deprecated because the boards are read directly by the BoardReader from serialized files
 * class.
 */
@Deprecated
public class PuzzleGenerator {

    public static boolean hasZero(int[][] puzzle){
        for (int[] rowArray : puzzle) {
            for (int val : rowArray) {
                if (val == 0) return true;
            }
        }
        return false;
    }
    public static void fillMatrixMinusOne(int[][] puzzle){
        for (int l= 0;l< puzzle.length;l++) {
            for (int c=0;c<puzzle[0].length;c++) {
                if(puzzle[l][c]==0){
                    puzzle[l][c] =-1;
                }
            }
        }
    }


    //TODO: make puzzle generator generate random puzzles
    @Deprecated
    public static int[][] generate(int nbRows,int nbColumns ) {
        /*return new int[][]{
                {0, 1, 2, -1, -1, -1, 3, -1, -1},
                {-1, -1, -1, -1, 4, -1, 0, -1, -1},
                {-1, -1, -1, -1, -1, -1, 5, -1, -1},
                {-1, -1, -1, -1, -1, 1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, 5, -1, -1},
                {-1, -1, -1, 2, -1, -1, 4, -1, -1},
                {-1, -1, -1, -1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1, 3, -1, -1}
        };}}*/
        int[][] puzzle = new int[nbRows][nbColumns];
        int[][] puzzleReturn = new int[nbRows][nbColumns];
        int pathNumber = 1;

        boolean pasFini = true;


        while(pasFini){



            boolean pasTrouve = true;
            int currCol = 0;
            int currRow= 0;


            while(pasTrouve){
                currCol = (int) (Math.random()*nbColumns);
                currRow = (int) (Math.random()*nbRows);
                pasTrouve = puzzle[currRow][currCol] !=0;
            }
            int linDepart = currRow;
            int colDepart = currCol;
            puzzle[currRow][currCol] = pathNumber;
            boolean currPath = true;
            int nbTries = 0;
            while (currPath) {
                nbTries++;
                int dir = (int) (Math.random()*4);
                switch (dir){
                    case 0:
                        currRow--;
                        if(currRow<0 || puzzle[currRow][currCol]!=0){
                            currRow++;
                            if(nbTries>10){ currPath = false;}
                        }
                        else{
                            puzzle[currRow][currCol] = pathNumber;
                        }
                    case 1:
                        currCol--;
                        if(currCol<0 || puzzle[currRow][currCol]!=0){
                            currCol++;
                            if(nbTries>10){ currPath = false;}
                        }
                        else{
                            puzzle[currRow][currCol] = pathNumber;
                        }
                    case 2:
                        currRow++;
                        if(currRow>=nbRows || puzzle[currRow][currCol]!=0){
                            currRow--;
                            if(nbTries>10){ currPath = false;}
                        }
                        else{
                            puzzle[currRow][currCol] = pathNumber;
                        }
                    case 3:
                        currCol++;
                        if(currCol>=nbColumns|| puzzle[currRow][currCol]!=0){
                            currCol--;
                            if(nbTries>10){ currPath = false;}
                        }
                        else{
                            puzzle[currRow][currCol] = pathNumber;
                        }
                }

            }
            if((currRow == linDepart && currCol==colDepart)){break;}
            puzzleReturn[currRow][currCol]=pathNumber;
            puzzleReturn[linDepart][colDepart] = pathNumber;
            pathNumber++;
            pasFini = hasZero(puzzle);

        }
        fillMatrixMinusOne(puzzleReturn);
        return puzzleReturn;
        }
    }
