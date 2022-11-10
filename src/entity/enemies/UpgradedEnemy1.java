package entity.enemies;

/**
 * Decorator that upgrades the health of Enemy entities
 * @author Ricardo Almeida
 *
 */
public class UpgradedEnemy1 extends UpgradedEnemy {
	private int BonusHealth;
	
	public UpgradedEnemy1(Enemy enemyEnt) {
		super(enemyEnt);
		BonusHealth = super.getInnerEnemy().getHealth() + 200;
	}
}
