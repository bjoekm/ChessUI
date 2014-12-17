package graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class GameCanvas extends Canvas implements MouseListener, MouseMotionListener, Runnable {

	private static final long DEFAULT_SLEEP = 20L; //draw once every 20 ms ie 50 Hz
	private ArrayList<Sprite> sprites;
	private Sprite background;
	private boolean isDraggingObjected = false;
	private Sprite draggedSprite = null;
	
	public GameCanvas(){
		this.setBackground(Color.CYAN);
		
		sprites = new ArrayList<Sprite>();
		
		Sprite tmp = new Sprite();
		sprites.add(tmp);
		addMouseListener(this);
		addMouseMotionListener(this);
		this.setIgnoreRepaint(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		String str = "Clicked: ";
		str += " (" + e.getX();
		str += " , " + e.getY() + ")";
		StatusPanel.setStatus(str,StatusPanel.CLICKED_STATUS_IND);
		//System.out.println("Clicked test");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		String str = "Pressed ";
		str += " (" + e.getX();
		str += " , " + e.getY() + ")";
		StatusPanel.setStatus(str,StatusPanel.PRESSED_RELEASED_STATUS_IND);
		
		Point p = e.getPoint();
		
		for (Sprite  sprite : sprites) {
			if(sprite.isMoveable()){
				if(sprite.contains(p)){
					sprite.setSnapBackPoint();
					isDraggingObjected = true;
					draggedSprite = sprite;
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		String str = "Released";
		str += " (" + e.getX();
		str += " , " + e.getY() + ")";
		StatusPanel.setStatus(str,StatusPanel.PRESSED_RELEASED_STATUS_IND);
		
		if(isDraggingObjected){
			//Check if move was allowed or snapBack
			//draggedSprite.snapBack();
			isDraggingObjected = false;
			draggedSprite = null;
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		String str = "Inside ";
		StatusPanel.setStatus(str,StatusPanel.IN_OUT_STATUS_IND);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		String str = "Outside";
		StatusPanel.setStatus(str,StatusPanel.IN_OUT_STATUS_IND);
		
		if(isDraggingObjected){
			draggedSprite.snapBack();
			isDraggingObjected = false;
			draggedSprite = null;
		}
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		String str = "Dragged: ";
		str += " (" + e.getX();
		str += " , " + e.getY() + ")";
		StatusPanel.setStatus(str,StatusPanel.DRAGGED_STATUS_IND);
		
		if(isDraggingObjected){
			draggedSprite.setMiddlePointLocation(e.getPoint());
			//repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		String str = "Moved: ";
		str += " (" + e.getX();
		str += " , " + e.getY() + ")";
		StatusPanel.setStatus(str,StatusPanel.MOUSE_MOVED_STATUS_IND);
	}

	@Override
	public void run() {
		long beforeTime, timeDiff, time2sleep;
		beforeTime = System.currentTimeMillis();
		
		while(true){
			draw();
			timeDiff = System.currentTimeMillis()-beforeTime;
			time2sleep = DEFAULT_SLEEP - timeDiff;
			if(time2sleep<0){
				time2sleep = 1L;
			}
			
			StatusPanel.setStatus("Sleep: "+time2sleep , StatusPanel.SLEEP_TIME_STATUS_IND);
			
			try {
				Thread.sleep(time2sleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			beforeTime = System.currentTimeMillis();
		
		}
	}
	
	public void draw(){
		BufferStrategy buffer = this.getBufferStrategy();
		if(buffer==null){
			this.createBufferStrategy(2);
			return;
		}
		
		Graphics g = buffer.getDrawGraphics();
		
		this.paint(g);
		//TODO paint background first, if we have one
		for (Sprite spr : sprites) {
			spr.draw(g);
		}
		
		g.dispose();
		buffer.show();
	}
}

