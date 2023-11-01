package animation_chenile;
import java.awt.Graphics;
import javax.swing.*;
public class tete extends Anneau {
	private double cap;
	public tete() {
	
	}
	 public tete(int x, int y, int r, double cap) {
	        super(x, y, r ); // Double du rayon des anneaux
	        this.cap = cap;
	    }

	   
	    public void dessiner(Graphics g) {
	        g.fillOval(this.getX() - r, this.getY() - r, this.r * 2, this.r * 2);
	    }
	public void devierCap(double deltaC) {
		this.cap += deltaC;
	}
	public void deplacerSelonCap() {
		this.x = (int) (this.getX() + (this.r * Math.cos(this.cap)));
		this.y = (int) (this.getY() + (this.r * Math.sin(this.cap)));
		this.placerA(this.x, this.y);
	}
	public boolean CapOK(int xMax, int yMax) {
		double newX = this.x + this.r * Math.cos(this.cap);
		double newY = this.y + this.r * Math.sin(this.cap);
		return(newX >= this.r && newX <= (xMax - this.r) && newY >= this.r && newY <= (yMax - this.r));
	}	
}
