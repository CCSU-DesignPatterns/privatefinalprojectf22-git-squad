package entity.enemies;

public class UpgradedEnemy20S extends UpgradedEnemy {
	private final int BonusStrength = 20;
	
	public UpgradedEnemy20S(Enemy enemy) {
		super(enemy);
		baseEnemy.setHealth(BonusStrength);
	}

	@Override
	public int getHealth() {
		return baseEnemy.getHealth();
	}

	@Override
	public int getStrength() {
		return baseEnemy.getStrength();
	}
}
