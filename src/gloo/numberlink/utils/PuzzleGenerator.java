package gloo.numberlink.utils;

import java.util.ArrayList;

public class PuzzleGenerator {


    public static boolean hasZero(int[][] puzzle){
        for (int l= 0;l< puzzle.length;l++) {
            for (int c=0;c<puzzle[0].length;c++) {
                if(puzzle[l][c]==0){
                    return true;
                }
            }

        }
        return false;
    }
    public static int[][] remplissageMoinsUn(int[][] puzzle){

        for (int l= 0;l< puzzle.length;l++) {
            for (int c=0;c<puzzle[0].length;c++) {
                if(puzzle[l][c]==0){
                    puzzle[l][c] =-1;

                }
            }

        }

        return puzzle;
    }


    //TODO: make puzzle generator generate random puzzles
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
        int numeroChemin = 1;

        boolean pasFini = true;
        boolean grilleInvalide = false;


        while(pasFini){



            boolean pasTrouve = true;
            int colCourante = 0;
            int linCourante= 0;


            while(pasTrouve){
                colCourante = (int) (Math.random()*nbColumns);
                linCourante = (int) (Math.random()*nbRows);
                pasTrouve = puzzle[linCourante][colCourante] !=0;
            }
            int linDepart = linCourante;
            int colDepart = colCourante;
            puzzle[linCourante][colCourante] = numeroChemin;
            int compteur=1;
            boolean cheminEnCours = true;
            int essais = 0;
            while (cheminEnCours) {

                essais++;
                int dir = (int) (Math.random()*4);
                switch (dir){
                    case 0:
                        linCourante--;
                        if(linCourante<0 || puzzle[linCourante][colCourante]!=0){
                            linCourante++;
                            if(essais>10){ cheminEnCours = false;}
                        }
                        else{
                            puzzle[linCourante][colCourante] = numeroChemin;
                            compteur++;
                        }
                    case 1:
                        colCourante--;
                        if(colCourante<0 || puzzle[linCourante][colCourante]!=0){
                            colCourante++;
                            if(essais>10){ cheminEnCours = false;}
                        }
                        else{
                            puzzle[linCourante][colCourante] = numeroChemin;
                            compteur++;
                        }
                    case 2:
                        linCourante++;
                        if(linCourante>=nbRows || puzzle[linCourante][colCourante]!=0){
                            linCourante--;
                            if(essais>10){ cheminEnCours = false;}
                        }
                        else{
                            puzzle[linCourante][colCourante] = numeroChemin;
                            compteur++;
                        }
                    case 3:
                        colCourante++;
                        if(colCourante>=nbColumns|| puzzle[linCourante][colCourante]!=0){
                            colCourante--;
                            if(essais>10){ cheminEnCours = false;}
                        }
                        else{
                            puzzle[linCourante][colCourante] = numeroChemin;
                            compteur++;
                        }
                }

            }
            if(compteur<3){grilleInvalide=true;}
            if((linCourante == linDepart && colCourante==colDepart)){break;}
            puzzleReturn[linCourante][colCourante]=numeroChemin;
            puzzleReturn[linDepart][colDepart] = numeroChemin;
            numeroChemin++;
            pasFini = hasZero(puzzle);

        }




        if(hasZero(puzzle)||grilleInvalide){puzzle = generate(nbRows,nbColumns);}
        puzzleReturn = remplissageMoinsUn(puzzleReturn);
        return puzzleReturn;
        }


    }