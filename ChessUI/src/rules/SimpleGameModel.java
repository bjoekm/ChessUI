package rules;

import graphics.Sprite;

import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import rules.chess.ChessBoard;


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
		
		Image img = new ImageIcon(this.getClass().getResource("/black_bishop_50px.png")).getImage();
		Piece test = new Piece(img);
		
		Image img2 = new ImageIcon(this.getClass().getResource("/brown_board_208px.png")).getImage();
		Piece boardPart1 = new Piece(img2);
		
		pieces.add(tmp);
		pieces.add(test);
		ChessBoard b = new ChessBoard(img2);
		board.add(b);
		
	}
}