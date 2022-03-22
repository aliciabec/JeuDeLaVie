package sample;

public class JeuDeLaVie {

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
                t[i][j] = resultats(this.tableau[i][j], totalVoisins(i, j));
            }

        }
        this.tableau = t;

    }
}