package main;

import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;

import javax.swing.SwingUtilities;

import entity.enemies.EnemyManager;
import entity.towers.Tower;
import entity.towers.TowerManager;
import tile.TileManager;

public class PlacementState implements GameState {

	// Input handling and game thread
	private TileManager tileM;
	private TowerManager towerM;
	private EnemyManager enemyM;
	private Tower tower;
	private GamePanel gp;
	
	public PlacementState(TowerManager towerM, TileManager tileM, EnemyManager enemyM, Tower tower) {
		this.tileM = tileM;
		this.towerM = towerM;
		this.enemyM = enemyM;
		this.tower = tower;
		this.gp = GamePanel.getInstance();
	}
	
	@Override
	public void update() {
		Point p = MouseInfo.getPointerInfo().getLocation();
		SwingUtilities.convertPointFromScreen(p, gp);
		
		towerM.update();
		enemyM.update();
		tower.setPos(p.x - (gp.TILE_SIZE / 2), p.y - (gp.TILE_SIZE / 2));
	}

	@Override
	public void draw(Graphics2D g2) {
		tileM.draw(g2);
		enemyM.draw(g2);
		towerM.draw(g2);
		tower.draw(g2);
		g2.dispose();
	}

	@Override
	public StateType getType() {
		return StateType.PLACEMENT;
	}

	@Override
	public void endState() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Get the tower that is being placed
	 * @return {@link Tower} being placed
	 */
	public Tower getTower() { return tower; }
	
}
