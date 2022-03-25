package Projet2;

import java.util.ArrayList;
import java.util.Random;

public class Pandemie {
    ArrayList<ArrayList<Individu>> tab_ind;

    public Pandemie(){ this.tab_ind = new ArrayList<ArrayList<Individu>>(); }

    public ArrayList<ArrayList<Individu>> getTab_Ind(){
        return this.tab_ind;
    }

    public void setTab_Ind(ArrayList<ArrayList<Individu>> tab_ind) {
        this.tab_ind = tab_ind;
    }

    public ArrayList<ArrayList<Individu>> valeurCase(int i, int j){
        return this.tab_ind;
    }


    public int proba_contamine(int vaccine, int voisin_vacc) { // attribue la proba d'être contaminé
        /** attribue aléatoirement la contamination à partir d'une probabilité d'1/4
         * (Un voisin à une chance sur 4 d'être contaminé*/
        int rand = new Random().nextInt(100);
        if (vaccine == 1){ // si vacciné la proba est divisé par 2
            rand/=2;
        }
        if (voisin_vacc == 1){ // si le voisin contaminé est vacciné la proba est divisé par 2
            rand/=2;
        }
        if (rand <= 25) { //inférieur à 25% on est contaminé donc 1
            return 1;
        } else {
            return 0;
        }

    }

    public int proba_vaccination(double taux) {
        /** répartie le nombre de vaccinée dans le tableaux aléatoirement
         * @taux */
        double rand = new Random().nextInt(100);
        if (rand <= taux) {
            return 1;
        } else {
            return 0;
        }
    }
    public int resultats(int i, int j, Individu ind){
        /** Pas fini mais c'est une méthode qui va permettre d'afficher dans le tableau
         * les futurs contaminé, et non contaminés en fonction de proba d'être contaminé
         * si on est vacciné ou pas */
        int resultat = ind.getContamine();
        if(ind.getContamine()==0){
            for (int k = i-1; k < i+2; k++) {
                for (int l = j-1; l <j+2 ; l++) {
                    if( resultat == 0){
                        if (k != i || l != j) {
                            int ligne = k;
                            int col = l;
                            if (k == -1) {
                                ligne = this.tab_ind.size();
                            }
                            if (l == -1) {
                                col = this.tab_ind.get(k).size();
                            }
                            if (k == this.tab_ind.size() + 1) {
                                ligne = 0;
                            }
                            if (l == this.tab_ind.get(k).size() + 1) {
                                col = 0;
                            }
                            resultat = proba_contamine(ind.getVaccinne(),
                                    this.tab_ind.get(ligne).get(col).getVaccinne());
                        }
                    } else {
                        return resultat;
                    }
                }
            }
        }
        return resultat;
    }


    public void creationPop(int nb_contamine){

    }

    public void tour() {
        int contamine = 30;

    }
      //  int[][] t = new int[this.tableau.length][this.tableau[0].length];
       // for (int i = 0; i < this.tableau.length; i++) {
        //    for (int j = 0; j < this.tableau[0].length; j++) {
         //       t[i][j] = resultats(valeurCase(i,j), totalVoisins(i, j));
        //    }

       // }
      //  this.tableau = t;
    //}


}
