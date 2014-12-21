package rules;

import graphics.Sprite;

import java.util.ArrayList;


/**
 * Simple stub implementation of a game model allowing for simple tests of sprites movement.
 * @author Bjorn
 *
 */
public class SimpleGameModel extends AbstractGameModel{

	public SimpleGameModel(){
		pieces = new ArrayList<Piece>();
		board = new ArrayList<Board>();
		addDummySprite();
	}
	
	private void addDummySprite(){
		Piece tmp  = new Piece();
		pieces.add(tmp);
	}
}