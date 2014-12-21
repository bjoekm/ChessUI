package graphics.swingUI;

import graphics.Sprite;

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
import rules.SimpleGameModel;

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

	/**
	 * Determines how close to the canvas edge one can move a sprite's center coord.
	 */
	public static final int DRAGGING_BORDER_SIZE = 10;
	
	/**
	 * Draw once every 20 ms ie. 50 Hz
	 */
	public static final long DEFAULT_SLEEP = 20L;
	private int printSleepCounter = 0; //Difficult to read sleep time i status bar i printing at 50 Hz
	private ArrayList<? extends Sprite> sprites; //Sprites drawn second
	private ArrayList<? extends Sprite> board;//Sprites drawn first

	private boolean inside = true; //True if mouse pointer is inside the canvas bounds
	private IGameModel model;
	
	public GameCanvas(IGameModel model){
		this.setBackground(Color.CYAN);
		this.model = model;
		board = model.getBoard();
		sprites =  model.getGameObjects();
		addMouseListener(this);
		addMouseMotionListener(this);
		this.setIgnoreRepaint(true);
	}
	
	public GameCanvas(){
		this(new SimpleGameModel());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		String str = "Clicked: ";
		StatusPanel.setStatusWithPoint(str,e.getPoint(),StatusPanel.CLICKED_STATUS_IND);
		model.pointClicked(e.getPoint());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		String str = "Pressed ";
		StatusPanel.setStatusWithPoint(str,e.getPoint(),StatusPanel.PRESSED_RELEASED_STATUS_IND);
		model.pointClicked(e.getPoint());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		String str = "Released";
		StatusPanel.setStatusWithPoint(str,e.getPoint(),StatusPanel.PRESSED_RELEASED_STATUS_IND);
		model.releasedPoint(e.getPoint(), inside);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		String str = "Inside ";
		StatusPanel.setStatusWithPoint(str,e.getPoint(),StatusPanel.IN_OUT_STATUS_IND);
		inside = true;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		String str = "Outside";
		StatusPanel.setStatusWithPoint(str,e.getPoint(),StatusPanel.IN_OUT_STATUS_IND);
		inside = false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int px = e.getX();
		int py = e.getY();
		StatusPanel.setStatusWithPoint("Dragged: ", e.getPoint(),StatusPanel.DRAGGED_STATUS_IND);
		
		//Make sure the sent point is always inside the canvas bounds
		if(px<DRAGGING_BORDER_SIZE){
			px = DRAGGING_BORDER_SIZE;
		}else if(px > getWidth() -DRAGGING_BORDER_SIZE){
			px = getWidth()-DRAGGING_BORDER_SIZE;
		}
		
		if(py<DRAGGING_BORDER_SIZE){
			py = DRAGGING_BORDER_SIZE;
		}else if(py > getHeight()-DRAGGING_BORDER_SIZE ){
			py = getHeight()-DRAGGING_BORDER_SIZE;
		}
		
		model.pointDragged(new Point(px,py), inside);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		String str = "Moved: ";
		StatusPanel.setStatusWithPoint(str,e.getPoint(),StatusPanel.MOUSE_MOVED_STATUS_IND);
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
	
	private void draw(){
		BufferStrategy buffer = this.getBufferStrategy();
		if(buffer==null){
			//Initialisation of the Strategy seems to need to be done after JFrame.setVisible(true)
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

