package main;

import javax.swing.JFrame;

/**
 * 
 * @author RyiSnow (https://www.youtube.com/c/RyiSnow), Ryan Sharp
 * {@summary This is the only class that needs to be run in order to start the game.
 * 			 This class will be responsible for creating the graphical window that the game runs in.}
 *
 */
public class Main {

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
		window.add(gamePanel);
		
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		gamePanel.startGameThread();
	}

}
