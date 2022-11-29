package main;

import java.awt.Graphics2D;

import entity.SpriteNotFoundException;
import entity.enemies.EnemyManager;
import entity.towers.TowerManager;
import tile.TileManager;
import ui.GameplayUI;

/**
 * Game state used when the player is playing a level and the game is not paused
 * @author Ryan Sharp
 *
 */
public class GameplayState implements GameState {

	// Input handling and game thread
	private TileManager tileM;
	private TowerManager towerM;
	private EnemyManager enemyM;
	private GameplayUI ui;
	
	/**
	 * Create new gameplay state using the given tile, enemy, and tower managers.
	 * @param tileM
	 * @param towerM
	 * @param enemyM
	 */
	public GameplayState(TileManager tileM, TowerManager towerM, EnemyManager enemyM) {
		this.tileM = tileM;
		this.towerM = towerM;
		this.enemyM = enemyM;
		try {
			ui = new GameplayUI();
		}
		catch(SpriteNotFoundException e) {
			System.out.println("Error: GameplayUI could not find necessary images.");
		}
	}

	@Override
	public void update() {
		enemyM.update();
		towerM.update();
	}

	@Override
	public void draw(Graphics2D g2) {
		tileM.draw(g2);
		enemyM.draw(g2);
		towerM.draw(g2);
		g2.dispose();
	}

}
