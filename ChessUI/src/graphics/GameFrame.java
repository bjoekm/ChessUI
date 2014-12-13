package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {

	public static final int DEFAULT_WIDTH = 800;
	public static final int DEFAULT_HEIGHT = 600;
	
	public GameFrame()  {




		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setLocationRelativeTo(null);
		setTitle("R - Type");
		setResizable(false);

		setLayout(new BorderLayout());
		JPanel north = new JPanel();
		north.setPreferredSize(new Dimension(this.getWidth(), 20));
		north.setBackground(Color.RED);
		JPanel south = new JPanel();
		south.setPreferredSize(new Dimension(this.getWidth(), 20));
		south.setBackground(Color.GREEN);
		JPanel east = new JPanel();
		east.setPreferredSize(new Dimension(250, this.getHeight()));
		east.setBackground(Color.BLUE);
		add(north, BorderLayout.NORTH);
		add(south, BorderLayout.SOUTH);
		add(east, BorderLayout.EAST);
		add(new Board(), BorderLayout.CENTER);
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new GameFrame();
	}
}


