package rules.chess;

import java.util.ArrayList;

import rules.AbstractGameModel;
import rules.Piece;

public class ChessModel extends AbstractGameModel {

	ArrayList<Piece> pieces;
	//Timers - timers with settings for each player
	//CurrentPlayer - just a enum of something to keep track of the current player
	//Rulebook - class that determines if a move is legal or not
	//MoveListing - class to store moves in, perhaps return to a certain point or fetch moves from.
	//Board representation
	
	public ChessModel(){
		
	}
	
	//selectPiece - called when a piece is selected
	//deslectPiece - called when a piece is deselcted
	//movePiece - called when trying to move a piece, will check with the rules.
	
	//EndTurn - called when a players turn ends
	//BeginTurn - called when a players turn begins
	
}
