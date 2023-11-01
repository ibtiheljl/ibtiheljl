package animation_chenile;

import javax.swing.*;
public class test_deplacement {
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

        chenille chenille = new chenille(tete, anneaux, dessin);
        dessin.ajouterChenille(chenille);
        frame.add(dessin);

        Timer timer = new Timer(100, e -> {
            chenille.deplacer();
            dessin.repaint();
        });

        frame.setVisible(true);
        timer.start();
    }
}
