package entity.enemies;

import entity.*;

/**
 * Enemy upgrades Decorator
 * Used to upgrade existing enemies
 * @author Ricardo Almeida
 *
 */
public abstract class UpgradedEnemy implements iEnemy {
	
	protected final Enemy upgradedEnemy;
	
	/**
	 * Basic constructor
	 * @param enemyEnt Enemy entity to wrap
	 */
	public UpgradedEnemy(Enemy enemyEnt) {
		upgradedEnemy = enemyEnt;
	}
	
	@Override
	public void attack(Entity target) {
		upgradedEnemy.attack(target);
	}
	
	@Override
	public void update() {
		upgradedEnemy.update();
	}
}
