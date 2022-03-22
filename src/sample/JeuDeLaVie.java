package sample;

import java.util.Arrays;

public class    JeuDeLaVie {

    private int[][] tableau;

    public JeuDeLaVie(int[][] tab) {
        this.tableau = tab;
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
        /** renvoie la valeur de la case [i][j] ou 0 si la case n'existe pas */
        return this.tableau[i][j];
    }

    public int totalVoisins(int i, int j) {
        /** Renvoie la somme des valeur des voisins de la case [i][j] */
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
        /** renvoie la valeur d'une case de la cellule au tour suivant */
        int resultat = valeur_case;
        // Si la cellule est morte
        if (valeur_case == 0 && valeur_voisins == 3) {
            resultat = 1;
        }
        // Si la cellule est vivante
        if (valeur_case == 1 && (valeur_voisins < 2 || valeur_voisins > 3)) {
            resultat = 0;
        }
        return resultat;
    }
    public void run (int nombre_tours, int delai ) {
        /** Méthode principale du jeu
         * Fait tourner le jeu pendant nombre_tours. Elle rafraîchit l'affichage à chaque tour
         * et attend delai (en secondes) entre chaque tour
         */
        for(int tour=0; tour <= nombre_tours; tour++){
            tour();
            affiche();
        }
    }

    public void affiche(){
        for (int j = 0; j < this.tableau.length; j++) {
            System.out.println(Arrays.toString(this.tableau[j]));
        }
    }

    public void tour() {
        /** met à jour toutes les cellules du tableau en respectant les règles du jeu */
        int[][] t = new int[this.tableau.length][this.tableau[0].length];
        for (int i = 0; i < this.tableau.length; i++) {
            for (int j = 0; j < this.tableau[0].length; j++) {
                t[i][j] = resultats(this.tableau[i][j], totalVoisins(i, j));
            }

        }
        this.tableau = t;
    }
}