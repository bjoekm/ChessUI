package rules;

import java.awt.Point;
import java.util.ArrayList;

import graphics.Sprite;

public interface IGameModel {

	public ArrayList<Sprite> getBoard();
	public ArrayList<Sprite> getGameObjects();
	public void pointClicked(Point p);
	public void pointPressed(Point p);
	public void releasedPoint(Point p, boolean inside);
	public void pointDragged(Point p, boolean inside);
}
