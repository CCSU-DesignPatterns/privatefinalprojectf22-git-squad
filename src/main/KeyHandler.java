package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * {@summary Handles input detection from the user's keyboard.}
 * @author Ryan Sharp, RyiSnow
 *
 */
public class KeyHandler implements KeyListener{
	
	private GamePanel gp = GamePanel.getInstance();
	
	/**
	 * {@summary Called automatically when a key is typed.}
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	/**
	 * {@summary Called automatically when a key is pressed. Used to detect player input when needed.}
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_ESCAPE) {
			if(gp.getState().getType().equals(StateType.GAMEPLAY)) {
				GameplayState current = (GameplayState)gp.getState();
				System.out.println("Pausing game...");
				gp.updateState(new PausedState(current.getLevel(), current.getTowerManager(), current.getEnemyManager(), current.getPlayer()));
			}
			else if (gp.getState().getType().equals(StateType.PAUSE)) {
				PausedState current = (PausedState)gp.getState();
				System.out.println("Resuming game...");
				gp.updateState(new GameplayState(current.getLevel(), current.getTowerManager(), current.getEnemyManager(), current.getPlayer()));
			}
		}
		
	}
	
	/**
	 * {@summary Called automatically when a key is released. Used to detect end of user input when needed.}
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}

}
