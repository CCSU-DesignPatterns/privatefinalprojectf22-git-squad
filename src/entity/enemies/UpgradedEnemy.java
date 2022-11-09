package entity.enemies;

/**
 * Enemy upgrades Decorator
 * Used to upgrade existing enemies
 * @author Ricardo Almeida
 *
 */
public abstract class UpgradedEnemy {
	private static Enemy _upgEnemy;
	
	/**
	 * Basic constructor
	 * @param enemyEnt Enemy entity to wrap
	 */
	public UpgradedEnemy(Enemy enemyEnt) {
		_upgEnemy = enemyEnt;
	}
	
	/**
	 * To grant access to the wrapped enemy
	 * @return The wrapped Enemy entity
	 */
	public Enemy getInnerEnemy() {
		return _upgEnemy;
	}
}
