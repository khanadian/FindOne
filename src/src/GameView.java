package src;

import java.awt.BorderLayout;
import javax.swing.*;

public class GameView {

	JFrame frame;
	
	public GameView()
	{
		this.setup();
	}
	
	public static void main(String[] args)
	{
		new GameView();
	}
	
	private void setup()
	{
		JFrame frame = new JFrame("Find One");
		frame.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton north = new JButton("^");
		JButton south = new JButton("V");
		JButton west = new JButton("<");
		JButton east = new JButton(">");
		
		frame.add(north, BorderLayout.NORTH);
		frame.add(east, BorderLayout.EAST);
		frame.add(south, BorderLayout.SOUTH);
		frame.add(west, BorderLayout.WEST);
		
		
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
}
