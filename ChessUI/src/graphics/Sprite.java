package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class Sprite extends Rectangle {
	
	private Image img;
	private Color dummyColor=Color.ORANGE;
	private boolean moveable = true;
	
	public Sprite(){
		this.img = null;
		height = 30;
		width = 40;
	}
	
	public Sprite(Image img){
		if(img == null){
			 //Call to other constructor.
		}
		this.img = img;
		height = img.getHeight(null);
		width = img.getWidth(null);
	}
	
	public void draw(Graphics g){
		if(img==null){
			drawDummyRect(g);
		}
		int intx = Math.round((float)getX());
		int inty = Math.round((float)getY());
		g.drawImage(img, intx, inty, null);
	}
	
	private void drawDummyRect(Graphics g){
		g.setColor(dummyColor);
		g.fillRect(x, y, width, height);
	}
	
	public void setDummyColor(Color c){
		dummyColor = c;
	}

	public boolean isMoveable() {
		return moveable;
	}

	public void setMoveable(boolean moveable) {
		this.moveable = moveable;
	}
}
