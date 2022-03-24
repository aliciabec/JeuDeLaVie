package Projet1;

import javax.swing.*;

public class Vue {
    JFrame frame;
    JeuDeLaVie j;
    public Vue(JeuDeLaVie j){
        this.j = j;
        int ligne = 30;
        int colonne = 30;

        frame = new JFrame();
        frame.setResizable(false);
        frame.setSize(ligne*20, colonne*20);
        VueCase cases = new VueCase(j);
        frame.add(cases);
        frame.setVisible(true);

    }
}
