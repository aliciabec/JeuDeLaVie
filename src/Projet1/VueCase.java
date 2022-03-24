package Projet1;

import javax.swing.*;
import java.awt.*;

public class VueCase extends JPanel {
    JeuDeLaVie j;

    public VueCase(JeuDeLaVie j){
        this.j = j;
    }

    public void paintComponent(Graphics g) {
        this.dessinerCase(g);
    }

    public void dessinerCase(Graphics g){
        for (int i = 0; i < j.getTableau().length; i++) { // pointeur null probleme
            for (int k = 0; k < j.getTableau()[0].length; k++) {
                if(j.getTableau()[i][k]==1){
                    g.setColor(Color.pink);
                    g.fillRect(i*20,k*20,20,20);
                }
            }
        }

    }

    public void update(Graphics g) {
        super.update(g);
    }
}
