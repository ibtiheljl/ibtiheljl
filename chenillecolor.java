package animation_chenile;

import java.awt.Graphics;
import java.awt.*;

public class chenillecolor extends chenille  {

	 
    private Color couleur;
   
    public chenillecolor(Dessin d, Anneau[] a, tete tete) {
        super(tete, a, d);
        couleur = getRandomColor();
        
    }

    
    private Color getRandomColor() {
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        return new Color(r, g, b);
    }

    public void dessiner(Graphics g) {
        Color c = g.getColor();
        g.setColor(couleur);
        super.dessiner(g);
        g.setColor(c);
    }
}