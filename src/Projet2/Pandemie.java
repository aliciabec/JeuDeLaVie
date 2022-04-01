package Projet2;

import Projet1.Vue;

import java.util.ArrayList;
import java.util.Random;

public class Pandemie {
    ArrayList<ArrayList<Individu>> tab_ind;
    int nb_contamine;
    int nb_vaccine;
    int taille_pop;
    int ligne;
    VueG v;

    public Pandemie(int nb_contamine, int nb_vaccine, int taille_pop, int ligne){
        this.tab_ind = new ArrayList<ArrayList<Individu>>();
        this.nb_contamine = nb_contamine;
        this.nb_vaccine = nb_vaccine;
        this.taille_pop = taille_pop;
        this.ligne = ligne;
        this.v = new VueG(this);
    }

    public ArrayList<ArrayList<Individu>> getTab_Ind(){
        return this.tab_ind;
    }

    public void setTab_Ind(ArrayList<ArrayList<Individu>> tab_ind) {
        this.tab_ind = tab_ind;
    }

    public ArrayList<ArrayList<Individu>> valeurCase(int i, int j){
        return this.tab_ind;
    }

    public int getNb_contamine() {
        return nb_contamine;
    }

    public int getNb_vaccine() {
        return nb_vaccine;
    }

    public int getTaille_pop() {
        return taille_pop;
    }

    public int getLigne() {
        return ligne;
    }

    public int proba_contamine(int vaccine, int voisin_vacc, int voisin_contamine) { // attribue la proba d'être contaminé
        /** attribue aléatoirement la contamination à partir d'une probabilité d'1/4
         * (Un voisin à une chance sur 4 d'être contaminé*/
        int rand = new Random().nextInt(100);
        if (vaccine == 1){ // si vacciné la proba est divisé par 2
            rand*=2;
        }
        if (voisin_vacc == 1){ // si le voisin contaminé est vacciné la proba est divisé par 2
            rand*=2;
        }
        if (rand <= 25 && voisin_contamine == 1) { //inférieur à 25% on est contaminé donc 1
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
                            int lig = k;
                            int col = l;
                            if (k <= -1) {
                                lig = this.tab_ind.size()-1;
                                // System.out.println("k <= -1, ligne = " + ligne);
                            }
                            if (l <= -1) {
                                col = this.tab_ind.get(i).size()-1;
                                //System.out.println("l <= -1, col = " + col);
                            }
                            if (k >= this.tab_ind.size()) {
                                lig = 0;
                                //System.out.println("k >= this.tab_ind.size() + 1, ligne = " + ligne);
                            }
                            if (l >= this.tab_ind.get(i).size()) {
                                col = 0;
                                //System.out.println("l >= this.tab_ind.get(i).size() + 1, col = " + col);
                            }
                            //System.out.println("ligne: " + ligne + "col: " + col);
                            resultat = proba_contamine(ind.getVaccinne(),
                                    this.tab_ind.get(lig).get(col).getVaccinne(),
                                    this.tab_ind.get(lig).get(col).getContamine());
                        }
                    } else {
                        return resultat;
                    }
                }
            }
        }
        return resultat;
    }


    public void creationPop(){
        int i1 = ligne;
        while (i1 != 0) {
            ArrayList<Individu> ind = new ArrayList<>();
            for (int i = 0; i < taille_pop/ligne + 1; i++) {
                int rand = new Random().nextInt(taille_pop);
                if (rand < nb_contamine) {
                    ind.add(new Individu(1, proba_vaccination(nb_vaccine)));
                }else {
                    ind.add(new Individu(0, proba_vaccination(nb_vaccine)));
                }
            }
            i1--;
            this.tab_ind.add(ind);
        }

    }


    public void afficheTableau() {
        for (ArrayList<Individu> t : this.tab_ind) {
            String s = "[";
            for (Individu ind : t) {
                s += ind.getContamine();
            }
            s += "]";
            System.out.println(s);
        }
    }

    public void tour() {
        //System.out.println("avant la boucle");
        //afficheTableau();
        ArrayList<ArrayList<Individu>> t = this.tab_ind;
        for (int i = 0; i < this.tab_ind.size(); i++) {
            String s = "";
            for (int j = 0; j < this.tab_ind.get(i).size(); j++) {
                t.get(i).get(j).setContamine(resultats(i, j, this.tab_ind.get(i).get(j)));
                s+= t.get(i).get(j).getContamine();
                //System.out.println(t.get(i).get(j).getContamine());
            }
            System.out.println(s);
        }

        this.tab_ind = t;
        //System.out.println("apres la boucle");
        //afficheTableau();

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

    public String afficheTotal() {
        /** Affiche la pop totale, le nombre de vaccinés, contaminés, vaccinés étant contaminés,
         * non vaccinés étant contaminés
         */
        String affiche_pop = "Population : " + taille_pop + "\n";
        String affiche_vacc = "Vaccinés : " + nb_vaccine +"(" + nb_vaccine/taille_pop + "%)" + "\n";
        String affiche_conta = "Contaminés : " + nb_contamine + "\n" ;
        String affiche_contavacc = "Vaccinés contaminés : " + "\n";
        String affiche_contanonvacc = "Non vaccinés contaminés :" + "\n";

        return affiche_pop + affiche_vacc + affiche_conta + affiche_contavacc + affiche_contanonvacc;
    }

}