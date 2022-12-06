package entity.towers;

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
		if(target != null && Math.hypot(target.getX() - x, target.getY() - y) > range) {
			target = null;
		}
			
		for(IEnemy e : gp.getState().getEnemyManager().getChildren()) {
			if(Math.hypot(e.getX() - x, e.getY() - y) <= range && // if enemy is within range
					(target == null || e.getDistanceTraveled() > target.getDistanceTraveled())) { // and if enemy is at the front of those within range, or there is no current target
				target = e;
				setAngle((Math.atan2(x - e.getX(), y - e.getY()) * -1) + Math.PI);
			}
		}
	}
	
}
