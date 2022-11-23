package main;

import java.awt.Graphics2D;

import entity.enemies.EnemyManager;
import entity.towers.TowerManager;
import tile.TileManager;

public class PlayingState implements GameState {

	// Input handling and game thread
	private TileManager tileM;
	private TowerManager towerM;
	private EnemyManager enemyM;
	
	public PlayingState(TileManager tileM, TowerManager towerM, EnemyManager enemyM) {
		this.tileM = tileM;
		this.towerM = towerM;
		this.enemyM = enemyM;	}
	
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
