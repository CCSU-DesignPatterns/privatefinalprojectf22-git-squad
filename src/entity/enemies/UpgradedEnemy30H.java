package entity.enemies;

/**
 * Decorator that upgrades the health of Enemy entities
 * @author Ricardo Almeida
 *
 */
public class UpgradedEnemy30H extends UpgradedEnemy {
	private final int BonusHealth = 30;
	
	public UpgradedEnemy30H(Enemy enemy) {
		super(enemy);
		super.baseEnemy.setHealth(super.baseEnemy.getHealth() + BonusHealth);
	}

	@Override
	public int getHealth() {
		return super.baseEnemy.getHealth();
	}


	@Override
	public int getStrength() {
		return super.baseEnemy.getStrength();
	}
}
