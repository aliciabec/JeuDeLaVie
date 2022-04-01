package Projet2;

import javax.swing.*;
import java.awt.*;

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

        frame.add(cases, BorderLayout.CENTER ); //On centre le layout qui contient les cases

        //Affiche le text stat
        JTextArea stat = new JTextArea();
        stat.setEditable(false);
        stat.setLineWrap(true);
        stat.setOpaque(false);
        stat.setBorder(BorderFactory.createEmptyBorder());
        stat.setText( p.afficheTotal() );

        frame.add( stat, BorderLayout.SOUTH ); //On place en bas de notre image


        frame.setVisible(true);

    }
}
