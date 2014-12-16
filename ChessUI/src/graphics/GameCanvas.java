package graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class GameCanvas extends Canvas implements MouseListener, MouseMotionListener {

	ArrayList<Sprite> sprites;
	Sprite background;
	
	public GameCanvas(){
		this.setBackground(Color.CYAN);
		
		sprites = new ArrayList<Sprite>();
		
		Sprite tmp = new Sprite();
		sprites.add(tmp);
		this.addMouseListener(this);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		for (Sprite spr : sprites) {
			spr.draw(g);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Clicked test");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Pressed test");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Released test");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("entered test");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("exited test");
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Point p = e.getPoint();
		//showStatus("mouse Dragged to " + p);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
	
	
}

