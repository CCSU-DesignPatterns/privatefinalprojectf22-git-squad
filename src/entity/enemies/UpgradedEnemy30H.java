package entity.enemies;

/**
 * Decorator that upgrades the health of Enemy entities
 * @author Ricardo Almeida
 *
 */
public class UpgradedEnemy30H extends UpgradedEnemy {
	protected int upgradedHealth = 30;				// The upgraded health amount. Should not go above the max bonus amount
	private final int maxHealth = upgradedHealth;	// CONSTANT: The max bonus health amount for this upgrade (gets the initial 30 amount)
	
	/**
	 * Default constructor that takes an Enemy type as the base object to be upgraded
	 * @param enemy The Enemy object to be upgraded 
	 */
	public UpgradedEnemy30H(Enemy enemy) {
		super(enemy);
		upgradedHealth = baseEnemy.getHealth() + maxHealth;
	}

	/**
	 * Returns the total health of the upgraded enemy object
	 */
	@Override
	public int getHealth() {
		return baseEnemy.getHealth() + upgradedHealth;
	}

	/**
	 * Returns the base enemy object's strength
	 */
	@Override
	public int getStrength() {
		return baseEnemy.getStrength();
	}

	/**
	 * takeDamage method override that applies health damage to the
	 * upgraded enemy and the base enemy objects
	 */
	@Override
	public void takeDamage(int damage) {
		if(damage > 0) {
			if(damage <= upgradedHealth) {
				upgradedHealth -= damage;
			}
			else {
				int subDamage = damage - upgradedHealth;
				upgradedHealth = 0;
				baseEnemy.takeDamage(subDamage);
			}	
		}
	}

	@Override
	public void setHealth(int health) {
		if(upgradedHealth < maxHealth) {
			int difference = maxHealth - upgradedHealth;
			upgradedHealth =+ difference;
			baseEnemy.setHealth(health - difference);
		}
		else {
			baseEnemy.setHealth(health);
		}
	}

	@Override
	public void setStrength(int strength) {
		baseEnemy.setStrength(strength);
	}
}
