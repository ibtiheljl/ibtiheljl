package animation_chenile;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
//q7
import java.util.ArrayList;
import java.util.List;

public class Dessin extends JPanel {
	protected chenille v;// chenille principale
	protected chenille_gourmande v1;// chenille de couleur
	protected chenillecolor col;
	protected List<salade> salades = new ArrayList<>();// Liste des salades représentées par des disques
	protected List<mine> mines = new ArrayList<>();// Liste des mines représentées par des rectangles
   
	// Méthodes pour obtenir la largeur et la hauteur de la zone de dessin
	public int getLargeur() {
		return getWidth();
	}
	public int getHauteur() {
        return getHeight();
    }
	
    // Méthode pour ajouter une chenille à la zone de dessin
	public void ajouterChenille(chenille C) {
	v = C;	
	}
    // Méthode pour ajouter une chenille de couleur à la zone de dessin
	public void ajouterChenilleC(chenillecolor Color) {
		col = Color;	
		}
	// Méthode pour ajouter une salade à la liste de salades
	 public void ajouterSalade(int x, int y, int r) {
	        salades.add(new salade(x, y, r));
	    }
	 // Méthode pour ajouter une mine à la liste des mines
	public void ajouterMine(int x, int y, int width, int height) {
	    mine mine = new mine(x, y, width, height);
	    mines.add(mine);
	}

    // Méthode pour mettre en pause l'exécution pendant un certain temps
	public void pause(int duree) {
           
				try {
					Thread.sleep(duree);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
    }
    // Méthode pour dessiner les composants
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		v1.dessiner(g);
		v1.mangerSalade(salades);
		for (salade salade : salades) {
            g.setColor(Color.GREEN);
            g.fillOval(salade.getX() - salade.getR(), salade.getY() - salade.getR(), 2 * salade.getR(), 2 * salade.getR());
        }
		for (mine mine : mines) {
		    g.setColor(Color.RED);
		    g.fillRect(mine.getX(), mine.getY(), mine.getWidth(), mine.getHeight());
		   
		}

		
		
	}
}
