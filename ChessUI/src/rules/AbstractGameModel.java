package rules;

import graphics.Sprite;
import graphics.swingUI.StatusPanel;

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
	
	public Sprite getSelected(){
		return selectedSprite;
	}
	
	public void pieceSelected(Sprite selected){
		if(selected != selectedSprite){
			pieceDeselected();
			selected.setSnapBackPoint();
			selectedSprite = selected;
			System.out.println("selected");
		}
		StatusPanel.setStatus(selectedSprite.toString(),StatusPanel.SPRITE_SELECTION);
	}
	
	public void pieceDeselected(){
		System.out.println("desleceted");
		selectedSprite = Sprite.NULL;
		StatusPanel.setStatus(selectedSprite.toString(),StatusPanel.SPRITE_SELECTION);
	}
	
	public void movePiece(Point newPos){
		if(selectedSprite.isMoveable()){
			if(moveIsAllowed(selectedSprite, newPos)){
				selectedSprite.setMiddlePointLocation(newPos);
				pieceDeselected();
			}else{
				selectedSprite.snapBack();
			}
		}
	}
	
	public boolean moveIsAllowed(Sprite selectedSzprite2, Point newPos){
		return true;
	}

	public void pointClicked(Point p) {
		boolean selected = false;
		for (Sprite sprite : pieces) {
			if(sprite.contains(p)){
				if(sprite.isSelectable()){
					System.out.println("selectable");
					pieceSelected(sprite);
					selected = true;
				}
			}
		}

		if(!selected){
			for (Sprite sprite : board) {
				if(sprite.contains(p)){
					if(sprite.isSelectable()){
						System.out.println("selectable");
						pieceSelected(sprite);	
					}else{
						movePiece(p);
					}
				}
			}
		}
		
	}

	public void releasedPoint(Point p, boolean inside) {
		if(!inside){
			selectedSprite.snapBack();
			return;
		}
		System.out.println("moved 2");
		movePiece(p);
		
	}

	public void pointDragged(Point p, boolean inside) {
		if(selectedSprite.isMoveable()){
			selectedSprite.setMiddlePointLocation(p);
		}
	}
}
