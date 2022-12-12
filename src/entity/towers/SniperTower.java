package entity.towers;

import java.awt.Rectangle;

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
		this.setCollisionBox(new Rectangle(TowerType.SNIPER.getCollisionInfo()[0] * gp.SCALE,
				TowerType.SNIPER.getCollisionInfo()[1] * gp.SCALE,
				TowerType.SNIPER.getCollisionInfo()[2] * gp.SCALE,
				TowerType.SNIPER.getCollisionInfo()[3] * gp.SCALE));
	}

	@Override
	public void attack() {
		if(target != null) {
			target.takeDamage(damage);
			if(target.getHealth() <= 0) {
				gp.getState().getPlayer().addMoney(damage + target.getHealth());
				target = null;
			}
			else {
				gp.getState().getPlayer().addMoney(damage);
			}
		}
	}

	@Override
	public void updateTarget() {
		for(IEnemy e : gp.getState().getEnemyManager().getChildren()) {
			if(target == null || e.getDistanceTraveled() > target.getDistanceTraveled()) { // and if enemy is at the front of those within range
				target = e;
				setAngle((Math.atan2(x - e.getX(), y - e.getY()) * -1) + Math.PI);
			}
		}
	}
}
