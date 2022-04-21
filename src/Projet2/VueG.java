package Projet2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VueG extends JFrame{
    Pandemie p;

    public VueG(Pandemie p){
        this.p = p;
        setPreferredSize(new Dimension(600, 600 + 130)); // a revoir pour la taille
        setLayout(new BorderLayout());

        VueInd cases = new VueInd(p);
        add(cases, BorderLayout.CENTER);

        setVisible(true);
        pack();

    }
}
