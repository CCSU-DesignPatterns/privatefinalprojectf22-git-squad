package main;

import java.awt.Graphics2D;

import entity.SpriteNotFoundException;
import entity.enemies.EnemyManager;
import entity.towers.TowerManager;
import levels.Level;
import ui.GameplayUI;

/**
 * Game state used when the player is playing a level and the game is not paused
 * @author Ryan Sharp
 *
 */
public class GameplayState implements GameState {

	// Input handling and game thread
	private Level level;
	private TowerManager towerM;
	private EnemyManager enemyM;
	private Player player;
	private GameplayUI ui;
	
	/**
	 * Create new gameplay state using the given tile, enemy, and tower managers.
	 * @param tileM
	 * @param towerM
	 * @param enemyM
	 */
	public GameplayState(Level level, TowerManager towerM, EnemyManager enemyM, Player player) {
		this.level = level;
		this.towerM = towerM;
		this.enemyM = enemyM;
		this.player = player;
		try {
			ui = new GameplayUI();
		}
		catch(SpriteNotFoundException e) {
			System.out.println("Error: GameplayUI could not find necessary images.");
		}
		
	}

	@Override
	public void update() {
		ui.setHealth(player.getHealth());
		ui.setMoney(player.getMoney());
		enemyM.update();
		towerM.update();
		if(enemyM.getWaves().getRunning() == false && enemyM.getChildren().size() == 0) {
			ui.setWaveRunning(false);
		}
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
		return StateType.GAMEPLAY;
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
