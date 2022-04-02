package Projet2;

import Projet1.JeuDeLaVie;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        int ligne = 30;
        int colonne = 30;
        Pandemie p = new Pandemie(3,40,450, 15);
        p.creationPop();
        System.out.println("premiere tableau cree");
        p.afficheTableau();
        System.out.println("premiere tableau cree");

        p.run(100, 500000000.);
        System.out.println(p.afficheTotal());
        /*System.out.println("Entrez la taille de la population \n");
        Scanner sc= new Scanner(System.in);
        int pop= sc.nextInt();

        System.out.println("Entrez le taux de vacciné dans la population sous la forme : **.*\n");
        Scanner sc1= new Scanner(System.in);
        double taux_vacc= sc1.nextDouble();*/
    }
}

