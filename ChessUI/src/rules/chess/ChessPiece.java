package rules.chess;

import java.awt.Graphics;

import rules.Piece;

@SuppressWarnings("serial")
public class ChessPiece extends Piece{

	private ChessType type;
	private ChessSide side;
	
	public ChessPiece(ChessType ct, ChessSide cs){
		//load picture depending on type?
		type =  ct;
	}
	
	public ChessType getType(){
		return type;
	}
	
	public ChessSide getSide(){
		return side;
	}
	
	
	
}
