package Projet1;

public class Main {


    public static void main(String[] args) {
        int ligne = 30;
        int colonne = 30;
        JeuDeLaVie j = new JeuDeLaVie(ligne,colonne);
        j.creationTableau(200);
        j.run(100, 200000000);

    }
}
