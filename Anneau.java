package animation_chenile;
import java.awt.Graphics;
import javax.swing.*;
public class Anneau {
	protected int x;
	protected int y;
	protected int r;
	public Anneau() {
		
	}
	public Anneau(int x, int y , int r) {
		this.x = x;
		this.y = y;
		this.r=r;
	}
	public int getX() {
		return this.x;	
	}
	public int getY() {
		return this.y;
	}
	 public void placerA(int px, int py) {
	        this.x = px;
	        this.y = py;
	    }

	    public void placerA(Anneau a) {
	        this.x = a.x;
	        this.y = a.y;
	    }
	public void dessiner(Graphics g) {
		g.drawOval(x - r, y - r, 2 * r, 2 * r);
	}

}
