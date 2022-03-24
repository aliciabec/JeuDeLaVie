package Projet1;

import java.util.Random;

public class JeuDeLaVie {

    private int[][] tableau;
    Vue v = new Vue(this);

    public JeuDeLaVie(int k, int l) {
        this.tableau = new int[k][l];
        for (int i = 0; i < tableau.length; i++) {
            for (int j = 0; j < tableau[0].length; j++) {
                this.tableau[i][j] = 0;
            }
        }
    }

    public int[][] getTableau() {
        return this.tableau;
    }

    public void setTableau(int[][] tableau) {
        this.tableau = tableau;
    }

    public void setTableauIJ(int i, int j, int nb) {
        this.tableau[i][j] = nb;
    }

    public int valeurCase(int i, int j) {
        return this.tableau[i][j];
    }

    public int totalVoisins(int i, int j) {
        int somme= 0 ;
        for (int ligne = i-1 ; ligne < i + 2; ligne++){
            for (int colonne = j-1 ; colonne < j+2 ; colonne++){
                if ((ligne != i || colonne != j)
                        && (ligne != -1 && colonne!= -1)
                        && (ligne != this.tableau.length && colonne != this.tableau[0].length)) {
                    somme = somme + this.tableau[ligne][colonne];
                }
            }
        }
        return somme;
    }

    public int resultats(int valeur_case, int valeur_voisins) {
        int resultat = valeur_case;
        if (valeur_case == 0 && valeur_voisins == 3) { // la cellule est morte
            resultat = 1;
        }
        if (valeur_case == 1 && (valeur_voisins < 2 || valeur_voisins > 3)) {
            resultat = 0;
        }
        return resultat;
    }


    public void tour() {
        int[][] t = new int[this.tableau.length][this.tableau[0].length];
        for (int i = 0; i < this.tableau.length; i++) {
            for (int j = 0; j < this.tableau[0].length; j++) {
                t[i][j] = resultats(valeurCase(i,j), totalVoisins(i, j));
            }

        }
        this.tableau = t;
    }

    public void creationTableau(int cell_vivantes){
        /** méthode qui permet de mettre des cellules vivantes dans la matrice
         * cell_vivantes : nombre de cellules vivantes qu'on veut
         */
        Random r = new Random();
        int ligne;
        int colonne;
        for (int c = 1 ; c < cell_vivantes +1 ; c++) {
            ligne = r.nextInt(30);
            colonne = r.nextInt(30);
            this.tableau[ligne][colonne] = 1;
        }
    }

    public void run (int nombre_tours, double delai ) {
        /** Méthode principale du jeu.
         * Elle fait tourner le jeu pendant nombre_tours. Elle rafraîchit l'affichage à chaque tour
         * et attend delai (en secondes) entre chaque tour.
         * @nombre_tours fait tourner le programme pendant pendant ce nombre de tour
         * @delai rafraichi la page au delai
         */
        long nanoSecond = System.nanoTime();
        int i = 0;
        while(true) {
            if (i != nombre_tours){
                if (System.nanoTime() - nanoSecond > delai) {
                    nanoSecond += delai;
                    tour();
                    i++;
                } else {
                    v.frame.repaint();
                }
            }else {
                break;
            }

        }
    }

}