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
		sprites = new ArrayList<Sprite>();
		board = new ArrayList<Sprite>();
		addDummySprite();
	}
	
	private void addDummySprite(){
		Sprite tmp  = new Sprite();
		sprites.add(tmp);
	}
}