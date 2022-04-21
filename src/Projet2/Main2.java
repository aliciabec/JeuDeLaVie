package Projet2;



public class Main2 {
    public static void main(String[] args){
        int colonne = 40;
        Pandemie p = new Pandemie(3,50,colonne*colonne, colonne);
        p.run(20, 500000000);
    }
}

