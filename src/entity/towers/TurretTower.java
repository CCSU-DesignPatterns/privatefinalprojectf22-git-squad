package entity.towers;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import entity.enemies.IEnemy;

/**
 * Turret type tower, able to rapidly attack enemies for a lower damage.
 * @author Ryan Sharp
 *
 */
public class TurretTower extends Tower {
	
	/**
	 * Create Turret Tower at given x and y pixels.
	 * @param x
	 * @param y
	 */
	public TurretTower(int x, int y) {
		super(x, y, TowerType.TURRET);
		this.setCollisionBox(new Rectangle(TowerType.TURRET.getCollisionInfo()[0] * gp.SCALE,
				TowerType.TURRET.getCollisionInfo()[1] * gp.SCALE,
				TowerType.TURRET.getCollisionInfo()[2] * gp.SCALE,
				TowerType.TURRET.getCollisionInfo()[3] * gp.SCALE));
	}

	@Override
	public void attack() {
		target.takeDamage(damage);
	}

	@Override
	public void updateTarget() {
		for(IEnemy e : gp.getState().getEnemyManager().getChildren()) {
			if(Math.sqrt((Math.pow((e.getX() - x), 2) + Math.pow(e.getY() - y, 2))) <= range && // if enemy is within range
					e.getDistanceTraveled() > target.getDistanceTraveled()) { // and if enemy is at the front of those within range
				target = e;
			}
		}
	}
	
}
