package entity.towers;

import java.awt.Graphics2D;

import entity.enemies.IEnemy;

public class TurretTower extends Tower implements ITower {

	public TurretTower(int x, int y) {
		super(x, y, TowerType.TURRET);
	}

	@Override
	public void attack() {
		target.takeDamage(damage);
	}

	@Override
	public void updateTarget() {
		for(IEnemy e : gp.enemyM.getChildren()) {
			if(Math.sqrt((Math.pow((e.getX() - x), 2) + Math.pow(e.getY() - y, 2))) <= range && // if enemy is within range
					e.getDistanceTravelled() > target.getDistanceTravelled()) { // and if enemy is at the front of those within range
				target = e;
			}
		}
	}
	
}
