package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class Sprite extends Rectangle {
	
	private Image img;
	private Color dummyColor;
	private boolean moveable;
	private boolean selectable;
	private Point snapBackPoint;
	
	
	public Sprite(){
		this(null, Color.ORANGE, 30, 40, true, true);
	}
	
	public Sprite(Image img){
		this(img, Color.ORANGE, img.getHeight(null), img.getWidth(null), true, true);
	}
	
	public Sprite(Image img,Color c, int width, int height, boolean isMoveable, boolean isSelectable){
		this.img = img;
		this.width = width;
		this.height = height;
		this.moveable = isMoveable;
		this.selectable = isSelectable;
		snapBackPoint = new Point();
		dummyColor = c;
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
	
	public void setMiddlePointLocation(Point p){
		int halfWidth = Math.round((float)width/2);
		int halfHeight = Math.round((float)height/2);
		p.translate(-halfWidth,-halfHeight);
		this.setLocation(p);
	}
	
	public void setSnapBackPoint(){
		snapBackPoint.x = x;
		snapBackPoint.y = y;
	}
	
	public void snapBack(){
		x = snapBackPoint.x;
		y = snapBackPoint.y;
	}

	public boolean isMoveable() {
		return moveable;
	}

	public void setMoveable(boolean moveable) {
		this.moveable = moveable;
	}
}
