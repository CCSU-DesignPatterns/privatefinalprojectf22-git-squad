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
				System.out.println("Pausing game...");
				gp.updateState(new PausedState(gp.TILE_MANAGER, gp.TOWER_MANAGER, gp.ENEMY_MANAGER));
			}
			else if (gp.getState().getType().equals(StateType.PAUSE)) {
				System.out.println("Resuming game...");
				gp.updateState(new GameplayState(gp.TILE_MANAGER, gp.TOWER_MANAGER, gp.ENEMY_MANAGER));
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
