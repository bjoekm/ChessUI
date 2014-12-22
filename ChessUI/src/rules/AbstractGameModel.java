package rules;

import graphics.Sprite;

import java.awt.Point;
import java.util.ArrayList;

public class AbstractGameModel implements IGameModel {

	private Sprite draggedSprite = Sprite.NULL;
	protected ArrayList<Sprite> sprites;
	protected ArrayList<Sprite> board;

	public AbstractGameModel() {
		super();
	}

	public ArrayList<Sprite> getBoard() {
		return board;
	}

	public ArrayList<Sprite> getGameObjects() {
		return sprites;
	}

	public void pointClicked(Point p) {
		for (Sprite sprite : sprites) {
			if(sprite.isSelectable()){
				if(sprite.contains(p)){
					
					//Set selected
				}
			}
		}
	}

	public void pointPressed(Point p) {
		for (Sprite sprite : sprites) {
			if(sprite.isMoveable()){
				if(sprite.contains(p)){
					sprite.setSnapBackPoint();
					draggedSprite = sprite;
				}
			}
		}
	}

	public void releasedPoint(Point p, boolean inside) {
		if(!inside){
			draggedSprite.snapBack();
			return;
		}
		//Check if move was allowed or snapBack
		//draggedSprite.snapBack();
		draggedSprite = Sprite.NULL;
	}

	public void pointDragged(Point p, boolean inside) {
		draggedSprite.setMiddlePointLocation(p);
	}

}