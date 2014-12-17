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

import rules.IGameModel;

/**
 * Tasked with updating the graphics and handling mouse events concerning the game<p>
 * 
 * Is a part of the graphical layer in the ChessUI project. <br>
 * Extends the {@link Canvas} class and implements the {@link MouseListener}, {@link MouseMotionListener} and {@link Runnable} interfaces. <p>
 * 
 * It is in this panel/area that the actual game plays out. MouseEvents are caught and the relevant ones are sent to the underlying gameModel
 * where sprites and game state should be updated according to the game rules. Meanwhile this class is responsible for the continuous 
 * redrawing of all graphics using a {@link BufferStrategy} to help with the animation part. 
 * 
 * @author bjoekm
 */
@SuppressWarnings("serial")
public class GameCanvas extends Canvas implements MouseListener, MouseMotionListener, Runnable {

	private static final long DEFAULT_SLEEP = 20L; //draw once every 20 ms ie 50 Hz
	private ArrayList<Sprite> sprites;
	private ArrayList<Sprite> board;

	private boolean inside = true;
	private int printSleepCounter = 0;
	private IGameModel model;
	
	public GameCanvas(){
		
		this(new SimpleGameModel());
		this.setBackground(Color.CYAN);
	}
	
	public GameCanvas(IGameModel model){
		this.model = model;
		board = model.getBoard();
		sprites = model.getGameObjects();
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
		model.pointClicked(e.getPoint());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		String str = "Pressed ";
		str += " (" + e.getX();
		str += " , " + e.getY() + ")";
		StatusPanel.setStatus(str,StatusPanel.PRESSED_RELEASED_STATUS_IND);
		model.pointPressed(e.getPoint());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		String str = "Released";
		str += " (" + e.getX();
		str += " , " + e.getY() + ")";
		StatusPanel.setStatus(str,StatusPanel.PRESSED_RELEASED_STATUS_IND);
		model.releasedPoint(e.getPoint(), inside);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		String str = "Inside ";
		str += " (" + e.getX();
		str += " , " + e.getY() + ")";
		StatusPanel.setStatus(str,StatusPanel.IN_OUT_STATUS_IND);
		inside = true;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		String str = "Outside";
		str += " (" + e.getX();
		str += " , " + e.getY() + ")";
		StatusPanel.setStatus(str,StatusPanel.IN_OUT_STATUS_IND);
		inside = false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		String str = "Dragged: ";
		str += " (" + e.getX();
		str += " , " + e.getY() + ")";
		StatusPanel.setStatus(str,StatusPanel.DRAGGED_STATUS_IND);
		model.pointDragged(e.getPoint(), inside);
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
			printSleepCounter++;
			if(printSleepCounter == 4){
				printSleepCounter = 0;
				StatusPanel.setStatus("Sleep: "+time2sleep , StatusPanel.SLEEP_TIME_STATUS_IND);
			}
			
			
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
		for (Sprite spr : board) {
			spr.draw(g);
		}
		for (Sprite spr : sprites) {
			spr.draw(g);
		}
		
		g.dispose();
		buffer.show();
	}
}

