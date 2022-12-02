package main;

import java.awt.Dimension;

import javax.swing.JFrame;
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
	 * @author Ryan Sharp
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Tower Defense");
		pane = window.getLayeredPane();
		
		GamePanel gamePanel = GamePanel.getInstance(); //Updated this to use singleton pattern rather than creating instance variable
		
		pane.setSize(new Dimension(gamePanel.SCREEN_WIDTH, gamePanel.SCREEN_HEIGHT));
		pane.setLocation(0, 0);
		pane.add(gamePanel, Integer.valueOf(0));
		
		window.setSize(gamePanel.SCREEN_WIDTH, gamePanel.SCREEN_HEIGHT);
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		gamePanel.requestFocusInWindow();
		gamePanel.startGameThread();
	}
	
	/**
	 * Get the layered pane in the application JFrame. Used by UI classes to add elements on top of GamePanel.
	 * @return The layered pane of the JFrame
	 */
	public static JLayeredPane getPane() { return pane; }
}
