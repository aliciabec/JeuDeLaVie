package Projet2;


import javax.swing.*;
import java.awt.*;

public class VueInd extends JPanel {
    Pandemie p;

    public VueInd(Pandemie p){
        this.p = p;
    }

    public void paint(Graphics g) {
        this.dessinerCase(g);
        this.dessinerText(g);
    }

    public void dessinerCase(Graphics g){
        /** Dessine les cases representant les indiviues
         * @param g cree les elements graphiques de l'affichage
        */
        int taille_case = 600/(p.getTaille_pop()/p.getLigne());
        for (int i = 0; i < p.getTab_Ind().size(); i++) { // pointeur null probleme
            for (int k = 0; k < p.getTab_Ind().get(i).size(); k++) {
                if(p.getTab_Ind().get(i).get(k).getContamine()==1){
                    g.setColor(Color.gray);
                    g.fillRect(i*taille_case,k*taille_case,taille_case,taille_case);
                }else if(p.getTab_Ind().get(i).get(k).getVaccinne() == 1){
                    g.setColor(Color.PINK);
                    g.fillRect(i*taille_case,k*taille_case,taille_case,taille_case);
                }
            }
        }
    }

    public void dessinerText(Graphics g){
        /** Ecrit le text
         * @param g cree les elements graphiques de l'affichage
         */
        int taille_case = 600/(p.getTaille_pop()/p.getLigne());
        int dist = 20;
        g.setColor(Color.gray);
        for(String i: p.afficheTotal()) {
            g.drawString(i, 0, 600 + dist);
            dist += 20;
        }


    }


}
