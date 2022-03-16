package sample;

public class JeuDeLaVie {

    private int[][] tableau;

    public JeuDeLaVie(int[][] tab){
        this.tableau = tab;
    }

    public int[][] getTableau(){
        return this.tableau;
    }

    public void setTableau(int[][] tableau) {
        this.tableau = tableau;
    }

    public void setTableauIJ(int i, int j, int nb){
        this.tableau[i][j] = nb;
    }

    public int valeurCase(int i, int j){
        return this.tableau[i][j];
    }

    public int totalVoisins(int i, int j){
        int somme =0;

        for (int k = i-1; k < i+2; k++) {
            for (int l = j-1; l <j+2 ; l++) {
                if (k != i || l !=j){
                    somme = somme + this.tableau[k][l];
                }
            }

        }
        return somme;
    }

    public int resultats(int valeur_case ,int valeur_voisins ){
        int resultat = valeur_case;
        if(valeur_case==0 && valeur_voisins==3 ){ // la cellule est morte
            resultat = 1;
        }
        if(valeur_case==1 && (valeur_voisins<2 || valeur_voisins>3)){
            resultat = 0;
        }
        return resultat;
    }

}
