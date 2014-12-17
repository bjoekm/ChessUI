package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
		JPanel east = new JPanel();
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


