package entity.towers;

import java.awt.Graphics2D;

import entity.enemies.IEnemy;

/**
 * Sniper tower, able to fire at any enemy on screen for high damage, but at a slow rate.
 * @author Ryan Sharp
 *
 */
public class SniperTower extends Tower {
	
	/**
	 * Create a sniper tower at the given x and y pixels
	 * @param x
	 * @param y
	 */
	public SniperTower(int x, int y) {
		super(x, y, TowerType.SNIPER);
	}

	@Override
	public void attack() {
		target.takeDamage(damage);
	}

	@Override
	public void updateTarget() {
		for(IEnemy e : gp.getState().getEnemyManager().getChildren()) {
			if(e.getDistanceTraveled() > target.getDistanceTraveled()) { // and if enemy is at the front of those within range
				target = e;
			}
		}
	}
}
