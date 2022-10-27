package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * {@summary Handles input detection from the user's keyboard.}
 * @author RyiSnow
 *
 */
public class KeyHandler implements KeyListener{

//	public boolean upPressed, downPressed, leftPressed, rightPressed;
	
	/**
	 * {@summary Called automatically when a key is typed.}
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * {@summary Called automatically when a key is pressed. Used to detect player input when needed.}
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		
//		int code = e.getKeyCode();
//		
//		if (code == KeyEvent.VK_W) {
//			upPressed = true;
//		}
//		else if(code == KeyEvent.VK_S) {
//			downPressed = true;
//		}
//		else if(code == KeyEvent.VK_A) {
//			leftPressed = true;
//		}
//		else if(code == KeyEvent.VK_D) {
//			rightPressed = true;
//		}
		
	}
	
	/**
	 * {@summary Called automatically when a key is released. Used to detect end of user input when needed.}
	 */
	@Override
	public void keyReleased(KeyEvent e) {
//		int code = e.getKeyCode();
//		
//		if (code == KeyEvent.VK_W) {
//			upPressed = false;
//		}
//		else if(code == KeyEvent.VK_S) {
//			downPressed = false;
//		}
//		else if(code == KeyEvent.VK_A) {
//			leftPressed = false;
//		}
//		else if(code == KeyEvent.VK_D) {
//			rightPressed = false;
//		}
	}

}
