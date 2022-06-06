import java.awt.Color;

public class Level {
	private int x, y, size;
	private Color c;
	
	public Level() {
		size = 75;
	}
	
	public Level(int x, int y, Color c) {
		this.x = x;
		this.y = y;
		this.c = c; 
		size = 70;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public Color getColor() {
		return c;
	}
}
