package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * Allows for the creation of a simple image filled with just one color. <p>
 *
 */
public class SimpleImage extends BufferedImage {

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
