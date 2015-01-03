package model;

import model.chess.ChessTile;

public interface IBoard {

	public void initNewGame();
	public ChessTile getTileAtPos(int x, int y);
	
	
}
