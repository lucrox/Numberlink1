package gloo.numberlink;

import java.util.ArrayList;

public class PuzzleGenerator {
    public static void ajoutCase(int tag, int[] cases , int[][] tab){
        tab[cases[0]][cases[1]] = tag;


    }
    //TODO: make puzzle generator generate random puzzles
    public static int[][] generate(int dimension ) {
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
        };*/
        int[][] puzzle = new int[dimension][dimension];
        boolean[][] puzzleUnavailable = new boolean[dimension][dimension];
        ArrayList<Integer> longueursChemins = new ArrayList<Integer>();
        boolean pasFini = true;
        int somme = 0;
        int numeroChemin =1;
        while(pasFini) {
            System.out.println("somme"+somme);
            System.out.println("longueurschemins " + longueursChemins.toString());

            somme = 0;
            for(int i = 0; i<longueursChemins.size();i++) {
            somme += longueursChemins.get(i);
            }
            pasFini = (somme <= dimension*dimension);

            int[] caseDepart = new int[2];
            boolean pasTrouve = true;
            while(pasTrouve){

                int randCol = (int) (Math.random()*dimension);
                int randLin = (int) (Math.random()*dimension);
                if(!puzzleUnavailable[randLin][randCol]){
                    caseDepart[0] = randLin;
                    caseDepart[1] = randCol;
                    puzzleUnavailable[randLin][randCol]= false;
                    pasTrouve = false;

                }

            }


            boolean cheminPasFini = true;
            int longueurChemin = 1;
            int l = caseDepart[0];
            int c = caseDepart[1];
            System.out.println("case depart "+ l+c);
            int[]cheminCol = new int[10];
            int[]cheminlin = new int[10];
            cheminCol[0] = c;
            cheminlin[0] = l;
            puzzleUnavailable[l][c]=true;
            while(cheminPasFini){

                int dir = (int) (Math.random()*4);
                System.out.println("case courante:" + l+c);


                switch(dir){
                    case 0 : if((l-1)>=0 && !puzzleUnavailable[l-1][c]){


                        l--;
                        System.out.println(l);
                        cheminlin[longueurChemin] = l;
                        cheminCol[longueurChemin] = c;
                        puzzleUnavailable[l][c] = true;
                        longueurChemin += 1;}

                        else {

                            longueursChemins.add(longueurChemin);
                            numeroChemin++;
                            cheminPasFini = false;

                    }
                    case 1 : if((c-1)>=0 && !puzzleUnavailable[l][c-1]){


                        c--;
                        System.out.println(c);
                        cheminlin[longueurChemin] = l;
                        cheminCol[longueurChemin] = c;
                        puzzleUnavailable[l][c] = true;
                        longueurChemin += 1;}

                    else {

                        longueursChemins.add(longueurChemin);
                        numeroChemin++;
                        cheminPasFini = false;

                    }
                    case 2 : if((l+1)<dimension && !puzzleUnavailable[l+1][c]){


                        l++;
                        System.out.println(l);
                        cheminlin[longueurChemin] = l;
                        cheminCol[longueurChemin] = c;
                        puzzleUnavailable[l][c] = true;
                        longueurChemin += 1;
                    }

                    else {

                        longueursChemins.add(longueurChemin);
                        numeroChemin++;
                        cheminPasFini = false;

                    }
                    case 3 : if((c+1)<dimension && !puzzleUnavailable[l][c+1]){


                        c++;
                        System.out.println(c);
                        cheminlin[longueurChemin] =l;
                        cheminCol[longueurChemin] = c;
                        puzzleUnavailable[l][c] = true;
                        longueurChemin += 1;}

                    else {

                        longueursChemins.add(longueurChemin);
                        numeroChemin++;
                        cheminPasFini = false;}
                    }

                    }


            for(int i = 0; i<longueurChemin;i++) {
                System.out.println("lin: " + cheminlin[i]+ "col: "+cheminCol[i]);
                puzzle[cheminlin[i]][cheminCol[i]] = numeroChemin;

            }




        }
        for (boolean[] tab: puzzleUnavailable) {
            for (boolean s: tab) {
                System.out.print(s + "\t");
            }
            System.out.println("\n");
        }
        return puzzle;
        }


    }
