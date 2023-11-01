package animation_chenile;

import java.util.List;
import javax.swing.Timer;

public class chenille_gourmande extends chenille {
	private Timer timer;
	public chenille_gourmande(tete t, Anneau[] a, Dessin d, Timer timer) {
        super(t, a, d);
        this.timer = timer;
    }
    public void mangerSalade(List<salade> salades) {
        for (int i = 0; i < salades.size(); i++) {
            salade s = salades.get(i);
            double distance = Math.sqrt(Math.pow(t.getX() - s.getX(), 2) + Math.pow(t.getY() - s.getY(), 2));
            if (distance < t.r) {
                t.r += 5; // Augmentez la taille de la tête
                for (Anneau anneau : listeA) {
                    anneau.r += 5; // Augmentez la taille de tous les anneaux
                }
                salades.remove(i); // Retirez la salade de la liste
                i--;
            }
        }
    }
    public void deplacer() {
        if (this.t.CapOK(d.getLargeur(), d.getHauteur())) {
            this.t.deplacerSelonCap();
        } else {
            double devier = ((Math.random() * 60) - 30);
            this.t.devierCap(devier);
        }

        for (int i = listeA.length - 1; i > 0; i--) {
            listeA[i].placerA(listeA[i - 1]);
        }
        listeA[0].placerA(t);

        // Vérifiez si la chenille touche une mine
        for (mine mine : d.mines) {
            if (this.t.getX() >= mine.getX() && this.t.getX() <= mine.getX() + mine.getWidth() &&
                this.t.getY() >= mine.getY() && this.t.getY() <= mine.getY() + mine.getHeight()) {
                // La chenille a touché une mine, arrêtez le timer
                timer.stop();
            }
        }
    }
}