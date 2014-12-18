package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

@SuppressWarnings("serial")
public class Sprite extends Rectangle {
	
	private Image img;

	private boolean moveable;
	private boolean selectable;
	private Point snapBackPoint;
	
	public static final Sprite NULL = new NullSprite();
	
	public Sprite(){
		this(new SimpleImage(), true, true);
	}
	
	public Sprite(int width, int height, boolean isMoveable, boolean isSelectable){
		this(new SimpleImage(width, height), isMoveable, isSelectable);
	}
	
	public Sprite(Image img){
		this(img, true, true);
	}
	
	public Sprite(Image img, boolean isMoveable, boolean isSelectable){
		this.img = img;
		this.width = img.getHeight(null); //No callback object is supplied - assumes image is already loaded. 
		this.height = img.getWidth(null); //No callback object is supplied - assumes image is already loaded. 
		this.moveable = isMoveable;
		this.selectable = isSelectable;
		snapBackPoint = new Point();
	}
	
	public void draw(Graphics g){
		int intx = Math.round((float)getX());
		int inty = Math.round((float)getY());
		g.drawImage(img, intx, inty, null);
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

	public boolean isSelectable() {
		return selectable;
	}
	
	public void setSelectable(boolean selectable) {
		this.selectable = selectable;
	}
}

/**
 * Allows for the creation of a simple image filled with just one color. <p>
 *
 */
class SimpleImage extends BufferedImage {

	public static int DEFAULT_WIDTH = 30;
	public static int DEFAULT_HEIGHT = 40;
	public static Color DEFAULT_COLOR = Color.ORANGE;

	public SimpleImage(){
		this(DEFAULT_WIDTH,DEFAULT_HEIGHT, DEFAULT_COLOR);
	}
	
	public SimpleImage(int width, int height){
		this(width,height, DEFAULT_COLOR);
	}
	
	public SimpleImage(int width, int height, Color c) {
		super(width,height, BufferedImage.TYPE_INT_ARGB);
		Graphics g = this.getGraphics();
		g.setColor(c);
		g.fillRect(0, 0, width,height);
	}
}

@SuppressWarnings("serial")
class NullSprite extends Sprite {

	public NullSprite(){
		super(new SimpleImage(1,1, Color.BLACK), false, false);
		this.setLocation(-50, -50);
	}
	
	@Override
	public void draw(Graphics g){
		//Do nothing
	}
	
	@Override
	public void setMiddlePointLocation(Point p){
		//Do nothing
	}
	
	@Override
	public void setSnapBackPoint(){
		//Do nothing
	}
}
