package entity.enemies;

public class UpgradedEnemy20S extends UpgradedEnemy {
	private final int BonusStrength = 20;
	
	public UpgradedEnemy20S(Enemy enemy) {
		super(enemy);
		super.baseEnemy.setHealth(BonusStrength);
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
