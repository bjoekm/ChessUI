package graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class Sprite extends Rectangle {
	
	private Image img;
	
	public Sprite(Image img){
		this.img = img;
		height = img.getHeight(null);
		width = img.getWidth(null);
	}
	
	public void draw(Graphics g){
		int intx = Math.round((float)getX());
		int inty = Math.round((float)getY());
		g.drawImage(img, intx, inty, null);
	}
}
