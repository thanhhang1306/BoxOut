import java.awt.Color;
import java.awt.Graphics;

public class Laser {
	private int[] x, y;
	private int x1, y1;
	private int width = 5,  height = 40;
	
	public Laser() {
		
	}
	
	public Laser(int y) {
		x1 = 350;
		this.y1 = y;
		width = 5; 
		height = 40;
	}
	public Laser (int[] x, int[] y) {
		this.x = x;
		this.y = y;
	}
	
	public void drawLaser(Graphics g) {
		g.setColor(Color.red);
		g.fillPolygon(x,y, 4);
	}
	
	
	public void moveLaser() {
		for(int j = 0; j < x.length; j++) {
			x[j] += 7;	
		}
	}
	
	
	
	public int getXClosest() {
		return x[0];
	}
	public int getXFarthest() {
		return x[2];
	}
	
	public int getYClosest() {
		return y[0];
	}
	public int getYFarthest() {
		return y[1];
	}
}
