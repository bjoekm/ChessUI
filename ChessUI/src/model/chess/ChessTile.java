package model.chess;

import graphics.Sprite;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

public class ChessTile{

	private Point pos;
	private ChessType type;
	private boolean selected;
	private boolean possible;
	
	public ChessTile(ChessType ct, int x, int y){
		possible = false;
		selected = false;
		type =  ct;
		pos = new Point(x,y);
	}
	
	public ChessType getType(){
		return type;
	}
	
}
