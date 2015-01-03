package model.chess;

import java.awt.Point;

import graphics.Sprite;
import graphics.swingUI.StatusPanelSingelton;

public class ChessModel{

	//ArrayList<Piece> pieces;
	//Timers - timers with settings for each player
	//CurrentPlayer - just a enum of something to keep track of the current player
	//Rulebook - class that determines if a move is legal or not
	//MoveListing - class to store moves in, perhaps return to a certain point or fetch moves from.
	//Board representation
	//Selected Piece
	private ChessBoard board;
	private ChessTile selectedPiece = null;
	
	public ChessModel(){
		board = new ChessBoard();
	}
	
	public void tileSelected(Point p){
		tileSelected(p.x, p.y);
	}
	
	public void tileSelected(int x, int y){
		ChessTile selected = board.getPieceAtPos(x,y);
		if(selected != selectedPiece){
			pieceDeselected();
			selectedPiece = selected;
			System.out.println("selected");
		}
		StatusPanelSingelton.setStatus(selectedPiece.toString(),StatusPanelSingelton.SPRITE_SELECTION);
	}
	
	public void pieceDeselected(){
		System.out.println("desleceted");
		selectedPiece = null;
		StatusPanelSingelton.setStatus(selectedPiece.toString(),StatusPanelSingelton.SPRITE_SELECTION);
	}
	
	//selectPiece - called when a piece is selected
	//deslectPiece - called when a piece is deselcted
	//movePiece - called when trying to move a piece, will check with the rules.
	
	//EndTurn - called when a players turn ends
	//BeginTurn - called when a players turn begins
	
}
