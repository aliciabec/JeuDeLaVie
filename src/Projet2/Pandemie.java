package Projet2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Pandemie {
    ArrayList<ArrayList<Individu>> tab_ind;

    public Pandemie(){ this.tab_ind = new ArrayList<ArrayList<Individu>>(); }

    public ArrayList<ArrayList<Individu>> getTab_Ind(){
        return this.tab_ind;
    }

    public void setTab_Ind(ArrayList<ArrayList<Individu>> tab_ind) {
        this.tab_ind = tab_ind;
    }

    public int valeurCase(int i, int j){
        return this.tab_ind;
    }

    public int totalVoisins(int i, int j){
        int somme =0;

        for (int k = i-1; k < i+2; k++) {
            for (int l = j-1; l <j+2 ; l++) {
                if (k != i || l !=j){
                    somme = somme + this.tab_ind.get(k).get(l);
                }
            }

        }
        return somme;
    }

    public int proba_contamine() {
        int i = new Random().nextInt(100);
        if (i <= 25) {
            return 1;
        } else {
            return 0;
        }
    }

    public int proba_vaccination(double taux) {
        int i = new Random().nextInt(100);
        if (i <= taux) {
            return 1;
        } else {
            return 0;
        }
    }
    public int resultats(int valeur_case_vaccin, int valeur_case_contamine ,int valeur_voisins ){
        int resultat = valeur_case_contamine;

        if(valeur_case_contamine==0 && valeur_voisins>0 ){
                resultat=proba_contamine();

        }
        if(valeur_case_vaccin)


        return resultat;


    }


}
