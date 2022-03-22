package sample;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        JeuDeLaVie tab = new JeuDeLaVie(new int[10][10]);

        for (int i = 0; i < tab.getTableau().length; i++) {
            for (int j = 0; j < tab.getTableau()[0].length; j++) {
                tab.setTableauIJ(i, j, 0);
            }
        }
        tab.setTableauIJ(0, 1, 1);
        tab.setTableauIJ(0, 0, 1);
        tab.setTableauIJ(0, 2, 1);
        //tab.setTableauIJ(2, 2, 1);


        //tab.setTableauIJ(1, 1, 1);
        int valeur_voisins = tab.totalVoisins(2,2);
        System.out.println(tab.resultats(tab.valeurCase(1,2), tab.totalVoisins(1,2)));
        System.out.println("voisin 2, 2: " + (valeur_voisins < 2 || valeur_voisins > 3));
        int valeur_voisins2 = tab.totalVoisins(2,1);
        System.out.println("voisin 2, 1: " + (valeur_voisins2 < 2 || valeur_voisins2 > 3));
        int valeur_voisins3 = tab.totalVoisins(2,1);
        System.out.println("voisin 2, 3: " + tab.valeurCase(2,3));


        System.out.println("\n");
        System.out.println("\n");
        for (int j = 0; j < tab.getTableau()[0].length; j++) {
            System.out.println(Arrays.toString(tab.getTableau()[j]));
        }
        tab.tour();
        System.out.println("\n");
        System.out.println("\n");
        for (int j = 0; j < tab.getTableau()[0].length; j++) {
            System.out.println(Arrays.toString(tab.getTableau()[j]));
        }

        //System.out.println(tab.resultats(tab.valeurCase(2,2), tab.totalVoisins(2,2)));



    }
}
