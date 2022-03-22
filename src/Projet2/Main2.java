package Projet2;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        System.out.println("Entrez la taille de la population \n");
        Scanner sc= new Scanner(System.in);
        int pop= sc.nextInt();

        System.out.println("Entrez le taux de vacciné dans la population sous la forme : **.*\n");
        Scanner sc1= new Scanner(System.in);
        double taux_vacc= sc1.nextDouble();
    }
}

