package graphics.swingUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 * Main class for the ChessUI-project. <p>
 * 
 * Creates the frame and the different panels. <p>
 * Idea:
 * <li>One panel to the left showing the game with its board and pieces.
 * <li>One panel to the right showing timers and previous moves.
 * <li>One panel at the bottom with status texts <p><br>
 * 
 * Currently also have a panel at the top - unknown. Could be used for some sort of scorekeeping.
 * 
 * @author Bjorn
 *
 */
@SuppressWarnings("serial")
public class GameFrame extends JFrame {

	public static final int DEFAULT_WIDTH = 800;
	public static final int DEFAULT_HEIGHT = 600;
	
	public GameFrame()  {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setLocationRelativeTo(null);
		setTitle("A square based board game with two players");
		setResizable(true);
		setLayout(new BorderLayout());
		
		//SEtup north panel layout
		JPanel north = new JPanel();
		north.setPreferredSize(new Dimension(this.getWidth(), 20));
		north.setBackground(Color.RED);
		
		//Setup South panel layout
		StatusPanel statusLabel = StatusPanel.getInstance();
		statusLabel.setPreferredSize(new Dimension(this.getWidth(), 40));
		statusLabel.setBackground(Color.GREEN);
		
		//Setup East panel
		EventDisplayPanel east = EventDisplayPanel.getInstance();
		east.setPreferredSize(new Dimension(250, this.getHeight()));
		east.setBackground(Color.BLUE);
		
		//Setup gamecanvas (center)
		GameCanvas canvas = new GameCanvas();
		Thread t = new Thread(canvas);
		
		//Add panels
		add(north, BorderLayout.NORTH);
		add(statusLabel, BorderLayout.SOUTH);
		add(east, BorderLayout.EAST);
		add(canvas, BorderLayout.CENTER);
		
		setVisible(true);
		t.start();
	}

	public static void main(String[] args) {
		new GameFrame();
	}
}


