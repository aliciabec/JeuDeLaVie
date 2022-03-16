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
        tab.setTableauIJ(2, 1, 1);
        tab.setTableauIJ(2, 3, 1);
        tab.setTableauIJ(1, 2, 1);

        //tab.setTableauIJ(1, 1, 1);

        for (int j = 0; j < tab.getTableau()[0].length; j++) {
            System.out.println(Arrays.toString(tab.getTableau()[j]));
        }

        System.out.println(tab.resultats(tab.valeurCase(2,2), tab.totalVoisins(2,2)));

    }
}
