package animation_chenile;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;


public class test{
    public static void main(String[] args) {
    
        JFrame frame = new JFrame("Test de Déplacement de Chenille");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        

        Dessin dessin = new Dessin();
        tete tete = new tete(400, 300, 20, 0);
        Anneau[] anneaux = new Anneau[10];

        for (int i = 0; i < 10; i++) {
            anneaux[i] = new Anneau(tete.getX() - (i + 1) * 40, tete.getY(), 20);
        }

       
        chenillecolor chenilleColor = new chenillecolor(dessin, anneaux, tete);

        dessin.ajouterChenille(chenilleColor);
        frame.add(dessin);

        Timer timer = new Timer(100, e -> {
            chenilleColor.deplacer();
            dessin.repaint();
        });

        frame.setVisible(true);
        timer.start();
    }
}

