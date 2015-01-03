package rules;

import java.awt.Point;
import java.util.ArrayList;

import graphics.Sprite;

/**
 * An interface describing communication between an actual game model and the canvas. <p>
 * The canvas is responsible for drawing all sprites.
 * It listens for mouse events inside it and send them along to the underlying game model. <br>
 * Using this interface allows (in theory) for easier functionality testing of the actual game logic as one
 * only have to supply points rather than events. 
 * 
 * @author Bjorn
 */
public interface IGameModel {

	public ArrayList<? extends Sprite> getBoard();
	public ArrayList<? extends Sprite> getGameObjects();
	public void pointClicked(Point p);
	public void releasedPoint(Point p, boolean inside);
	public void pointDragged(Point p, boolean inside);
}
