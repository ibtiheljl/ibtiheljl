package animation_chenile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;



public class test_gourmand {
    private static Timer timer;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Test de Chenille Gourmande");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        Dessin dessin = new Dessin();
        frame.add(dessin);

        Random random = new Random();

        // Créez et ajoutez des salades aléatoirement
        for (int i = 0; i < 9; i++) {
            int x = random.nextInt(800);
            int y = random.nextInt(600);
            int r = 10 + random.nextInt(20); // Diamètre de la salade entre 10 et 30
            dessin.ajouterSalade(x, y, r);
        }

        // Créez et ajoutez des mines aléatoirement
        for (int i = 0; i < 9; i++) {
            int x = random.nextInt(800);
            int y = random.nextInt(600);
            int width = 20 + random.nextInt(30);
            int height = 10 + random.nextInt(20);
            dessin.ajouterMine(x, y, width, height);
        }

        // Créez une chenille gourmande
        tete tete = new tete(400, 300, 20, 0);
        Anneau[] anneaux = new Anneau[10];
        for (int i = 0; i < 10; i++) {
            anneaux[i] = new Anneau(tete.getX() - (i + 1) * 40, tete.getY(), 20);
        }
        chenille_gourmande chenilleGourmande = new chenille_gourmande(tete, anneaux, dessin, timer);
        dessin.v1 = chenilleGourmande;

        frame.setVisible(true);

        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                timer.stop();
            }
        });

        frame.add(stopButton, BorderLayout.SOUTH);

        timer = new Timer(100, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chenilleGourmande.deplacer();
                dessin.repaint();
            }
        });

        timer.start();
    }
}
