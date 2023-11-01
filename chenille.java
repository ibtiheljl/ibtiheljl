package animation_chenile;

import java.awt.Graphics;

public class chenille {
	protected tete t;
	protected Anneau[] listeA;
	protected Dessin d;
	public chenille() {
		
	}
	public chenille(tete t, Anneau[] a, Dessin d) {
		this.t = t;
		this.listeA = a;
		this.d = d;
	}
	public void dessiner(Graphics g) {
		t.dessiner(g);
		for (Anneau a : this.listeA) {
			a.dessiner(g);
			a.placerA(a.getX(), a.getY());
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
    }
	public void setDessin(Dessin d) {
		this.d = d;
	}
}
