package graphics;

import java.awt.Point;
import java.util.ArrayList;

import rules.IGameModel;

public class SimpleGameModel implements IGameModel{

	private boolean isDraggingObjected = false;
	private Sprite draggedSprite = null;
	private ArrayList<Sprite> sprites;
	private ArrayList<Sprite> board;
	
	public SimpleGameModel(){
		sprites = new ArrayList<Sprite>();
		board = new ArrayList<Sprite>();
		addDummySprite();
	}
	
	private void addDummySprite(){
		Sprite tmp  = new Sprite();
		sprites.add(tmp);
	}

	@Override
	public ArrayList<Sprite> getBoard() {
		return board;
	}

	@Override
	public ArrayList<Sprite> getGameObjects() {
		return sprites;
	}

	@Override
	public void pointClicked(Point p) {
		// TODO Auto-generated method stub
		
	}

	@Override
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

	@Override
	public void releasedPoint(Point p, boolean inside) {
		if(!inside){
			return;
		}
		
		if(isDraggingObjected){
			//Check if move was allowed or snapBack
			//draggedSprite.snapBack();
			isDraggingObjected = false;
			draggedSprite = null;
		}
	}

	@Override
	public void pointDragged(Point p, boolean inside) {
		if(isDraggingObjected){
			draggedSprite.setMiddlePointLocation(p);
		}
	}
}