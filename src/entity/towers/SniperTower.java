package entity.towers;

import java.awt.Graphics2D;

import entity.enemies.IEnemy;

public class SniperTower extends Tower implements ITower {

	public SniperTower(int x, int y) {
		super(x, y, TowerType.SNIPER);
	}

	@Override
	public void attack() {
		target.takeDamage(damage);
	}

	@Override
	public void updateTarget() {
		for(IEnemy e : gp.enemyM.getChildren()) {
			if(e.getDistanceTraveled() > target.getDistanceTraveled()) { // and if enemy is at the front of those within range
				target = e;
			}
		}
	}
}
