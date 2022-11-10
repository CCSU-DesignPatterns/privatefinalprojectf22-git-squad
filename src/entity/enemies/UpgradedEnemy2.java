package entity.enemies;

/**
 * Decorator that upgrades the health of Enemy entities
 * @author Ricardo Almeida
 *
 */
public class UpgradedEnemy2 extends UpgradedEnemy {
	private int bonusStrength;
	
	public UpgradedEnemy2(Enemy enemyEnt) {
		super(enemyEnt);
		bonusStrength = super.getInnerEnemy().getHealth() + 200;
	}
}
