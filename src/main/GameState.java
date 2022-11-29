package main;

import java.awt.Graphics2D;

/**
 * Interface for game states. Defines basic functionality that needs to be implemented for every state.
 * @author Ryan Sharp
 *
 */
public interface GameState {
	/**
	 * Perform any updates needed between frames
	 */
	public void update();
	
	/**
	 * Redraw all components as needed between frames
	 * @param g2 - {@link Graphics2D} object used to draw
	 */
	public void draw(Graphics2D g2);
}
