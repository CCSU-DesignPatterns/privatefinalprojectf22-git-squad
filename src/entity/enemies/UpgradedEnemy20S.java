package entity.enemies;

/**
 * decorator to give an enemy a bonus 20 strength
 * @author Ricardo Almeida
 *
 */
public class UpgradedEnemy20S extends UpgradedEnemy {
	private int BonusStrength = 20;
	
	public UpgradedEnemy20S(Enemy enemy) {
		super(enemy);
	}

	/**
	 * Returns the base enemy object's health
	 */
	@Override
	public int getHealth() {
		return baseEnemy.getHealth();
	}

	/**
	 * Returns the total strength of the upgraded enemy object
	 */
	@Override
	public int getStrength() {
		return baseEnemy.getStrength() + BonusStrength;
	}

	/**
	 * Causes the enemy object to take damage
	 */
	@Override
	public void takeDamage(int damage) {
		if(damage > 0 ) {
			baseEnemy.takeDamage(damage);
		}
	}

	/**
	 * Override to set the health of the base enemy object
	 */
	@Override
	public void setHealth(int health) {
		baseEnemy.setHealth(health);
	}

	/**
	 * Override method to set the strength of the upgraded enemy object
	 */
	@Override
	public void setStrength(int strength) {
		if(strength > 0) {
			BonusStrength = strength;
		}
	}

	@Override
	public void setOriginalHealth(int health) {
		baseEnemy.setOriginalHealth(health);
	}

	@Override
	public int getOriginalHealth() {
		return baseEnemy.getOriginalHealth();
	}
}
