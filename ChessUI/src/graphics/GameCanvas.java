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

	private ArrayList<Sprite> sprites;
	private Sprite background;
	private boolean isDragginObjected;
	private Sprite draggedSprite = null;
	
	public GameCanvas(){
		this.setBackground(Color.CYAN);
		
		sprites = new ArrayList<Sprite>();
		
		Sprite tmp = new Sprite();
		sprites.add(tmp);
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		//TODO paint background first, if we have one
		for (Sprite spr : sprites) {
			spr.draw(g);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		String str = "Clicked: ";
		str += " (" + e.getX();
		str += " , " + e.getY() + ")";
		StatusPanel.setStatus(str,0);
		//System.out.println("Clicked test");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		String str = "Pressed ";
		str += " (" + e.getX();
		str += " , " + e.getY() + ")";
		StatusPanel.setStatus(str,3);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		String str = "Released";
		str += " (" + e.getX();
		str += " , " + e.getY() + ")";
		StatusPanel.setStatus(str,3);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		String str = "Inside ";
		StatusPanel.setStatus(str,2);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		String str = "Outside";
		StatusPanel.setStatus(str,2);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		String str = "Dragged: ";
		str += " (" + e.getX();
		str += " , " + e.getY() + ")";
		StatusPanel.setStatus(str,1);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		String str = "Moved: ";
		str += " (" + e.getX();
		str += " , " + e.getY() + ")";
		StatusPanel.setStatus(str,4);
	}
	
	
}

