package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * The Sprite class contains the graphical info of a game entity, ie. entity's the actual position, bounding box and its graphical appearance (ie. its image). <p>
 * 
 * Keeps track of last "allowed" position to be able to return there if user input tries to place it in an disallowed space (example outside the canvas).<p>
 * Uses some local classes to allow for easy test sprites and null-object sprites to be created. <br>
 * @author Bjorn
 */
@SuppressWarnings("serial")
public class Sprite extends Rectangle {
	
	private Image img;
	public static final Sprite NULL = new NullSprite();
	
	public Sprite(){
		this(new SimpleImage());
	}
	
	public Sprite(int width, int height){
		this(new SimpleImage(width, height));
	}
	
	public Sprite(Image img){
		this.img = img;
		this.width = img.getWidth(null); //No callback object is supplied as it is assumed that image already was loaded completely. 
		this.height = img.getHeight(null); //No callback object is supplied as it is assumed that image already was loaded completely. 
	}
	
	public void draw(Graphics g){
		int intx = Math.round((float)getX());
		int inty = Math.round((float)getY());
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(intx, inty, width, width);
		g.drawImage(img, intx, inty, null); //No callback object is supplied as it is assumed that image already was loaded completely. 
	}
	
	public void setMiddlePointLocation(Point p){
		int halfWidth = Math.round((float)width/2);
		int halfHeight = Math.round((float)height/2);
		p.translate(-halfWidth,-halfHeight);
		this.setLocation(p);
	}
	
	public boolean isNull(){
		return false;
	}
}



/**
 * Creates a very small sprite outside the canvas bounds. If ever asked to be drawn/moved it just does nothing at all.<p>
 * 
 * This allows the gamemodel to always send appropriate commands to currently "selected" sprite without bothering a null check at all times. 
 */
@SuppressWarnings("serial")
class NullSprite extends Sprite {

	public NullSprite(){
		super(new SimpleImage(1,1, Color.BLACK));
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
	public boolean isNull(){
		return true;
	}
	
	@Override
	public String toString(){
		String str = super.toString();
		str = "NULL-Sprite: "+ str;
		return str;
	}
}
