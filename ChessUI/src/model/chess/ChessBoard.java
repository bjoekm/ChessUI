package model.chess;

import java.awt.Image;


@SuppressWarnings("serial")
public class ChessBoard {

	ChessTile board[][];
	
	public int boardSize = 8;
	public int forbiddenBorder = 2;
	private ChessSide currentPlayer;
	public int totalGridSize = boardSize+2*forbiddenBorder;
	
	//Called logical indexs:
	//a1 maps to index (x,y) = (0,0);
	//May result in requests for negative places: will be handled by board
	
	public ChessBoard() {
		initNewGame();
	}
	
	public void clearBoard(){
		board = new ChessTile[totalGridSize][totalGridSize];
	}
	
	/**
	 * @param x - an integer between -2 and 9 => will translated to something between 0 and 11 where 2 to 9 are "allowed" squares
	 * @param y - an integer between -2 and 9 => will translated to something between 0 and 11 where 2 to 9 are "allowed" squares
	 */
	public ChessTile getPieceAtPos(int x, int y){
		x += forbiddenBorder;
		y += forbiddenBorder;
		return board[x][y];
	}
	
	public void initNewGame(){
		clearBoard();
		currentPlayer = ChessSide.WHITE;
		int row = 0;
		for(; row< forbiddenBorder; row++){
			addWholeRow(row, ChessType.FORBIDDEN, ChessSide.NEUTRAL);
		}
		
		addBackRow(row,ChessSide.WHITE);
		row++;
		addWholeRow(row,ChessType.PAWN, ChessSide.WHITE);
		row++;
		
		for(; row<boardSize-2;row++){
			addWholeRow(row,ChessType.EMPTY, ChessSide.NEUTRAL);
		}
		
		addWholeRow(row,ChessType.PAWN, ChessSide.BLACK);
		row++;
		addBackRow(row,ChessSide.BLACK);
		row++;
		
		for(; row< totalGridSize; row++){
			addWholeRow(row, ChessType.FORBIDDEN, ChessSide.NEUTRAL);
		}
	}
	
	private void addBackRow(int row,ChessSide side){
		addForbiddenInRow(row);
		int column = forbiddenBorder;
		board[row][column] = new ChessPiece(ChessType.ROOK, side);
		column++;
		board[row][column] = new ChessPiece(ChessType.KNIGHT, side);
		column++;
		board[row][column] = new ChessPiece(ChessType.BISHOP, side);
		column++;
		board[row][column] = new ChessPiece(ChessType.QUEEN, side);
		column++;
		board[row][column] = new ChessPiece(ChessType.KING, side);
		column++;
		board[row][column] = new ChessPiece(ChessType.BISHOP, side);
		column++;
		board[row][column] = new ChessPiece(ChessType.KNIGHT, side);
		column++;
		board[row][column] = new ChessPiece(ChessType.ROOK, side);
	}
	
	private void addWholeRow(int row, ChessType type, ChessSide side){
		addForbiddenInRow(row);
		for(int column = forbiddenBorder; column < boardSize; column++){
			board[row][column] = new ChessPiece(type, side);
		}
	}
	
	private void addForbiddenInRow(int row){
		int column = 0;
		board[row][column] = new ChessPiece(ChessType.FORBIDDEN, ChessSide.NEUTRAL);
		column++;
		board[row][column] = new ChessPiece(ChessType.FORBIDDEN, ChessSide.NEUTRAL);
		column = boardSize + forbiddenBorder;
		board[row][column] = new ChessPiece(ChessType.FORBIDDEN, ChessSide.NEUTRAL);
		column++;
		board[row][column] = new ChessPiece(ChessType.FORBIDDEN, ChessSide.NEUTRAL);
	}
}
