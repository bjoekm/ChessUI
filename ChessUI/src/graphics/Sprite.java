package graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

public class Sprite {

	public static final int DEFAULT_SPRITE_POSITION = 5;
	Image img;
	Point pos;
	
	public Sprite(Image img){
		this.img = img;
		pos = new Point(DEFAULT_SPRITE_POSITION,DEFAULT_SPRITE_POSITION);
	}
	
	public void setPos(Point newPos){
		pos = newPos;
	}
	
	public void draw(Graphics g){
		g.drawImage(img, pos.x, pos.y, null);
	}
}
