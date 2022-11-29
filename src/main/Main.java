package main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

/**
 * 
 * @author RyiSnow (https://www.youtube.com/c/RyiSnow), Ryan Sharp
 * {@summary This is the only class that needs to be run in order to start the game.
 * 			 This class will be responsible for creating the graphical window that the game runs in.}
 *
 */
public class Main {

	private static JLayeredPane pane;
	
	/**
	 * {@summary Run this method to start the game!}
	 * @author RyiSnow
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Tower Defense");
		
		GamePanel gamePanel = GamePanel.getInstance(); //Updated this to use singleton pattern rather than creating instance variable
		
		pane = window.getLayeredPane();
		pane.setPreferredSize(new Dimension(gamePanel.SCREEN_WIDTH, gamePanel.SCREEN_HEIGHT));
		pane.add(gamePanel, Integer.valueOf(0));
		
		//window.add(pane);
		
		JLabel test = new JLabel("Test");
		test.setBackground(Color.gray);
		test.setForeground(Color.white);
		test.setBounds(50, 50, 50, 20);
		test.setVisible(true);
		test.setOpaque(true);
		pane.add(test, Integer.valueOf(1));
		
		window.setSize(gamePanel.SCREEN_WIDTH, gamePanel.SCREEN_HEIGHT);
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		gamePanel.requestFocusInWindow();
		gamePanel.startGameThread();
	}
	
	public JLayeredPane getPane() { return pane; }
}
