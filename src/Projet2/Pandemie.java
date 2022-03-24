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

    public int totalVoisins(int i, int j){
        int somme =0;

        for (int k = i-1; k < i+2; k++) {
            for (int l = j-1; l <j+2 ; l++) {
                if (k != i || l !=j){
                    somme = somme + this.tab_ind.get(k).get(l); //erreur ici car je dois utiliser mon objet individu (pas fini ici)
                }
            }

        }
        return somme;
    }

    public int proba_contamine() { // attribue la proba d'être contaminé
        /** attribue aléatoirement la contamination à partir d'une probabilité d'1/4
         * (Un voisin à une chance sur 4 d'être contaminé*/
        int i = new Random().nextInt(100); // utilisation de la méthode random pour attribuer aléatoirement
        if (i <= 25) { //inférieur à 25% on est contaminé donc 1
            return 1;
        } else {
            return 0;
        }
    }

    public int proba_vaccination(double taux) {
        /** répartie le nombre de vaccinée dans le tableaux aléatoirement */
        int i = new Random().nextInt(100);
        if (i <= taux) {
            return 1;
        } else {
            return 0;
        }
    }
    public int resultats(int valeur_case_vaccin, int valeur_case_contamine ,int valeur_voisins ){
        /** Pas fini mais c'est une méthode qui va permettre d'afficher dans le tableau
         * les futurs contaminé, et non contaminés en fonction de proba d'être contaminé
         * si on est vacciné ou pas */
        int resultat = valeur_case_contamine;

        if(valeur_case_contamine==0 && valeur_voisins>0 ){
                resultat=proba_contamine();

        }
        //if(valeur_case_vaccin) // pas fini


        return resultat;


    }


}
