package main;

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

	/**
	 * {@summary Run this method to start the game!}
	 * @author RyiSnow
	 * @param args
	 */
	public static void main(String[] args) {
//		JFrame window = new JFrame();
//		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		window.setResizable(false);
//		window.setTitle("Tower Defense");
//		
//		GamePanel gamePanel = GamePanel.getInstance(); //Updated this to use singleton pattern rather than creating instance variable
//		window.add(gamePanel);
//		
//		window.pack();
//		
//		window.setLocationRelativeTo(null);
//		window.setVisible(true);
//		
//		gamePanel.requestFocusInWindow();
//		gamePanel.startGameThread();
		
		GamePanel gp = GamePanel.getInstance();
		
		JLayeredPane pane = new JLayeredPane();
		pane.setSize(gp.SCREEN_WIDTH, gp.SCREEN_HEIGHT);
		pane.add(gp, Integer.valueOf(1));
		
		JFrame frame = new JFrame("TD Game");
		frame.setSize(gp.SCREEN_WIDTH, gp.SCREEN_HEIGHT);
		frame.add(pane);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		gp.requestFocusInWindow();
		gp.startGameThread();
	}

}
