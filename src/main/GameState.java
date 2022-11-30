package main;

import java.awt.Graphics2D;

import entity.enemies.EnemyManager;
import entity.towers.TowerManager;
import tile.TileManager;

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
	
	/**
	 * Perform any actions necessary before switching states
	 */
	public void endState();
	
	/**
	 * Get the type of this state
	 * @return StateType enum for this type of state
	 */
	public StateType getType();
	
	/**
	 * Get this state's tile manager
	 * @return Current {@link TileManager}
	 */
	public TileManager getTileManager();
	
	/**
	 * Get this state's tower manager
	 * @return Current {@link TowerManager}
	 */
	public TowerManager getTowerManager();
	
	/**
	 * Get this state's enemy manager
	 * @return Current {@link EnemyManager}
	 */
	public EnemyManager getEnemyManager();
	
	/**
	 * Get this state's player
	 * @return Current {@link Player}
	 */
	public Player getPlayer();
}
