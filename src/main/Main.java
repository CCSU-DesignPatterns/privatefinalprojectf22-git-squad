package main;

import javax.swing.JFrame;

/**
 * 
 * @author RyiSnow, Ryan Sharp
 * {@summary This is the only class that needs to be run in order to start the game.
 * 			 This class will be responsible for creating the graphical window that the game runs in.}
 *
 */
public class Main {

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Tower Defense");
		
		GamePanel gamePanel = GamePanel.getInstance();
		window.add(gamePanel);
		
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		gamePanel.startGameThread();
	}

}
