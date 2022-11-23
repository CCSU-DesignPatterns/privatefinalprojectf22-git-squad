package main;

import java.awt.Graphics2D;

import entity.enemies.EnemyManager;
import entity.towers.TowerManager;
import tile.TileManager;
import ui.UI;

public class PausedState implements GameState {

	// Input handling and game thread
		private TileManager tileM;
		private TowerManager towerM;
		private EnemyManager enemyM;
		private UI ui;
		
		public PausedState(TileManager tileM, TowerManager towerM, EnemyManager enemyM) {
			this.tileM = tileM;
			this.towerM = towerM;
			this.enemyM = enemyM;
			this.ui = new UI();
		}
	
	@Override
	public void update() {
		// nothing, for now
		// will be updated if pause menu is implemented
	}

	@Override
	public void draw(Graphics2D g2) {
		tileM.draw(g2);
		enemyM.draw(g2);
		towerM.draw(g2);
		ui.draw(g2);
		g2.dispose();
	}

}
