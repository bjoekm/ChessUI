package rules.chess;

import java.util.ArrayList;

import rules.AbstractGameModel;
import rules.Board;
import rules.Piece;

public class ChessModel extends AbstractGameModel {

	public ChessModel(){
		pieces = new ArrayList<Piece>();
		board = new ArrayList<Board>();
		addSprites();
	}
	
	private void addSprites(){
		Piece tmp  = new Piece();
		pieces.add(tmp);
	}
}
