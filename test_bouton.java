package animation_chenile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test_bouton {
    
    private static Timer timer;

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

       
        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                timer.stop();
            }
        });

       
        frame.add(stopButton, BorderLayout.SOUTH);

       
        timer = new Timer(100, new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                chenilleColor.deplacer();
                dessin.repaint();
            }
        });

        frame.setVisible(true);
        timer.start();
    }
}
