package rules;

import graphics.Sprite;

import java.awt.Point;
import java.util.ArrayList;

public class AbstractGameModel implements IGameModel {

	private boolean isDraggingObjected = false;
	private Sprite draggedSprite = null;
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
		for (Sprite  sprite : sprites) {
			if(sprite.isSelectable()){
				if(sprite.contains(p)){
					//Set selected
				}
			}
		}
	}

	public void pointPressed(Point p) {
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

	public void releasedPoint(Point p, boolean inside) {
		if(isDraggingObjected){
			if(!inside){
				draggedSprite.snapBack();
				return;
			}
			//Check if move was allowed or snapBack
			//draggedSprite.snapBack();
			isDraggingObjected = false;
			draggedSprite = null;
		}
	}

	public void pointDragged(Point p, boolean inside) {
		if(isDraggingObjected){
			draggedSprite.setMiddlePointLocation(p);
		}
	}

}