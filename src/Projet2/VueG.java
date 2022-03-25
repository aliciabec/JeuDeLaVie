package Projet2;

import javax.swing.*;

public class VueG {
    JFrame frame;
    Pandemie p;

    public VueG(Pandemie p){
        this.p = p;
        int ligne = p.getLigne();
        int colonne = p.getLigne();

        frame = new JFrame();
        frame.setResizable(false);
        int taille_case = 600/colonne;
        System.out.println(taille_case);
        frame.setSize(taille_case*ligne, taille_case*colonne);
        VueInd cases = new VueInd(p);
        frame.add(cases);
        frame.setVisible(true);

    }
}
