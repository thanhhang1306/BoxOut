import javax.swing.ImageIcon;

public class Setting {
	private int x, y,size;
	private ImageIcon image;
	private String fileName;
	
	public Setting() {
		image = new ImageIcon();
		fileName = "";
	}
	
	public Setting(String s, int x, int y) {
		image = new ImageIcon(s);
		this.fileName = s;
		this.x = x;
		this.y = y;
		size = 50;
	}
	
	public ImageIcon getPic() {	
		return image;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
