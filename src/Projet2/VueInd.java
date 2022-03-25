package Projet2;


import javax.swing.*;
import java.awt.*;

public class VueInd extends JPanel {
    Pandemie p;

    public VueInd(Pandemie p){
        this.p = p;
    }

    public void paintComponent(Graphics g) {
        this.dessinerCase(g);
    }

    public void dessinerCase(Graphics g){
        for (int i = 0; i < p.getTab_Ind().size(); i++) { // pointeur null probleme
            for (int k = 0; k < p.getTab_Ind().get(i).size(); k++) {
                if(p.getTab_Ind().get(i).get(k).getContamine()==1){
                    g.setColor(Color.gray);
                    int taille_case = 600/(p.getTaille_pop()/p.getLigne());
                    g.fillRect(i*taille_case,k*taille_case,taille_case,taille_case);
                }
            }
        }
    }

    public void update(Graphics g) {
        super.update(g);
    }


}
