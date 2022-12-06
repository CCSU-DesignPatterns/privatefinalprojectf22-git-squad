package main;

import java.awt.Graphics2D;

import entity.enemies.EnemyManager;
import entity.towers.TowerManager;
import levels.Level;
import ui.PauseUI;

/**
 * Game state used when the player is in a level and the game is paused
 * @author Ryan Sharp
 *
 */
class PausedState implements GameState {

	// Input handling and game thread
	private Level level;
	private TowerManager towerM;
	private EnemyManager enemyM;
	private Player player;
	private PauseUI ui;
	
	/**
	 * Create new paused state with the given tile, tower, and enemy managers
	 * @param tileM
	 * @param towerM
	 * @param enemyM
	 */
	public PausedState(Level level, TowerManager towerM, EnemyManager enemyM, Player player) {
		this.level = level;
		this.towerM = towerM;
		this.enemyM = enemyM;
		this.player = player;
		this.ui = new PauseUI();
	}
	
	@Override
	public void update() {
		// nothing, for now
		// will be updated if pause menu is implemented
	}

	@Override
	public void draw(Graphics2D g2) {
		level.draw(g2);
		enemyM.draw(g2);
		towerM.draw(g2);
		g2.dispose();
	}

	@Override
	public StateType getType() {
		return StateType.PAUSE;
	}

	@Override
	public void endState() {
		ui.remove();
	}
	
	/**
	 * Get this state's tile manager
	 * @return Current {@link TileManager}
	 */
	public Level getLevel() { return level; }
	
	/**
	 * Get this state's tower manager
	 * @return Current {@link TowerManager}
	 */
	public TowerManager getTowerManager() { return towerM; }
	
	/**
	 * Get this state's enemy manager
	 * @return Current {@link EnemyManager}
	 */
	public EnemyManager getEnemyManager() { return enemyM; }
	
	/**
	 * Get this state's player
	 * @return Current {@link Player}
	 */
	public Player getPlayer() { return player; }

}
