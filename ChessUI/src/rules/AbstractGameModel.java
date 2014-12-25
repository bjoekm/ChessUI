package rules;

import graphics.Sprite;

import java.awt.Point;
import java.util.ArrayList;

public abstract class AbstractGameModel implements IGameModel {

	protected Sprite selectedSprite = Sprite.NULL;
	protected ArrayList<Piece> pieces;
	protected ArrayList<Board> board;
	

	public AbstractGameModel() {
		super();
	}

	public ArrayList<? extends Sprite> getBoard() {
		return board;
	}

	public ArrayList<? extends Sprite> getGameObjects() {
		return pieces;
	}
	
	public void pieceSelected(Sprite selected){
		if(selected != selectedSprite){
			pieceDeselected();
			selected.setSnapBackPoint();
			selectedSprite = selected;
		}
	}
	
	public void pieceDeselected(){
		selectedSprite = Sprite.NULL;
	}
	
	public void movePiece( Point newPos){
		if(selectedSprite.isMoveable()){
			if(moveIsAllowed(selectedSprite, newPos)){
				selectedSprite.setMiddlePointLocation(newPos);
				pieceDeselected();
			}else{
				selectedSprite.snapBack();
			}
		}
	}
	
	public boolean moveIsAllowed(Sprite selectedSprite2, Point newPos){
		return true;
	}

	public void pointClicked(Point p) {
		for (Sprite sprite : pieces) {
			if(sprite.isSelectable()){
				if(sprite.contains(p)){
					pieceSelected(sprite);
				}
			}
		}
	}

	public void releasedPoint(Point p, boolean inside) {
		if(!inside){
			selectedSprite.snapBack();
			return;
		}
		movePiece(p);
	}

	public void pointDragged(Point p, boolean inside) {
		if(selectedSprite.isMoveable()){
			selectedSprite.setMiddlePointLocation(p);
		}
	}

}