package entity.enemies;

import entity.*;

/**
 * Enemy upgrades Decorator
 * Used to upgrade existing enemies
 * @author Ricardo Almeida
 *
 */
public abstract class UpgradedEnemy implements IEnemy {
	
	protected final IEnemy baseEnemy;
	
	/**
	 * Basic constructor
	 * @param <code>enemy</code> Enemy entity to wrap
	 */
	public UpgradedEnemy(Enemy enemy) {
		baseEnemy = enemy;
	}
	
	
	public void update() {
		baseEnemy.update();
	}
}
