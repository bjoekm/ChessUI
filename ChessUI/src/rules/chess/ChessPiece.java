package rules.chess;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import rules.Piece;

@SuppressWarnings("serial")
public class ChessPiece extends Piece{

	public static String RESOLUTION = "50px";
	
	
	private ChessType type;
	private ChessSide side;
	
	public ChessPiece(ChessType ct, ChessSide cs){
		//super(getChessPieceImage(ct, cs));
		type =  ct;
		side = cs;
	}
	
	public ChessType getType(){
		return type;
	}
	
	public ChessSide getSide(){
		return side;
	}
	
	public static Image getChessPieceImage(ChessType ct, ChessSide cs){
		
		String fileEnding = ".png";
		String path = "/";
		String getStr = path+ cs.getText() + "_" + ct.getText() +"_" + ChessPiece.RESOLUTION + fileEnding;
		
		Image imgTest = new ImageIcon(ChessPiece.class.getClassLoader().getResource(getStr)).getImage();
		return imgTest;
	}
	
}
