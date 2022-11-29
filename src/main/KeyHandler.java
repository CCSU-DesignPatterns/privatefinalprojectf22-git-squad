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
			if(gp.getStateType().equals(StateType.PLAY)) {
				gp.updateState(StateType.PAUSE);
			}
			else if (gp.getStateType().equals(StateType.PAUSE)) {
				gp.updateState(StateType.PLAY);
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
